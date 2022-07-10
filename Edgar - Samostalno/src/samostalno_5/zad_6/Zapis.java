package samostalno_5.zad_6;

class Zapis implements Comparable<Zapis>{
    String ime;
    Integer bodovi;
    
    public Zapis(String ime, Integer bodovi) {
		this.ime = ime;
		this.bodovi = bodovi;
	}

	public String toString() {
        return this.ime + ":" + this.bodovi;
    }    
    
    @Override
    public boolean equals(Object obj) {
    	if(!(obj instanceof Zapis))
    		return false;
    	
    	Zapis castedObj = (Zapis)obj;
    	return ime.equals(castedObj.ime);
    }
    
    @Override
    public int hashCode() {
    	return ime.hashCode();
    }

	@Override
	public int compareTo(Zapis o) {
		return ime.compareTo(o.ime);
	}

}
