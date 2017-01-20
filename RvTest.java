import java.awt.Color;

import java.util.Map;
import java.util.HashMap;

import variables.ReferenceVariable;

class RvTest{
	public static void main(String[] args) {
		HashMap<String,ReferenceVariable> map = new HashMap<>();
		map.put("int",new ReferenceVariable<Integer>(5));
		map.put("double",new ReferenceVariable<Double>(2.5));
		map.put("Color",new ReferenceVariable<Color>(new Color(255,255,0)));
		set(map,"double",new ReferenceVariable<Double>(125.125));
		set(map,"double",new ReferenceVariable<String>("str"));

		ReferenceVariable<Double> rvd = new ReferenceVariable<>(5.5);
		ReferenceVariable<Integer> rvi = new ReferenceVariable<>(rvd);
		rvi.set(rvd);
		System.out.println(rvi.get());

		for(Map.Entry<String,ReferenceVariable> entry: map.entrySet()) {
			System.out.println(entry.getKey()+","+((ReferenceVariable)entry.getValue()).get());
		}
	}

	public static void set(HashMap<String,ReferenceVariable> _map, String _key, ReferenceVariable _value) {
		if(_map.containsKey(_key)) {
			ReferenceVariable rv = _map.get(_key);
			try{
				System.out.println(rv.get().getClass());
				System.out.println(_value.get().getClass());
				if(rv.get().getClass()==_value.get().getClass())rv.set(_value);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("katatigauze");
			}
		}
	}
}
