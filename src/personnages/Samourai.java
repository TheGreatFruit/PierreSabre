package personnages;

public class Samourai extends Humain {
	private	String seigneur;
	private int niveauTraitrise;
	
	public Samourai(String seigneur, String nom, String boissonFav, int qArgent) {
		super(nom, boissonFav, qArgent);
		this.seigneur = seigneur;	
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Je suis fier de servir le seigneur " + seigneur + ".");
	}
	
	public void boire(String boisson) {
		super.boire();
		parler("Qu'est-ce que je vais choisir comme boisson ? Tiens je vais prendre du " + boisson + ".");
	}
	
}
