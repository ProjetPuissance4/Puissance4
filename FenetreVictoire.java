import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FenetreVictoire extends JFrame {
	
	//Attributs
	private JLabel titre = new JLabel("VICTOIRE !!!!");
	private JPanel pane;
	private JLabel image;
	private JPanel haut;
	
	//Constructeur
	public FenetreVictoire() {
		
		super("Victoire");
		
		//Changement de police
		titre.setFont(new Font("Elephant", Font.BOLD, 48));
		
		//Création du visuel 
		pane = new JPanel(new BorderLayout());
		haut = new JPanel(new BorderLayout());
		image = new JLabel( new ImageIcon( "feuxartifices.gif"));
		haut.add(titre);
		pane.add(image);
		
		this.add(haut, BorderLayout.NORTH);
		this.add(pane, BorderLayout.CENTER);
		
		setVisible(true); 
		this.setSize(500,500);
		
	}
}

		
	
