package test;


public class Main {

	public static void main(String[] args) {
		
		
		test t = new test();
		test2 t2 = new test2();
		
		t.setNum(15);
		
		System.out.println(t.getNum());
		
		t2.tset(t);
		System.out.println(t.getNum());

	}

}
