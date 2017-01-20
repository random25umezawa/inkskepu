package objects;

/*
DrawObjectとGroupObjectの親クラスです。
要するにVector画像のアイテム全般の基底クラスです。
*/

import java.awt.Color;
import java.awt.Graphics2D;

import java.util.HashMap;

import variables.ReferenceVariable;

public abstract class BaseObject{
	BaseObject parent;
	HashMap<String,ReferenceVariable> attr;
	public BaseObject(BaseObject _parent) {
		parent = _parent;
		attr = new HashMap<>();
	}

	public abstract void draw(Graphics2D g);

	public abstract String getName();
	public HashMap<String,ReferenceVariable> getAttrs() {
		return attr;
	}

	public BaseObject getParent() {
		return parent;
	}

//追加、変更用
	public boolean setAttr(String _name, String _value) {
		if(attr.containsKey(_name)) {
			ReferenceVariable rv = attr.get(_name);
			ReferenceVariable _rv = null;
			try{
				Class cls = rv.get().getClass();
				if(cls == Double.class) _rv = new ReferenceVariable<Double>(Double.parseDouble(_value));
				if(cls == String.class) _rv = new ReferenceVariable<String>(_value);
				if(cls == Color.class) _rv = new ReferenceVariable<Color>(Color.decode(_value));
			}catch(Exception e) {
				//なかったことに
				e.printStackTrace();
			}
			if(_rv != null) {
				attr.put(_name,_rv);
				return true;
			}
			return false;
		}else {
			//attr.put(_name,new ReferenceVariable<String>(_value));
			return true;
		}
	}

//初期化用
	public boolean setAttr(String _name, ReferenceVariable _value) {
		if(attr.containsKey(_name)) {
			ReferenceVariable rv = attr.get(_name);
			if(rv.get().getClass() == _value.get().getClass()) {
				attr.put(_name,_value);
				return true;
			}else {
				return false;
			}
		}else {
			attr.put(_name,_value);
			return true;
		}
	}

	<T> T getAttr(String _name) {
		return (T)attr.get(_name).get();
	}
}
