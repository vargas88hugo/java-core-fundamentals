package timer;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer; // to resolve conflict with java.util.Timer

/**
 * This program implements a timer and resolves a  method conflict with Timer
 * @author Hugo Vargas
 * @version 1.0 2019-12-27 
 */
public class TimerTest {

	public static void main(String[] args) 
	{
		ActionListener listener = new TimePrinter();
		
		/**
		 * @see	Timer(int interval, ActionListener listener) constructs 
		 * a timer that notifies listener whenever interval milliseconds have elapsed.
		 * @see	start() starts the timer. Once started, the timer calls 
		 * actionPerformed on its listeners.
		 * @see	stop() stops the timer. Once stopped, the timer no longer calls 
		 * actionPerformed on its listeners
		 */
		Timer t = new Timer(10000, listener);
		t.start();
		
		/**
		 * showMessageDialog displays a dialog box with a message 
		 * prompt and an OK button. The dialog is centered over 
		 * the parent component. If parent is null , the dialog is 
		 * centered on the screen.
		 */
		JOptionPane.showMessageDialog(null, "Quit Program?");
		System.exit(0);
	}
}

class TimePrinter implements ActionListener
{
	public void actionPerformed(ActionEvent event)
	{
		System.out.println("At the tone, the time is " + new Date());
		
		/**
		 * @see	getDefaultToolkit() gets the default toolkit. A toolkit contains 
		 * information about the GUI environment.
		 * @see beep() emits a beep sound
		 */
		Toolkit.getDefaultToolkit().beep();
	}
}

