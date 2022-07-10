package samostalno_3.zad_3;

class MaliExpres {
	public static double checkout(ShoppingCart cart) {
		Item[] items = cart.getItems();
		
		double suma = 0;
		for(Item item: items) {
			// provjera null-pointera
			if(item == null)
				continue;
			
			// provjera da li je alkoholno
			if(item instanceof AlcBeverage && cart.getCustomer().getAge() < 18)
				throw new IllegalAgeException("Nije dozvoljena prodaja alkohola maloljetnicima");
			
			// dodavanje na sumu
			suma += item.getPrice(1);
		}
		
		return suma;
	}
}
