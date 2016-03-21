package Controller;

import Model.CdCommand;
import Model.Command;
import Model.ExitCommand;
import Model.FavCommand;
import Model.FindCommand;
import Model.InfoCommand;
import Model.PlayCommand;
import Model.ReportCommand;

public class CommandSolver {

	public Command getCommand(String stringCommand)
	{
		switch(stringCommand.toLowerCase())
		{
		case "cd": return new CdCommand();
		case "exit": return new ExitCommand();
		case "fav": return new FavCommand();
		case "find": return new FindCommand();
		case "info": return new InfoCommand();
		case "list": return new ListCommand();
		case "play": return new PlayCommand();
		case "report": return new ReportCommand();
		default: return null;
		}
	}
	
	public void executeCommand(String stringCommand)
	{
		Command currentCommand= getCommand(stringCommand);
		
		if(currentCommand!=null)
		{
			currentCommand.execute();
		}
		
	}
}
