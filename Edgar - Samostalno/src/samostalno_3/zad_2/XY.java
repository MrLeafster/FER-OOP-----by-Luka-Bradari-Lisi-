package samostalno_3.zad_2;

class XY extends SingleTypeKeyValue<Double>{

	public XY(double key, double value) {
		super(key, value);
		// TODO Auto-generated constructor stub
	}
	
	public static boolean isIncreasingFunction(XY[] data) {
		// #1 sortiranje
		
		XY[] dataSorted = data.clone();
		
		for(int i = 0; i < dataSorted.length; i++) {
			int minIndex = i;
			
			for(int j = i; j < dataSorted.length; j++) {
				if(dataSorted[j].getKey() < dataSorted[minIndex].getKey())
					minIndex = j;
			}
			
			XY temp = dataSorted[i];
			dataSorted[i] = dataSorted[minIndex];
			dataSorted[minIndex] = temp;
		}
		
		// #2 provjera rasta
		
		boolean isRising = true;
		
		for(int i = 1; i < dataSorted.length; i++){
			if(dataSorted[i].getValue() < dataSorted[i-1].getValue()) {
				isRising = false;
				break;
			}
		}
		
		return isRising;
	}
	
}
