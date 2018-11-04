package com.toyrobot.simulator;

public class Board implements Surface {

	private final int rows;
	private final int columns;

	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
	}

	public Board(int length) {
		this.rows = length;
		this.columns = length;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public static Board square(int length) {
		return new Board(length);
	}

	public boolean isValidPosition(Position position) {
		return !(position.getX() > this.columns || position.getX() < 0 || position.getY() > this.rows
				|| position.getY() < 0);
	}

}
