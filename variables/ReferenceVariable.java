package variables;

@SuppressWarnings("unchecked")
public class ReferenceVariable<T> extends Variable{
	Variable<T> value;
	public ReferenceVariable(T _value) {
		value = new SimpleVariable(_value);
	}
	public ReferenceVariable(Variable<T> _value) {
		value = _value;
	}
	public void set(T _value) {
		value = new SimpleVariable(_value);
	}
	public void set(Variable<T> _value) {
		value = _value;
	}
	public T get() {
		return value.get();
	}
}
