import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClicEvent implements ActionListener {

    public void actionPerformed(ActionEvent e)
    {       
    	synchronized (Vue.clic) {
    		Humain.colSelected = Integer.parseInt(e.getActionCommand());
    		Vue.clic.notify(); 
    	}
    }

}
