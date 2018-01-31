package objects;

import java.awt.Color;
import java.awt.Graphics2D;

import variables.ColorVariable;
import variables.DoubleVariable;

public class Rect extends DrawObject{
	public Rect(BaseObject _parent) {
		super(_parent);
		setAttr("x",new DoubleVariable(0.0));
		setAttr("y",new DoubleVariable(0.0));
		setAttr("width",new DoubleVariable(0.0));
		setAttr("height",new DoubleVariable(0.0));
		setAttr("rx",new DoubleVariable(0.0));
		setAttr("ry",new DoubleVariable(0.0));
	}
	/*
	public Rect(BaseObject _parent, DoubleVariable _x, DoubleVariable _y, DoubleVariable _w, DoubleVariable _h, DoubleVariable _rx, DoubleVariable _ry) {
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
		setAttr("x",new DoubleVariable(_x));
		setAttr("y",new DoubleVariable(_y));
		setAttr("width",new DoubleVariable(_w));
		setAttr("height",new DoubleVariable(_h));
		setAttr("rx",new DoubleVariable(_rx));
		setAttr("ry",new DoubleVariable(_ry));
	}
	*/

	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		g.setColor(((ColorVariable)this.getAttr("fill")).get());
		g.fillRoundRect(
			((DoubleVariable)this.getAttr("x")).get().intValue(),
			((DoubleVariable)this.getAttr("y")).get().intValue(),
			((DoubleVariable)this.getAttr("width")).get().intValue(),
			((DoubleVariable)this.getAttr("height")).get().intValue(),
			((DoubleVariable)this.getAttr("rx")).get().intValue(),
			((DoubleVariable)this.getAttr("ry")).get().intValue()
		);
		g.setColor(((ColorVariable)this.getAttr("stroke")).get());
		g.drawRoundRect(
			((DoubleVariable)this.getAttr("x")).get().intValue(),
			((DoubleVariable)this.getAttr("y")).get().intValue(),
			((DoubleVariable)this.getAttr("width")).get().intValue(),
			((DoubleVariable)this.getAttr("height")).get().intValue(),
			((DoubleVariable)this.getAttr("rx")).get().intValue(),
			((DoubleVariable)this.getAttr("ry")).get().intValue()
		);
	}

	@Override
	public String getName() {
		return "rect";
	}
}
