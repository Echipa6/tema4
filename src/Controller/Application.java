package Controller;

import java.util.Scanner;

import OurExceptions.NullCommandException;
import View.CommandView;

/**
 * The Class Application.
 * there will be the main of our application
 */
public class Application {

	public static void main(String[] args) {
		String currentCommand;
		Scanner keyboard = new Scanner(System.in);
		
		CommandSolver comamnderManager= new CommandSolver();
		
		while(true)
		{
			
			currentCommand = keyboard.nextLine();
			
			try{
				
				comamnderManager.executeCommand(currentCommand);

			}
			catch(NullCommandException e)
			{
				System.out.println("Command is empty."+e.getMessage());
			}
			
		}
		
		
	}

}
