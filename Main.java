import variables.*;
import window.*;
import functions.*;

class Main{
	public static void main(String[] args) {
		ReferenceVariable<Double> p = new ReferenceVariable<Double>(0.5);
		ReferenceVariable<Double> p2 = new ReferenceVariable<Double>(p);
		System.out.println(p.get());
		System.out.println(p2.get());
		p.set(1.5);
		System.out.println(p.get());
		System.out.println(p2.get());
		Data.set = XmlUtil.read("save.svg");
		MainFrame mf = new MainFrame();
	}
}
