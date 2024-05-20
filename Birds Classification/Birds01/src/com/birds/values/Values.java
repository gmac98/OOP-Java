package com.birds.values;

/**Class contains values of Birds.*/
public class Values {

  /**Class contains names of Birds.*/
  public enum Name {
    HAWKS,
    EAGLES,
    OSPREY,
    EMUS,
    KIWIS,
    MOAS,
    OWLS,
    ROSE_RING_PARAKEET,
    GRAY_PARROT,
    SULFURE_CRESTED_COCKATOO,
    PIGEONS,
    DOVES,
    GREAT_AUK,
    HORNED_PUFFIN,
    AFRICAN_JACANA,
    DUCKS,
    SWANS,
    GEESE
  }

  /**Class contains type of Birds.*/
  public enum Type {
    PREY,
    NOT_PREY,
    FLIGHT_LESS
  }

  /**Class contains extinct values of Birds.*/
  public enum Extinct {
    EXTINCT,
    HALF_EXTINCT,
    NOT_EXTINCT
  }

  /**Class contains size of Birds.*/
  public enum SizeOfBirds {
    SMALL,
    MEDIUM,
    LARGE
  }

  /**Class contains habitat of Birds.*/
  public enum Habitat {
    LAND,
    WATER
  }
}
