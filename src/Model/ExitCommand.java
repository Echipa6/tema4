package Model;

public class ExitCommand implements Command {

	private static Command instance= null;
	
	public static Command getInstance(){
		if(instance == null) {
	         instance = new ExitCommand();
	      }
	      return instance;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Comman exit execute...");
	}
	private ExitCommand()
	{
		
	}
}
