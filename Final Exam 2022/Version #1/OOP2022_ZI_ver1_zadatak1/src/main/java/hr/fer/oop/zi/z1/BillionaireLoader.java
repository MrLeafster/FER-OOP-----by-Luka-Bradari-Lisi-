package hr.fer.oop.zi.z1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BillionaireLoader {
    public static List<BillionaireDatum> load(String path){
        List<BillionaireDatum> bills = new ArrayList<>();

        try {
            for(String red: Files.readAllLines(Path.of(path))){
                String[] elementi = red.split("\t");

                Integer age;
                if(elementi[2].equals(""))
                    age = null;
                else
                    age = Integer.parseInt(elementi[2]);

                BillionaireDatum temp = new BillionaireDatum(
                        Integer.parseInt(elementi[0]),
                        elementi[1],
                        //elementi[2].equals("") ? null : Integer.parseInt(elementi[2]),
                        age,
                        Integer.parseInt(elementi[3]),
                        elementi[4]
                );

                bills.add(temp);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return bills;
    }
}
