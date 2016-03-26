package OurExceptions;

public class NullCommandException extends NullPointerException{

    public NullCommandException(String exc)
    {
        super(exc);
    }

	public NullCommandException() {
		super();
		// TODO Auto-generated constructor stub
	}

}
