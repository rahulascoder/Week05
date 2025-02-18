import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReadCSVTest {

    @Test
    public void testCSVParsing() {
        String testLine = "101,Rahul Kumar,20,85.5";
        String[] details = testLine.split(",");

        assertEquals(4, details.length);
        assertEquals("101", details[0].trim());
        assertEquals("Rahul Kumar", details[1].trim());
        assertEquals(20, Integer.parseInt(details[2].trim()));
        assertEquals(85.5, Double.parseDouble(details[3].trim()), 0.01);
    }
}
