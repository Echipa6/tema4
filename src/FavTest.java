import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Model.FavCommand;
import Model.Song;

public class FavTest {

	@Test
	public void test() {
		
		List<Song> list1= new ArrayList<Song>();
		
		Song song=new Song();
		song.setPath("E:\\muzica\\Alternative\\3 Doors Down - Landing In London.mp3");
		song.setTitle("Landing In London");
		song.setAlbum("Seventeen Days");
		
		song.setGenre("Alternative");
		
		list1.add(song);
		
		FavCommand fav1= FavCommand.getInstance();
		
		fav1.execute("E:\\muzica\\Alternative\\3 Doors Down - Landing In London.mp3");
		
		boolean  ok=false;
		for(Song son:fav1.getFavoriteSong())
		{
			if(son.getPath().equals(son.getPath())) 
				ok=true;
		}
		assertTrue(ok);
		
	}

}
