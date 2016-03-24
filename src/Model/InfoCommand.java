package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class InfoCommand implements Command {
	
	private static InfoCommand instance= null;
	
	private String path;
	private String title;
	private String artist;
	private String composer;
	private String genre;
	private String album;
	
	public static InfoCommand getInstance(){
		if(instance == null) {
	         instance = new InfoCommand();
	      }
	      return instance;
	} 
	private InfoCommand()
	{
		
	}
	
	@Override
	public void execute(String parameters) 
	{
		// TODO Auto-generated method stub
		//System.out.println("Command info execute...");
		String pathToAudioFile=CdCommand.getInstance().getCurrentPath()+"\\"+parameters;
		
		if(Pattern.matches("(.)+.flac", parameters) )
			parseMetadataFlac(pathToAudioFile);
		
		else if(Pattern.matches("(.)+.mp3", parameters)||Pattern.matches("(.)+.wav", parameters))
			parseMetadataMp3(pathToAudioFile, parameters);
		
		else
			System.out.println("Your choise isn't audio file ");
		
	
	}
	
	void parseMetadataFlac(String pathToAudioFile)
	{
		AudioFile f = null;
		try {
			f = AudioFileIO.read(new File(pathToAudioFile));
		} catch (CannotReadException e) {
			 System.err.println(e);
			//e.printStackTrace();
		} catch (IOException e) {
			System.err.println(e);
			//e.printStackTrace();
		} catch (TagException e) {
			System.err.println(e);
			//e.printStackTrace();
		} catch (ReadOnlyFileException e) {
			System.err.println(e);
			//e.printStackTrace();
		} catch (InvalidAudioFrameException e) {
			System.err.println(e);	
			//e.printStackTrace();
		}
		Tag tag = f.getTag();

			//pathToAudioFile=pathToAudioFile.replace('\\','/');
		try{
			System.out.println("Title= "+tag.getFirst(FieldKey.TITLE));
			System.out.println("Artist= "+tag.getFirst(FieldKey.ARTIST));
			System.out.println("Comoser= "+tag.getFirst(FieldKey.COMPOSER));
			System.out.println("Genre= "+tag.getFirst(FieldKey.GENRE));
			System.out.println("Album= "+tag.getFirst(FieldKey.ALBUM));
			//System.out.println(tag.getFirst(FieldKey.TRACK));
			
			this.setTitle(tag.getFirst(FieldKey.TITLE));
			this.setAlbum(tag.getFirst(FieldKey.ALBUM));
			this.setArtist(tag.getFirst(FieldKey.ARTIST));
			this.setComposer(tag.getFirst(FieldKey.COMPOSER));
			this.setGenre(tag.getFirst(FieldKey.GENRE));
			this.setPath(pathToAudioFile);
			
			
		} catch(UnsupportedOperationException e)
		{
			System.err.println(e);
		}
	}
	
	void parseMetadataMp3(String pathToAudioFile, String parameters)
	{
		try{
			Parser parser=null;
			InputStream input=null;
				if(Pattern.matches("(.)+.mp3", parameters))
				{	
					parser = new Mp3Parser();	
					input=new FileInputStream(new File(pathToAudioFile));
				}
				
				
				ContentHandler handler = new DefaultHandler();
				Metadata metadata = new Metadata();
				
				ParseContext parseCtx= new ParseContext();
				parser.parse(input,handler,metadata,parseCtx);
				
				
				this.setTitle(metadata.get("title"));
				this.setAlbum(metadata.get("xmpDM:album"));
				this.setArtist(metadata.get("xmpDM:artist"));
				this.setComposer(metadata.get("xmpDM:composer"));
				this.setGenre(metadata.get("xmpDM:genre"));
				this.setPath(pathToAudioFile);
		}
		catch(FileNotFoundException e){
			System.err.println(e);
			//e.printStackTrace();
			}catch (IOException e){
				System.err.println(e);
				e.printStackTrace();
			}catch(SAXException e){
				System.err.println(e);
				//e.printStackTrace();
			}catch(TikaException e){
				System.err.println(e);
				//e.printStackTrace();
			}
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

}
