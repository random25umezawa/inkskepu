package window;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import functions.Data;
import functions.XmlUtil;
import objects.Rect;

class MainPanel extends JPanel implements KeyListener{
	MainPanel() {
		setPreferredSize(new Dimension(500,500));
		addKeyListener(this);
		setFocusable(true);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Data.draw((Graphics2D)g);
	}

	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_R:
				Rect r = new Rect(Data.mother);
				r.setAttr("x",""+System.nanoTime()%300);
				r.setAttr("y",""+System.nanoTime()%400);
				r.setAttr("width",""+System.nanoTime()%50+50);
				r.setAttr("height",""+System.nanoTime()%34+68);
				r.setAttr("rx","5");
				r.setAttr("ry","5");
				Data.add(r);
				break;
			case KeyEvent.VK_S:
				XmlUtil.write("save.svg",Data.set);
				break;
			case KeyEvent.VK_L:
				Data.back();
				break;
		}
		repaint();
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}
