package Controller;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		String currentCommand;
		Scanner keyboard = new Scanner(System.in);
		
		CommandSolver comamnderManager= new CommandSolver();
		
		//comentariu genereaza conflict
		// altceva
		while(true)
		{
			
			System.out.println("");
			currentCommand = keyboard.nextLine();
			//System.out.println(currentCommand);
			
			try{
				
				comamnderManager.executeCommand(currentCommand);
				System.out.println(comamnderManager.getActualPath());
			}
			catch(NullPointerException e)
			{
				System.out.println("Command is empty");
			}
			
		}
		
		
	}

}
