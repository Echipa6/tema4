package Model;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayCommand.
 */
public class PlayCommand implements Command {
	
	/** The instance. */
	private static PlayCommand instance= null;
	
	/**
	 * Gets the single instance of PlayCommand.
	 *
	 * @return single instance of PlayCommand
	 */
	public static PlayCommand getInstance(){
		if(instance == null) {
	         instance = new PlayCommand();
	      }
	      return instance;
	}
	
	/* (non-Javadoc)
	 * this method establishes connection between our application and an audio player installed on desktop by opening audio file
	 * and you can play only by giving relative path to the current directory
	 * @see Model.Command#execute(java.lang.String)
	 */
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
	
	/**
	 * Instantiates a new play command.
	 */
	private PlayCommand()
	{
		
	}

}
