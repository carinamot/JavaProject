package ex.Model;

import java.io.Serializable;

public enum BallsColor implements Serializable {

	red, yellow, green, blue, orange, pink, none;
	
	@Override
	public String toString() {
		switch (this) {
		case blue: return "B";
		case red: return "R";
		case yellow: return "Y";
		case green: return "G";
		case orange: return "O";
		case pink: return "P";
		case none: return "N";
		default: return "-";
		}
	}
}
