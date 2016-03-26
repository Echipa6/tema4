

import static org.junit.Assert.*;

import org.junit.Test;

import Model.CdCommand;

public class SingletonCdTest {

	@Test
	public void testSingleton1() {
		
		CdCommand c1= CdCommand.getInstance();
		CdCommand c2= CdCommand.getInstance();
		
		c1.execute("E:\\muzica");
		//c1.execute("..");
		c2.execute("Alternative");
		assertTrue(c1.getCurrentPath().equals(c2.getCurrentPath()));
		
		
	}
	
	@Test
	public void testSingleton() {
		
		CdCommand c1= CdCommand.getInstance();
		CdCommand c2= CdCommand.getInstance();
		
		c1.execute("E:\\muzica");
		
		c2.execute("Alternative");
		
		c1.execute("..");
		assertEquals(c1.getCurrentPath(),(c2.getCurrentPath()));
		
		
	}



}
