package variables;

//@SuppressWarnings("unchecked")
public class StringVariable extends Variable{
	String value;
	public StringVariable(String _value) {
		this.value = _value;
	}

	public String get() {
		return value;
	}

	@Override
	public void set(String _value) {
		value = _value;
	}

	@Override
	public Class getT() {
		return String.class;
	}

	@Override
	public void cloneMore(Variable _value) {
		StringVariable _newValue = (StringVariable)_value;
		_newValue.value = this.value;
		_value = _newValue;
	}

	@Override
	public String toString() {
		return value;
	}
}
