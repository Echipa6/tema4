package Model;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ExitCommand implements Command {

	private static final String FILENAME = "favoriteSongs.xml";
	private static Command instance= null;
	
	public static Command getInstance(){
		if(instance == null) {
	         instance = new ExitCommand();
	      }
	      return instance;
	}
	private ExitCommand()
	{

	}
	
	@Override
	public void execute(String parametres) {
		try{

			XMLEncoder encoder = new XMLEncoder( new BufferedOutputStream( new FileOutputStream(FILENAME)));
			encoder.writeObject(FavCommand.getInstance().favoriteSong);
			encoder.close();
			
		}catch(FileNotFoundException e)
		{
			System.out.println("eceptioe");
		}
		System.exit(0);
	}
	
}
