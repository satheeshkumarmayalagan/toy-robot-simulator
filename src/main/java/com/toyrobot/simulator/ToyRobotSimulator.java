package com.toyrobot.simulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * An implementation of the Toy Robot simulator.
 */

public class ToyRobotSimulator {

	public static String NEW_LINE = System.getProperty("line.separator");

	public static void main(String[] args) {
		List<String> commands = scan();
		if (commands != null && !commands.isEmpty())
			issueCommands(commands);

	}

	public static List<String> scan() {
		List<String> commands = new ArrayList<String>();
		System.out.println("Issue commands to the Robot. To exit, enter twice.");
		Scanner scanner = new Scanner(System.in);
		try {
			String command = null;
			while (true) {
				command = scanner.nextLine();
				if (command == null || command.isEmpty() || command.equals(NEW_LINE))
					break;
				commands.add(command);
			}
		} finally {
			scanner.close();
		}
		return commands;
	}

	public static Position issueCommands(List<String> commands) {
		ToyRobot robot = new ToyRobot();
		Board board = Board.square(5);
		for (String command : commands) {
			if (command.startsWith("PLACE")) {
				Position position = parsePlaceCommand(command);
				if (position != null)
					robot.place(board, position);
			} else if (command.equalsIgnoreCase("RIGHT")) {
				robot.turnRight();
			} else if (command.equalsIgnoreCase("LEFT")) {
				robot.turnLeft();
			} else if (command.equalsIgnoreCase("MOVE")) {
				robot.move();
			} else if (command.equalsIgnoreCase("REPORT")) {
				System.out.println(robot.report());
			}
		}
		return robot.report();
	}

	private static Position parsePlaceCommand(String command) {
		try {
			String[] placeArgs = command.split(" ");
			if (placeArgs.length != 2)
				return null;
			String[] placeCmds = placeArgs[1].split(",");
			if (placeCmds.length != 3)
				return null;
			Position position = new Position(Integer.parseInt(placeCmds[0]), Integer.parseInt(placeCmds[1]),
					Facing.valueOf(placeCmds[2]));
			return position;
		} catch (Exception e) {
			//Ignore any invalid input
			return null;
		}
	}
}
