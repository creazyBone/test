package test;

public abstract  class Pet {
	private String name = "uuu";
	
	public int age = 10;
	
	public Pet(String name) {
		this.name = name;
		System.out.println("pet 构造方法");
	}
	
	public Pet() {
		
	}
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		System.out.println("pet set age..."+age);
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("pet set name..."+name);
	}
	
	public String getName() {
		return this.name;
	}
	
	
	public void showName() {
		System.out.println("show name1:" + this.name);
		System.out.println("show name2:" + this.getName());
	}
	
	public abstract void hello();
	

}
