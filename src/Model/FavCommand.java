package Model;


import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class FavCommand.
 * 
 */
public class FavCommand implements Command{

	/** The instance. */
	private static FavCommand instance= null;
	
	/** The execution type. */
	private String executionType="ok";
	
	/** The list of  favorite songs. */
	public List<Song> favoriteSong;
	
	/**
	 * Gets the single instance of FavCommand.
	 *
	 * @return single instance of FavCommand
	 */
	public static FavCommand getInstance(){
		if(instance == null) {
	         instance = new FavCommand();
	      }
	      return instance;
	}
	
	/**
	 * Instantiates a new fav command.
	 */
	private FavCommand()
	{
		favoriteSong=new ArrayList<Song>();
	}
	
		
	/**
	 * Gets the favorite song.
	 *
	 * @return the favorite song
	 */
	public List<Song> getFavoriteSong() {
		return favoriteSong;
	}


	/**
	 * Sets the favorite song.
	 *
	 * @param favoriteSong the new favorite song
	 */
	public void setFavoriteSong(List<Song> favoriteSong) {
		this.favoriteSong = favoriteSong;
	}


	/* (non-Javadoc)
	 * @see Model.Command#execute(java.lang.String)
	 * in this method we'll be add to the favorite songs song specified by parameters song, and in song will be stored metaData for this song
	 */
	@Override
	public void execute(String parameters) {
		System.out.println("Command fav execute...");
		
		InfoCommand.getInstance().execute(parameters);
		
		Song song=new Song(InfoCommand.getInstance());
		if(InfoCommand.getInstance().getExecutionType().equals("ok")){
			favoriteSong.add(song);
			setExecutionType("ok");
		}
		else
			setExecutionType("fail");

	}
	
	
	
	
	/**
	 * Gets the execution type.
	 *
	 * @return the execution type
	 */
	public String getExecutionType() {
		return executionType;
	}
	
	/**
	 * Sets the execution type.
	 *
	 * @param executionType the new execution type
	 */
	public void setExecutionType(String executionType) {
		this.executionType = executionType;
	}
}
