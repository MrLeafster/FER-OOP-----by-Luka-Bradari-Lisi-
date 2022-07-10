package samostalno_3.zad_3;

import java.time.LocalDate;

public interface IPerishable {

    default public String getInstructions() {
        return "Keep in dry and cool place";
    }

    public LocalDate getBestBefore();

    public void setBestBefore(LocalDate bestBefore);
}
