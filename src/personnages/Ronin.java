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
	
}
