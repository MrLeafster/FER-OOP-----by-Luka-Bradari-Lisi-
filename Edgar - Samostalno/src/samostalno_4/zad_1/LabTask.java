package samostalno_4.zad_1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class LabTask {
	public static Map<Integer, Set<String>> underpayed(Map<String, Map<Integer, List<Integer>>> salaries){
		Map<String, Map<Integer, Integer>> averageSalary = new HashMap<>();
		Set<Integer> allYears = new TreeSet<>();
		
		for(String id: salaries.keySet()) {
			Map<Integer, List<Integer>> salaryByYear = salaries.get(id);
			
			Map<Integer, Integer> yearAverages = new TreeMap<>();	
			for(Integer year: salaryByYear.keySet()) {
				allYears.add(year);
				
				int tempSalary = IntArraySum(salaryByYear.get(year)) / 12;
				yearAverages.put(year, tempSalary);
			}
			averageSalary.put(id, yearAverages);
		}
		
		Map<Integer, Set<String>> poorPeople = new TreeMap<>();
		for(Integer year: allYears) {
			int yearSum = 0, yearCnt = 0;
			
			for(Map<Integer, Integer> avgSalaries: averageSalary.values()) {
				if(!avgSalaries.containsKey(year))
					continue;
				yearSum += avgSalaries.get(year);
				yearCnt++;
			}
			
			double threshold = (double)yearSum / yearCnt * 0.7;
			
			for(String id: averageSalary.keySet()) {
				if(!averageSalary.get(id).containsKey(year))
					continue;
				
				if(averageSalary.get(id).get(year) < threshold) {
					if(!poorPeople.containsKey(year))
						poorPeople.put(year, new TreeSet<>());
					poorPeople.get(year).add(id);
				}
			}
		}
		
		return poorPeople;
	}
	
	private static int IntArraySum(List<Integer> arr) {
		int sum = 0;
		for(Integer num: arr) {
			sum += num;
		}
		return sum;
	}

}
