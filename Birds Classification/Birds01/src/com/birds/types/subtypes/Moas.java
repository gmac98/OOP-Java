package com.birds.types.subtypes;

import com.birds.types.FlightLess_Birds;
import com.birds.values.Values;

public class Moas extends FlightLess_Birds{

	public Moas() {
		super(Values.Name.MOAS.toString(),
				Values.Type.FLIGHT_LESS.toString(),
				2,
				Values.Extinct.EXTINCT.toString(),
				Values.Habitat.LAND.toString(),
				false,
				Values.SizeOfBirds.SMALL.toString(),
				false);
	}
}
