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
	private String actualPath=null;
	
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
		StringTokenizer st = new StringTokenizer(stringCommand);
	   
		String command = null;
	    String parametres = null;
		
		if(st.hasMoreTokens())
			command=st.nextToken();
		
		
		
		
		Command currentCommand= getCommand(command);
		
		if(currentCommand!=null)
		{
			if(st.hasMoreTokens())
				parametres=st.nextToken();
			currentCommand.execute(parametres);
		}
		else
		{
			//exceptie
			System.out.println("Unknown command");
		}
		
		
	}
	
	public String getActualPath() {
		
			return CdCommand.getInstance().getCurrentPath();
		
		
	}

	

}
