package Model;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;


// TODO: Auto-generated Javadoc
/**
 * The Class FindCommand.
 * 
 */
public class FindCommand implements Command {

	/** The instance. */
	private static FindCommand instance= null;
	
	/** The found audio files. */
	private List<String> foundAudioFiles;
	
	/**
	 * Gets the single instance of FindCommand.
	 *
	 * @return single instance of FindCommand
	 */
	public static FindCommand getInstance(){
		if(instance == null) {
	         instance = new FindCommand();
	      }
	      return instance;
	}
	
	/* (non-Javadoc)
	 * 
	 * in this method the specified by parameter artist will be searched in metadata of songs from this folder and so on recursive;
	 * @see Model.Command#execute(java.lang.String)
	 */
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
    				
    			}
    		}
    	}
	}
	
	/**
	 * Gets the found audio files.
	 *
	 * @return the found audio files
	 */
	public List<String> getFoundAudioFiles() {
		return foundAudioFiles;
	}

	

	/**
	 * Instantiates a new find command.
	 */
	private FindCommand()
	{
		
	}
	
	

}
