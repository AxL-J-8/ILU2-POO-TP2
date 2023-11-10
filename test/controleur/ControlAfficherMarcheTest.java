package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois asterix;
 	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		asterix= new Gaulois("asterix",5);
        village.ajouterHabitant(asterix);
	}

	@Test
	void testControlAfficherMarche() {
           ControlAfficherMarche controlAfficherMarche=new ControlAfficherMarche(village);
           assertNotNull(controlAfficherMarche,"constructeur non null");
	}

	@Test
	void testDonnerInfosMarche() {
		ControlAfficherMarche controlAfficherMarche=new ControlAfficherMarche(village);
		String[]resultat=controlAfficherMarche.donnerInfosMarche();
		assertEquals(resultat.length,0);
	}
	
	@Test
	void testDonnerInfosMarche2() {
		ControlAfficherMarche controlAfficherMarche=new ControlAfficherMarche(village);
		village.installerVendeur(asterix, "fleurs", 5);
		String[]resultat=controlAfficherMarche.donnerInfosMarche();
		assertEquals(resultat.length,3);
		assertEquals(resultat[0],"asterix");
		assertEquals(resultat[1],"5");
		assertEquals(resultat[2],"fleurs");
	}

}
