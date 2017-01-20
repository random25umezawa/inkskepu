import variables.*;
import window.*;
import functions.*;

class Main{
	public static void main(String[] args) {
		if(args.length==0) Data.set = XmlUtil.read("save.svg");
		else Data.set = XmlUtil.read(args[0]);
		MainFrame mf = new MainFrame();
	}
}
