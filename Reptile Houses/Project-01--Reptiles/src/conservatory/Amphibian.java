package conservatory;

/**
 * Amphibian represents the amphibian animals under the Animal super class.
 */
public class Amphibian extends Specie {

  /**
   * Constructor for the Amphibian class.
   */

  public Amphibian(String specieName, String characteristics, Size size,
                   Status status, FeatureType featureType, int minTemp,
                   int maxTemp, boolean isPoisonous, boolean canCoexist) {
    super(specieName,
            characteristics,
            size,
            status,
            featureType,
            minTemp,
            maxTemp,
            isPoisonous,
            canCoexist);
  }

}
