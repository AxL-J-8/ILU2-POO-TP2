package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef abraracourcix;
	
	
    @BeforeEach
    public void initialiserSituation() {
    	System.out.println("Initialisation");
    	village= new Village("le village des irréductibles",10,5);
    	abraracourcix=new Chef("Abraracourcix",10,village);
    	village.setChef(abraracourcix);
    	
    }
	@Test
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlVerifIdentite = new ControlVerifierIdentite(village);
		assertNotNull(controlVerifIdentite,"Constructeur ne renvoi pas null");
	}

	@Test
	void testVerifierIdentite() {
		Gaulois gaulois=new Gaulois("Obelix",10);
		village.ajouterHabitant(gaulois);
		ControlVerifierIdentite controlVerifIdentite = new ControlVerifierIdentite(village);
		assertTrue(controlVerifIdentite.verifierIdentite("Obelix"));
		assertFalse(controlVerifIdentite.verifierIdentite("Existe pas"));
		assertFalse(controlVerifIdentite.verifierIdentite("obelix"));
	}

}
