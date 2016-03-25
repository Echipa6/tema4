package Model;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

// TODO: Auto-generated Javadoc
/**
 * The Class ListCommand the command are meant to list all audio files from current dir.
 */
public class ListCommand implements Command {
	
	/** The instance. */
	private static ListCommand instance= null;
	
	/**
	 * Gets the single instance of ListCommand.
	 *
	 * @return single instance of ListCommand
	 */
	public static ListCommand getInstance(){
		if(instance == null) {
	         instance = new ListCommand();
	      }
	      return instance;
	}
	
	/* (non-Javadoc)
	 * 
	 * this method opens the current folder and parse all files, and select only audio files with extensions, like mp3, flac and wav;
	 * @see Model.Command#execute(java.lang.String)
	 */
	@Override
	public void execute(String parameters) {
		System.out.println("Command list execute...");
		Path dir;
		if(parameters!=null)
		{
			 dir=Paths.get(parameters);
		}
		else
		{
			dir =Paths.get(CdCommand.getInstance().getCurrentPath());
		}
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			
			for (Path file: stream) {
				//System.out.println(file.getFileName());
				if( Pattern.matches("(.)+.wav",file.getFileName().toString()) || Pattern.matches("(.)+.mp3", file.getFileName().toString()) || Pattern.matches("(.)+.flac",file.getFileName().toString()) ){
						 System.out.println(file.getFileName());
				}
			}
			
		   
		} catch (IOException | DirectoryIteratorException x) {
		    // IOException can never be thrown by the iteration.
		    // In this snippet, it can only be thrown by newDirectoryStream.
		    System.err.println(x);
		}
	}
	
	/**
	 * Instantiates a new list command.
	 */
	private ListCommand()
	{
		
	}

}
