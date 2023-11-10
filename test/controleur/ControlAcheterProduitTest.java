package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	private Chef abraracourcix;
	private Gaulois asterix;
	public void initialiserSituation() {
		System.out.println("Initialisation");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		asterix= new Gaulois("asterix",5);
        village.ajouterHabitant(asterix);
        
        controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
        controlVerifierIdentite = new ControlVerifierIdentite(village);
	}
	
	@Test
	void testControlAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit= new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertNotNull(controlAcheterProduit,"constructeur non null");
	}

	@Test
	void testVerifierIdentite() {
		ControlAcheterProduit controlAcheterProduit= new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
	    assertFalse(controlAcheterProduit.verifierIdentite("aucun nom"));
	    assertTrue(controlAcheterProduit.verifierIdentite("asterix"));
	}

	@Test
	void testTrouverCommercant() {
		ControlAcheterProduit controlAcheterProduit= new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		String[]liste;
		assertFalse(controlAcheterProduit.verifierIdentite("aucun nom"));
	}

	@Test
	void testAcheterProduit() {
		fail("Not yet implemented");
	}

}
