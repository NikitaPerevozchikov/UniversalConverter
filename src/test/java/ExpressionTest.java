import junit.framework.TestCase;
import main.model.Conversion;
import main.model.Expression;
import main.model.PartFraction;

public class ExpressionTest extends TestCase {
    Expression expression;
    String text;

    @Override
    protected void setUp() throws Exception {
        expression = new Expression();
        text = "м/км";

    }

    public void testIsParsingText () {
        boolean excepted = expression.isParsingText(text);
        boolean actual = true;
        assertEquals(excepted, actual);
    }

    @Override
    protected void tearDown() throws Exception {

    }
}
