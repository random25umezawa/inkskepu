package variables;

@SuppressWarnings("unchecked")
public class SimpleVariable<T> extends Variable{
	T value;
	public SimpleVariable(T _value) {
		value = _value;
	}
	public SimpleVariable(Variable<T> _value) {
		value = _value.get();
	}
	public T get() {
		return value;
	}
}
