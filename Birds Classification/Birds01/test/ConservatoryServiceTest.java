import org.junit.Assert;
import org.junit.Test;

import com.birds.service.ConservatoryService;

public class ConservatoryServiceTest {
  @Test
  public void testAddBirds() {
    ConservatoryService conservatoryService = new ConservatoryService();
    conservatoryService.createConservatory();
    Assert.assertEquals(true, conservatoryService.addBirds(1)); // Non extinct animal;
    Assert.assertEquals(false, conservatoryService.addBirds(8)); // Extinct Animal
  }

  @Test
  public void testSearchForABird() {
    ConservatoryService conservatoryService = new ConservatoryService();
    conservatoryService.createConservatory();
    Assert.assertEquals(true, conservatoryService.addBirds(1));
    Assert.assertEquals(true, conservatoryService.searchForABird(1));
    Assert.assertEquals(false, conservatoryService.searchForABird(2));
  }

  @Test
  public void testListAllAviaries() {
    ConservatoryService conservatoryService = new ConservatoryService();
    conservatoryService.createConservatory();
    Assert.assertEquals(true, conservatoryService.addBirds(1));
    Assert.assertEquals(true, conservatoryService.searchForABird(1));
    Assert.assertEquals(false, conservatoryService.searchForABird(2));
    Assert.assertEquals(2, ConservatoryService.getId());
  }
}
