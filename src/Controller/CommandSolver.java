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
import View.CommandView;

public class CommandSolver {
	
	private static final String FILENAME = "FavoriteSongs.xml";
	CommandView commandView= new CommandView();
	
	CommandSolver()
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
	
	public void executeCommand(String stringCommand)
	{
		String[] result = stringCommand.split(" ", 2);
		
		
		String command = null;
	    String parameteres = null;
		
	    if(result!=null)
	    	command=result[0];
	    if(result.length==2)
	    parameteres=result[1];
		
		
		Command currentCommand= getCommand(command);
		
		if(currentCommand!=null){
			currentCommand.execute(parameteres);
			commandView.writeResult(currentCommand);
			
		}
		else
		{
			//exceptie
			System.out.println("Unknown command");
		}
		
		
	}
	
}
