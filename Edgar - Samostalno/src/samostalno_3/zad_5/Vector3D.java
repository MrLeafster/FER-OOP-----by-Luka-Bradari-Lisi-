package samostalno_3.zad_5;

class Vector3D extends Triple<Number>{

	public Vector3D(Number a, Number b, Number c) {
		super(a.doubleValue(), b.doubleValue(), c.doubleValue());
		// TODO Auto-generated constructor stub
	}
	
	public static double dotProduct(Vector3D v1, Vector3D v2) {
		double suma = 0;
		
		for(int i = 1; i <= 3; i++) {
			suma += (double)v1.getElement(i) * (double)v2.getElement(i);
		}
		
		return suma;
	}
	
}
