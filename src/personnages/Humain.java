package personnages;

public class Humain {
	private String nom;
	private String boissonFav;
	protected int qArgent;
	
	public Humain(String nom, String boissonFav, int qArgent) {
		this.nom = nom;
		this.boissonFav = boissonFav;
		this.qArgent = qArgent;
	}

	public String getNom() {
		return nom;
	}

	public int getqArgent() {
		return qArgent;
	}
	
	public void parler(String texte) {
		System.out.println(nom + " : " + texte);
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du "
				+ boissonFav + ".");
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFav + " ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
		if (qArgent >= prix) {
			parler("J'ai " + qArgent + " sous en poche. "
					+ "Je vais pouvoir m'offrir " + bien + " à " +
					prix + " sous.");
			perdreArgent(prix);
		} else {
			parler("Je n'ai plus que  " + qArgent +
					" sous en poche. " + "Je ne peux même pas "
							+ "m'offrir " + bien + " à " +
					prix + " sous.");
		}

	}
	
	
	protected int gagnerArgent(int gain) {
		qArgent += gain;
		return gain;
	}
	
	
	protected int perdreArgent(int perte) {
		qArgent -= perte;
		return perte;
	}
	
}