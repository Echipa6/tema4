package Model;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class CdCommand implements Command {

	private static CdCommand instance= null;
	private String currentPath=null;
	private String executionType="ok";
	
		
	public static CdCommand getInstance(){
		if(instance == null) {
	         instance = new CdCommand();
	      }
	      return instance;
	}
	private CdCommand(){
		
	}
	
	@Override
	public void execute(String parameters) {
		
		if(parameters==null)
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
	public void setCurrentPath(String currentPath) {
		this.currentPath = currentPath;
	}
	
	public String getExecutionType() {
		return executionType;
	}
	public void setExecutionType(String executionType) {
		this.executionType = executionType;
	}

}
