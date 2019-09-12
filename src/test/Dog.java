package test;

import java.lang.reflect.Field;

public class Dog extends Pet {
	
	public String name = "aaa";
	
	public int age;
	
	public Dog(String name) {
		super(name);
		System.out.println("dog set name..."+name);
		this.setName(name);//1. this确实是子类的实例，但其实是调用了父类的setName方法
		System.out.println("super.getName():"+super.getName());//因为前面步骤1。已经修改了super里面的值，所以这里值会发生变化
		System.out.println("this.name:"+this.name);//这里发现还是“aaa”,很好的说明了步骤1.的“this.setName()”看上去是修改子类的name属性，其实还是在修改父类。
												   //之所以这样的原因是因为子类中没有重写setName()方法
		System.out.println("this.getName():"+this.getName());//其实这里也是调用了父类的getName()方法
	}
	
	public Dog() {
		super();
	}
	
	@Override
	public void hello() {


	}
	
	public int getAge() {
		return this.age;
	}
	
	
	public void aaa() {
		
	}
	public static void main(String[] args) {
	//	Pet dog = new Dog();
		Dog dog = new Dog();
		//父类的getAge()方法一直是public,子类没有定义getAge()方法
		//当父类age属性为public/protected---当父类age属性为private
		//当子类没有重定义age属性/当子类重定义age属性
		System.out.println(dog.getAge());//10/10---10/10
		System.out.println(dog.age);//10/16---na/16
		dog.age = 11; 
		System.out.println(dog.getAge());//11/10---10/10
		System.out.println(dog.age);//11/11---na/11
		
		//只要子类重写了getAge()方法，不管Pet dog = new Dog();还是Dog dog = new Dog();dog.getAge()都是调用子类的实现
		System.out.println("---------");
		System.out.println(dog.getAge());
	}
}
