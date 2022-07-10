package samostalno_4.zad_2;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution implements StudentScoreStatistics{
	Map<String, List<Integer>> studentScores = new LinkedHashMap<>();
	
	@Override
	public void addStudentScores(String student, Integer... scores) {
		if(!studentScores.containsKey(student))
			studentScores.put(student, new LinkedList<>());
		
		studentScores.get(student).addAll(List.of(scores));
	}

	@Override
	public Collection<String> getInsertionOrderedStudents() {
		return studentScores.keySet();
	}

	@Override
	public Collection<Integer> getNaturallySortedPointsForStudent(String student) {
		if(!studentScores.containsKey(student))
			return null;
		
		Collections.sort(studentScores.get(student));
		return studentScores.get(student);
	}
	
	public static void main(String[] args) {
		Solution grader = new Solution();
		
		grader.addStudentScores("Luka", 4, 1, 2);
		grader.addStudentScores("Marko", 5, 1, 3);
	}
}
