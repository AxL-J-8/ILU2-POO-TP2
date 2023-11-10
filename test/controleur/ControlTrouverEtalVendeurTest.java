package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
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
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur,"Constructeur ne renvoi pas null");
	}

	@Test
	void testTrouverEtalVendeur() {
		Gaulois asterix =new Gaulois("Asterix",6);
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		
		Etal etal=controlTrouverEtalVendeur.trouverEtalVendeur("Asterix");
		assertNull(etal);
		
		village.ajouterHabitant(asterix);
		village.installerVendeur(asterix, "fleurs", 10);
	    etal=controlTrouverEtalVendeur.trouverEtalVendeur("Asterix");
		
		
		assertNotNull(etal,"TrouverEtalVendeur ne renvoie pas null");
		
		assertTrue(etal.isEtalOccupe());	
		assertTrue(etal.getVendeur().equals(asterix));
		assertTrue(etal.contientProduit("fleurs"));
		assertTrue(etal.getQuantite()==10);
		
	}

}