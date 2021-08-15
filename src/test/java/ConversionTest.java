import junit.framework.TestCase;
import main.ListGeneration;
import main.model.Conversion;
import main.model.PartFraction;

import java.nio.file.Paths;

public class ConversionTest extends TestCase {
    Conversion conversion;
    String from;
    String to;

    PartFraction numerator;
    PartFraction denominator;

    @Override
    protected void setUp() throws Exception {
        ListGeneration.createListLineConvert(Paths.get("src/main/resources/listConvert.csv"));
        conversion = new Conversion();
        from = "м";
        to = "км * с / час";
    }

    public void testIsCompletionFraction () {
        boolean excepted = conversion.isCompletionFraction(from,to);
        boolean actual = true;
        assertEquals(excepted, actual);
    }

    public void testIsParsingExpression () {
        conversion.isCompletionFraction(from,to);
        boolean excepted = conversion.isParsingExpression();
        boolean actual = true;
        assertEquals(excepted, actual);
    }

    public void testGetConvertIndex() {
        conversion.isCompletionFraction(from,to);
        conversion.isParsingExpression();
        double excepted = conversion.getConvertIndex();
        double actual = 3.6;
        assertEquals(excepted, actual);
    }

    @Override
    protected void tearDown() throws Exception {

    }
}
