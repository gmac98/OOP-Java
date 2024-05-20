package com.birds.types.subtypes;

import com.birds.types.Parrots;
import com.birds.values.Values;

public class Sulfer_crested_cockatoo extends Parrots{
	
	public Sulfer_crested_cockatoo(){
		super(Values.Name.SULFURE_CRESTED_COCKATOO.toString(),
				Values.Type.NOT_PREY.toString(),
				2,
				Values.Extinct.NOT_EXTINCT.toString(),
				Values.Habitat.LAND.toString(),
				false,
				Values.SizeOfBirds.SMALL.toString(),
				false);
	}

}
