package com.birds.types.subtypes;

import com.birds.types.Parrots;
import com.birds.values.Values;

public class Gray_Parrot extends Parrots{
	
	public Gray_Parrot(){
		super(Values.Name.GRAY_PARROT.toString(),
				Values.Type.NOT_PREY.toString(),
				2,
				Values.Extinct.NOT_EXTINCT.toString(),
				Values.Habitat.LAND.toString(),
				false,
				Values.SizeOfBirds.SMALL.toString(),
				false);
	}
}
