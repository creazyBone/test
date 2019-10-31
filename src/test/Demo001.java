package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo001 {

	public Demo001() {
		// TODO Auto-generated constructor stub
	}

	public static Stream<Character> toCharacterStream(String str){
		ArrayList<Character> list = new ArrayList<>();
		for(Character c : str.toCharArray()) {
			list.add(c);
		}
		return list.stream();
	}
	
	public static void main(String[] args) {
		List<String> list =  Arrays.asList("aaa","bbb","ccc");
		
		Function<String,String> f = new Function<String,String>() {

			@Override
			public String apply(String t) {
				return t.toUpperCase();
			}
			 
		 };
		
		 list.stream().map(f).forEach(System.out::println);
		 System.out.println("--------------------------");
		 
		 
		 Function<String,Stream<Character>> f2 = new Function<String,Stream<Character>>() {

				@Override
				public Stream<Character> apply(String t) {
					return Demo001.toCharacterStream(t);
				}
				 
			 };
		// list.stream().flatMap(f2).forEach(System.out::println);
		list.stream()
		 	.flatMap((t) -> Demo001.toCharacterStream(t.toUpperCase()))
		 //	.forEach(System.out::println);
		 	.collect(Collectors.toList()).forEach(System.out::println);
		
		
		 
	}

}
