import org.example.junit.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public  class CalculatorTest {

    @Test
    void tesAddition(){
               Calculator calculator = new Calculator();
                int result = calculator.add(3,4);
                assertEquals(7 , result);
    }

}
