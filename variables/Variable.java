package variables;

//BaseObjectに設定する各パラメータ
public abstract class Variable implements Cloneable{
	//public abstract <T> T get();
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

	public Class getT() {
		return Object.class;
	}

	public void cloneMore(Variable _value) {
	}
}
