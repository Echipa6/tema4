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
	
	private static Command instance= null;
	
	public static Command getInstance(){
		if(instance == null) {
	         instance = new InfoCommand();
	      }
	      return instance;
	}
	
	@Override
	public void execute(String parameteres) 
	{
		// TODO Auto-generated method stub
		System.out.println("Command info execute...");
		String pathToAudioFile=CdCommand.getInstance().getCurrentPath()+"\\"+parameteres;
		
		if(Pattern.matches("(.)+.flac", parameteres) )
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
				AudioHeader AudioHeader = f.getAudioHeader();

					//pathToAudioFile=pathToAudioFile.replace('\\','/');
				try{
					System.out.println("Title= "+tag.getFirst(FieldKey.TITLE));
					System.out.println("Artist= "+tag.getFirst(FieldKey.ARTIST));
					System.out.println("Comoser= "+tag.getFirst(FieldKey.COMPOSER));
					System.out.println("Genre= "+tag.getFirst(FieldKey.GENRE));
					System.out.println("Album= "+tag.getFirst(FieldKey.ALBUM));
					//System.out.println(tag.getFirst(FieldKey.TRACK));
					
					
				} catch(UnsupportedOperationException e)
				{
					System.err.println(e);
				}
		}
		else 
			if(Pattern.matches("(.)+.mp3", parameteres)||Pattern.matches("(.)+.wav", parameteres))
			{
				try{
					Parser parser=null;
					InputStream input=null;
						if(Pattern.matches("(.)+.mp3", parameteres))
						{	
							parser = new Mp3Parser();	
							input=new FileInputStream(new File(pathToAudioFile));
						}
						
						
						ContentHandler handler = new DefaultHandler();
						Metadata metadata = new Metadata();
						
						ParseContext parseCtx= new ParseContext();
						parser.parse(input,handler,metadata,parseCtx);
						
						System.out.println("Title= "+ metadata.get("title"));
						System.out.println("Artist= "+ metadata.get("xmpDM:artist"));
						System.out.println("Composer= "+ metadata.get("xmpDM:composer"));
						System.out.println("Genre= "+ metadata.get("xmpDM:genre"));
						System.out.println("Album= "+ metadata.get("xmpDM:album"));
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
			else
			{
				System.out.println("Your choise isn't audio file ");
			}
	
	}
	
	private InfoCommand()
	{
		
	}

}
