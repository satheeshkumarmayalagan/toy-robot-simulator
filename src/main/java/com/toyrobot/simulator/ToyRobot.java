package com.toyrobot.simulator;

/**
 * An implementation of the Toy Robot capable of moving on the given surface
 * based on the given commands
 */

public class ToyRobot {

	private Position position;

	private Surface surface;

	public void place(Surface surface, Position position) {
		if (surface == null || position == null)
			return;
		if (!surface.isValidPosition(position))
			return;
		this.surface = surface;
		this.position = position;
	}

	public void move() {
		if (!isPlaced())
			return;
		Position newPosition = newPosition();
		if (surface.isValidPosition(newPosition)) {
			this.position = newPosition;
		}
	}

	private Position newPosition() {
		Position newPosition = position.clone();
		int val = -1;
		switch (position.getFacing()) {
		case NORTH:
			val = newPosition.getY();
			newPosition.setY(++val);
			break;
		case SOUTH:
			val = newPosition.getY();
			newPosition.setY(--val);
			break;
		case EAST:
			val = newPosition.getX();
			newPosition.setX(++val);
			break;
		case WEST:
			val = newPosition.getX();
			newPosition.setX(--val);
			break;
		}
		return newPosition;
	}

	public void turnLeft() {
		if (!isPlaced())
			return;
		switch (this.position.getFacing()) {
		case NORTH:
			this.position.setFacing(Facing.WEST);
			break;
		case WEST:
			this.position.setFacing(Facing.SOUTH);
			break;

		case SOUTH:
			this.position.setFacing(Facing.EAST);
			break;
		case EAST:
			this.position.setFacing(Facing.NORTH);
			break;
		}
	}

	public void turnRight() {
		if (!isPlaced())
			return;
		switch (this.position.getFacing()) {
		case NORTH:
			this.position.setFacing(Facing.EAST);
			break;
		case EAST:
			this.position.setFacing(Facing.SOUTH);
			break;
		case SOUTH:
			this.position.setFacing(Facing.WEST);
			break;
		case WEST:
			this.position.setFacing(Facing.NORTH);
			break;
		}
	}

	public Position report() {
		return position;
	}

	public boolean isPlaced() {
		return position != null;
	}
}
