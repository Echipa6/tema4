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
	private String executionType="ok";
	
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
	private FindCommand()
	{
		
	}
	
	/* (non-Javadoc)
	 * 
	 * in this method the specified by parameter artist will be searched in metadata of songs from this folder and so on recursive;
	 * @see Model.Command#execute(java.lang.String)
	 */
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
	
	 * Gets the found audio files.
	 *
	 * @return the found audio files
	 */
	public List<Song> getFoundAudioFiles() {
	
	
	
	public String getExecutionType() {
		return executionType;
	}

	/**
	 * Instantiates a new find command.
	 */
	private FindCommand()
	{
		
	public void setExecutionType(String executionType) {
		this.executionType = executionType;
	}
}
