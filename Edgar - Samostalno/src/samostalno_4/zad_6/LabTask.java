package samostalno_4.zad_6;

import java.util.Map;
import java.util.Set;

class LabTask {
    public static int count(Map<Integer, Integer> map, Set<Integer> set) {
    	int cnt = 0;
        for(Integer setNum: set) {
        	boolean isIn = false;
        	for(Integer mapValNum: map.values()) {
        		if(setNum.equals(mapValNum)) {
        			isIn = true;
        			break;
        		}
        	}
        	if(isIn)
        		cnt++;
        }
        return cnt;
    }
    
    public static void main(String[] args) {
		Set<Integer> testSet = Set.of(50, 500000, 5000, 500, 0, -10000, -500, -300, -200, -100);
		Map<Integer, Integer> testMap = Map.of(80,500, 60,50, 40,50, 20,50, 0,50);
		
		count(testMap, testSet);
	}
}
