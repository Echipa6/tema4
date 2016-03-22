package Model;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class ListCommand implements Command {
	
	private static Command instance= null;
	
	public static Command getInstance(){
		if(instance == null) {
	         instance = new ListCommand();
	      }
	      return instance;
	}
	@Override
	public void execute() {
		
		System.out.println("Command list execute...");
		Path dir =Paths.get("F:\\muzica andrei\\[2001] First Love 1");
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			
			for (Path file: stream) {
				//System.out.println(file.getFileName());
				if( Pattern.matches("[ ._a-zA-Z0-9]+.wav",file.getFileName().toString()) || Pattern.matches("[ ._a-zA-Z0-9]+.mp3", file.getFileName().toString()) || Pattern.matches("[ ._a-zA-Z0-9]+.flac",file.getFileName().toString()) ){
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
