package hr.fer.oop.bag;

public abstract class AbstractBag<T> implements Bag<T> {

    /**
     * Compares the specified object with this bag for equality. Returns
     * {@code true} if the given object is also a bag and the two bags contain
     * the same elements.
     *
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        //#1 Provjera klase

        Bag<T> castedObj;
        try{
            castedObj = (Bag<T>) obj;
        } catch (ClassCastException e){
            return false;
        }

        //#2 Provjera velicine

        if(castedObj.size() != this.size())
            return false;

        //#3 Provjera elemenata

        for(T el: this.toCollection()){
            if(this.frequency(el) != castedObj.frequency(el))
                return false;
        }
        return true;

    }

    /**
     * Returns the hash code value for this bag. Two bags that contain the same
     * group of elements (irrespective of their order) should return the same
     * hash code.
     *
     * @return the hash code value for this bag
     */
    @Override
    public int hashCode() {
        int sum = 0;
        for(T el: this.toCollection()){
            if(el == null)
                sum += 1;
            else
                sum += el.hashCode();
        }
        return sum;
    }
}
