package com.birds.types.subtypes;

import com.birds.types.ShoreBirds;
import com.birds.values.Values;

public class Great_Auk extends ShoreBirds{
	
	public Great_Auk() {
		super(Values.Name.GREAT_AUK.toString(),
				Values.Type.NOT_PREY.toString(),
				2,
				Values.Extinct.EXTINCT.toString(),
				Values.Habitat.WATER.toString(),
				true,
				Values.SizeOfBirds.MEDIUM.toString(),
				false);
	}
}
