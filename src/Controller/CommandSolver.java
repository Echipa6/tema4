package Controller;

import java.util.StringTokenizer;

import Model.CdCommand;
import Model.Command;
import Model.ExitCommand;
import Model.FavCommand;
import Model.FindCommand;
import Model.InfoCommand;
import Model.ListCommand;
import Model.PlayCommand;
import Model.ReportCommand;

public class CommandSolver {
	
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
		
		if(currentCommand!=null)
		{
			
			currentCommand.execute(parameteres);
			
			System.out.println(CdCommand.getInstance().getCurrentPath());
		}
		else
		{
			//exceptie
			System.out.println("Unknown command");
		}
		
		
	}
	
}
