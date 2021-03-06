package objects;

/*
svg要素のこと
*/

import java.awt.Graphics2D;

import variables.SimpleVariable;

public class Svg extends GroupObject{
	public Svg(BaseObject _parent) {
		super(_parent);
		setAttr("viewBox",new SimpleVariable<String>("0,0,500,500"));
		setAttr("xmlns:svg",new SimpleVariable<String>("http://www.w3.org/2000/svg"));
		setAttr("xmlns",new SimpleVariable<String>("http://www.w3.org/2000/svg"));
		setAttr("xmlns:xlink",new SimpleVariable<String>("http://www.w3.org/1999/xlink"));
	}

/*
	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		g.drawRect(<Double>getAttr("x").intValue(),<Double>getAttr("y").intValue(),<Double>getAttr("width").intValue(),<Double>getAttr("height").intValue());
	}
*/

	@Override
	void applyAttr(Graphics2D g) {
		//no
	}

	@Override
	public String getName() {
		return "svg";
	}
}
