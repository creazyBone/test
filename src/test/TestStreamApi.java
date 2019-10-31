package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreamApi {
	public static List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
	
	public static Stream<Character> filterCharacter(String str){
		List<Character> list = new ArrayList<>();
		
		for(Character c : str.toCharArray()) {
			list.add(c);
		}
		return list.stream();
	}
	
		public static void test1() {
	
			list.stream().map(new Function<String,String>() {

				@Override
				public String apply(String t) {
					return t.toUpperCase();
				}
				
			}).forEach(System.out::println);
			
			list.stream().map(String::toUpperCase).forEach(System.out::println);
	}
	
	
	public static void test2() {
		List<Character> result = new ArrayList<>();
		list.stream().map(new Function<String,Stream<Character>>(){

			@Override
			public Stream<Character> apply(String t) {
				return TestStreamApi.filterCharacter(t);
			}
			
		}).forEach(new Consumer<Stream<Character>>() {
			@Override
			public void accept(Stream<Character> stream) {
				stream.forEach(new Consumer<Character>() {

					@Override
					public void accept(Character t) {
						result.add(t);
					}
					
				});
			}
		});
		result.forEach(System.out::println);
	}
	
	public static void test3() {
		List<Character> result = new ArrayList<>();
		list.stream().map(TestStreamApi::filterCharacter)
		.forEach(stream -> stream.forEach(t -> result.add(t)));
		result.forEach(System.out::println);
	}
	
	public static void test4() {
		Stream<Character> sm = list.stream().flatMap(TestStreamApi::filterCharacter);
		sm.forEach(System.out::println);
	}
	
	//归约
	public static void test5() {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Integer result = list.stream()
		.map((t)-> t-1)
	//	.reduce(Integer::sum); 如果用这种，因为没有初始值0所以必须用Optional
		.reduce(0,Integer::sum);
	/*	.reduce(new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				return Integer.sum(t, u);
			}
			
		});*/
		
	/*	.reduce(0, new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				return Integer.sum(t, u);
			}
			
		});*/
		
		System.out.println(result);
	}
	
	//collect1
	public static void test6() {
		List<Integer> list = Arrays.asList(1,2,3,3,4,5,6,7,7,8,8,9,10);
		list.stream()
		.map((t)-> t-1)
		//.collect(Collectors.toSet())
	//	.collect(Collectors.toCollection(HashSet<Integer>::new))
		.collect(Collectors.toCollection(HashSet::new))
		.forEach(System.out::println);
		
	}
	
	//collect2
		public static void test7() {
			List<Integer> list = Arrays.asList(1,2,3,3,4,5,6,7,7,8,8,9,10);
			Map<Boolean,List<Integer>> map = list.stream()
			.collect(Collectors.partitioningBy((t) -> t>5));
			System.out.println(map);
			
		}
	
		//collect3
		public static void test8() {
			List<Integer> list = Arrays.asList(1,2,3,3,4,5,6,7,7,8,8,9,10);
			 IntSummaryStatistics collect = list.stream()
					 .collect(Collectors.summarizingInt(value -> value));				 
			/*.collect(Collectors.summarizingInt(new ToIntFunction<Integer>() {

				@Override
				public int applyAsInt(Integer value) {
					return value;
				}
				
			}));*/
			 
			System.out.println(collect.getAverage());
			
		}
		
		//collect4
		public static void test9() {
			List<Integer> list = Arrays.asList(1,2,3,3,4,5,6,7,7,8,8,9,10);
			String collect = list.stream().map(v -> v+"").collect(Collectors.joining());
			
			System.out.println(collect);
		}
		
	public static void main(String[] args) {
		
	//	TestStreamApi.test1();
	
	//	TestStreamApi.test2();
		
	//	TestStreamApi.test3();
		
	//	TestStreamApi.test4();
		
	//	TestStreamApi.test5();
		
	//	TestStreamApi.test6();
		
	//	TestStreamApi.test7();
		
	//	TestStreamApi.test8();
		
		TestStreamApi.test9();
	}

	
	
}
