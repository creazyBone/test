package test;

import java.lang.reflect.Field;

public class Dog extends Pet {
	
	public String name = "aaa";
	
	public int age;
	
	public Dog(String name) {
		super(name);
		System.out.println("dog set name..."+name);
		this.setName(name);//1. thisȷʵ�������ʵ��������ʵ�ǵ����˸����setName����
		System.out.println("super.getName():"+super.getName());//��Ϊǰ�沽��1���Ѿ��޸���super�����ֵ����������ֵ�ᷢ���仯
		System.out.println("this.name:"+this.name);//���﷢�ֻ��ǡ�aaa��,�ܺõ�˵���˲���1.�ġ�this.setName()������ȥ���޸������name���ԣ���ʵ�������޸ĸ��ࡣ
												   //֮����������ԭ������Ϊ������û����дsetName()����
		System.out.println("this.getName():"+this.getName());//��ʵ����Ҳ�ǵ����˸����getName()����
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
		//�����getAge()����һֱ��public,����û�ж���getAge()����
		//������age����Ϊpublic/protected---������age����Ϊprivate
		//������û���ض���age����/�������ض���age����
		System.out.println(dog.getAge());//10/10---10/10
		System.out.println(dog.age);//10/16---na/16
		dog.age = 11; 
		System.out.println(dog.getAge());//11/10---10/10
		System.out.println(dog.age);//11/11---na/11
		
		//ֻҪ������д��getAge()����������Pet dog = new Dog();����Dog dog = new Dog();dog.getAge()���ǵ��������ʵ��
		System.out.println("---------");
		System.out.println(dog.getAge());
	}
}
