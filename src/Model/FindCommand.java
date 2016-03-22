package Model;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FindCommand implements Command {

	private static Command instance= null;
	
	public static Command getInstance(){
		if(instance == null) {
	         instance = new FindCommand();
	      }
	      return instance;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Command find execute...");
		
	}
	
	private FindCommand()
	{
		
	}
	

}
