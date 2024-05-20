package com.birds.service;

import java.util.ArrayList;
import java.util.List;
import com.birds.objects.Aviaries;

/**
 * AviaryService gives the list of aviaries and provides the functionality to add aviaries to the
 * conservatory.
 */
public class AviaryService {

  private List<Aviaries> aviaries;

  /** Declares the list of aviaries. */
  public AviaryService() {
    aviaries = new ArrayList<Aviaries>();
  }

  /** Method to add aviaries to the conservatory. */
  public void addAviaries(Aviaries aviary) {
    aviaries.add(aviary);
  }

  /** Method to remove aviaries from the conservatory. */
  public void removeAviaries(int id) {
    aviaries.remove(id);
  }

  public int getCountOfAviaries() {
    return this.aviaries.size();
  }
}
