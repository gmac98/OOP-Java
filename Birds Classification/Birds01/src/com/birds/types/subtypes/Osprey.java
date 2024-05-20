package com.birds.types.subtypes;

import com.birds.types.Birds_Of_Prey;
import com.birds.values.Values;

public class Osprey extends Birds_Of_Prey{

	public Osprey() {
		super(Values.Name.OSPREY.toString(),Values.Type.PREY.toString(),2,Values.Extinct.NOT_EXTINCT.toString(),Values.Habitat.LAND.toString(),true,Values.SizeOfBirds.LARGE.toString(),false);
	}
}
