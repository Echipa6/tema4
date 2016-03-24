package Model;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FavCommand implements Command{

	private static FavCommand instance= null;
	
	public List<Song> favoriteSong;
	
	public static FavCommand getInstance(){
		if(instance == null) {
	         instance = new FavCommand();
	      }
	      return instance;
	}
	
		
	@Override
	public void execute(String parameters) {
		System.out.println("Command fav execute...");
		
		InfoCommand.getInstance().execute(parameters);
		
		Song song=new Song(InfoCommand.getInstance());
		favoriteSong.add(song);
		
		System.out.println("Lista melodii favorite");
		this.afiseaza();
	}
	
	
	private FavCommand()
	{
		favoriteSong=new ArrayList<Song>();
	}
	
	public void afiseaza()
	{
		for (Song currentSong : this.favoriteSong)
		{
			currentSong.afisare();
		}
	}
}
