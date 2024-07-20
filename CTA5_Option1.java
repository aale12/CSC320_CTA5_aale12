package CSC320.CSC320_CTA5_aale12;

import java.util.ArrayList;
import java.util.Scanner;

public class CTA5_Option1 {

    public static void main(String[] args) {
        ArrayList<String> dayNames = new ArrayList<>();
        ArrayList<Integer> dayTemperatures = new ArrayList<>();
        String userInput = null;
        String formattedUserInput = null;
        boolean invalidOrNoInput = true;
        dayNames.add("monday");
        dayNames.add("tuesday");
        dayNames.add("wednesday");
        dayNames.add("thursday");
        dayNames.add("friday");
        dayNames.add("saturday");
        dayNames.add("sunday");

        dayTemperatures.add(91);
        dayTemperatures.add(88);
        dayTemperatures.add(88);
        dayTemperatures.add(84);
        dayTemperatures.add(83);
        dayTemperatures.add(82);
        dayTemperatures.add(81);

        Scanner sc = new Scanner(System.in);
        while (invalidOrNoInput) {
            System.out.println("\nEnter a day of the week, or enter 'week'.  Enter 'q' to quit.");
            userInput = sc.next().toLowerCase();
            formattedUserInput = userInput.substring(0, 1).toUpperCase() + userInput.substring(1).toLowerCase();
            //System.out.println("User input is " + userInput);
            if ("q".equals(userInput)) {
                System.out.println("Thank you for using the program. Good bye!");
                invalidOrNoInput = false;
            } else if (dayNames.contains(userInput)) {
                //System.out.println("Valid Input");
                System.out.println("The temperature on " + formattedUserInput + " is " + dayTemperatures.get(dayNames.indexOf(userInput)) + " degrees.");
            } else if ("week".equalsIgnoreCase(userInput)) {
                Integer sum = 0;
                for (String day : dayNames) {
                    String dayFormatted = day.substring(0, 1).toUpperCase() + day.substring(1);
                    System.out.println("The temperature on " + dayFormatted + " is " + dayTemperatures.get(dayNames.indexOf(day)) + " degrees.");
                    sum += dayTemperatures.get(dayNames.indexOf(day));
                }
                System.out.format("The average temperature for the week is %.2f degrees.\n", sum.doubleValue() / dayNames.size());
            } else {
                System.err.println("You did not input a valid day.");
            }
        }
        sc.close();
    }
}
