package ex.Model;

import java.io.Serializable;

public enum BallsColor implements Serializable {

	RED, YELLOW, GREEN, BLUE, ORANGE, PINK, NONE;
	
	@Override
	public String toString() {
		switch (this) {
		case BLUE: return "B";
		case RED: return "R";
		case YELLOW: return "Y";
		case GREEN: return "G";
		case ORANGE: return "O";
		case PINK: return "P";
		case NONE: return "N";
		default: return "-";
		}
	}
}
