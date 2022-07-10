package samostalno_3.zad_6;

class Items<T> extends Artikl<T>{
	private double quantity;

	public Items(T tag, double pricing, Type type) {
		super(tag, pricing, type);
		
		this.quantity = 0;
	}
	
	public void setQuantity(double quantity) {
		//provjera negativnosti
		if(quantity < 0)
			throw new IllegalArgumentException("Negative values forbidden");
		
		// provjera vrste artikla
		if(getType() == Type.ITEM) {
			if(Math.floor(quantity) != quantity)
				throw new IllegalArgumentException("For pricing per item, the quantity cannot have decimals");
		}
		
		this.quantity = quantity;
	}
	
	@Override
	public double getPrice() {
		if(getType() == Type.ITEM)
			return getPricing() * quantity;
		else
			return getPricing() * quantity / 1000;
	}
}
