package samostalno_5.zad_1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Solution{

    public static Predicate<List<List<Integer>>> allDigitsMatch(double exemplar){
        return new Predicate<List<List<Integer>>>() {

			@Override
			public boolean test(List<List<Integer>> t) {
				String exString = Double.toString(exemplar);
				
				for(List<Integer> digitInfo: t) {
					int placement = digitInfo.get(0);
					int digit = digitInfo.get(1);
					
					if(placement != 0)
						placement++;
					
					if(exString.length() <= placement)
						continue;
					
					int testDigit = Integer.parseInt(String.valueOf(exString.charAt(placement)));
					
					if(testDigit != digit)
						return false;
				}
				
				return true;
				
			}
        	
        };
    }
    
    
    public static Predicate<List<List<Integer>>> allDigitsDefined(){
        return new Predicate<List<List<Integer>>>() {
			
			@Override
			public boolean test(List<List<Integer>> t) {
				int maxDig = -1;
				for(List<Integer> digitInfo: t) {
					if(digitInfo.get(0) > maxDig)
						maxDig = digitInfo.get(0);
				}
				return t.size() == maxDig + 1;
			}
		};
    }
    
    public static void main(String[] args) {
    	List<List<Integer>> ulaz1= Arrays.asList(Arrays.asList(1,2),Arrays.asList(0,3),Arrays.asList(2,6)); // 3.26

    	boolean t1_1 = Solution.allDigitsMatch(3.266).test(ulaz1); // true
    	boolean t2_1 = Solution.allDigitsDefined().test(ulaz1); // true

    	List<List<Integer>> ulaz2=
    	Arrays.asList(Arrays.asList(1,2),Arrays.asList(0,3),Arrays.asList(4,6)); // 3.2**6
    	boolean t1 = Solution.allDigitsMatch(3.266).test(ulaz2); // true
    	boolean t2 = Solution.allDigitsDefined().test(ulaz2); // false
	}

}
