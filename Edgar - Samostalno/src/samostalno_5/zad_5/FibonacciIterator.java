package samostalno_5.zad_5;

import java.util.Iterator;
import java.util.NoSuchElementException;

class FibonacciIterator implements Iterator<Integer> {
	private int numOfIterations;
	
	private int[] currentPair = new int[] {0, 1};
	private int counter = 0;

	public FibonacciIterator(int numOfIterations) {
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
		
		int returnValue = currentPair[0];
		
		currentPair[0] = currentPair[1];
		currentPair[1] += returnValue;
		
		counter++;
		
		return returnValue;
	}
	
	public static void main(String[] args) {
		Iterator<Integer> iterator = new FibonacciIterator(10);
		while(iterator.hasNext())
		    System.out.println(iterator.next());
	}
}
