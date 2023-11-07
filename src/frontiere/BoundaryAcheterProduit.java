package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean nomValide=controlAcheterProduit.verifierIdentite(nomAcheteur);
		String[] listeVendeur;
		int indiceVendeur;
		int nbProduit;
		int nbProduitAchete;
	    String produit;
	    String nomVendeur;
	    
		if(nomValide) {
			System.out.println("Quel produit souhaitez-vous acheter ?");
			produit=scan.next();
			listeVendeur=controlAcheterProduit.trouverCommercant(produit);
			
			if(listeVendeur!=null) {
				indiceVendeur=recupererIndiceVendeur(listeVendeur);
				
				if(indiceVendeur<listeVendeur.length) {
					
				   nomVendeur=listeVendeur[indiceVendeur];
				   System.out.println(nomAcheteur+" se déplace jusqu'à l'étal du vendeur " +nomVendeur+"\n"
				   		              + "Bonjour "+nomAcheteur);
				   
				   nbProduit=Clavier.entrerEntier("Combien de "+produit+" voulez-vous acheter ?");
				   nbProduitAchete=controlAcheterProduit.acheterProduit(nomVendeur, nbProduit);
				   afficherMessageProduit(nbProduit, nbProduitAchete, nomAcheteur, nomVendeur, produit);
				}
				
				else {
				System.out.println("Désolé, le vendeur no "+(indiceVendeur+1)+ " n'existe pas");
				}
			}
			
			else {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			}
		}
		
		else {
			System.out.println(" “Je suis désolée" +nomAcheteur +" mais il faut être un habitant"
					+ " de notre village pour commercer ici.”");
		}
		
		
	}
private void afficherMessageProduit(int nbProduit ,int nbProduitAchete,String nomAcheteur,String nomVendeur,String produit) {
	StringBuilder messageFinale = new StringBuilder();
	String message1=nomAcheteur+" veut acheter "+ nbProduit+" "+produit+",";
	String message2="  malheureusement il n'y en a plus !";
	String message3="  malheureusement "+nomVendeur+ "n'en a plus que "+nbProduitAchete+".";
	String message4=nomAcheteur+ " achète tout le stock de "+nomVendeur+".";
	if(nbProduitAchete==nbProduit) {
		System.out.println(nomAcheteur+" achete "+ nbProduit+" "+produit+" a "+ nomAcheteur+".");
	
	}
   else {
	   messageFinale.append(message1);
	   if (nbProduitAchete==0) {
		   messageFinale.append(message2);}
	   else {
		   messageFinale.append(message3);
		   messageFinale.append(message4);
	   }
	   System.out.println(messageFinale.toString());
	   }
	   
   }

private int recupererIndiceVendeur(String[] listeVendeur) {
	int indiceVendeur;
	StringBuilder question = new StringBuilder();
	question.append("Chez quel commerçant voulez-vous acheter des fleurs ?\n");
	for(int i=0;i<listeVendeur.length;i++) {
		question.append((i+1)+" - "+listeVendeur[i]+"\n");		
	}
	indiceVendeur=Clavier.entrerEntier(question.toString())-1;
	return indiceVendeur;
}

}
