
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import java.util.stream.*;

public class CalculatorSimpleTest {
  /**
   * Sets up the test fixture.
   *
   * Called before every test case method.
   */
  @BeforeEach
  public void setUp()
  {
  }

  /**
   * Tears down the test fixture.
   *
   * Called after every test case method.
   */
  @AfterEach
  public void tearDown()
  {
  }

  @Test
  public void testAdd() {
      Calculator c = new Calculator(3, 4);
      int result = c.add();
      assertEquals(result, 7, "result should be 7");
  }

  @Test
  public void testSubtract() {
      Calculator c = new Calculator(3, 4);
      int result = c.subtract();
      assertEquals(result, -1, "result should be -1");
  }

  @Test
  public void testSubtractThrowsException() {
      Calculator c = new Calculator(4, 3);
      Throwable exception = assertThrows(
          ArithmeticException.class, 
          () -> c.subtract()
      );
  }

  /** Adding zero to a number should always
    * give us the same number back.
    */
  @ParameterizedTest
  @ValueSource(	ints = { -99, -1, 0, 1, 2, 101, 337  })
  void addZeroHasNoEffect(int num) {
      Calculator c = new Calculator(num, 0);
      int result = c.add();
      assertEquals(result, num, "result should be same as num");
  }

  @ParameterizedTest
  @MethodSource("additionTestCasesProvider")
  /** Test Calculator.add() with multiple test values
   * and expected values.
   *
   * @param num1 First test value to be passed to Calculator.add()
   * @param num1 Second test value to be passed to Calculator.add()
   * @param expectedResult The expected result for Calculator.add()
   */
  void tableOfTests(int num1, int num2, int expectedResult) {
      Calculator c = new Calculator(num1, num2);
      int result = c.add();
      assertEquals(expectedResult, result, "result should be same as as expected result");
  }
  
  static Stream<Arguments> additionTestCasesProvider() {
      return Stream.of(
          // the arguments are:
          //    num1, num2, and expected result.
          arguments(1, 2, 3),
          arguments(3, 7, 10),
          arguments(3, 7, 11)
          arguments(99, 1, 100)
      );
  }


}
