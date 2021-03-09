import com.model.Operation;
import com.model.Polynomial;
import com.model.Utils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class OperationTest {

    @Test
    public void addition() {
        Polynomial p = Utils.createPolynomialFromString("3x^4 + 2x^3 + 2x^1 + 1x^0");
        Polynomial q = Utils.createPolynomialFromString("2x^1");
        Polynomial sum = new Operation(p).add(p, q);
        assertEquals("3x^4+2x^3+0x^2+4x^1+1x^0+", sum.printPolynomial());

    }


}
