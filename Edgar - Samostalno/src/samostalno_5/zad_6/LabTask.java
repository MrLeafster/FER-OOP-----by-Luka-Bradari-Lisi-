package samostalno_5.zad_6;

import java.util.Collection;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class LabTask {
    public static Collection<Zapis> readData() {
        Scanner terminalInput = new Scanner(System.in);
        
        Set<Zapis> sortedZapisNatural = new TreeSet<>();
        
        String tempLine;
        while(terminalInput.hasNext() && !(tempLine = terminalInput.nextLine()).equals("quit")) {
        	String[] tempElements = tempLine.split("#");
        	int tempBodovi = Integer.parseInt(tempElements[1]);
        	
        	Zapis tempZapis = new Zapis(tempElements[0], tempBodovi);
        	
        	sortedZapisNatural.remove(tempZapis);
        	sortedZapisNatural.add(tempZapis);
        }
        
        return sortedZapisNatural;
    }
    
    public static void main(String[] args) {
		Collection<Zapis> temp = readData();
		
		for(Zapis zapis: temp) {
			System.out.println(zapis);
		}
	}
}
