package P2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnterpriseTest {

    private Enterprise enterprise;

    @Before
    public void createSpaceship(){
        enterprise = new Enterprise(50);
        enterprise.board("Denisa",1);
        enterprise.board("Luca",3);
    }

    @Test
    public void testFlyToSucces(){
        assertTrue(enterprise.flyTo("Mars",10));
    }

    @Test
    public void testFlyToFailure(){
        enterprise.board("Toma",3);
        assertFalse(enterprise.flyTo("Mars", 10));
    }

    @Test
    public void testUnboard(){
        enterprise.unboard("Luca");
        assertFalse(enterprise.getCrewNames().contains("Luca"));
    }

    @Test
    public void testPlanetVisited(){
        enterprise.flyTo("Mars",10);
        assertTrue(enterprise.getPlanetsVisited().contains("Mars"));
    }


}