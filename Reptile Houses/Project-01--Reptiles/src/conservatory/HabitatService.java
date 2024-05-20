package conservatory;

import java.util.ArrayList;
import java.util.List;

/** HabitatService coordinates between different habitats to assign specie to them. **/
public class HabitatService {

  private List<Habitat> h;

  /** Declares the list of habitats. */
  public HabitatService() {
    h = new ArrayList<Habitat>();
  }

  /** Method to add habitats to the conservatory. */
  public void addHabitat(Habitat habitat) {
    h.add(habitat);
  }

  public int getCountOfHabitat() {
    return this.h.size();
  }
}
