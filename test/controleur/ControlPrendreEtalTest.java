package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private Chef abraracourcix;
	private ControlVerifierIdentite controlVerifierIdentite;
	private Gaulois gaulois;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation");
		gaulois = new Gaulois("asterix", 5);
		village = new Village("le village des irréductibles", 10, 1);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		village.ajouterHabitant(gaulois);
	}

	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal, "Constructeur ne renvoi pas null");
	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.resteEtals());
		village.installerVendeur(abraracourcix, null, 0);
		assertFalse(controlPrendreEtal.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertEquals(controlPrendreEtal.prendreEtal("asterix", "fleurs", 3),1);
	}
	@Test
	void testPrendreEtal2() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		village.installerVendeur(gaulois, "fleurs", 2);
		assertEquals(controlPrendreEtal.prendreEtal("obelix", "fleurs", 3),-1);
	}

	@Test
	void testVerifierIdentite() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		village.installerVendeur(gaulois, "fleurs", 2);
		assertTrue(controlPrendreEtal.verifierIdentite("asterix"));
		assertFalse(controlPrendreEtal.verifierIdentite("aucun nom"));
	}

}
