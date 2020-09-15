public class Decrypter
{
    public String decrypt(String num)
    {
        int realnum = Integer.parseInt(num);
        int num1 = (realnum/1000)%10;
        int num2 = (realnum/100)%10;
        int num3 = (realnum/10)%10;
        int num4 = realnum%10;

        if(num1 < 7)
        {
            num1 = num1 + 3;
        }else{
            num1 = num1 - 7;
        }

        if(num2 < 7)
        {
            num2 = num2 + 3;
        }else{
            num2 = num2 - 7;
        }

        if(num3 < 7)
        {
            num3 = num3 + 3;
        }else{
            num3 = num3 - 7;
        }
        if(num4 < 7)
        {
            num4 = num4 + 3;
        }else{
            num4 = num4 - 7;
        }

        String a = Integer.toString(num1);
        String b = Integer.toString(num2);
        String c = Integer.toString(num3);
        String d = Integer.toString(num4);
        return(c+d+a+b);
    }
}
