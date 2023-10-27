package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlEmmenagerTest {
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
	void testControlEmmenager() { 
		
		ControlEmmenager controlEmmenager=new ControlEmmenager(village);
		assertNotNull(controlEmmenager,"Constructeur ne renvoie pas null");
		
	}

	@Test
	void testIsHabitant() {
		ControlEmmenager controlEmmenager= new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemie", 10);
		
		assertTrue(controlEmmenager.isHabitant("Bonemie"));
		assertFalse(controlEmmenager.isHabitant("Existe pas"));
		
		
		controlEmmenager.ajouterDuide("Panoramix", 10, 1, 5);
		
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
	}
	
	@Test
	void testAjouterDruide() {
		
		Druide monDruide= new Druide("idefix",10,1,5);
		ControlEmmenager controlEmmenager= new ControlEmmenager(village);
		controlEmmenager.ajouterDuide("idefix", 10, 1, 5);
		Gaulois habitant =village.trouverHabitant("idefix");
		
		assertNotNull(habitant, "Trouver habitant ne renvoie pas null");
		assertTrue(habitant instanceof Druide );
		assertTrue(habitant.toString().equals(monDruide.toString()));
	}
	
	@Test
	void testAjouterGaulois() {
		
		Gaulois gaulois =new Gaulois("Obelix",10);
		ControlEmmenager controlEmmenager= new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Obelix", 10);
		Gaulois habitant =village.trouverHabitant("Obelix");
		
		
		assertNotNull(habitant, "Trouver habitant ne renvoie pas null");
		assertTrue(habitant instanceof Gaulois );
		assertFalse(habitant instanceof Druide );
		assertTrue(habitant.toString().equals(gaulois.toString()));
	}
	
	
}
