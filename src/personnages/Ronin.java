package personnages;

public class Ronin extends Humain {
	int honneur = 1;
	
	public Ronin(String nom, String boissonFav, int qArgent) {
		super(nom, boissonFav, qArgent);
		}

	public void donner(Commercant beneficaire) {
		int somme = 0;
		somme = qArgent * 10/100;
		parler("Tiens " + beneficaire.getNom() + ", je te donne " + somme + " sous.");
		beneficaire.recevoir(somme);
	}
	
	public void provoquer(Yakuza adversaire) {
		int force = 2 * honneur;
		parler("Je t'ai retrouve vermine, tu vas payer pour ce que tu as fait a ce pauvre marchand !");
		if (force >= adversaire.getReputation()) {
			parler("Je t'ai eu, petit Yakuza !");
			gagnerArgent(adversaire.perdre());
			honneur += 1;
		} else {
			honneur -= 1;
			adversaire.gagner(qArgent);
		}
	}
	
}
