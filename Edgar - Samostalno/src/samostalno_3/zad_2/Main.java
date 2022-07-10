package samostalno_3.zad_2;

public class Main {

	public static void main(String[] args) {
		// (6, 8), (7.5, 12), (9, 9), (10, 10), (11, 11)
		// (6, 8), (7, 8), (9.1, 13), (-3, -2), (-1, 4)
		
		XY[] data1 = new XY[] {new XY(6.0, 8.0), new XY(7.5, 12.0), new XY(9.0, 9.0), new XY(10.0, 10.0), new XY(11.0, 11.0)};
		XY[] data2 = new XY[] {new XY(6.0, 8.0), new XY(7.0, 8.0), new XY(9.1, 13.0), new XY(-3.0, -2.0), new XY(-1.0, 4.0)};
		
		System.out.println(XY.isIncreasingFunction(data1));
		System.out.println(XY.isIncreasingFunction(data2));
	}

}
