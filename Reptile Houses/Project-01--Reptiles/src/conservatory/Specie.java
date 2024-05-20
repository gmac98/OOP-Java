package conservatory;

abstract class Specie implements SpecieInterface {

  private final String specieName;
  private final String characteristics;
  private final Size size;
  private final Status status;
  private final FeatureType featureType;
  private final int minTemp;
  private final int maxTemp;
  private final boolean isPoisonous;
  private final boolean canCoexist;


  public Specie(String specieName, String characteristics, Size size,
                Status status, FeatureType featureType, int minTemp,
                int maxTemp, boolean isPoisonous, boolean canCoexist) {
    this.specieName = specieName;
    this.characteristics = characteristics;
    this.size = size;
    this.status = status;
    this.featureType = featureType;
    this.minTemp = minTemp;
    this.maxTemp = maxTemp;
    this.isPoisonous = isPoisonous;
    this.canCoexist = canCoexist;
  }

  @Override
  public int animalSize() {
    if (size == Size.SMALL) {
      return 1;
    } else if (size == Size.MEDIUM) {
      return 5;
    } else {
      return 10;
    }
  }

  @Override
  public boolean animalStatus() {
    return status != Status.EXTINCT;
  }

  @Override
  public String animalName() {
    return this.specieName;
  }

  public FeatureType animalFeature() {
    return this.featureType;
  }

  @Override
  public String toString() {
    return String.format("Specie name: %s, Characteristics: %s, Size: %s, "
                    + "Status: %s, Feature Type: %s, Temp range: %d - %d, "
                    + "isPoisonous: %b, canCoexist : %b",specieName,characteristics,size.toString(),
            status.toString(),featureType.toString(),minTemp,maxTemp,isPoisonous,canCoexist);
  }
}
