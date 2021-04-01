import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.*;
import java.lang.*;
import java.lang.Thread;
import java.util.concurrent.TimeUnit;


public class FenetreJeu extends JFrame {
	
	public String[][] cases;
	public Pion pionGagnant;
	public JButton[] flechesJeu;
	public JPanel cadre;
	public JLabel haut;
	public boolean demarrer;
	public JLabel timer;
	public int[] tabJeu;
	public int nbCoup;
	public FenetreAccueil fAccueil;
	public JLabel[][] grille;
	public Joueur[] joueur;
	public ImageIcon fleche;
	public ImageIcon[] images = new ImageIcon[]{ new ImageIcon("bleu.jpg"), new ImageIcon("rouge.jpg") , new ImageIcon("vert.jpg") , new ImageIcon("jaune.jpg") } ;
	
	public FenetreJeu(FenetreAccueil f, Joueur j1, Joueur j2) {
		
		super("Puissance 4");
		
		fAccueil = f;
		nbCoup = 0;
		joueur = new Joueur[]{j1 , j2};
		this.setLayout(null);
		tabJeu = new int[]{0,0,0,0,0,0,0};
		demarrer = false;
		cases = new String[9][8];
		for (int i = 0 ; i < 9 ; i++) {
			for(int j = 0; j < 8 ; j++) {
				cases[i][j]= "blanc";
			}
		}
		
		grille = new JLabel[7][6];
		fleche = new ImageIcon("fleche.png");
		setLocationRelativeTo(null);
		
		this.setSize(1300,1000); 
		
		

		//Bouton des flèches, pour jouer
		flechesJeu = new JButton[7];
		for(int i = 0 ; i < 7 ; i++) {
			flechesJeu[i] = new JButton("jouer à la ligne "+i, fleche);
			flechesJeu[i].addActionListener(new EcouteurFleche((this), i));
			flechesJeu[i].setLocation(290+i*100,790);
			flechesJeu[i].setSize(100,100);
			this.add(flechesJeu[i]);
		}
		
		//Texts du haut
		haut = new JLabel("C'est à "+joueur[nbCoup%2].getNom()+" de jouer ! ");
		haut.setFont(new Font("Elephant", Font.BOLD, 20));
		haut.setLocation(600,50);
		haut.setSize(400,50);
		this.add(haut);
		
		this.validate();
		this.repaint();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(1000,200,1000,800);
		for (int i = 0; i <= 6 ; i++ ) {
			g.drawLine(300+i*100,200,300+i*100,800);
			g.drawLine(300,200+i*100,1000,200+i*100);
		}
	}
	
		
	public void showfile() throws java.io.IOException {
		
	}
	
	public void startTimer() {
		
	}
	
	public void jouer(int col) {
		
		
		if ( nbCoup == 0 ) {
			this.startTimer();
		}
		
		if (tabJeu[col] == 6) {
			this.remove(flechesJeu[col]);
		}
		

		cases[col][tabJeu[col]] =  joueur[nbCoup%2].getPion().getCouleur();
		grille[col][tabJeu[col]] = new JLabel(joueur[nbCoup%2].getPion().getImage());
		grille[col][tabJeu[col]].setSize(100,100);
		grille[col][tabJeu[col]].setLocation(290+col*100,160);
		this.add(grille[col][tabJeu[col]]);
		int nbFois = 50 - 10 * tabJeu[col];
		repaint();
		
		for (int i = 1; i <= nbFois ; i++) {
			this.remove(grille[col][tabJeu[col]]);
			grille[col][tabJeu[col]] = new JLabel(joueur[nbCoup%2].getPion().getImage());
			grille[col][tabJeu[col]].setSize(100,100);
			grille[col][tabJeu[col]].setLocation(290+col*100,160+i*10);
			this.add(grille[col][tabJeu[col]]);
			validate();
			repaint();
			wait(20);
		}
		
		tabJeu[col]++;
		
		if (tabJeu[col] == 6) {
			this.remove(flechesJeu[col]);
		}
		
		if (!testVictoire()) {
			nbCoup++;
			haut.setText("C'est à "+joueur[nbCoup%2].getNom()+" de jouer ! ");
		}
		
		else if (testVictoire()) {
			this.victoire();
		}
	}
	
	
	public boolean testVictoire(){
		boolean test=false;
		//si un test d'alignement de 4 pions est vérifié, il y a victoire
		if(testLigneDroite() == true){ // || testLigneGauche() == true || testLigneHaut() == true || testLigneBas() == true || testDiagoHautDroite() == true || testDiagoHautGauche() == true ||  testDiagoBasDroite() == true || testDiagoBasGauche() == true){
			test=true;
			System.out.println("victoire");
		}
		return test;
			
	}
	public boolean testLigneDroite(){
		boolean test=false;
		for (int i=0; i<8; i++){
			for (int j=0;i<9;i++){
				String p = cases[i][j];
				if(p != "blanc"){
					int cpt=0;
					while(cases[i][j]== p){
						cpt++;
						i++;
					}
					if(cpt==4){
						test=true;
						System.out.println("vic");
						pionGagnant.setCouleur(p);
					}
				}
			}
		}
		return test;
	}
	
	/*public boolean testLigneGauche(){
		boolean test=false;
		for (int i=0; i<8; i++){
			for (int j=0;i<9;i++){
				Pion p = cases[i][j];
				if(p.getCouleur() != "blanc"){
					while(cases[i][j].couleur == p.getCouleur()){
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
				Pion p = cases[i][j];
				if(p.getCouleur() != "blanc"){
					while(cases[i][j].couleur == p.getCouleur()){
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
				Pion p = cases[i][j];
				if(p.getCouleur() != "blanc"){
					while(cases[i][j].couleur == p.getCouleur()){
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
				Pion p = cases[i][j];
				if(p.getCouleur() != "blanc"){
					while(cases[i][j].couleur == p.getCouleur()){
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
				Pion p = cases[i][j];
				if(p.getCouleur() != "blanc"){
					while(cases[i][j].couleur == p.getCouleur()){
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
				Pion p = cases[i][j];
				if(p.getCouleur() != "blanc"){
					while(cases[i][j].couleur == p.getCouleur()){
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
				Pion p = cases[i][j];
				if(p.getCouleur() != "blanc"){
					while(cases[i][j].couleur == p.getCouleur()){
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
	*/
	
	public void victoire() {
		if(testVictoire() ==true){
			String couleurGagnant = pionGagnant.getCouleur();
			if(joueur[0].getPion().getCouleur()==couleurGagnant){
				System.out.println("La partie est terminée, c'est " + joueur[0].getNom() + " qui a gagné.");
				joueur[0].addVic();
			}if(joueur[1].getPion().getCouleur()==couleurGagnant){
				System.out.println("La partie est terminée, c'est " + joueur[1].getNom() + " qui a gagné.");
				joueur[1].addVic();
			}
		}
	}
	
		
	
	
	public static void wait(int ms) {
										
		try {
		
			Thread.sleep(ms);
        
		}
    
		catch(InterruptedException ex) {
		
			Thread.currentThread().interrupt();
		}
	}
	
	

		
}




