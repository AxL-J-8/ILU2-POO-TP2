package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer
	public boolean verifierIdentite(String nomVillageois) {
		return controlVerifierIdentite.verifierIdentite(nomVillageois);
	}
	public String[] trouverCommercant(String Produit) {
		String[]listeVendeur=null;
		int leng;
		Gaulois[] vendeur=village.rechercherVendeursProduit(Produit);
		if(vendeur!=null) {
			
			leng=vendeur.length;
			listeVendeur=new String[leng];
			for(int i=0;i<leng;i++) {
				listeVendeur[i]=vendeur[i].getNom();
		}
			
		}
		return listeVendeur;
	}
	public int acheterProduit(String nomVendeur,int quantite) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etal.acheterProduit(quantite);
	}

	
}
