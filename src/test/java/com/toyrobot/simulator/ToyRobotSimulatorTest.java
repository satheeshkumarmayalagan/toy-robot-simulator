package com.toyrobot.simulator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ToyRobotSimulatorTest {

	@Before
	public void setUp() {

	}

	@Test
	public void testValidCommands() {
		List<String> validCommands = Arrays.asList("PLACE 0,3,NORTH", "MOVE", "MOVE", "RIGHT", "MOVE", "LEFT");
		Position position = ToyRobotSimulator.issueCommands(validCommands);
		assertEquals("1,5,NORTH", position.toString());
	}

	@Test
	public void testInvalidBoardPostion() {
		List<String> invalidBoardPostion = Arrays.asList("PLACE 6,6,NORTH");
		Position position = ToyRobotSimulator.issueCommands(invalidBoardPostion);
		assertNull(position);
	}

	@Test
	public void testErrorPlacement() {
		List<String> errorPlacement = Arrays.asList("PLACE 0,1,JUNKIE");
		Position position = ToyRobotSimulator.issueCommands(errorPlacement);
		assertNull(position);
	}

	@Test
	public void testErrorInputs() {
		List<String> errorPlacement = Arrays.asList("PLACE 0,1,SOUTH", "JUNKIE");
		Position position = ToyRobotSimulator.issueCommands(errorPlacement);
		assertEquals("0,1,SOUTH", position.toString());
	}

	@Test
	public void testIgnoreInvalidPostions() {
		List<String> ignoreInvalidPostions = Arrays.asList("PLACE 4,4,NORTH", "MOVE", "MOVE", "MOVE", "MOVE", "MOVE");
		Position position = ToyRobotSimulator.issueCommands(ignoreInvalidPostions);
		assertEquals("4,5,NORTH", position.toString());
	}

}
