package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu=controlPrendreEtal.verifierIdentite(nomVendeur);
		boolean etalDisponible;
		
		if(!nomVendeurConnu) {
			System.out.println("Je suis désolé "+nomVendeur+" mais il faut etre un habitant de notre village pour commercer ici.");
		}
		else {
			System.out.println("Bonjour "+nomVendeur+" , je vais regarder si je peux vous trouver un étal.");
			etalDisponible=controlPrendreEtal.resteEtals();
			
			if (!etalDisponible) {
				System.out.println("Désolée " +nomVendeur +"je n'ai plus d'étal qui ne soit pas déja occupé");
			}
			else {
				installerVendeur(nomVendeur);
				
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		String produit;
		int nbProduit,numeroEtal;
		System.out.println("C'est parfait, il me reste un étal pour vous !\n"
				           + "IL me faudrait quelques renseignements:\n"
				           +"Quel produit souhaitez vous vendre ?");
		produit=scan.next();
		nbProduit=Clavier.entrerEntier("Combien souhaitez-vous vendre ?");
		numeroEtal= controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal!=-1) {
			System.out.println("Le vendeur "+ nomVendeur+ "s'est installé à l'étal n° "+(numeroEtal));
		}
	}
}
