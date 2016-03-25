package Model;


import java.util.ArrayList;
import java.util.List;

public class FavCommand implements Command{

	private static FavCommand instance= null;
	private String executionType="ok";
	
	public List<Song> favoriteSong;
	
	public List<Song> getFavoriteSong() {
		return favoriteSong;
	}
	public void setFavoriteSong(List<Song> favoriteSong) {
		this.favoriteSong = favoriteSong;
	}
	public static FavCommand getInstance(){
		if(instance == null) {
	         instance = new FavCommand();
	      }
	      return instance;
	}
	private FavCommand()
	{
		favoriteSong=new ArrayList<Song>();
	}
	
		
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
	
	
	public void afiseaza()
	{
		
	}
	public String getExecutionType() {
		return executionType;
	}
	public void setExecutionType(String executionType) {
		this.executionType = executionType;
	}
}
