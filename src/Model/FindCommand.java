package Model;

import java.awt.PrintJob;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

import thredds.filesystem.ControllerOS7.PrintFiles;

public class FindCommand implements Command {

	private static Command instance= null;
	
	public static Command getInstance(){
		if(instance == null) {
	         instance = new FindCommand();
	      }
	      return instance;
	}
	
	@Override
	public void execute(String parametres) {
		// TODO Auto-generated method stub
		System.out.println("Command find execute...");
		
		try {
			Files.walk(Paths.get(CdCommand.getInstance().getCurrentPath().toString())).forEach(filePath -> {
			    if (Files.isReadable(filePath)) {
			        System.out.println(filePath);
			    }
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		}
		/*
		String revertPath=CdCommand.getInstance().getCurrentPath().toString();
		
		Path dir=Paths.get(CdCommand.getInstance().getCurrentPath().toString());
		if(parametres==null)
		{
			 System.out.println("give a search key");
		}
		else
		{
			
			
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
		*/
	
		
	}
	
	private FindCommand()
	{
		
	}
	
	

}
