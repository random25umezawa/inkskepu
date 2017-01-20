package functions;

import java.awt.Graphics2D;

import java.util.HashSet;
import java.util.Stack;

import objects.BaseObject;

public class Data{
	public static HashSet<BaseObject> set = new HashSet<>();
	public static Stack<History> history = new Stack<>();
	public static BaseObject mother;

	public static void draw(Graphics2D g) {
		//for(BaseObject _o : set) _o.draw(g);
		mother.draw(g);
	}

	public static void add(BaseObject _do) {
		set.add(_do);
		history.push(new History(_do,null));
	}

	public static void back() {
		if(!history.empty()) {
			History _his = history.pop();
			set.remove(_his.prev);
			if(_his.back!=null) set.add(_his.back);
		}
	}

	public static void change(BaseObject _before, BaseObject _after) {
		if(set.contains(_before)) {
			set.remove(_before);
			set.add(_after);
			history.push(new History(_after,_before));
		}
	}
}
