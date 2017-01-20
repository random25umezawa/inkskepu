package objects;

import java.awt.Graphics2D;

import java.util.ArrayList;

public abstract class GroupObject extends BaseObject{
	ArrayList<BaseObject> childs;

	public GroupObject(BaseObject _parent) {
		super(_parent);
		childs = new ArrayList<>();
	}

	public ArrayList<BaseObject> getChilds() {
		return childs;
	}

	public void addChild(BaseObject _bo) {
		childs.add(_bo);
	}

	@Override
	public void draw(Graphics2D g) {
		applyAttr(g);
		for(BaseObject _bo : childs) {
			_bo.draw(g);
		}
	}

	abstract void applyAttr(Graphics2D g);
}
