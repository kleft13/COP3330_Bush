public class Encrypter
{
    public String encrypt(String num)
    {
        int realnum = Integer.parseInt(num);
        int num1 = ((realnum/1000)+7)%10;
        int num2 = ((realnum/100)+7)%10;
        int num3 = ((realnum/10)+7)%10;
        int num4 = (realnum + 7)%10;
        String a = Integer.toString(num1);
        String b = Integer.toString(num2);
        String c = Integer.toString(num3);
        String d = Integer.toString(num4);
        return(c+d+a+b);
    }
}

