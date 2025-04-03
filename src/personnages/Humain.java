package personnages;

import java.util.Iterator;

public class Humain {
	private String nom;
	private String boissonFav;
	protected int qArgent;
	protected Humain[] memoire = new Humain[30];
	protected int nbConnaissance;

	
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
	
	private void repondre() {
		direBonjour();
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFav + " ! GLOUPS !");
	}
	
	public void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		autreHumain.repondre();
		autreHumain.memoriser(this);
		memoriser(autreHumain);
		
	}

	private void memoriser(Humain humain) {
	    // Vérifie si l'humain est déjà dans memoire
	    for (int i = 0; i < nbConnaissance; i++) {
	        if (memoire[i] == humain) {
	            return; // L'humain est déjà mémorisé, donc on ne fait rien
	        }
	    }

	    // Si le tableau est plein, on déplace les éléments vers la gauche et on ajoute la nouvelle connaissance
	    if (nbConnaissance == memoire.length) {
	        // Décale toutes les connaissances vers la gauche (écrase la première)
	        for (int i = 1; i < nbConnaissance; i++) {
	            memoire[i - 1] = memoire[i];  // Décale chaque élément vers la gauche
	        }
	    } else {
	        // Si le tableau n'est pas encore plein, on décale juste une position et on ajoute la nouvelle connaissance
	        nbConnaissance++;
	    }

	    // Ajoute la nouvelle connaissance à la dernière position (qui est maintenant disponible)
	    memoire[nbConnaissance - 1] = humain;
	}


	
	public void listerConnaissances() {
		parler("Je connais beaucoup de monde dont : ");
	    for (int i = 0; i < nbConnaissance; i++) {
	        System.out.print(memoire[i].getNom());
	        if (i < nbConnaissance - 1) {
	            System.out.print(", ");
	        }
	    }
	    System.out.println();
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