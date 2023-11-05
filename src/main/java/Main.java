import java.io.File;

public class Main {

    public static void main(String[] args) {
        File sourceFile = new File("./src/main/resources/Data.txt");
        File baseForFrequencyFile = new File("./src/main/resources/CalculationBasis.txt");
        FrequencyCounter frequencyCounter = new FrequencyCounter(baseForFrequencyFile,sourceFile);
        frequencyCounter.calculate();
        System.out.println(frequencyCounter);

    }
}