package Model;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class ListCommand implements Command {
	
	private static ListCommand instance= null;
	
	public static ListCommand getInstance(){
		if(instance == null) {
	         instance = new ListCommand();
	      }
	      return instance;
	}
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
	
	private ListCommand()
	{
		
	}

}
