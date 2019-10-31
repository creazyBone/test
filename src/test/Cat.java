package test;

public  class Cat {
	
	public String name;
	
	public int age;
	
	public void bbb() {
		Fish f = new Fish();
		f.aaa();
	}
	
	public static void main(String[] args) {
		Cat c1 = new Cat();
		c1.name = "Tom";
		c1.age = 1;
		
		Cat c2 = new Cat();
		c2.name = "Tom";
		c2.age = 1;
		
		Cat c3 = c1;
		
		System.out.println("before change age,hashcode:"+c1.hashCode());
		c1.age =2;
		System.out.println(c1.age);
		
		System.out.println("after change age,hashcode:"+c1.hashCode());
		
		c1 = new Cat();
		c1.name = "Tom";
		c1.age = 1;
		
		System.out.println("after new cat,hashcode:"+c1.hashCode());
		System.out.println(c2.hashCode());
	//	System.out.println(c3.hashCode());
		
	//	String a = "aaa";
	//	String b = "aaa";
		
	//	String a = new String("aaa");
	//	String b = new String("aaa");
		
	//	System.out.println(a.hashCode());
	//	System.out.println(b.hashCode());
	}
	
	
}
