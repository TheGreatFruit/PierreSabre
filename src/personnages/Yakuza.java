package personnages;

public class Yakuza extends Humain {
	private int reputation = 4;
	private String clan;
	
	public Yakuza(String nom, String boissonFav, int qArgent, String clan) {
		super(nom, boissonFav, qArgent);
		this.clan = clan;
	}
	
	public int getReputation() {
		return reputation;
	}

	public String getClan() {
		return clan;
	}

	public void extorquer(Commercant victime) {
		int argentext;
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par la ?");
		parler(victime.getNom() + ", si tu tiens à la vie, donne moi ta bourse !");
		argentext = victime.seFaireExtorquer();
		qArgent += argentext;
		reputation += 1;
		parler("J'ai piqué les " + argentext + " sous de Marco, ce qui me fait " + qArgent
				+ " sous dans ma poche. Hi ! Hi !");
	}

	public void gagner(int gain) {
		gagnerArgent(gain);
		reputation += 1;
		parler("Ce ronin pensait vraiment battre " + this.getNom() + " du clan " + clan + " ? Je l'ai dépouille de ses 54 sous.");
	}
	
	public int perdre() {
		int sommeperdue;
		sommeperdue =  perdreArgent(qArgent);
		reputation -= 1;
		parler("J'ai perdu mon duel et mes " + sommeperdue +" sous, snif... J'ai deshonore le clan de " + clan + ".");
		return sommeperdue;
	}

}
