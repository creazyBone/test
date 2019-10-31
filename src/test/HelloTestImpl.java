package test;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class HelloTestImpl implements HelloTest<String> {

	public HelloTestImpl() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		UnaryOperator<Integer> u = new UnaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t) {
				return t + 1;
			}
		};

		Stream.iterate(0, u);

		Stream.iterate(0, (t) -> t + 2).filter((t) -> t > 150).limit(3).forEach(System.out::println);

	}

	public String apply(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	public <P> P ccc() {
		return null;
	}
}
