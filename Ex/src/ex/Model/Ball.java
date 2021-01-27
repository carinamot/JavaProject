package ex.Model;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

import ex.Model.*;

public class Ball implements Comparable<Ball>, Serializable {

	BallsColor color;
	
	public Ball() {
		super();
		final Random random = new Random();
		color = BallsColor.values()[Math.abs(random.nextInt()) % 6];
	}

	public void setColor(BallsColor colour) {
		this.color = colour;

	}

	public BallsColor getColor() {
		return color;
	}

	@Override
	public String toString() {
		return color.toString();
	}
	
	@Override
	public int compareTo(Ball o) {
		return this.color.compareTo(o.color);
	}
}
