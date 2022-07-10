package samostalno_3.zad_4;

class Utils {
	public static int checkPassword(String pass) {
		// ** ocjena = (duljina lozinke) + (broj znamenki)*3 + (broj velikih slova)*2 **
		
		// broj znamenki i velikih slova
		int digitNum = 0, upperNum = 0;
		for(int i = 0; i < pass.length(); i++) {
			if(Character.isDigit(pass.charAt(i)))
				digitNum++;
			
			if(Character.isUpperCase(pass.charAt(i)))
				upperNum++;
		}
		
		// racun ocjene
		int ocjena = pass.length() + digitNum*3 + upperNum*2;
		
		// pregled uvjeta
		if(pass.length() < 6)
			throw new IllegalArgumentException();
		else if(ocjena < 10)
			throw new SecurityException();
		
		return ocjena;
	}
}
