import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CalcTest {
    private Calc c;

    @Before
    public void setUp() {
        c = new Calc();
    }

    @Test
    public void testSub() {
        System.out.println("sub");
        assertEquals(2, c.sub(8, 6));
        assertEquals(0, c.sub(5, 5));
        assertEquals(-3, c.sub(2, 5));
    }

    @Test
    public void testSum() {
        System.out.println("sum");
        assertEquals(2, c.sum(2, 0));
        assertEquals(5, c.sum(2, 3));
        assertEquals(0, c.sum(0, 0));
    }

    @Test
    public void testMul() {
        System.out.println("mul");
        assertEquals(0, c.mul(2, 0));
        assertEquals(6, c.mul(2, 3));
        assertEquals(-6, c.mul(2, -3));
    }

    @Test
    public void testDiv() {
        System.out.println("div");
        assertEquals(2, c.div(6, 3));
        assertEquals(1, c.div(5, 5));
        assertEquals(0, c.div(0, 1));
    }
}
