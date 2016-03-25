package Controller;

import java.util.Scanner;

import View.CommandView;

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
			catch(NullPointerException e)
			{
				System.out.println("Command is empty. Exception");
			}
			
		}
		
		
	}

}
