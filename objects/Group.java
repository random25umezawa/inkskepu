package objects;

import java.awt.Graphics2D;

public class Group extends GroupObject{
	public Group(BaseObject _parent) {
		super(_parent);
	}

	@Override
	void applyAttr(Graphics2D g) {
		//no
	}

	@Override
	public String getName() {
		return "g";
	}
}
