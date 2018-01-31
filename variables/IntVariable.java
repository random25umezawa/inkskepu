package variables;

//@SuppressWarnings("unchecked")
public class IntVariable extends Variable{
	int value;
	public IntVariable(int _value) {
		this.value = _value;
	}

	public int get() {
		return value;
	}

	@Override
	public void set(String _value) {
		value = Integer.parseInt(_value);
	}

	@Override
	public Class getT() {
		return int.class;
	}

	@Override
	public void cloneMore(Variable _value) {
		IntVariable _newValue = (IntVariable)_value;
		_newValue.value = this.value;
		_value = _newValue;
	}

	@Override
	public String toString() {
		return ""+value;
	}
}
