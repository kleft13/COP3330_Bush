public class BodyMassIndex {

    double bmi;
    String bCat;

    BodyMassIndex (double height, double weight)
    {
       bmi = bodyMassMath(height, weight);
       bCat = bodyMassCat(bmi);
    }

    public double bodyMassMath(double height, double weight)
    {
        double tempBmi = (703 * weight)/(height * height);
        return Math.round(tempBmi * 10) / 10.0;
    }

    public String bodyMassCat (double bmi)
    {
        if (bmi < 18.5)
            return "Underweight";

        else if (18.5 <= bmi && bmi <= 24.9)
            return "Normal Weight";

        else if (25 <= bmi && bmi <= 29.9)
            return "Overweight";

        else
            return "Obesity";

    }
}
