import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InvalidNumberException exception = new InvalidNumberException("Invalid Number");
        try {
            int[] numbers = exception.readNumbersFromFile("C:\\Users\\gioko\\IdeaProjects\\untitled\\src\\numbers.txt");
            int sum = exception.sumArray(numbers);
            System.out.println(Arrays.toString(numbers));
        } catch (InvalidNumberException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}



