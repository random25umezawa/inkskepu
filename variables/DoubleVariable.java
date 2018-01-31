package variables;

//@SuppressWarnings("unchecked")
public class DoubleVariable extends Variable{
	Double value;
	public DoubleVariable(Double _value) {
		this.value = _value;
	}

	public Double get() {
		return value;
	}

	@Override
	public void set(String _value) {
		value = Double.parseDouble(_value);
	}

	@Override
	public Class getT() {
		return Double.class;
	}

	@Override
	public void cloneMore(Variable _value) {
		DoubleVariable _newValue = (DoubleVariable)_value;
		_newValue.value = this.value;
		_value = _newValue;
	}

	@Override
	public String toString() {
		return ""+value;
	}
}
