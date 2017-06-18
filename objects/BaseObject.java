package objects;
/*
DrawObjectとGroupObjectの親クラスです。
要するにVector画像のアイテム全般の基底クラスです。
*/

import java.awt.Color;
import java.awt.Graphics2D;

import java.util.HashMap;

import variables.Variable;

@SuppressWarnings("unchecked")
public abstract class BaseObject{
	BaseObject parent;
	HashMap<String,Variable> attr;
	public BaseObject(BaseObject _parent) {
		parent = _parent;
		attr = new HashMap<>();
	}

	public abstract void draw(Graphics2D g);

	public abstract String getName();
	public HashMap<String,Variable> getAttrs() {
		return attr;
	}

	public BaseObject getParent() {
		return parent;
	}

//追加、変更用
	public boolean setAttr(String _name, String _value) {
		if(attr.containsKey(_name)) {
			Variable rv = attr.get(_name);
			Variable _rv = rv.clone();
			_rv.set(_value);
			if(_rv != null) {
				attr.put(_name,_rv);
				return true;
			}
			return false;
		}else {
			return true;
		}
	}

//初期化用
	public boolean setAttr(String _name, Variable _value) {
		if(attr.containsKey(_name)) {
			Variable rv = attr.get(_name);
			//クラスが同じなら入れる
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
