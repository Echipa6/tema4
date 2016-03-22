package Model;

public class InfoCommand implements Command {
	
	private static Command instance= null;
	
	public static Command getInstance(){
		if(instance == null) {
	         instance = new InfoCommand();
	      }
	      return instance;
	}
	
	@Override
	public void execute(String parametres) {
		// TODO Auto-generated method stub
		System.out.println("Command info execute...");
	}
	
	private InfoCommand()
	{
		
	}

}
