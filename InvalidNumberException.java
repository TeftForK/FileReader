import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InvalidNumberException extends Exception {

    public InvalidNumberException(String message) {
        super(message);
    }

    private String message;

    public int[] readNumbersFromFile(String filename) throws InvalidNumberException {
        int[] numbers = new int[10];
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            String line;
            int i = 0;
            while ((line = br.readLine()) != null && i < 10) {
                int number = Integer.parseInt(line.trim());
                if (number < 0 || number > 100) {
                    throw new InvalidNumberException("Invalid number: " + number);
                }
                numbers[i] = number;
                i++;
            }
            if (i < 10) {
                throw new InvalidNumberException("Not enough numbers in file.");
            }
        } catch (IOException e) {
            throw new InvalidNumberException("Error reading file: " + filename);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {

                }
            }
        }
        return numbers;
    }
}
