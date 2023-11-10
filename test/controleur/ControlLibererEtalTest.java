package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private Chef abraracourcix;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Gaulois gaulois;
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation");
		gaulois=new Gaulois("asterix",5);
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs", 2);
	}

	@Test
	void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal, "Constructeur ne renvoi pas null");
	}

	@Test
	void testLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
        assertNull(controlLibererEtal.libererEtal("aucun nom"));
        assertNotNull(controlLibererEtal.libererEtal("asterix"));
	}

	@Test
	void testIsVendeur() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
        assertFalse(controlLibererEtal.isVendeur("aucun nom"));
        assertTrue(controlLibererEtal.isVendeur("asterix"));
	}

}
