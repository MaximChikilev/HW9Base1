import java.io.*;
import java.util.*;
import java.lang.Integer;

public class FrequencyCounter {
    private Set<String> calculationBasis;
    private Map<String, Integer> calculationResult;
    private File sourceFile;
    private File baseFroFrequency;

    public FrequencyCounter(File baseFroFrequency, File sourceFile) {
        this.sourceFile = sourceFile;
        this.baseFroFrequency = baseFroFrequency;
        this.calculationBasis = baseForFrequencyLoader();
        fillCalculationResult();
    }

    @Override
    public String toString() {
        System.out.println("Frequency of loss of specified characters from the text:");
        calculationResult.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
        return "";
    }

    public void setSourceFile(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public void setBaseFroFrequency(File baseFroFrequency) {
        this.baseFroFrequency = baseFroFrequency;
        this.calculationBasis = baseForFrequencyLoader();
        fillCalculationResult();
    }

    private void fillCalculationResult() {
        this.calculationResult = new HashMap<String, Integer>();
        for (String element : calculationBasis) {
            calculationResult.put(element, 0);
        }
    }

    public void calculate() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile));
            while (bufferedReader.ready()) {
                frequencyInStringLine(bufferedReader.readLine());
            }

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }

    private void frequencyInStringLine(String line) {
        for (Character element : line.toCharArray()) {
            if(calculationBasis.contains(String.valueOf(element))){
                calculationResult.put(String.valueOf(element), calculationResult.getOrDefault(String.valueOf(element), 0) + 1);
            }
        }
    }

    private Set<String> baseForFrequencyLoader() {
        BufferedReader bufferedReader = null;
        Set<String> newSet = new HashSet<String>();
        try {
            bufferedReader = new BufferedReader(new FileReader(baseFroFrequency));
            while (bufferedReader.ready()) {
                newSet.add(bufferedReader.readLine());
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        return newSet;
    }

}
