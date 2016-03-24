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
			
			currentCommand = keyboard.nextLine();
			//System.out.println(currentCommand);
			
			comamnderManager.executeCommand(currentCommand);
			
//			try{
//				
//				
//				//System.out.println(comamnderManager.getActualPath());
//			}
//			catch(NullPointerException e)
//			{
//				System.out.println("Command is empty. Exception");
//			}
			
		}
		
		
	}

}
