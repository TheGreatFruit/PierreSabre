package personnages;

public class Commercant extends Humain {

	public Commercant(String nom, int qArgent) {
		super(nom, "the", qArgent);

	}

	public int seFaireExtorquer() {
		parler("J'ai tout perdu ! Le monde est trop injuste...");
		return perdreArgent(qArgent);
	}
	
	public void recevoir(int argent) {
		parler(argent + " sous ! Je te remercie, genereux donateur !");
	}
	
	
}
