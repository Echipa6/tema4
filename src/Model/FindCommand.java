package Model;

public class FindCommand implements Command {

	private static Command instance= null;
	
	public static Command getInstance(){
		if(instance == null) {
	         instance = new FindCommand();
	      }
	      return instance;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Command find execute...");
	}
	
	private FindCommand()
	{
		
	}
	

}
