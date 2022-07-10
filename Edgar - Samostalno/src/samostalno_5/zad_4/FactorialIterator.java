package samostalno_5.zad_4;

import java.util.Iterator;
import java.util.NoSuchElementException;

class FactorialIterator implements Iterator<Integer>{
	private int numOfIterations;
	private int counter = 0;
	
	private int current = 1;

	public FactorialIterator(int numOfIterations) {
		if(numOfIterations < 0)
			throw new IllegalArgumentException();
		
		this.numOfIterations = numOfIterations;
	}

	@Override
	public boolean hasNext() {
		return counter != numOfIterations;
	}

	@Override
	public Integer next() {
		if(!hasNext())
			throw new NoSuchElementException("No more digits");
      
		if(counter != 0)
			current *= counter;
		
		counter++;
		return current;
	}
	
	public static void main(String[] args) {
		Iterator<Integer> iterator = new FactorialIterator(10);
		while(iterator.hasNext())
		    System.out.println(iterator.next());
		
		System.out.println(iterator.next());
	}

}
