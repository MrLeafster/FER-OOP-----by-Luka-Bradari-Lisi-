package samostalno_5.zad_3;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

class CollectionUtil {
	public static <T> T myFilterReduce(Collection<T> coll, T init, Predicate<T> pred, BinaryOperator<T> op) {
		T buffer = init;
		
		for(T item: coll) {
			if(pred.test(item))
				buffer = op.apply(buffer, item);
		}
		
		return buffer;
	}
	
	public static void main(String[] args) {
		System.out.println(myFilterReduce(Arrays.asList("fer", "oop", "java", "javadoc"),
	            "both begin with j.",
	            x -> x.startsWith("j"),
	            (x,y) -> y + " " + x) );
		
		System.out.println(myFilterReduce(Arrays.asList(2, 3, 6, 3),
	               5,
	               x->x%2==0,
	               (x,y)->x*y) );
	}
}
