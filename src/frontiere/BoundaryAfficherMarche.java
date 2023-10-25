package frontiere;

import controleur.ControlAfficherMarche;
import personnages.Gaulois;
import villagegaulois.Etal;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
        String[] infosMarche=controlAfficherMarche.donnerInfosMarche();
        String vendeur,quantite,produit;
        if(infosMarche.length==0) {
        	System.out.println("le marché est vide , revenez plus tard.");
        }
        else {
        	System.out.println(nomAcheteur+" vous trouverez au marché : \n");
			for (int i = 0; i < infosMarche.length; i++) {
                vendeur=infosMarche[i];
                i++;
                quantite=infosMarche[i];
                i++;
                produit=infosMarche[i];
                i++;
				System.out.println("- "+vendeur+ "qui vend "+ quantite+" "+produit);
				}
			}
        	
     }
}

