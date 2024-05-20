package com.birds.utilities;

import java.util.Random;

public final class RandomGenerator {
	public static int getRandomNumberUsingInts(int min, int max) {
	    Random random = new Random();
	    return random.ints(min, max)
	      .findFirst()
	      .getAsInt();
	}
}
