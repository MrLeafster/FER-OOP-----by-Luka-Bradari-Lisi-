package samostalno_5.zad_2;

class MyGame extends Game implements Comparable<Game>{

	protected MyGame(String name, int rating) {
		super(name);
		super.setRating(rating);
	}

	@Override
	public int compareTo(Game o) {
		return super.getName().compareTo(o.getName());
	}

}
