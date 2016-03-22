package Model;

public class ReportCommand implements Command {

	private static Command instance= null;
	
	public static Command getInstance(){
		if(instance == null) {
	         instance = new ReportCommand();
	      }
	      return instance;
	}
	
	@Override
	public void execute(String parametres) {
		// TODO Auto-generated method stub
		System.out.println("Command report execute...");
	}
	
	private ReportCommand()
	{
		
	}

}
