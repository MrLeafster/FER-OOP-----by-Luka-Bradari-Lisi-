package samostalno_4.zad_1;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MainLab {

	public static void main(String[] args) {
		Map<String, Map<Integer, List<Integer>>> salaries = new TreeMap<>();
		
		Map<Integer, List<Integer>> Ktemp = new TreeMap<>();
		Ktemp.put(2018, List.of(16600, 16500, 16500, 16500, 16600, 16600, 16600, 16700, 16800, 16800, 16900, 16900));
		Ktemp.put(2017, List.of(8200, 8100, 8200, 8200, 8300, 8200, 8200, 8100, 8200, 8200, 8300, 8500));
		salaries.put("Klara", Ktemp);
		
		Map<Integer, List<Integer>> Itemp = new TreeMap<>();
		Itemp.put(2018, List.of(6600, 6500, 6500, 6500, 6600, 6600, 6600, 6700, 6800, 6800, 6900, 6900));
		Itemp.put(2017, List.of(6200, 6100, 6200, 6200, 6300, 6200, 6200, 6100, 6200, 6200, 6300, 6500));
		salaries.put("Ivan", Itemp);
		
		Map<Integer, List<Integer>> Atemp = new TreeMap<>();
		Atemp.put(2018, List.of(6500, 6500, 6500, 6500, 6600, 6600, 6600, 6700, 6800, 6800, 6900, 6900));
		Atemp.put(2017, List.of(4000, 4100, 4200, 4200, 4200, 4200, 4200, 4100, 4200, 4200, 4300, 4500));
		salaries.put("Ana", Atemp);
		
		Map<Integer, Set<String>> rez = LabTask.underpayed(salaries);
		System.out.println(rez.toString());
	}

}
