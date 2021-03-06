/* Life is Hard
 * a virtual representation of how I feel.
 * Carrie Nguyen
 * 6/1/17
 */

package mood;

import javax.swing.*;
import java.awt.event.*;      
import java.util.Random;

public class LifeIsHard implements ActionListener {
	String[] labelText = {"Sometimes you literally just can't and that's ok", "What?",
			"Sorry, I'm 200% done.", "I h8 everything.", "Please don't bother me, I already bother myself.",
			"I would like 5 minutes of peace and a pizza to go, thank you."};
	Random rand = new Random();
	JFrame frame;
	JPanel contentPane;
	JLabel label;
	JButton button;

    public LifeIsHard(){
        /* Create and set up the frame */
        frame = new JFrame("Life Is Hard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Create a content pane */
        contentPane = new JPanel();

		/* Create and add label */
	    label = new JLabel("Hello.");
        contentPane.add(label);

		/* Create and add button */
        button = new JButton("Hide from my problems.");
    	button.setActionCommand("Hide from my problems.");
    	button.addActionListener(this);
    	contentPane.add(button);

		/* Add content pane to frame */
        frame.setContentPane(contentPane);

        /* Size and then display the frame. */
        frame.pack();
        frame.setVisible(true);
    }
    
    
    /**
     * Handle button click action event
     * pre: none
     * post: Clicked button has different text and label
     * displays message depending on when the button was clicked.
     */
    public void actionPerformed(ActionEvent event) {
        String eventName = event.getActionCommand();
        
        if (eventName.equals("Hide from my problems.")) {
        	label.setText("");
        	button.setText("Do you even want to know?");
        	button.setActionCommand("Do you even want to know?");
        } else {
        	String random = (labelText[new Random().nextInt(labelText.length)]);
        	label.setText(random);
        	button.setText("Hide from my problems.");
        	button.setActionCommand("Hide from my problems.");
        }
    }


    /**
     * Create and show the GUI.
     */
    private static void runGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        LifeIsHard greeting = new LifeIsHard();
    }
     

    public static void main(String[] args) {
        /* Methods that create and show a GUI should be 
           run from an event-dispatching thread */
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                runGUI();
            }
        });
    }
}