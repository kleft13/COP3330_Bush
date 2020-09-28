import java.util.*;

public class App
{
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    public static boolean moreInput()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Would you like to calculate a BMI? yes (Y) or no (N): ");
        String ans = input.nextLine();
        if ( ans.equals("Y") || ans.equals("y"))
        {
            return true;
        } else if (ans.equals("N") || ans.equals("n"))
        {
            return false;
        }else {
            System.out.print("invalid input\n");
            return false;
        }
    }

    public static double getUserHeight()
    {
        Scanner inches = new Scanner(System.in);
        System.out.print("What is your height in inches: ");
        String height = inches.nextLine();
        double hNum = Double.parseDouble(height);
        if(hNum < 0)
        {
            System.out.print("I need a positive height, Try again\n");
            return getUserHeight();
        }else{
            return hNum;
        }
    }
    public static double getUserWeight()
    {
        Scanner pounds = new Scanner(System.in);
        System.out.print("What is your weight in pounds: ");
        String weight = pounds.nextLine();
        double wNum = Double.parseDouble(weight);
        if(wNum < 0)
        {
            System.out.print("I need a positive weight, Try again\n");
            return getUserWeight();
        } else{
            return wNum;
        }
    }
    public static void displayBmiInfo(BodyMassIndex bmi)
    {
        System.out.print("Your BMI is " + bmi.bmi + ". This puts you in a category of " + bmi.bCat + "\n");
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmidata)
    {
        double sumBmi = 0.0;
        double avg;
        double roundAvg;
        for(int i = 0; i < bmidata.size(); i++)
        {
            sumBmi += bmidata.get(i).bmi;
        }
        avg = sumBmi / bmidata.size();
        roundAvg = Math.round(avg * 10) / 10.0;
        System.out.print("The average of all User BMIs is " + roundAvg);
    }

}
