public class FenetreJeu{
	
	public Joueur joueur1;
	public Joueur joueur2;
	public Pion[][] grille;
	
	
	public FenetreJeu(){
		grille= new Pion[6][7];
		//joueur1= new Joueur(FenetreAccueil.getNom1(),FenetreAccueil.getCouleur1());
		//joueur2= new Joueur(FenetreAccueil.getNom2(),FenetreAccueil.getCouleur2());
	}
	
	public void initGrille(){
		for (int i=0; i<6; i++){
			for (int j=0;i<7;i++){
				grille[i][j]=new Pion("vide");
			}
		}
	}
	
	public void jouer1(JButton colonne){
		int numCol=flechesJeu[colonne];
		int i=0;
		while(grille[i][colonne].couleur == 'vide'){
			i++;
		}
		if(i>6){
			System.out.println("On ne peut pas ajouter de pion dans cette colonne");
		}else{
			Pion p = new Pion(joueur1.getCouleur());
			p=grille[i][colonne];
		}
		
	}
	
	public void jouer2(JButton colonne){
		int numCol=flechesJeu[colonne];
		int i=0;
		while(grille[i][colonne].couleur == "vide"){
			i++;
		}
		if(i>6){
			System.out.println("On ne peut pas ajouter de pion dans cette colonne");
		}else{
			Pion p = new Pion(joueur2.getCouleur());
			p=grille[i][colonne];
		}
		
	}
	
}

