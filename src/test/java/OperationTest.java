import com.model.Operation;
import com.model.Polynomial;
import com.utilities.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class OperationTest {

    private static Object[] validAdditionParameters(){
        return new Object[][]{
                {"25","25","+50"}, // simple numbers
                {"-3x","3x","0"}, // canceling terms
                {"","","0"},     // empty fields
                {"3x^4+2x^2+x+25", "2x^4-x^2-x+5", "+5x^4+x^2+30"}, // missing & negative terms
                {"2x^2+75x^7+13x^3-2", "4x^3+15x^15", "+15x^15+75x^7+17x^3+2x^2-2"} // non-arranged, missing terms

        };
    }

    private static Object[] validSubtractionParameters(){
        return new Object[][]{
                {"25", "25", "0"},
                {"3x", "3x", "0"},
                {"-3x", "3x", "-6x"},
                {"3x^4+2x^3-1x^2+x", "3x^5-3x^4+2x^3-25", "-3x^5+6x^4-x^2+x+25"},
                {"-2x^2+x+50", "-3x^15-2x+30x^2", "+3x^15-32x^2+3x+50"}
        };
    }

    private static Object[] validMultiplicationParameters(){
        return new Object[][]{
                {"25", "0", "0"},
                {"25", "25", "+625"},
                {"-3x", "3x", "-9x^2"},
                {"2x+3", "2x-3", "+4x^2-9"},
                {"3x^4-2x^3+0x^2-4", "2x-x^2", "-3x^6+8x^5-4x^4+4x^2-8x"}
        };
    }

    private static Object[] validDerivationParameters(){
        return new Object[][]{
                {"25", "0"},
                {"3x", "+3"},
                {"", "0"},
                {"0", "0"},
                {"3x^3+4x^2-x", "+9x^2+8x-1"}
        };
    }

    private static Object[] validIntegrationParameters(){
        return new Object[][]{
                {"25", "+25.0x"},
                {"3x", "+1.5x^2"},
                {"", "0"},
                {"0", "0"},
                {"3x^3+4x^2-x", "+0.75x^4+1.3333334x^3-0.5x^2"}
        };
    }

    private static Object[] validDivisionParamaters(){
        return new Object[][]{
                {"25", "25", "+1.0", "0"},
                {"3x^3-2x^2+5", "x^2-1", "+3.0x-2.0", "+3x+3"},
                {"x^3+3x^2-4x-12", "x^2+x-6", "+x+2.0", "0"},
                {"0", "3x^3-4x^4", "0", "0"},
                {"3x^7-5-2x^2", "2x^3", "+1.5x^4", "-2x^2-5"},
                {"3x^7-2x^4-4x^2", "25", "+0.12x^7-0.08x^4-0.16x^2", "0"}


        };
    }

    @ParameterizedTest
    @ValueSource(strings = {"AAA", "37x.3", "37.3x", "*&&*!"})
    public void nonValidParametersTest(String str){
        Assertions.assertNull(Utils.validateUserInput(str));
    }

    @ParameterizedTest(name = "{index}: add({0},{1}) = {2}")
    @MethodSource("validAdditionParameters")
    public void additionTest(String p1, String p2, String res){
        Polynomial p = Utils.validateUserInput(p1);
        Polynomial q = Utils.validateUserInput(p2);

        Polynomial sum = new Operation().add(p,q);
        Assertions.assertEquals(res, sum.printPolynomial());
    }

    @ParameterizedTest(name = "{index}: sub({0},{1}) = {2}")
    @MethodSource("validSubtractionParameters")
    public void subtractionTest(String p1, String p2, String res){
        Polynomial p = Utils.validateUserInput(p1);
        Polynomial q = Utils.validateUserInput(p2);

        Polynomial diff = new Operation().subtract(p, q);
        Assertions.assertEquals(res, diff.printPolynomial());

    }

    @ParameterizedTest(name = "{index}: mul({0},{1}) = {2}")
    @MethodSource("validMultiplicationParameters")
    public void multiplicationTest(String p1, String p2, String res){
        Polynomial p = Utils.validateUserInput(p1);
        Polynomial q = Utils.validateUserInput(p2);

        Polynomial mult = new Operation().multiply(p, q);
        Assertions.assertEquals(res, mult.printPolynomial());
    }

    @ParameterizedTest(name = "{index}: derivate({0}) ={1}")
    @MethodSource("validDerivationParameters")
    public void derivativeTest(String poly, String res){
        Polynomial p = Utils.validateUserInput(poly);
        Polynomial derivation = new Operation().derivate(p);
        Assertions.assertEquals(res, derivation.printPolynomial());

    }

    @ParameterizedTest(name = "{index}: integrate({0}) ={1}")
    @MethodSource("validIntegrationParameters")
    public void integrationTest(String poly, String res){
        Polynomial p = Utils.validateUserInput(poly);
        Polynomial derivation = new Operation().integrate(p);
        Assertions.assertEquals(res, derivation.printPolynomial());

    }

    @ParameterizedTest(name = "{index}: divide({0},{1}) = q:{2}, r:{3}")
    @MethodSource("validDivisionParamaters")
    public void divisionTest(String p1S, String p2S, String qS, String rS){
        Polynomial p1 = Utils.validateUserInput(p1S);
        Polynomial p2 = Utils.validateUserInput(p2S);

        Operation op = new Operation();
        op.divide(p1, p2);
        Polynomial quotient = op.getQuotient();
        Polynomial remainder = op.getRemainder();
        Assertions.assertEquals(qS, quotient.printPolynomial());
        Assertions.assertEquals(rS, remainder.printPolynomial());

    }
}
