package View;

import org.apache.poi.util.SystemOutLogger;

import Model.CdCommand;
import Model.Command;
import Model.FavCommand;
import Model.FindCommand;
import Model.InfoCommand;
import Model.ListCommand;
import Model.PlayCommand;
import Model.ReportCommand;
import Model.Song;

public class CommandView {
	
	public void writeResult(CdCommand command)
	{
		switch(command.getExecutionType())
		{
			case "ok": System.out.println("Current path is "+ command.getCurrentPath());
				break;
			case "root": System.out.println("You are in root and can't go back");
				break;
			case "invalid": System.out.println("Your path is invalid. Try again");
				break;
			default: System.out.println("Unexpected result on CD command");
		}
	}
	
	public void writeResult(FavCommand command)
	{
		switch(command.getExecutionType())
		{
		case "ok": System.out.println("This song will be add to your avorite list: \n"+command.getFavoriteSong().get(command.getFavoriteSong().size()-1).toString());
			break;
		case "fail": System.out.println("Can't get the file. Verify that it exist!");
			break;
		default: System.out.println("Unexpected result on FavCommand");
		}
	}
	
	public void writeResult(FindCommand command)
	{
		switch(command.getExecutionType())
		{
		case "ok":
			for(Song song: command.getFoundAudioFiles())
			{
				System.out.println(song.toString());
			}
			break;
		case "Exception": System.out.println("Exception FindComand!");
			break;
		default: System.out.println("Anormal execution of Find");
		}
	}
	
	public void writeResult(InfoCommand command)
	{
		switch(command.getExecutionType()){
			case "ok": System.out.println(command.toString());
				break;
				
			case "Exception": System.out.println("Command don't work normally. Exception!");
				break;
			
			case "fail": System.out.println("Invalid path. File not exist or isn't audio file");
				break;
			default: System.out.println("Unexpected result on InfoCommand");
		}
		
	}
	
	public void writeResult(ListCommand command)
	{
		switch(command.getExecutionType())
		{
		case "ok":
			for(Song song: command.getFoundAudioFiles())
			{
				System.out.println(song.toString());
			}
			break;
		case "Exception": System.out.println("Exception ListComand!");
			break;
		default: System.out.println("Anormal execution of List");
		}
		
	}
	
	public void writeResult(PlayCommand command)
	{
		switch(command.getExecutionType()){
		case "ok": System.out.println("File is opening");
			break;
		case "fail": System.out.println("File doesn't exist or format doesn't match");
			break;
		default : System.out.println("Unexpected result on InfoCommand");
		}
		
	}
	
	public void writeResult(ReportCommand command)
	{
		
	}
	public void writeResult(Command currentCommand) {
		
		if(currentCommand instanceof CdCommand)
		{
			writeResult((CdCommand)currentCommand);
			return;
		}
		if(currentCommand instanceof FavCommand)
		{
			writeResult((FavCommand)currentCommand);
			return;
		}
		if(currentCommand instanceof FindCommand)
		{
			writeResult((FindCommand)currentCommand);
			return;
		}
		if(currentCommand instanceof InfoCommand)
		{
			writeResult((InfoCommand)currentCommand);
			return;
		}
		if(currentCommand instanceof ListCommand)
		{
			writeResult((ListCommand)currentCommand);
			return;
		}
		if(currentCommand instanceof PlayCommand)
		{
			writeResult((PlayCommand)currentCommand);
			return;
		}
		
		if(currentCommand instanceof ReportCommand)
		{
			writeResult((ReportCommand)currentCommand);
			return;
		}
		
	}

}
