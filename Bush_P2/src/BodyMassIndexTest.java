import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BodyMassIndexTest
{
    @Test
    void testBmiFunctionUnderweight()
    {
        BodyMassIndex b = new BodyMassIndex(65.5,90.9);
       assertEquals(14.9, b.bodyMassMath(65.5, 90.9));
    }
    @Test
    void testBmiFunctionNormalWeight()
    {
        BodyMassIndex b = new BodyMassIndex(67,140);
        assertEquals(21.9, b.bodyMassMath(67,140));
    }
    @Test
    void testBmiFunctionOverweight()
    {
        BodyMassIndex b = new BodyMassIndex(70,180);
        assertEquals(25.8, b.bodyMassMath(70,180));
    }
    @Test
    void testBmiFunctionObesity()
    {
        BodyMassIndex b = new BodyMassIndex(50,127);
        assertEquals(35.7, b.bodyMassMath(50,127));
    }
    @Test
    void testOfBmiCatFunctionUnderweight()
    {
        BodyMassIndex b = new BodyMassIndex(65.5,90.9);
        String ans = b.bodyMassCat(b.bodyMassMath(65.5,90.9));
        assertEquals("Underweight", ans);
    }
    @Test
    void testOfBmiCatFunctionNormalWeight()
    {
        BodyMassIndex b = new BodyMassIndex(67,140);
        String ans = b.bodyMassCat(b.bodyMassMath(67,140));
        assertEquals("Normal Weight", ans);
    }
    @Test
    void testOfBmiCatFunctionOverweight()
    {
        BodyMassIndex b = new BodyMassIndex(70,180);
        String ans = b.bodyMassCat(b.bodyMassMath(70,180));
        assertEquals("Overweight", ans);
    }
    @Test
    void testOfBmiCatFunctionObesity()
    {
        BodyMassIndex b = new BodyMassIndex(50,127);
        String ans = b.bodyMassCat(b.bodyMassMath(50,127));
        assertEquals("Obesity", ans);
    }
}
