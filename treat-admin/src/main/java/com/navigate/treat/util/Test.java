package com.navigate.treat.util;

import java.util.ArrayList;
import java.util.List;


public class Test {
	public static void main(String[] args) {
//		Singleton singleton = Singleton.getInstance();
//		System.out.println("counter1:" + singleton.counter1);
//		System.out.println("counter2:" + singleton.counter2);
//		
//		System.out.println("\u65e0\u6548\u7684Action"); 
//		Integer a = 1;
//		Integer b = 2;
//		Integer c = 3;
//		Integer d = 3;
//		Integer c1 = 127;
//		Integer d1 = 127;
//		Integer c2 = 128;
//		Integer d3 = 128;
//		Integer e = 321;
//		Integer f = 321;
//		Long g = 3L;
//		//c == d:true
//		System.out.print("c == d:");
//		System.out.println(c == d);
//		//c == (a + b)):true
//		System.out.print("c == (a + b)):");
//		System.out.println(c == (a + b));
//		//c.equals(a + b):true
//		System.out.print("c.equals(a + b):");
//		System.out.println(c.equals(a + b));
//		//e == f:false
//		System.out.print("e == f:");
//		System.out.println(e == f);
//		//g == a + b:true
//		System.out.print("g == a + b:");
//		System.out.println(g == a + b);
//		//g.equals(a + b):false
//		System.out.print("g.equals(a + b):");
//		System.out.println(g.equals(a + b));
//		List<String> sList = new ArrayList<String>();
//		sList.add("string");
//		Testest(sList);
//		
//		List<Integer> iList = new ArrayList<Integer>();
//		iList.add(123);
//		Testest(iList);
	}
	
//	public static String Testest(List<String> string){
//		System.out.println(string);
//		return "11";
//	}
//	
//	public static Integer Testest(List<Integer> integer){
//		System.out.println(integer);
//		return 11;
//	}
//	
//	public static void Testest(List<String> string){
//		System.out.println(string);
//	}
	
//	public static void Testest(List<Integer> integer){
//		System.out.println(integer);
//	}
}

class Singleton{
	private static Singleton singleton = new Singleton();
	public static int counter1;
	public static int counter2 = 2;
	
	private Singleton(){
		System.out.println("counter1:" + singleton.counter1 + "，counter2:" + singleton.counter2);
		counter1++;
		counter2++;
		System.out.println("counter1:" + singleton.counter1 + "，counter2:" + singleton.counter2);
	}
	
	public static Singleton getInstance(){
		return singleton;
	}
}



//class Singleton{
//	private static Singleton singleton;
//	public static int counter1;
//	public static int counter2 = 2;
////	private static Singleton singleton = new Singleton();
//	private Singleton(){
//		counter1++;
//		counter2++;
//	}
//	
//	public static synchronized Singleton getInstance(){
//		if(singleton == null){
//			singleton = new Singleton();
//		}
//		return singleton;
//	}
//}