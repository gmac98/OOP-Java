package com.birds.types.subtypes;

import com.birds.types.ShoreBirds;
import com.birds.values.Values;

public class African_Jacana extends ShoreBirds{
	
	public African_Jacana() {
		super(Values.Name.AFRICAN_JACANA.toString(),
				Values.Type.NOT_PREY.toString(),
				2,
				Values.Extinct.HALF_EXTINCT.toString(),
				Values.Habitat.WATER.toString(),
				false,
				Values.SizeOfBirds.MEDIUM.toString(),
				false);
	}
}
