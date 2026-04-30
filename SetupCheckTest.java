// SetupCheckTest.java
// Verifies that the Test Runner for Java can discover and execute JUnit tests.

import org.junit.Test;
import static org.junit.Assert.*;

public class SetupCheckTest {

    @Test
    public void testAddBasic() {
        assertEquals(5, SetupCheck.add(2, 3));
    }

    @Test
    public void testAddZero() {
        assertEquals(7, SetupCheck.add(7, 0));
    }
}