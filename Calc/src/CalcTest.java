import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalcTest {
    private Calc c;

    @Test
    public void testSub() {
        c = new Calc();
        System.out.println("sub");
        assertEquals(2, c.sub(8, 6));
    }

    @Test
    public void testSum() {
        c=new Calc();
        System.out.println("sum");
        assertEquals(2, c.sum(2, 0));
    }
}
