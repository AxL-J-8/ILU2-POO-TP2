package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu=controlLibererEtal.isVendeur(nomVendeur);
		String[]donneesEtal;
		boolean etalOccupe;
		if(!vendeurReconnu) {
			System.out.println("Mais vous n'etes pas inscrit sur notre marché aujourd'hui !");
		}
		else {
			donneesEtal=controlLibererEtal.libererEtal(nomVendeur);
			etalOccupe=donneesEtal[0].equals("true");
			if (etalOccupe) {
				System.out.println("Vous avez vendu " +donneesEtal[4]+ " sur "+
			                        donneesEtal[3]+" "+ donneesEtal[2]+".\n"+
						"En revoir "+nomVendeur+", passez une bonne journée");
			}
		}
	}

}
