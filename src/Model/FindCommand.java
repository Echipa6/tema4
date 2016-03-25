package Model;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;


public class FindCommand implements Command {

	private static FindCommand instance= null;
	private String executionType="ok";
	
	private List<Song> foundAudioFiles;
	
	public static FindCommand getInstance(){
		if(instance == null) {
	         instance = new FindCommand();
	      }
	      return instance;
	}
	private FindCommand()
	{
		
	}
	
	@Override
	public void execute(String parametres) {
		
		foundAudioFiles=new ArrayList<Song>();
		InfoCommand infoMetadate= InfoCommand.getInstance();
				
		List<File> files =(List<File>) FileUtils.listFiles(
				FileUtils.getFile(CdCommand.getInstance().getCurrentPath()), 
				new String[] {"mp3","flac","wav"}, 
				true);
		
		try{
			for(File file:files){
				infoMetadate.execute(file.toString());
				if(parametres.equals(infoMetadate.getArtist()) )
				{
					foundAudioFiles.add(new Song(infoMetadate));
				}
			}
		}catch(NullPointerException e)
		{
			System.out.println("Execute FindComand NullPointerException "+e);
			executionType="Exception";
		}
	}
	
	public List<Song> getFoundAudioFiles() {
		return foundAudioFiles;
	}
	
	public String getExecutionType() {
		return executionType;
	}

	public void setExecutionType(String executionType) {
		this.executionType = executionType;
	}
}
