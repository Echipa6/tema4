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
	public void execute(String parametres) {
		// TODO Auto-generated method stub
		//System.out.println("Command cd execute");
		if(parametres==null)
		{
			Path currentRelativePath = Paths.get("");
			String s = currentRelativePath.toAbsolutePath().toString();
			System.out.println("path is:"+this.getCurrentPath());
			this.setCurrentPath(s);
		}
		else
		{
			
			if(parametres.equals(new String("..")))
			{
				
				String s =this.getCurrentPath();
				String newPath="";
				
				String[] result = getCurrentPath().split("\\\\");
			    if(result.length<=1) {
			    	
			    }
			    else
			    {
			    	newPath=result[0];
			    	for (int x=1; x<result.length-1; x++)
			    		if (result[x]!="")
			    		newPath = newPath+"\\" +result[x];
			    		
			    	this.setCurrentPath(newPath);
			    }
			    
			    
				
			}
			else
			{
				if(Pattern.matches("[A-Z]:(.)*", parametres))
				{
					File file=new File(parametres);
					
					if(file.exists() && file.isDirectory())
					{
						this.setCurrentPath(parametres);
					}
					else
					{
						System.out.println("Invalid path");
					}
					
				}
				else
				{
					if(Pattern.matches("(.)*", parametres))
					{
						
						String newPath;
						newPath=this.getCurrentPath();
					
						newPath=newPath+"\\"+parametres;
					
						File file=new File(newPath);
					
						if(file.exists() && file.isDirectory())
						{
							this.setCurrentPath(newPath);
						}
						else
						{
							System.out.println("Invalid path");
						}
					
					}
				}
			}
			//System.out.println("path is:"+this.getCurrentPath());
		}
		
		

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

}
