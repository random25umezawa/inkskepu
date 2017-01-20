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

import variables.ReferenceVariable;

public abstract class DrawObject extends BaseObject{
	//fill-rule:evenodd;
	//stroke-dasharray:none;

	public DrawObject(BaseObject _parent) {
		super(_parent);
		setAttr("fill",new ReferenceVariable<Color>(new Color(0)));
		setAttr("fill-opacity",new ReferenceVariable<Double>(1.0));
		setAttr("stroke",new ReferenceVariable<Color>(new Color(0)));
		setAttr("stroke-width",new ReferenceVariable<Double>(1.0));
		setAttr("stroke-miterlimit",new ReferenceVariable<Double>(1.0));
		setAttr("stroke-opacity",new ReferenceVariable<Double>(1.0));
	}

	public void draw(Graphics2D g) {
		BasicStroke stroke = new BasicStroke();
		if(attr.containsKey("stroke-width")) stroke = new BasicStroke(this.<Double>getAttr("stroke-width").floatValue());
		g.setStroke(stroke);
	}
}
