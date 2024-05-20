package com.birds.types.subtypes;

import com.birds.types.Pigeons;
import com.birds.values.Values;

public class Doves extends Pigeons{

	public Doves() {
		super(Values.Name.PIGEONS.toString(),
				Values.Type.NOT_PREY.toString(),
				2,
				Values.Extinct.HALF_EXTINCT.toString(),
				Values.Habitat.LAND.toString(),
				true,
				Values.SizeOfBirds.MEDIUM.toString(),
				false);
	}

}
