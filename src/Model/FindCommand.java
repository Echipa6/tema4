package Model;


import java.io.File;
import java.util.ArrayList;
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
		foundAudioFiles=new ArrayList<String>();
		InfoCommand info= InfoCommand.getInstance();
				
		List<File> files =
                (List<File>) FileUtils.listFiles(FileUtils.getFile(CdCommand.getInstance().getCurrentPath().toString()), new String[] {"mp3","flac","wav"},true);
		for(File file:files){
			info.execute(file.toString());
			//System.out.println(file.toString());
    		if(parametres.equals(InfoCommand.getInstance().getArtist()) )
    		{
    			try{
    				foundAudioFiles.add(file.getAbsolutePath());
    				System.out.println(file);
    			}catch(NullPointerException e)
    			{
    				System.out.println("tralala");
    			}
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
