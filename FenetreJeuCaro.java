public class FenetreJeuCaro{
	
	public Joueur joueur1;
	public Joueur joueur2;
	public Pion[][] grille;
	public Pion pionGagnant;
	public int compteurTour = 0;
	
	
	public FenetreJeuCaro(FenetreAccueil fen){
		grille= new Pion[8][9];
		pionGagnant=new Pion("vide");
		//joueur1= new Joueur(FenetreAccueil.getNom1(),FenetreAccueil.getCouleur1());
		//joueur2= new Joueur(FenetreAccueil.getNom2(),FenetreAccueil.getCouleur2());
	}
	
	public void initGrille(){
		//on rajoute 2 lignes et 2 colonnes en + pour que les tests à la fin marchent
		for (int i=0; i<8; i++){
			for (int j=0;i<9;i++){
				//on crée un tableau de pion de couleur "vide" (=pas de pion)
				grille[i][j]=new Pion("vide");
			}
		}
	}
	
	public void jouer1(int colonne){
		int numCol=flechesJeu[colonne];
		int i=6;
		//on parcourt la colonne en sens inverse pour vérifier qu'elle n'est pas déjà remplie
		while(grille[i][colonne].getCouleurPion() == "vide"){
			i--;
		}
		// la colonne est pleine
		if(i==0){
			System.out.println("On ne peut pas ajouter de pion dans cette colonne");
		//il reste de la place, on ajoute le pion
		}else{
			Pion p = new Pion(joueur1.getCouleurJoueur());
			p=grille[i][colonne];
		}
		compteurTour ++;
		
	}
	
	public void jouer2(int colonne){
		//même chose que pour jouer1
		int numCol=flechesJeu[colonne];
		int i=6;
		while(grille[i][colonne].getCouleurPion() == "vide"){
			i--;
		}
		if(i==0){
			System.out.println("On ne peut pas ajouter de pion dans cette colonne");
		}else{
			Pion p = new Pion(joueur2.getCouleurJoueur());
			p=grille[i][colonne];
		}
		compteurTour ++;
		
	}
	
	public Joueur quiJoue(){
		Joueur sonTour;
		if (compteurTour % 2 == 0){ //si le nombre de tour est pair, c'est joueur1  qui joue
			System.out.println("C'est à " + joueur1.nom + " de jouer.");
			sonTour=joueur1;
		}else{
			System.out.println("C'est à " + joueur2.nom + " de jouer."); //inversement pour joueur2
			sonTour=joueur2;
		}
		return sonTour;
	}
		
	public boolean TestVictoire(){
		boolean test=false;
		//si un test d'alignement de 4 pions est vérifié, il y a victoire
		if(testLigneDroite() == true || testLigneGauche() == true || testLigneHaut() == true || testLigneBas() == true || testDiagoHautDroite() == true || testDiagoHautGauche() == true ||  testDiagoBasDroite() == true || testDiagoBasGauche() == true){
			test=true;
		}
		return test;
			
	}
	
	public void fin(){
		if(TestVictoire() ==true){
			String couleurGagnant = pionGagnant.getCouleurPion();
			if(joueur1.getCouleurJoueur()==couleurGagnant){
				System.out.println("La partie est terminée, c'est " + joueur1.getNom() + " qui a gagné.");
				joueur1.addVic();
			}if(joueur2.getCouleurJoueur()==couleurGagnant){
				System.out.println("La partie est terminée, c'est " + joueur2.getNom() + " qui a gagné.");
				joueur2.addVic();
			}
		}
	}
			
		
	
	public boolean testLigneDroite(){
		boolean test=false;
		for (int i=0; i<8; i++){
			for (int j=0;i<9;i++){
				Pion p = grille[i][j];
				if(p.getCouleurPion() != "vide"){
					while(grille[i][j].couleur == p.getCouleurPion()){
						i++;
					}
					if(i==4){
						test=true;
						pionGagnant=p;
					}
				}
			}
		}
		return test;
	}
	
	public boolean testLigneGauche(){
		boolean test=false;
		for (int i=0; i<8; i++){
			for (int j=0;i<9;i++){
				Pion p = grille[i][j];
				if(p.getCouleurPion() != "vide"){
					while(grille[i][j].couleur == p.getCouleurPion()){
						i--;
					}
					if(i==4){
						test=true;
						pionGagnant=p;
					}
				}
			}
		}
		return test;
	}
	
	public boolean testLigneHaut(){
		boolean test=false;
		for (int i=0; i<8; i++){
			for (int j=0;i<9;i++){
				Pion p = grille[i][j];
				if(p.getCouleurPion() != "vide"){
					while(grille[i][j].couleur == p.getCouleurPion()){
						j--;
					}
					if(i==4){
						test=true;
						pionGagnant=p;
					}
				}
			}
		}
		return test;
	}
					
	public boolean testLigneBas(){
		boolean test=false;
		for (int i=0; i<8; i++){
			for (int j=0;i<9;i++){
				Pion p = grille[i][j];
				if(p.getCouleurPion() != "vide"){
					while(grille[i][j].couleur == p.getCouleurPion()){
						j++;
					}
					if(i==4){
						test=true;
						pionGagnant=p;
					}
				}
			}
		}
		return test;
	}	
	
					
	public boolean testDiagoHautDroite(){
		boolean test=false;
		for (int i=0; i<8; i++){
			for (int j=0;i<9;i++){
				Pion p = grille[i][j];
				if(p.getCouleurPion() != "vide"){
					while(grille[i][j].couleur == p.getCouleurPion()){
						j++;
						i--;
					}
					if(i==4){
						test=true;
						pionGagnant=p;
					}
				}
			}
		}
		return test;
	}	
	
	public boolean testDiagoHautGauche(){
		boolean test=false;
		for (int i=0; i<8; i++){
			for (int j=0;i<9;i++){
				Pion p = grille[i][j];
				if(p.getCouleurPion() != "vide"){
					while(grille[i][j].couleur == p.getCouleurPion()){
						j--;
						i--;
					}
					if(i==4){
						test=true;
						pionGagnant=p;
					}
				}
			}
		}
		return test;
	}				
		
	public boolean testDiagoBasGauche(){
		boolean test=false;
		for (int i=0; i<8; i++){
			for (int j=0;i<9;i++){
				Pion p = grille[i][j];
				if(p.getCouleurPion() != "vide"){
					while(grille[i][j].couleur == p.getCouleurPion()){
						j--;
						i++;
					}
					if(i==4){
						test=true;
						pionGagnant=p;
					}
				}
			}
		}
		return test;
	}				
		
	public boolean testDiagoBasDroite(){
		boolean test=false;
		for (int i=0; i<8; i++){
			for (int j=0;i<9;i++){
				Pion p = grille[i][j];
				if(p.getCouleurPion() != "vide"){
					while(grille[i][j].couleur == p.getCouleurPion()){
						j++;
						i++;
					}
					if(i==4){
						test=true;
						pionGagnant=p;
					}
				}
			}
		}
		return test;
	}				
					
	
}

