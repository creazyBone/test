package test;

public class MainTest {

	public void sayHello(Man man) {
		System.out.println("I'm " + Man.GENDER);
	}

	public void sayHello(Woman woman) {
		System.out.println("I'm " + Woman.GENDER);
	}

	public static void main(String[] args) {
		Human human = new Human();
		MainTest test = new MainTest();
		test.sayHello((Woman)human);
	}
}
