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
	
	@Override
	public void execute(String parametres) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	private ExitCommand()
	{
		
		try{
			
			XMLEncoder encoder =
			           new XMLEncoder(
			              new BufferedOutputStream(
			                new FileOutputStream(FILENAME)));
			        encoder.writeObject(FavCommand.getInstance().favoriteSong);
			        encoder.close();
			}catch(FileNotFoundException e)
			{
				System.out.println("eceptioe");
			}
		
	}
}
