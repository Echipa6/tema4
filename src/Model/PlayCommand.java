package Model;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Pattern;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayCommand.
 */
public class PlayCommand implements Command {
	
	/** The instance. */
	private static PlayCommand instance= null;
	private String executionType="ok";
	
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
	private PlayCommand()
	{
		
	}
	
	/* (non-Javadoc)
	 * this method establishes connection between our application and an audio player installed on desktop by opening audio file
	 * and you can play only by giving relative path to the current directory
	 * @see Model.Command#execute(java.lang.String)
	 */
	@Override
	public void execute(String parameteres) {
		if(!(Pattern.matches("(.)+\\.wav",parameteres)) && !(Pattern.matches("(.)+\\.mp3", parameteres)) && !(Pattern.matches("(.)+\\.flac",parameteres)) )
		{
			setExecutionType("fail");
			return;
		}
		String pathToAudioFile=CdCommand.getInstance().getCurrentPath()+"\\"+parameteres;
		Desktop desktop = null;
		try {
			File playFile= new File(pathToAudioFile);
			if(playFile.isFile() && Desktop.isDesktopSupported()){
				desktop = Desktop.getDesktop();
				desktop.open(playFile);
				setExecutionType("ok");
			}
		}catch(FileNotFoundException e)
		{
			System.err.println("Play FileNotFoundException "+e);
			setExecutionType("Exception");
			
		}catch (IOException e) {
			System.err.println("Play FileNotFoundException "+e);
			setExecutionType("Exception");
		}

	}
	
	/**
	 * Instantiates a new play command.
	 */
	private PlayCommand()
	{
		
	public String getExecutionType() {
		return executionType;
	}
	public void setExecutionType(String executionType) {
		this.executionType = executionType;
	}
}
