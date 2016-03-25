package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Model.FavCommand;
import Model.Song;

public class FavTest {

	@Test
	public void test() {
		
		Song song=new Song();
		song.setPath("C:\\Users\\Dorin\\Documents\\Alternative\\3 Doors Down - Landing In London.mp3");
		song.setTitle("Landing In London");
		song.setAlbum("Seventeen Days");
		
		song.setGenre("Alternative");	
		FavCommand fav1= FavCommand.getInstance();
		
		fav1.execute("C:\\Users\\Dorin\\Documents\\Alternative\\3 Doors Down - Landing In London.mp3");
		
		boolean  ok=false;
		for(Song song2:fav1.getFavoriteSong())
		{
			if(song2.getPath().equals(song.getPath())) 
				ok=true;
		}
		assertTrue(ok);
		
	}

}
