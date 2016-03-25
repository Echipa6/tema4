package Model;

import OurExceptions.NullCommandException;

// TODO: Auto-generated Javadoc
/**
 * The Interface Command.
 */
public interface Command {
	
	/**
	 * Execute.
	 *
	 * @param parametres the parametres
	 */
	public void execute(String parametres)throws NullCommandException;

}
