package Model;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CdCommand implements Command {

	private static Command instance= null;
	
	public static Command getInstance(){
		if(instance == null) {
	         instance = new CdCommand();
	      }
	      return instance;
	}
	private CdCommand()
	{
		
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Command cd execute");
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		System.out.println("Current relative path is: " + s);

	}

}
