package Model;

public class PlayCommand implements Command {
	
	private static Command instance= null;
	
	public static Command getInstance(){
		if(instance == null) {
	         instance = new PlayCommand();
	      }
	      return instance;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Command play execute...");
	}
	
	public PlayCommand()
	{
		
	}

}
