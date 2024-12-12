import java.io.File;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        try {
            File inputFile = new File("src/input.txt");
            Scanner scanner = new Scanner(inputFile);

            int result = 0;

            while (scanner.hasNext()) {
                String next = scanner.next();
                // split by "mul("
                String[] splitNext = next.split("mul\\(");
                for (int i = 0; i < splitNext.length; i++) {

                    // split by ")"
                    String[] splitClose = splitNext[i].split("\\)");
                    if (splitClose.length < 1) continue;

                    // now we only have the values left "xxx,yyy" or what was between the paren in mul()
                    String values = splitClose[0];
                    System.out.println(values);

                    // If we have more than 7 chars or we do not have a ',' continue to the next values.
                    if (values.length() > 7 || !values.contains(",")) continue;

                    String[] splitComma = values.split(",");

                    if (splitComma.length < 2) continue;

                    // Split by ","
                    String val1 = splitComma[0];
                    String val2 = splitComma[1];


                    // If either value is greater than 3 continue
                    if (val1.length() > 3 || val2.length() > 3) continue;


                    // Check if numbers
                    if (!isNumeric(val1) || !isNumeric(val2)) continue;

                    // Get the result

                    int val1Num = Integer.parseInt(val1);
                    int val2Num = Integer.parseInt(val2);

                    System.out.println("Multiplying: " + val1Num + " by " + val2Num);
                    System.out.println("Current Result: " + result);
                    result += val1Num * val2Num;
                }
            }

            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }


    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) return false;

        try {
            int integer = Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            System.out.println("Error parsing '" + strNum + "' to an integer. Not a number");
            return false;
        }

        return true;
    }

}
