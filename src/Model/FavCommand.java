package Model;

public class FavCommand implements Command{

	private static FavCommand instance= null;
	
	public static FavCommand getInstance(){
		if(instance == null) {
	         instance = new FavCommand();
	      }
	      return instance;
	}
	
		
	@Override
	public void execute(String parametres) {
		// TODO Auto-generated method stub
		System.out.println("Command fav execute...");
	
	}
	
	private FavCommand()
	{
		
	}
	

}
