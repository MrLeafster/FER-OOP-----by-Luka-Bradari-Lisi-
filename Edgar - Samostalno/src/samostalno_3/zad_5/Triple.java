package samostalno_3.zad_5;

class Triple <K> {
	private K a;
	private K b;
	private K c;
	
	public Triple(K a, K b, K c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public K getElement(int index) {
		if(index == 1)
			return a;
		else if(index == 2)
			return b;
		else if(index == 3)
			return c;
		else
			throw new IllegalArgumentException();
	}
	
	public void setElement(int index, K element) {
		if(index == 1)
			a = element;
		else if(index == 2)
			b = element;
		else if(index == 3)
			c = element;
		else
			throw new IllegalArgumentException();
	}
}
