package Model;

public class ListCommand implements Command {
	
	private static Command instance= null;
	
	public static Command getInstance(){
		if(instance == null) {
	         instance = new ListCommand();
	      }
	      return instance;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Command list execute...");
	}
	
	private ListCommand()
	{
		
	}

}
