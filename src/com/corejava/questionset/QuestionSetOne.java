package com.corejava.questionset;

public class QuestionSetOne {

//	Difference between & and &&
//	& is bitwise AND, compare bits of both sides
//	&& is logical AND, only evaluate the right side when the left side is true
//	the original code will print out 1; change && to &, the code will print out 2
//	this is because b is false, so when using &&, the right side won't get executed, thus the value of x stays as 1
	public static void q1() {
		int x = 1;
		boolean b = false;
		if (b && (++x) > 0) { // change && to & ?
			System.out.println("error");
		} else {
			System.out.println(x);
		}
	}

//	Difference between = and ==
//	= is assignment operator, return value is the assigned value
//	== is comparison operator, compares by references
	public static void q2() {
		int x = 1;
		boolean b = false;
		// the value of (x = 5) is 5, if() only takes boolean type
		// so it will give out an error
		if (x == 5) {
			System.out.println("!");
		}
		if (b = true) {
			System.out.println("!!");
		}
	}

//	switch will evaluate its expression, and execute all statements after the matching case label
//	a break statement will break out the entire switch block immediately
//	if no break, all subsequent case statements following the matching case label will be executed in sequence, regardless their expressions
//	default statement is optional, it will handle all other values that are not explicitly handled by case labels
	public static void q3() {
		// A B
		int x = 1;
		// Z A B
//		int x = 5;
		// cannot switch on long
		// only allow primitive types, String, enum, wrapper classes
//		long x = 1;
		// type mismatch for case statements
//		String x = "1";
		switch (x) {
		default:
			System.out.println("Z");
		case 1:
			System.out.println("A");
		case 2:
			System.out.println("B");
			break;
		case 3:
			System.out.println("C");
		}
	}

	enum Color {
		RED, GREEN, YELLOW
	};

	public static void q4() {
		Color color = Color.RED;
		switch (color) {
		case RED:
			System.out.println("A");
		case GREEN:
			System.out.println("B");
			break;
		case YELLOW:
			System.out.println("C");
		}
	}

//	String is immutable
//	total of 5 objects are created
	public static void q5() {
		// 1: "abc"
		String s = "abc";
		// 2: "defgh" and "abcdefgh"
		s = s + "defgh";
		// 1: "cdef
		s = s.substring(2, 6);
		// if already all upper cased, return itself
		// else create a new String
		// 1: "CDEF"
		s = s.toUpperCase();
		// return itself, do not create new String
		// 0
		s = s.toString();
	}

	static void q6foo(String str) {
		str = "inFoo";
	}

//	passing by the value of the reference
	public static void q6() {
		String str = "abc";
		q6foo(str);
		System.out.println(str);
	}

//	String a = new String(xxx) will create a new String object every time
//	String a = "xxx" will create a new String object in the String pool
//	no duplicates in String pool, flyweight design pattern
	public static void q7() {
		String s1 = new String("abc");
		String s2 = new String("abc");
		String s3 = "abc";
		String s4 = "abc";
		System.out.println(s1 == s2);
		System.out.println(s2 == s3);
		System.out.println(s3 == s4);
		System.out.println(s1.equals(s3));
		System.out.println(s1.intern() == s2.intern());
		System.out.println(s1.intern() == s3.intern());
	}

	static void q8foo(Short x) {
		System.out.println("Short: " + x);
	}

	static void q8foo(Long x) {
		System.out.println("Long: " + x);
	}

	static void q8foo(int x) {
		System.out.println("Int: " + x);
	}

	public static void q8() {
		short x = 6;
		long y = 7;
		q8foo(x);
		q8foo(y);
	}

	static class q9A {
		void foo(Object o) {
			System.out.println("Object");
		}

		void foo(String str) {
			System.out.println(str);
		}
	}

	public static void q9() {
		new q9A().foo("abc");
		new q9A().foo(null);
	}

	static class q10A {
		public void doIt(int x, int y) {
			System.out.println("a");
		}

		public void doIt(int... vals) {// new feature in Java 5
			System.out.println("b");
		}
	}

	public static void q10() {
		q10A a = new q10A();
		a.doIt(3, 4);
		a.doIt(5);
		a.doIt(6, 7, 8);
	}

	public static void switchFallThrough() {
		java.util.ArrayList<String> futureMonths = new java.util.ArrayList<String>();
		int month = 8;

		switch (month) {
		default:
			futureMonths.add("default");
		case 1:
			futureMonths.add("January");
		case 2:
			futureMonths.add("February");
		case 3:
			futureMonths.add("March");
		case 4:
			futureMonths.add("April");
		case 5:
			futureMonths.add("May");
		case 6:
			futureMonths.add("June");
		case 7:
			futureMonths.add("July");
		case 8:
			futureMonths.add("August");
		case 9:
			futureMonths.add("September");
		case 10:
			futureMonths.add("October");
		case 11:
			futureMonths.add("November");
		case 12:
			futureMonths.add("December");
		}

		if (futureMonths.isEmpty()) {
			System.out.println("Invalid month number");
		} else {
			for (String monthName : futureMonths) {
				System.out.println(monthName);
			}
		}
	}

	public static void main(String[] args) {
//		q8();
//		q9();
		q10();
	}

}
