package test;

import java.util.Arrays;
import java.util.List;

public class Test02 {

	public static void main(String[] args) {
		Integer[] a = {1,5,3,4,2};
	//	Arrays.sort(a);
		List<Integer> list = Arrays.asList(a);
	//	a[1] = 6;
		list.set(1, 7);
		for(Integer i : list) {
			System.out.println(i);
		}
		for(Integer n : a) {
			System.out.println(n);
		}
	}

}
