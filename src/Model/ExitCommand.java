package Model;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

// TODO: Auto-generated Javadoc
/**
 * The Class ExitCommand.
 */
public class ExitCommand implements Command {

	/** The Constant FILENAME. */
	private static final String FILENAME = "favoriteSongs.xml";
	
	/** The instance. */
	private static Command instance= null;
	
	/**
	 * Gets the single instance of ExitCommand.
	 *
	 * @return single instance of ExitCommand
	 */
	public static Command getInstance(){
		if(instance == null) {
	         instance = new ExitCommand();
	      }
	      return instance;
	}
	
	/**
	 * Instantiates a new exit command.
	 */
	private ExitCommand()
	{

	}
	
	/* (non-Javadoc)
	 * in this place we are searilize in xml our favorit list of music;
	 * @see Model.Command#execute(java.lang.String)
	 */
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
