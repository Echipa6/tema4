package Model;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

// 
/**
 * The Class CdCommand.
 */
public class CdCommand implements Command {

	/** The instance. */
	private static CdCommand instance= null;
	
	/** The current path. is actual path where we are in the file tree  */
	private String currentPath=null;
	private String executionType="ok";
	
		
	/**
	 * Gets the single instance of CdCommand.
	 *
	 * @return single instance of CdCommand
	 */
	public static CdCommand getInstance(){
		if(instance == null) {
	         instance = new CdCommand();
	      }
	      return instance;
	}
	
	
	/**
	 * Instantiates a new cd command.
	 */
	private CdCommand()
	{
		
	}
	
	/* (non-Javadoc)
	 * the method walk on the tree, if param are .. then you will be placed to one directory back.
	 * or it can be the absolute path, or relative path to current directory
	 * @see Model.Command#execute(java.lang.String)
	 */
	@Override
	public void execute(String parameters) {
		
		if(parameters=="" || parameters==null)
		{
			this.setExecutionType("ok");
			getCurrentPath();
			return;
		}
		if(parameters.equals(new String("..")))
		{
				goBackPath();
				return;
		}
		
		if(Pattern.matches("[A-Z]:(.)*", parameters))
		{
			setAbsolutePath(parameters);
			return;
		}
		if(Pattern.matches("(.)*", parameters))
			setRelativePath(parameters);
	
	}
	
	/**
	 * Go back path.
	 */
	private void goBackPath()
	{
		String newPath="";
		String[] result = getCurrentPath().split("\\\\");
		
	    if(result.length>1) {
	    	newPath=result[0];
	    	for (int x=1; x<result.length-1; x++)
	    		if (result[x]!="")
	    		newPath = newPath+"\\" +result[x];
	    	this.setCurrentPath(newPath);
	    	this.setExecutionType("ok");
	    }
	    else
	    	this.setExecutionType("root");
	}
	
	/**
	 * Sets the absolute path.
	 *
	 * @param parameters the new absolute path
	 */
	private void setAbsolutePath(String parameters)
	{
		File file=new File(parameters);
		
		if(file.exists() && file.isDirectory())
		{
			this.setCurrentPath(parameters);
			this.setExecutionType("ok");
		}
		else
			this.setExecutionType("invalid");
	}
	
	/**
	 * Sets the relative path.
	 *
	 * @param parameters the new relative path
	 */
	private void setRelativePath(String parameters)
	{
		String newPath;
		newPath=this.getCurrentPath();
		newPath=newPath+"\\"+parameters;

		File file=new File(newPath);
		
		if(file.exists() && file.isDirectory())
		{
			this.setCurrentPath(newPath);
			this.setExecutionType("ok");
		}
		else
			this.setExecutionType("invalid");
	}
	
	/**
	 * Gets the current path.
	 *
	 * @return the current path
	 */
	public String getCurrentPath() {
		if(currentPath!= null)
			return currentPath;
		else
		{
			Path currentRelativePath = Paths.get("");
			String s = currentRelativePath.toAbsolutePath().toString();
			this.setCurrentPath(s);
			return currentPath;
		}
	}
	
	/**
	 * Sets the current path.
	 *
	 * @param currentPath the new current path
	 */
	public void setCurrentPath(String currentPath) {
		this.currentPath = currentPath;
	}
	
	/**
	 * Gets the execution type.
	 *
	 * @return the execution type
	 */
	public String getExecutionType() {
		return executionType;
	}
	
	/**
	 * Sets the execution type.
	 *
	 * @param executionType the new execution type
	 */
	public void setExecutionType(String executionType) {
		this.executionType = executionType;
	}

}
