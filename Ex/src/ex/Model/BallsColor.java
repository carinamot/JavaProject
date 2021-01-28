package ex.Model;

import java.io.Serializable;

public enum BallsColor implements Serializable {

	R, Y, G, B, O, P, N;
	
	@Override
	public String toString() {
		switch (this) {
		case B: return "B";
		case R: return "R";
		case Y: return "Y";
		case G: return "G";
		case O: return "O";
		case P: return "P";
		case N: return "N";
		default: return "-";
		}
	}
}
