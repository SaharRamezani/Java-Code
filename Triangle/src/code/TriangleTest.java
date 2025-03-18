package code;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    public void testConstructor() {
        Triangle triangle = new Triangle(3, 4, 5);
        assertNotNull(triangle);
    }

    @Test
    public void testIsValid() {
        Triangle triangle1 = new Triangle(3, 4, 5);
        assertTrue(triangle1.isValid());

        Triangle triangle2 = new Triangle(1, 1, 2);
        assertFalse(triangle2.isValid());

        Triangle triangle3 = new Triangle(0, 4, 5);
        assertFalse(triangle3.isValid());

        Triangle triangle4 = new Triangle(-1, 4, 5);
        assertFalse(triangle4.isValid());

        Triangle triangle5 = new Triangle(3, 4, 7);
        assertFalse(triangle5.isValid());
    }

    @Test
    public void testIsRightAdditionalCases() {
        Triangle triangle1 = new Triangle(5, 12, 13);
        assertTrue(triangle1.isRight());

        Triangle triangle2 = new Triangle(8, 15, 17);
        assertTrue(triangle2.isRight());

        Triangle triangle3 = new Triangle(5, 4, 3);
        assertTrue(triangle3.isRight());

        Triangle triangle4 = new Triangle(5, 4, -3);
        assertFalse(triangle4.isRight());

        Triangle triangle5 = new Triangle(-5, 4, 3);
        assertFalse(triangle5.isRight());

        Triangle triangle6 = new Triangle(3, 4, 5);
        assertTrue(triangle6.isRight());

        Triangle triangle7 = new Triangle(3, 5, 4);
        assertTrue(triangle7.isRight());

        Triangle triangle8 = new Triangle(7, 24, 25);
        assertTrue(triangle8.isRight());

        Triangle triangle9 = new Triangle(9, 40, 41);
        assertTrue(triangle9.isRight());

        Triangle triangle10 = new Triangle(11, 60, 61);
        assertTrue(triangle10.isRight());

        Triangle triangle11 = new Triangle(20, 21, 29);
        assertTrue(triangle11.isRight());

        Triangle triangle13 = new Triangle(12, 35, 37);
        assertTrue(triangle13.isRight());

        Triangle triangle14 = new Triangle(13, 84, 85);
        assertTrue(triangle14.isRight());

        Triangle triangle15 = new Triangle(16, 63, 65);
        assertTrue(triangle15.isRight());

        Triangle triangle16 = new Triangle(28, 45, 53);
        assertTrue(triangle16.isRight());

        Triangle triangle17 = new Triangle(3, 4, 5);
        assertTrue(triangle17.isRight());

        Triangle triangle18 = new Triangle(3, 5, 4);
        assertTrue(triangle18.isRight());

        Triangle triangle19 = new Triangle(13, 12, 5);
        assertTrue(triangle19.isRight());

        Triangle triangle20 = new Triangle(1, 1, 1);
        assertFalse(triangle20.isRight());

        Triangle triangle21 = new Triangle(0, 0, 0);
        assertFalse(triangle21.isRight());

        Triangle triangle22 = new Triangle(2, 0, 0);
        assertFalse(triangle22.isRight());

        Triangle triangle23 = new Triangle(2, 0, 5);
        assertFalse(triangle23.isRight());

        Triangle triangle24 = new Triangle(0, 7, 5);
        assertFalse(triangle24.isRight());

        Triangle triangle25 = new Triangle(0, 4, 5);
        assertFalse(triangle25.isRight());

        Triangle triangle26 = new Triangle(1, 3, 2);
        assertFalse(triangle26.isRight());

        Triangle triangle27 = new Triangle(3, 1, 2);
        assertFalse(triangle27.isRight());

        Triangle triangle28 = new Triangle(3, -4, 5);
        assertFalse(triangle28.isRight());

        Triangle triangle29 = new Triangle(3, 4, 0);
            assertFalse(triangle29.isRight());

        // a positive triangle where the right-angle comes from the first disjunct
        Triangle triangle30 = new Triangle(13, 12, 5); // 13^2 = 12^2 + 5^2
        assertTrue(triangle30.isRight());

        // a case with one invalid side even if squares condition might be met in degenerate cases
        Triangle triangle31 = new Triangle(0, 3, 4);
        assertFalse(triangle31.isRight());

        Triangle triangle32 = new Triangle(0, 3, 3);
        assertFalse(triangle32.isRight());
    }

    @Test
    public void testInvalidSideA() {
        Triangle t = new Triangle(0, 4, 5);
        assertEquals(TriangleType.INVALID, t.CheckType());
    }

    @Test
    public void testInvalidSideB() {
        Triangle t = new Triangle(3, -4, 5);
        assertEquals(TriangleType.INVALID, t.CheckType());
    }

    @Test
    public void testInvalidSideC() {
        Triangle t = new Triangle(3, 4, 0);
        assertEquals(TriangleType.INVALID, t.CheckType());
    }

    @Test
    public void testRightTriangleNegativeSides() {
        // This hits the scenario where squares match, but sides are not > 0.
        Triangle t = new Triangle(-3, -4, -5);
        // -3^2 + -4^2 = 9 + 16 = 25, which equals -5^2,
        // so the Pythagorean part is "true" but positivity fails.
        assertFalse(t.isRight()); 
    }

    @Test
    public void testInvalidSideAOnly() {
        // a <= 0, but b > 0 and c > 0
        Triangle t = new Triangle(0, 4, 5);
        assertEquals(TriangleType.INVALID, t.CheckType());
    }

    @Test
    public void testInvalidSideBOnly() {
        // b <= 0, a > 0 and c > 0
        Triangle t = new Triangle(3, -4, 5);
        assertEquals(TriangleType.INVALID, t.CheckType());
    }

    @Test
    public void testInvalidSideCOnly() {
        // c <= 0, a > 0 and b > 0
        Triangle t = new Triangle(3, 4, 0);
        assertEquals(TriangleType.INVALID, t.CheckType());
    }

    @Test
    public void testIsoscelesDifferentPermutation1() {
        Triangle t = new Triangle(3, 4, 3); // a == c
        assertEquals(TriangleType.Isosceles, t.CheckType());
    }

    // a > 0, b <= 0, c > 0
    @Test
    public void testInvalidSideBOvnly() {
        Triangle t = new Triangle(3, -1, 5);
        assertEquals(TriangleType.INVALID, t.CheckType());
    }


    @Test
    public void testIsoscelesDifferentPermutation2() {
        Triangle t = new Triangle(4, 3, 3); // b == c
        assertEquals(TriangleType.Isosceles, t.CheckType());
    }

    @Test
    public void testCheckType() {
        Triangle triangle1 = new Triangle(3, 3, 3);
        assertEquals(TriangleType.Equilateral, triangle1.CheckType());

        Triangle triangle2 = new Triangle(3, 3, 4);
        assertEquals(TriangleType.Isosceles, triangle2.CheckType());

        Triangle triangle3 = new Triangle(3, 4, 5);
        assertEquals(TriangleType.Scalene, triangle3.CheckType());

        Triangle triangle4 = new Triangle(1, 1, 2);
        assertEquals(TriangleType.INVALID, triangle4.CheckType());

        Triangle triangle5 = new Triangle(0, 4, 5);
        assertEquals(TriangleType.INVALID, triangle5.CheckType());

        Triangle triangle6 = new Triangle(-1, -1, -1);
        assertEquals(TriangleType.INVALID, triangle6.CheckType());

        Triangle triangle7 = new Triangle(3, 4, 7);
        assertEquals(TriangleType.INVALID, triangle7.CheckType());

        Triangle triangle11 = new Triangle(7, 4, 1);
        assertEquals(TriangleType.INVALID, triangle11.CheckType());

        Triangle triangle8 = new Triangle(7, 40, 1);
        assertEquals(TriangleType.INVALID, triangle8.CheckType());

        Triangle triangle9 = new Triangle(1, 1, 2);
		assertEquals(TriangleType.INVALID, triangle9.CheckType());

		Triangle triangle10 = new Triangle(0, 4, 5);
		assertEquals(TriangleType.INVALID, triangle10.CheckType());
    }
}