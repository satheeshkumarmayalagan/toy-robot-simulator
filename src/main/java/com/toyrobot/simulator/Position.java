package com.toyrobot.simulator;

public class Position {

	private int X;
	private int Y;
	private Facing facing;

	public Position(int x, int y, Facing facing) {
		X = x;
		Y = y;
		this.facing = facing;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public Facing getFacing() {
		return facing;
	}

	public void setFacing(Facing facing) {
		this.facing = facing;
	}

	public Position clone() {
		return new Position(this.X, this.Y, this.facing);
	}

	@Override
	public String toString() {
		return String.format("%s,%s,%s", X,Y, facing);
	}

}
