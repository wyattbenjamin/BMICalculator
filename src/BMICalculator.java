import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Converts and calculates users BMI based on height and weight using inches and pounds.
 * @version 11/16/2022
 * @author 23benjamin
 */
public class BMICalculator {
/**
 * Convert English to metric units, perform the BMI calculations
 * @param inches user's height in inches
 * @param pounds user's weight in pounds
 * @return User's BMI weight (KG)/height^2 (meters)
 */

public static double computeBMI (int inches, int pounds){
    double kgs, meters;
    if (inches <=0 || pounds<= 0)
        return 0.;
    meters =inches * 0.0254;
    kgs = pounds * 0.454;
    return kgs/ Math.pow(meters, 2);



}

    /**
     * This is the main method of BMI Calculator. The function of this method is to sanitize data and return values.
     */
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String userin = new String();
    int inches, pounds;
    while (true) {
        System.out.print("Enter your height in feet and inches (Ex 6'1\") or 0 to quit ");
        userin = in.nextLine();
        if (userin.equals("0"))
            break;
        try {
            inches = Integer.parseInt(userin.substring(0, userin.indexOf("'"))) * 12;
            inches += Integer.parseInt(userin.substring(userin.indexOf("'") +1,userin.length()-1 ));
            System.out.print("Enter your weight in pounds: ");
            pounds = Integer.parseInt(in.nextLine());
            DecimalFormat bmiDecimal = new DecimalFormat("0.00");
            System.out.println("DEBUG: " + inches + " " + pounds);
            System.out.println("Your BMI, expressed as weight(kg)/height(m)^2: " + bmiDecimal.format(computeBMI(inches, pounds)) + " kg/m^2");
        }
        catch (Exception e) {
            System.out.println("There was an error, see here "+ e.toString());
        }
    }
}


}


