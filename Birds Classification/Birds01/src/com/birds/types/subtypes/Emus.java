package com.birds.types.subtypes;

import com.birds.types.FlightLess_Birds;
import com.birds.values.Values;

public class Emus extends FlightLess_Birds{

	public Emus() {
		super(Values.Name.EMUS.toString(),
				Values.Type.FLIGHT_LESS.toString(),
				2,
				Values.Extinct.HALF_EXTINCT.toString(),
				Values.Habitat.LAND.toString(),
				false,
				Values.SizeOfBirds.SMALL.toString(),
				false);
	}
}
