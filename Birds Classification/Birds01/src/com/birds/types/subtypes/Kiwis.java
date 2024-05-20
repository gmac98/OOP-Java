package com.birds.types.subtypes;

import com.birds.types.FlightLess_Birds;
import com.birds.values.Values;

public class Kiwis extends FlightLess_Birds{

	public Kiwis() {
		super(Values.Name.KIWIS.toString(),
				Values.Type.FLIGHT_LESS.toString(),
				2,
				Values.Extinct.HALF_EXTINCT.toString(),
				Values.Habitat.LAND.toString(),
				false,
				Values.SizeOfBirds.SMALL.toString(),
				false);
	}
}
