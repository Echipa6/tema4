package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.CommandSolver;
import Model.CdCommand;
import Model.ExitCommand;
import Model.FavCommand;
import Model.FindCommand;
import Model.InfoCommand;
import Model.ListCommand;
import Model.PlayCommand;
import Model.ReportCommand;

public class testCommandSolver {

	@Test
	public void testGetCommandCd() {
		
			
		CommandSolver comanderManager=new CommandSolver();
		assertTrue(comanderManager.getCommand("cd") instanceof CdCommand);
		
	}
	@Test
	public void testGetCommandExit() {
		
			
		CommandSolver comanderManager=new CommandSolver();
		assertTrue(comanderManager.getCommand("exit") instanceof ExitCommand);
		
	}
	
	@Test
	public void testGetCommandFav() {
		
			
		CommandSolver comanderManager=new CommandSolver();
		assertTrue(comanderManager.getCommand("fav") instanceof FavCommand);
		
	}
	
	@Test
	public void testGetCommandFind() {
		
			
		CommandSolver comanderManager=new CommandSolver();
		assertTrue(comanderManager.getCommand("find") instanceof FindCommand);
		
	}
	
	@Test
	public void testGetCommandInfo() {
		
			
		CommandSolver comanderManager=new CommandSolver();
		assertTrue(comanderManager.getCommand("info") instanceof InfoCommand);
		
	}
	
	@Test
	public void testGetCommandList() {
		
			
		CommandSolver comanderManager=new CommandSolver();
		assertTrue(comanderManager.getCommand("list") instanceof ListCommand);
		
	}
	
	@Test
	public void testGetCommandPlay() {
		
			
		CommandSolver comanderManager=new CommandSolver();
		assertTrue(comanderManager.getCommand("play") instanceof PlayCommand);
		
	}
	
	@Test
	public void testGetCommandReport() {
		
			
		CommandSolver comanderManager=new CommandSolver();
		assertTrue(comanderManager.getCommand("report") instanceof ReportCommand);
		
	}
	
	@Test
	public void testGetCommandInvalid() {
		
			
		CommandSolver comanderManager=new CommandSolver();
		assertNull(comanderManager.getCommand("tralala"));
		
	}
	@Test
	public void testGetCommandNull() {
		
			
		CommandSolver comanderManager=new CommandSolver();
		assertNull(comanderManager.getCommand(""));
		
	}
}