package samostalno_5.zad_2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class MyPlayer extends Player implements Iterable<Game>{
	Map<Game, List<Integer>> gameMap = new TreeMap<>();
	
	protected MyPlayer(String name) {
		super(name);
	}

	@Override
	void addGameScore(Game game, int score) {
		if(!gameMap.containsKey(game))
			gameMap.put(game, new LinkedList<>());
		
		gameMap.get(game).add(score);
	}

	@Override
	Iterable<Integer> getScores(Game game) {
		return gameMap.get(game);
	}

	@Override
	public Iterator<Game> iterator() {
		return gameMap.keySet().iterator();
	}
	
}
