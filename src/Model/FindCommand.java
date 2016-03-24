package Model;


import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;


public class FindCommand implements Command {

	private static FindCommand instance= null;
	
	private List<String> foundAudioFiles;
	
	public static FindCommand getInstance(){
		if(instance == null) {
	         instance = new FindCommand();
	      }
	      return instance;
	}
	
	@Override
	public void execute(String parametres) {
		
		System.out.println("Command find execute...");
		foundAudioFiles=null;
		InfoCommand info= InfoCommand.getInstance();
				
		List<File> files =
                (List<File>) FileUtils.listFiles(FileUtils.getFile(CdCommand.getInstance().getCurrentPath().toString()), new String[] {"mp3","flac","wav"},true);
		for(File file:files){
			info.execute(file.toString());
    		if(parametres.equals(InfoCommand.getInstance().getArtist()) )
    		{
    			foundAudioFiles.add(file.toString());
    			//System.out.println(file);
    		}
    	}
	}
	
	public List<String> getFoundAudioFiles() {
		return foundAudioFiles;
	}

	

	private FindCommand()
	{
		
	}
	
	

}
