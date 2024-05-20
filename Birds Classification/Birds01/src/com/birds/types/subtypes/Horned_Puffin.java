package com.birds.types.subtypes;

import com.birds.types.ShoreBirds;
import com.birds.values.Values;

public class Horned_Puffin extends ShoreBirds{
	public Horned_Puffin() {
		super(Values.Name.HORNED_PUFFIN.toString(),
				Values.Type.NOT_PREY.toString(),
				2,
				Values.Extinct.HALF_EXTINCT.toString(),
				Values.Habitat.WATER.toString(),
				false,
				Values.SizeOfBirds.MEDIUM.toString(),
				false);
	}
}
