import java.lang.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class Temps {
	
	private int heure=0;
	private int minute=0;
	private int seconde=0;
    private JPanel panel;
    private JLabel label;
    public static Timer timer;
    int delais=1000;
    ActionListener tache_timer;
    
   
    
    
    public Temps(){
        label = new JLabel("0"+heure+":0"+minute+":0"+seconde); 
        panel = new JPanel(); 
    }
    
    
     public void start(){
        tache_timer= new ActionListener(){

            public void actionPerformed(ActionEvent e1){
				String heurezero;
				String minutezero;
				String secondezero;
                seconde++;
                if(seconde==60){
                    seconde=0;
                    minute++;
                }
                if(minute==60){
                    minute=0;
                    heure++;
                }
                if ( heure < 10 ) {
					heurezero = "0";
				}
				else { 
					heurezero = "";
				}
					
				if ( minute < 10 ) {
					minutezero = "0";
				}
				else {
					minutezero = "";
				}
				if ( seconde < 10 ) {
					secondezero = "0";
				}
				else {
					secondezero = "";
				}
                label.setText(heurezero+heure+":"+minutezero+minute+":"+secondezero+seconde);
            }
        };
        timer= new Timer(delais,tache_timer);
        timer.start();
        label.setBorder(new EmptyBorder(20,140,20,20));
        panel.add(label,"Center");

    }
    
      public JPanel getPanel(){
        return panel;
    }
    
}
