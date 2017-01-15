import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Stack;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

class Main{
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
	}
}

class MainFrame extends JFrame{
	MainPanel mp;
	MainFrame() {
		setTitle("inkskape");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		mp = new MainPanel();
		getContentPane().add(mp);
		pack();

		setVisible(true);
	}
}

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
				Data.add(new Rect(System.nanoTime()%300, System.nanoTime()%400, System.nanoTime()%50+50, System.nanoTime()%34+68));
				break;
			case KeyEvent.VK_C:
				//Data.change(Data.history.peek().prev,new Rect(System.nanoTime()%300, System.nanoTime()%400, System.nanoTime()%50+50, System.nanoTime()%34+68));
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

class Data{
	static HashSet<DrawObject> set = new HashSet<>();
	static Stack<History> history = new Stack<>();

	public static void draw(Graphics2D g) {
		for(DrawObject _o : set) _o.draw(g);
		System.out.println(set.size());
	}

	static void add(DrawObject _do) {
		set.add(_do);
		history.push(new History(_do,null));
	}

	static void back() {
		if(!history.empty()) {
			History _his = history.pop();
			set.remove(_his.prev);
			if(_his.back!=null) set.add(_his.back);
		}
	}

	static void change(DrawObject _before, DrawObject _after) {
		if(set.contains(_before)) {
			set.remove(_before);
			set.add(_after);
			history.push(new History(_after,_before));
		}
	}
}

class History{
	DrawObject prev,back;
	History(DrawObject _prev, DrawObject _back) {
		prev = _prev;
		back = _back;
	}
}

//DrawObjectに設定する各パラメータ
class Parameter<T>{
	T param;
	Parameter(T _param) {
		param = _param;
	}
	T get() {
		return param;
	}
}

interface DrawObject{
	public abstract void draw(Graphics2D g);
}

class Rect implements DrawObject{
	double x,y,w,h;
	Rect(double _x, double _y, double _w, double _h) {
		x = _x;
		y = _y;
		w = _w;
		h = _h;
	}
	public void draw(Graphics2D g) {
		g.drawRect((int)x,(int)y,(int)w,(int)h);
	}
}
