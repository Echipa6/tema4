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
		
		//comentariu genereaza conflict
		// altceva
		while(true)
		{
			
			currentCommand = keyboard.nextLine();
			
			try{
				
				comamnderManager.executeCommand(currentCommand);
				
				//System.out.println(comamnderManager.getActualPath());
			}
			catch(NullCommandException e)
			{
				System.out.println("Command is empty."+e.getMessage());
			}
			
		}
		
		
	}

}
