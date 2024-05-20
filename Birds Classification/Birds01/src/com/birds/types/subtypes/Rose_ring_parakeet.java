package com.birds.types.subtypes;

import com.birds.types.Parrots;
import com.birds.values.Values;

public class Rose_ring_parakeet extends Parrots{
	
	public Rose_ring_parakeet(){
		super(Values.Name.ROSE_RING_PARAKEET.toString(),
				Values.Type.NOT_PREY.toString(),
				2,
				Values.Extinct.NOT_EXTINCT.toString(),
				Values.Habitat.LAND.toString(),
				false,
				Values.SizeOfBirds.SMALL.toString(),
				false);
	}
}
