package window;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	MainPanel mp;
	public MainFrame() {
		setTitle("inkskape");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		mp = new MainPanel();
		getContentPane().add(mp);
		pack();

		setVisible(true);
	}
}
