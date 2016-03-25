package Controller;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import Model.CdCommand;
import Model.Command;
import Model.ExitCommand;
import Model.FavCommand;
import Model.FindCommand;
import Model.InfoCommand;
import Model.ListCommand;
import Model.PlayCommand;
import Model.ReportCommand;
import Model.Song;
import OurExceptions.NullCommandException;
import View.CommandView;

// TODO: Auto-generated Javadoc
/**
 * The Class CommandSolver.
 * the central part of controller, this class will be create instances of commands, and will be run their execution. 
 */
public class CommandSolver {
	
	/** The Constant FILENAME. */
	private static final String FILENAME = "FavoriteSongs.xml";
	CommandView commandView= new CommandView();
	
	/**
	 * Instantiates a new command solver.
	 */
	public CommandSolver()
	{
		try{
			XMLDecoder decoder =
					new XMLDecoder(new BufferedInputStream(
							new FileInputStream(FILENAME)));
				FavCommand.getInstance().favoriteSong = (List<Song>)decoder.readObject();
				decoder.close();
		}catch(FileNotFoundException e)
		{
			System.out.println("Exception");
		}
	}
	
	/**
	 * Gets the command.
	 * this method will be return the implementation of interface command  given by param  
	 * @param stringCommand the string command
	 * @return the command
	 */
	public Command getCommand(String stringCommand)
	{
		
		switch(stringCommand.toLowerCase())
		{
		case "cd": return CdCommand.getInstance();
		case "exit": return ExitCommand.getInstance();
		case "fav": return FavCommand.getInstance();
		case "find": return FindCommand.getInstance();
		case "info": return InfoCommand.getInstance();
		case "list": return ListCommand.getInstance();
		case "play": return PlayCommand.getInstance();
		case "report": return ReportCommand.getInstance();
		default: return null;
		}
	}
	
	/**
	 * Execute command.
	 * here will be run execution of command string is command and they param;
	 * and also here is established the communication with user by view.
	 * @param stringCommand the string command
	 */
	public void executeCommand(String stringCommand)throws  NullCommandException
	{
		String[] result = stringCommand.split(" ", 2);
		
		
		String command = null;
	    String parameteres = null;
		
	    if(result!=null)
	    	command=result[0];
	    if(result.length==2)
	    parameteres=result[1];
		
		
	   
	    Command currentCommand= getCommand(command);
		
		if(currentCommand==null){
			throw new NullCommandException();
		}
			
			currentCommand.execute(parameteres);
			commandView.writeResult(currentCommand);
			
		
		
		
	}
}	

