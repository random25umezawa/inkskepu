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

		Parameter<Double> p = new Parameter<>(0.5);
		Parameter<Double> p2 = new Parameter<>(p);
		System.out.println(p.get());
		System.out.println(p2.get());
		p.set(1.0);
		System.out.println(p.get());
		System.out.println(p2.get());
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
				Rect r = new Rect(System.nanoTime()%300, System.nanoTime()%400, System.nanoTime()%50+50, System.nanoTime()%34+68);
				r.setX(p2);
				Data.add(r);
				//Data.add(new Rect(System.nanoTime()%300, System.nanoTime()%400, System.nanoTime()%50+50, System.nanoTime()%34+68));
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
	Object param;
	boolean flag;
	Parameter(T _param) {
		set(_param);
	}
	Parameter(Parameter<T> _param) {
		set(_param);
	}
	void set(T _param) {
		param = _param;
		flag = false;
	}
	void set(Parameter<T> _param) {
		param = _param;
		flag = true;
	}
	T get() {
		if(flag) return (T)((Parameter)param).get();
		return (T)param;
	}
}

interface DrawObject{
	public abstract void draw(Graphics2D g);
}

class Rect implements DrawObject{
	Parameter<Double> x,y,w,h;
	Rect() {
		this(0,0,0,0);
	}
	Rect(Parameter<Double> _x, Parameter<Double> _y, Parameter<Double> _w, Parameter<Double> _h) {
		setX(_x);
		setY(_y);
		setW(_w);
		setH(_h);
	}
	Rect(double _x, double _y, double _w, double _h) {
		setX(_x);
		setY(_y);
		setW(_w);
		setH(_h);
	}
	public void setX(Parameter<Double> _x) {
		x = _x;
	}
	public void setY(Parameter<Double> _y) {
		y = _y;
	}
	public void setW(Parameter<Double> _w) {
		w = _w;
	}
	public void setH(Parameter<Double> _h) {
		h = _h;
	}
	public void setX(double _x) {
		setX(new Parameter<Double>(_x));
	}
	public void setY(double _y) {
		setY(new Parameter<Double>(_y));
	}
	public void setW(double _w) {
		setW(new Parameter<Double>(_w));
	}
	public void setH(double _h) {
		setH(new Parameter<Double>(_h));
	}
	public void draw(Graphics2D g) {
		g.drawRect(x.get().intValue(),y.get().intValue(),w.get().intValue(),h.get().intValue());
	}
}
