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

    @ParameterizedTest
    @ValueSource(strings = {"AAA", "37x.3", "37.3x", "*&&*!"})
    public void nonValidParametersTest(String str){
        Assertions.assertNull(Utils.isUserInputValid(str));
    }

    @ParameterizedTest(name = "{index}: add({0},{1}) = {2}")
    @MethodSource("validAdditionParameters")
    public void additionTest(String p1, String p2, String res){
        Polynomial p = Utils.isUserInputValid(p1);
        Polynomial q = Utils.isUserInputValid(p2);

        Polynomial sum = new Operation().add(p,q);
        Assertions.assertEquals(res, sum.printPolynomial());
    }
}
