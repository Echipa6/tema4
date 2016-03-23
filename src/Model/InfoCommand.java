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
import org.gagravarr.flac.FlacFile;
import org.gagravarr.tika.FlacParser;
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
	public void execute(String parameteres) {
		// TODO Auto-generated method stub
		System.out.println("Command info execute...");
		
		if(Pattern.matches("(.)+.mp3", parameteres)||Pattern.matches("(.)+.flac", parameteres) )
		{
				String pathToAudioFile=CdCommand.getInstance().getCurrentPath()+"\\"	+parameteres;
				File playFile= new File(pathToAudioFile);
				
					pathToAudioFile=pathToAudioFile.replace('\\','/');
					
					try{
						Parser parser=null;
						InputStream input=null;
							if(Pattern.matches("(.)+.mp3", parameteres))
							{	
								parser = new Mp3Parser();	
								input=new FileInputStream(new File(pathToAudioFile));
							}
							if(Pattern.matches("(.)+.flac", parameteres))
							{
								parser=new FlacParser();
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
