package variables;

import java.awt.Color;

@SuppressWarnings("unchecked")
public class SimpleVariable<T> extends Variable{
	T value;
	public SimpleVariable(T _value) {
		this.value = _value;
	}
	public T get() {
		return value;
	}
	public void set(String _value) {
		//decode
		Object _o = new Object();
		if(value instanceof String) _o = _value;
		if(value instanceof Double) _o = Double.parseDouble(_value);
		if(value instanceof Color) _o = Color.decode(_value);
		value = (T)_o;
	}

	@Override
	public void cloneMore(Variable _value) {
		SimpleVariable _newValue = (SimpleVariable)_value;
		_newValue.value = this.value;
		_value = _newValue;
	}
}
