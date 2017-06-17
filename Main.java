import variables.*;
import window.*;
import functions.*;

class Main{
	public static void main(String[] args) {
		if(args.length==0) {
			System.out.println("please give an input file.");
			return;
		}
		else Data.set = XmlUtil.read(args[0]);
		MainFrame mf = new MainFrame();
	}
}
