package variables;

import java.awt.Color;

//@SuppressWarnings("unchecked")
public class ColorVariable extends Variable{
	Color value;
	public ColorVariable(Color _value) {
		this.value = _value;
	}

	public Color get() {
		return value;
	}

	@Override
	public void set(String _value) {
		value = Color.decode(_value);
	}

	@Override
	public Class getT() {
		return Color.class;
	}

	@Override
	public void cloneMore(Variable _value) {
		ColorVariable _newValue = (ColorVariable)_value;
		_newValue.value = this.value;
		_value = _newValue;
	}

	@Override
	public String toString() {
		return String.format("#%02x%02x%02x",((Color)value).getRed(),((Color)value).getGreen(),((Color)value).getBlue());
	}
}
