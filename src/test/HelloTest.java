package test;

import java.util.function.Function;


public interface HelloTest<T> extends Function<T,T>{
	
	
	static <T> HelloTest<T> identity() {
   //     return t -> t;
        
		return (t) -> {return t;};
		
		
     /*   return new HelloTest<T>() {

			@Override
			public T apply(T t) {
				return t;
			}
        	
        };*/
    }

}

/*public interface HelloTest<T,K> extends Function<T,K>{
	
	
	static <T,K> HelloTest<T,K> identity() {
        return (t) ->  (K)t;
		
		return new HelloTest<T,K>() {

			@Override
			public K apply(T t) {
				return (K)t;
			}
			
		};
    }

}*/
