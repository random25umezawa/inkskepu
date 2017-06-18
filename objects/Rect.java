package objects;

import java.awt.Color;
import java.awt.Graphics2D;

import variables.SimpleVariable;

public class Rect extends DrawObject{
	public Rect(BaseObject _parent) {
		super(_parent);
		setAttr("x",new SimpleVariable<Double>(0.0));
		setAttr("y",new SimpleVariable<Double>(0.0));
		setAttr("width",new SimpleVariable<Double>(0.0));
		setAttr("height",new SimpleVariable<Double>(0.0));
		setAttr("rx",new SimpleVariable<Double>(0.0));
		setAttr("ry",new SimpleVariable<Double>(0.0));
	}
	public Rect(BaseObject _parent, SimpleVariable<Double> _x, SimpleVariable<Double> _y, SimpleVariable<Double> _w, SimpleVariable<Double> _h, SimpleVariable<Double> _rx, SimpleVariable<Double> _ry) {
		super(_parent);
		setAttr("x",_x);
		setAttr("y",_y);
		setAttr("width",_w);
		setAttr("height",_h);
		setAttr("rx",_rx);
		setAttr("ry",_ry);
	}
	public Rect(BaseObject _parent, double _x, double _y, double _w, double _h, double _rx, double _ry) {
		super(_parent);
		setAttr("x",new SimpleVariable<Double>(_x));
		setAttr("y",new SimpleVariable<Double>(_y));
		setAttr("width",new SimpleVariable<Double>(_w));
		setAttr("height",new SimpleVariable<Double>(_h));
		setAttr("rx",new SimpleVariable<Double>(_rx));
		setAttr("ry",new SimpleVariable<Double>(_ry));
	}

	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		g.setColor(this.<Color>getAttr("fill"));
		g.fillRoundRect(this.<Double>getAttr("x").intValue(),this.<Double>getAttr("y").intValue(),this.<Double>getAttr("width").intValue(),this.<Double>getAttr("height").intValue(),this.<Double>getAttr("rx").intValue(),this.<Double>getAttr("ry").intValue());
		g.setColor(this.<Color>getAttr("stroke"));
		g.drawRoundRect(this.<Double>getAttr("x").intValue(),this.<Double>getAttr("y").intValue(),this.<Double>getAttr("width").intValue(),this.<Double>getAttr("height").intValue(),this.<Double>getAttr("rx").intValue(),this.<Double>getAttr("ry").intValue());
	}

	@Override
	public String getName() {
		return "rect";
	}
}
