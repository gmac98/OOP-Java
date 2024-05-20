package conservatory;

/**
 * Reptile represents the reptile animals under the Animal super class.
 */
public class Reptile extends Specie {

  /**
   * Constructor for the Reptile class.
   */
  public Reptile(String specieName, String characteristics, Size size,
                 Status status, FeatureType featureType, int minTemp,
                 int maxTemp, boolean isPoisonous, boolean canCoexist) {

    super(specieName, characteristics, size, status,
              featureType, minTemp, maxTemp, isPoisonous, canCoexist);
  }



}
