package com.birds.types.subtypes;

import com.birds.types.Birds_Of_Prey;
import com.birds.values.Values;

public class Hawks extends Birds_Of_Prey{

	public Hawks() {
		super(Values.Name.HAWKS.toString(),Values.Type.PREY.toString(),2,Values.Extinct.NOT_EXTINCT.toString(),Values.Habitat.LAND.toString(),true,Values.SizeOfBirds.LARGE.toString(),false);
	}
}
