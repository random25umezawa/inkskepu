package objects;

import java.awt.Color;
import java.awt.Graphics2D;

import variables.ReferenceVariable;

public class Rect extends DrawObject{
	public Rect(BaseObject _parent) {
		super(_parent);
		setAttr("x",new ReferenceVariable<Double>(0.0));
		setAttr("y",new ReferenceVariable<Double>(0.0));
		setAttr("width",new ReferenceVariable<Double>(0.0));
		setAttr("height",new ReferenceVariable<Double>(0.0));
		setAttr("rx",new ReferenceVariable<Double>(0.0));
		setAttr("ry",new ReferenceVariable<Double>(0.0));
	}
	public Rect(BaseObject _parent, ReferenceVariable<Double> _x, ReferenceVariable<Double> _y, ReferenceVariable<Double> _w, ReferenceVariable<Double> _h, ReferenceVariable<Double> _rx, ReferenceVariable<Double> _ry) {
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
		setAttr("x",new ReferenceVariable<Double>(_x));
		setAttr("y",new ReferenceVariable<Double>(_y));
		setAttr("width",new ReferenceVariable<Double>(_w));
		setAttr("height",new ReferenceVariable<Double>(_h));
		setAttr("rx",new ReferenceVariable<Double>(_rx));
		setAttr("ry",new ReferenceVariable<Double>(_ry));
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
