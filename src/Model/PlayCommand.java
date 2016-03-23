package Model;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public class PlayCommand implements Command {
	
	private static Command instance= null;
	
	public static Command getInstance(){
		if(instance == null) {
	         instance = new PlayCommand();
	      }
	      return instance;
	}
	
	@Override
	public void execute(String parameteres) {
		// TODO Auto-generated method stub
		System.out.println("Command play execute...");
		
		if( Pattern.matches("(.)+.wav",parameteres) || Pattern.matches("(.)+.mp3", parameteres) || Pattern.matches("(.)+.flac",parameteres) )
		{
				String pathToAudioFile=CdCommand.getInstance().getCurrentPath()+"\\"	+parameteres;
				File playFile= new File(pathToAudioFile);
				if(playFile.isFile())
				{
					try 
					 {
					     Desktop desktop = null;
					      if (Desktop.isDesktopSupported()) 
					      {
					        desktop = Desktop.getDesktop();
					      }
					      desktop.open(playFile);
					 } 
					 catch (IOException ioe) 
					 {
						      ioe.printStackTrace();
					 }
				}
				else
				{
					//sa arunc exceptia
					System.out.println("File not exists");
					
				}
		}
		else
		{
			System.out.println("Your choise isn't audio file ");
		}
	
	}
	
	private PlayCommand()
	{
		
	}

}
