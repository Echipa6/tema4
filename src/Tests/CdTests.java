package Tests;


import static org.junit.Assert.*;

import org.junit.Test;

import Model.CdCommand;

public class CdTests {

	@Test
	public void CdNoArguments() {
		CdCommand.getInstance().execute("");
		String path1= CdCommand.getInstance().getCurrentPath();
		
		CdCommand.getInstance().execute("");
		CdCommand.getInstance().execute("");
		CdCommand.getInstance().execute("");
		CdCommand.getInstance().execute("");
		String path2=CdCommand.getInstance().getCurrentPath();
		
		assertEquals(path2,path1);
		
	}
	
	@Test
	public void CdBack() {
		CdCommand.getInstance().execute("..");
		String path1= CdCommand.getInstance().getCurrentPath();
		
		CdCommand.getInstance().execute("");
		String path2=CdCommand.getInstance().getCurrentPath();
		assertTrue(path2.equals(path1));
		
	}
	@Test
	public void CdRoot1() {
		CdCommand.getInstance().execute("..");
		CdCommand.getInstance().execute("..");
		CdCommand.getInstance().execute("..");
		CdCommand.getInstance().execute("..");
		
		assertEquals(CdCommand.getInstance().getExecutionType(),"ok");
		
	}
	@Test
	public void CdRoot2() {
		CdCommand.getInstance().execute("..");
		CdCommand.getInstance().execute("..");
		CdCommand.getInstance().execute("..");
		CdCommand.getInstance().execute("..");
		
		assertEquals(CdCommand.getInstance().getExecutionType(),"root");
		
	}
	
	@Test
	public void CdAbsolutPath() {
		CdCommand.getInstance().execute("Z:fdssd");
		
		assertFalse(CdCommand.getInstance().getCurrentPath().equals("Z:fdssd"));
		
	}
	@Test
	public void CdAbsolutPath2() {
		CdCommand.getInstance().execute("E:");
		
		assertTrue(CdCommand.getInstance().getCurrentPath().equals("E:"));
		
	}
	
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
