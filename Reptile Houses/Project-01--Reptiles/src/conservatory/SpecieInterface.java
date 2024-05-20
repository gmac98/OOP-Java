package conservatory;

/** Specie Interface captures all the characteristics of a specie such as
 * its name, characteristics, size, preferred temperature,
 * natural feature type, status, if it is poisonous
 * and if it can coexist.
 **/
public interface SpecieInterface {

  /** It denotes the size of the animal to accommodate in animal house. **/
  public int animalSize();

  /** It denotes animal status to determine if animal can be added to conservatory. **/
  public boolean animalStatus();

  /** It denotes the name of the animal. **/
  public String animalName();
}
