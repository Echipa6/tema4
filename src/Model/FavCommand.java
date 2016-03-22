package Model;

public class FavCommand implements Command{

	private static Command instance= null;
	
	public static Command getInstance(){
		if(instance == null) {
	         instance = new FavCommand();
	      }
	      return instance;
	}
	
		
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Command fav execute...");
	
	}
	
	private FavCommand()
	{
		
	}
	

}
