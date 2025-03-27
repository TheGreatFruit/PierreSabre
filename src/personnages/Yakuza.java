package personnages;

public class Yakuza extends Humain {
	private int reputation = 0;
	private String clan;
	
	public Yakuza(String nom, String boissonFav, int qArgent, String clan) {
		super(nom, boissonFav, qArgent);
		this.clan = clan;
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

}
