import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Stack;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import parameters.*;
import window.*;

class Main{
	public static void main(String[] args) {
		Parameter<Double> p = new Parameter<>(0.5);
		Parameter<Double> p2 = new Parameter<>(p);
		System.out.println(p.get());
		System.out.println(p2.get());
		p.set(false);
		System.out.println(p.get());
		System.out.println(p2.get());
		//MainFrame mf = new MainFrame();
	}
}
