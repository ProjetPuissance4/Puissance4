public class Joueur {
	
	public String nom;
	public String couleur;
	public int nbVic;
	public Pion pion;
	
	public Joueur(String nom, String coul){
		this.couleur=coul;
		this.nom=nom;
		this.nbVic=0;
		this.pion.couleur=coul;
	}
	
	public String getNom(){
		return nom;
	}
	
	public String getCouleurJoueur(){
		return couleur;
	}
	
	public int getNbVic(){
		return nbVic;
	}
	
	public void addVic(){
		nbVic++;
	}
}

