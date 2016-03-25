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
	
	private String executionType="ok";
	
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
		
		String pathToAudioFile=null;
		
		if(Pattern.matches("[A-Z]:(.)*", parameters))
		{
			//Absolute path
			pathToAudioFile=parameters;	
		}
		else
		{
			//Relative path
			pathToAudioFile=CdCommand.getInstance().getCurrentPath()+"\\"+parameters;
		}
		
		if(Pattern.matches("(.)+.flac", parameters) )
			parseMetadataFlac(pathToAudioFile);
		
		else if(Pattern.matches("(.)+.mp3", parameters))
			parseMetadataMp3(pathToAudioFile, parameters);
		
		else
			setExecutionType("fail");
	}
	
	void parseMetadataFlac(String pathToAudioFile)
	{
		AudioFile f = null;
		try {
			f = AudioFileIO.read(new File(pathToAudioFile));
		} catch (CannotReadException e) {
			 System.err.println("ParseMedataFlac CannotReadException"+e);
			 setExecutionType("Exception");
		} catch (IOException e) {
			System.err.println("ParseMedataFlac IOException"+e);
			setExecutionType("Exception");
		} catch (TagException e) {
			System.err.println("ParseMedataFlac TagException"+e);
			setExecutionType("Exception");
		} catch (ReadOnlyFileException e) {
			System.err.println("ParseMedataFlac ReadOnlyException"+e);
			setExecutionType("Exception");
		} catch (InvalidAudioFrameException e) {
			System.err.println("ParseMedataFlac InvalidAudioFrameException"+e);	
			setExecutionType("Exception");
		}
		
		Tag tag = f.getTag();

		try{
			
			this.setTitle(tag.getFirst(FieldKey.TITLE));
			this.setAlbum(tag.getFirst(FieldKey.ALBUM));
			this.setArtist(tag.getFirst(FieldKey.ARTIST));
			this.setComposer(tag.getFirst(FieldKey.COMPOSER));
			this.setGenre(tag.getFirst(FieldKey.GENRE));
			this.setPath(pathToAudioFile);
			setExecutionType("ok");
			
		} catch(UnsupportedOperationException e){
			System.err.println("ParseMedataFlac UnsupportedOperationException"+e);
			setExecutionType("Exception");
		}
	}
	
	void parseMetadataMp3(String pathToAudioFile, String parameters){
		try{
			Parser parser=null;
			InputStream input=null;
			if(Pattern.matches("(.)+.mp3", parameters)){	
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
			setExecutionType("ok");
		}
		catch(FileNotFoundException e){
			System.err.println("ParseMedataMp3 FileNotFoundException"+e);
			setExecutionType("Exception");
		}catch (IOException e){
			System.err.println("ParseMedataMp3 IOException"+e);
			setExecutionType("Exception");
		}catch(SAXException e){
			System.err.println("ParseMedataMp3 SAXEException"+e);
			setExecutionType("Exception");
		}catch(TikaException e){
			System.err.println("ParseMedataMp3 TikaException"+e);
			setExecutionType("Exception");
		}
	}
	
	@Override
	  public String toString() {
	    return String.format("[Song: path='%s', \n\t title=%s,\n\t artist=%s,\n\t album=%s, \n\t composer=%s, \n\t genre=%s]", path, title, artist,album,composer,genre);
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
	public String getExecutionType() {
		return executionType;
	}
	public void setExecutionType(String executionType) {
		this.executionType = executionType;
	}

}
