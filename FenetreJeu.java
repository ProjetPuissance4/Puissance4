import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.*;

public class FenetreJeu extends JFrame {
	
	public String[][] cases;
	public Icon fleche;
	public JButton[] flechesJeu;
	public JPanel cadre;
	public JLabel haut;
	public boolean demarrer;
	public JLabel timer;
	
	
	public FenetreJeu() {
		super("Puissance 4");
		this.setLayout(null);
		demarrer = false;
		cases = new String[7][6];
		for (int i = 0 ; i < 7 ; i++) {
			for(int j = 0; j < 6 ; j++) {
				cases[i][j] = "blanc";
			}
		}
		ImageIcon fleche = new ImageIcon("fleche.png");
		setLocationRelativeTo(null);
		
		this.setSize(1300,1000); 
		
		

		//Bouton des flèches, pour jouer
		flechesJeu = new JButton[7];
		for(int i = 0 ; i < 7 ; i++) {
			flechesJeu[i] = new JButton("jouer à la ligne "+i, fleche);
			flechesJeu[i].setLocation(290+i*100,790);
			flechesJeu[i].setSize(100,100);
			this.add(flechesJeu[i]);
			//fleche[i].addActionListener(new EcouteurFleche(this), i);
		}
		
		//Texts du haut
		haut = new JLabel("Bienvenue");
		haut.setFont(new Font("Elephant", Font.BOLD, 20));
		haut.setLocation(600,50);
		haut.setSize(500,50);
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
	



		
}




