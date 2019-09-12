package test;

public class Node {
	
	public String name;
	
	public Node next;
	
	
	public Node(String name, Node next) {
		this.name = name;
		this.next = next;
	}


	public static void main(String[] args) {
		Node n1 = new Node("aaa",null);
		Node n3 = new Node("bbb",null);
		Node n2 = n1;
		
		n2.next = n3;
		
		System.out.println(n1.next.name);
	}

}
