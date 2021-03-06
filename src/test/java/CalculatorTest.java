import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
	Calculator calculator = new Calculator();
	
	@Test
	public void squareRootTest() {
		assertEquals("Correct answer for Square Root Function", 2.0, calculator.squareRoot(4.0), 0.0f);
		assertEquals("Correct answer for Square Root Function", 17.0, calculator.squareRoot(289.0), 0.0f);
	}
	
	@Test
	public void factorialTest() {
		assertEquals("Correct answer for Factorial Function", 120, calculator.factorial(5));
		assertEquals("Correct answer for Factorial Function", 5040, calculator.factorial(7));
	}
	
	@Test
	public void naturalLogTest() {
		assertEquals("Correct answer for Natural Log Function", 1.3862943611198906, calculator.naturalLog(4.0), 0.0f);
		assertEquals("Correct answer for Natural Log Function", 1.9459101490553132, calculator.naturalLog(7.0), 0.0f);
	}
	
	@Test
	public void powerTest() {
		assertEquals("Correct answer for Power Function", 8.0, calculator.power(2.0, 3.0), 0.0f);
		assertEquals("Correct answer for Power Function", 81.0, calculator.power(3.0, 4.0), 0.0f);
	}
}