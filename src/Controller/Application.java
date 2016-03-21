package Controller;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		String currentCommand;
		Scanner keyboard = new Scanner(System.in);
		
		CommandSolver comamnderManager= new CommandSolver();
		System.out.println("tralala");
		//comentariu genereaza conflict
		// altceva
		while(true)
		{
			
			System.out.println("Enter a new command");
			currentCommand = keyboard.next();
			//System.out.println(currentCommand);
			comamnderManager.executeCommand(currentCommand);
			
		}
		
		
	}

}
