package objects;

/*
ストロークの描画などが統一されている、目に見えて描画されるものたち
という設定
○ rect circle line ...
× filter layer use ...
*/

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

import variables.ColorVariable;
import variables.DoubleVariable;

public abstract class DrawObject extends BaseObject{
	//fill-rule:evenodd;
	//stroke-dasharray:none;

	public DrawObject(BaseObject _parent) {
		super(_parent);
		setAttr("fill",new ColorVariable(new Color(0)));
		setAttr("fill-opacity",new DoubleVariable(1.0));
		setAttr("stroke",new ColorVariable(new Color(0)));
		setAttr("stroke-width",new DoubleVariable(1.0));
		setAttr("stroke-miterlimit",new DoubleVariable(1.0));
		setAttr("stroke-opacity",new DoubleVariable(1.0));
	}

	public void draw(Graphics2D g) {
		BasicStroke stroke = new BasicStroke();
		if(attr.containsKey("stroke-width")) stroke = new BasicStroke(((DoubleVariable)this.getAttr("stroke-width")).get().floatValue());
		g.setStroke(stroke);
	}
}
