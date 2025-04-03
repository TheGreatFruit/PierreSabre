package personnages;

import java.util.Random;

public class Traitre extends Samourai {
	private int niveauTraitrise = 0;
	public Traitre(String seigneur, String nom, String boissonFav, int qArgent) {
		super(seigneur, nom, boissonFav, qArgent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traitre et momn niveau de traitrise est : " + niveauTraitrise + ". Chut !");
	}
	
	public void ranconner(Commercant commercant) {
		if (niveauTraitrise < 3) {
			int argentCommercant = commercant.getqArgent();
			int argentRanconner = argentCommercant * 2/10;
			commercant.perdreArgent(argentRanconner);
			gagnerArgent(argentRanconner);
			niveauTraitrise++;
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi "
					+ argentRanconner + " sous ou gare a toi !");
			commercant.parler("Tout de suite grand " + getNom() + ".");
		} else {
			parler("Mince ! Je ne peux plus ranconner " + commercant.getNom() + "sinon un samourai risque de me demasquer !");
		}
	}
	
	public void faireLeGentil() {
		if (nbConnaissance < 1) {
			parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif.");
		} else {
			Random r = new Random();
			int i = r.nextInt(nbConnaissance-1);
			int don = qArgent * 1/20;
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + getNom() + ".");
			parler("Bonjour l'ami ! Je voudrais vous aider en vous donnant " + don + " sous.");
			memoire[i].gagnerArgent(don);
			perdreArgent(don);
			memoire[i].parler("Merci " + getNom() + ", vous etes quelqu'un de bien.");
			if (niveauTraitrise > 0) {
				niveauTraitrise--;
			}
		
		}
	}
	
}
