import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FenetreAccueil extends JFrame {
	
	//Attributs
	
	private JButton start;
	
	private JPanel p2;
	
	private JLabel titre = new JLabel("Puissance 4  : Bienvenue !");
	private JLabel joueur1 = new JLabel("              Joueur 1");
	private JLabel joueur2 = new JLabel("       Joueur 2");
	private JLabel nom1 = new JLabel("Nom :");
	private JLabel nom2 = new JLabel("Nom :");
	private JTextField entrernom1 = new JTextField("",20);
	private JTextField entrernom2 = new JTextField("",20);
	private JLabel coul1 = new JLabel("Couleur: ");
	private JLabel coul2 = new JLabel("Couleur: ");
	
	private JPanel p4 = new JPanel(new FlowLayout());
	
	private ImageIcon jaune = new ImageIcon("jaune.png");
	private ImageIcon bleu = new ImageIcon("bleu.png");
	private ImageIcon rouge = new ImageIcon("rouge.png");
	private ImageIcon vert = new ImageIcon("vert.png");
	
	private JButton[] couleur1= {new JButton(jaune), new JButton(bleu), new JButton(rouge), new JButton(vert)};
	private JButton[] couleur2= {new JButton(jaune), new JButton(bleu), new JButton(rouge), new JButton(vert)};
	
	private JPanel haut ;
	private JPanel gauche ;
	private JPanel droite ;
	private JPanel bas;
	
	public Joueur j1;
	public Joueur j2;
	
	public String[] colors = new String[] { "jaune" , "bleu" , "rouge" , "vert" };
	
	//constructeur
		
	public FenetreAccueil() {
		super("Puissance 4");
		
		//Création des joueurs
		j1 = new Joueur();
		j2 = new Joueur();
		
		// Changement de police
		titre.setFont(new Font("Elephant", Font.BOLD, 48));
		joueur1.setFont(new Font("Elephant", Font.BOLD, 48));
		joueur2.setFont(new Font("Elephant", Font.BOLD, 48));
		nom1.setFont(new Font("Elephant", Font.BOLD, 48));
		nom2.setFont(new Font("Elephant", Font.BOLD, 48));
		coul1.setFont(new Font("Elephant", Font.BOLD, 48));
		coul2.setFont(new Font("Elephant", Font.BOLD, 48));
		
		
		//Création du panneau de gauche 
		gauche = new JPanel();
		GridLayout layoutgauche = new GridLayout(0,1);
		JPanel p1 = new JPanel(new FlowLayout());
		p2 = new JPanel(new FlowLayout());
		gauche.setLayout(layoutgauche);
		gauche.add(joueur1);
		p1.add(nom1);
		p1.add(entrernom1);
		p2.add(coul1);
		
		//Affichage des 4 boutons 
		for(int i =0; i<couleur1.length; i++){
			p2.add(couleur1[i]);
			couleur1[i].addActionListener(new EcouteurBouton(this,i,colors[i]));
		}
		gauche.add(p1);
		gauche.add(p2);
		
		// Création du panneau de droite 
		droite = new JPanel();
		JPanel p3 = new JPanel(new FlowLayout());
		GridLayout layoutdroite = new GridLayout(0,1);
		droite.setLayout(layoutdroite);
		droite.add(joueur2);
		p3.add(nom2);
		p3.add(entrernom2);
		droite.add(p3);
		droite.add(p4);
		
		//Création du panneau du haut 
		haut = new JPanel();
		haut.add(titre, BorderLayout.NORTH);
		
		//Création du panneau du bas 
		bas = new JPanel();
		JButton start= new JButton("START");
		start.setPreferredSize(new Dimension(400, 100));
		start.setFont(new Font("Elephant", Font.BOLD, 28));
		start.addActionListener(new EcouteurStart(this)); 
		bas.add(start);
		
		//Ajout des panneaux
		this.add(haut,BorderLayout.NORTH);
		add(gauche, BorderLayout.WEST);
		add(droite, BorderLayout.EAST);
		add(bas, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true); 	
		
	}
	
	//Méthode qui permet de fermer la fenêtre
	public void fermeFen() {
		dispose(); 	
	}
	
	//Méthode qui retourne le nom du joueur1
	public String getNom1() {
		return entrernom1.getText();
	}
	
	//Méthode qui retourne le nom du joueur2
	public String getNom2() {
		return entrernom2.getText();
	}
	

	public void supprimeBouton(int b){
		p4.add(coul2);
		
	// suppression du bouton choisi par le joueur 1 pour le joueur 2
		for(int i=0; i<couleur2.length; i++) {
			if (i != b) {
				p4.add(couleur2[i]);
				couleur2[i].addActionListener(new EcouteurBouton2(this,i,colors[i]));
			}
		}
		
	//supression des boutons non choisis par le joueur 1	
		for( int j = 0 ; j < couleur1.length ; j++ ) {
			if (j != b) {
				p2.remove(couleur1[j]);
			}
		}
		validate();
	}
	
	// Méthode qui permet de supprimer les boutons non choisis par le joueur 2
	public void supprimeBouton2(int b){
		for (int i = 0 ; i < couleur2.length ; i++ ) {
			if ( i != b ) {
				p4.remove(couleur2[i]);
			}
		}
		validate();
	}	
	
	
	//Méthode qui permet de savoir si le jeu peut commencer (noms remplis et couleurs choisies)
	public boolean condition() {
		return (j1.getNom().length() > 0 && j2.getNom().length() > 0 && j1.getPion().getCouleur().length() > 0 && j2.getPion().getCouleur().length() > 0);
	}
}
	

	
	
		
	 
	 
	
				
		
		
	
	
	
		


		
		
