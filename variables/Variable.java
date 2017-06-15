package variables;

//BaseObjectに設定する各パラメータ
public abstract class Variable<T> implements Cloneable{
	public abstract T get();
	public abstract void set(String _s);

	public Variable clone() {
		Variable _value = null;

		try {
			_value = (Variable)super.clone();
			cloneMore(_value);
		}catch (Exception e){
			e.printStackTrace();
		}
		return _value;
	}

	public void cloneMore(Variable _value) {
	}
}
