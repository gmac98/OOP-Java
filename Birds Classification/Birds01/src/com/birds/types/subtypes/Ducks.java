package com.birds.types.subtypes;

import com.birds.types.WaterFowl;
import com.birds.values.Values;

public class Ducks extends WaterFowl{
	
	public Ducks() {
		super(Values.Name.DUCKS.toString(),
				Values.Type.NOT_PREY.toString(),
				2,
				Values.Extinct.NOT_EXTINCT.toString(),
				Values.Habitat.WATER.toString(),
				false,
				Values.SizeOfBirds.MEDIUM.toString(),
				false);
	}
}
