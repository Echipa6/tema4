package Model;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class CdCommand implements Command {

	private static CdCommand instance= null;
	private String currentPath=null;
	
		
	public static CdCommand getInstance(){
		if(instance == null) {
	         instance = new CdCommand();
	      }
	      return instance;
	}
	private CdCommand()
	{
		
	}
	
	@Override
	public void execute(String parametres) {
		// TODO Auto-generated method stub
		//System.out.println("Command cd execute");
		if(parametres==null)
		{
			Path currentRelativePath = Paths.get("");
			String s = currentRelativePath.toAbsolutePath().toString();
			this.setCurrentPath(s);
		}
		else
		{
			//System.out.println("path is:"+this.getCurrentPath());
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
					if(Pattern.matches("[a-zA-Z]+(.)*", parametres))
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

}
