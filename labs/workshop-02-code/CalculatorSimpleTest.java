
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
    public void setUp() {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown() {
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
        assertEquals(result, 1, "result should be 1");
    }

    @Test
    public void testSubtractThrowsException() {
        Calculator c = new Calculator(4, 3);
        Throwable exception = assertThrows(
                ArithmeticException.class,
                () -> c.subtract());
    }

    /**
     * Adding zero to a number should always
     * give us the same number back.
     */
    @ParameterizedTest
    @ValueSource(ints = { -99, -1, 0, 1, 2, 101, 337, 114, 514, 1919, 810 })
    void addZeroHasNoEffect(int num) {
        Calculator c = new Calculator(num, 0);
        int result = c.add();
        assertEquals(result, num, "result should be same as num");
    }

    // Adding the @ParameterizedTest tells JUnit that this test needs to be run in a
    // special way. In effect, this annotation tells JUnit:"You need to call this
    // test multiple times. Each time you should call it with a different *int*"
    // Where does JUnit get the *int*s from? We supplied a @ValueSource annotation
    // which tells JUnit "Here is the list of *int*s to use with the test". (But
    // there are other ways of supplying the list of *int*s besides writing them out
    // explicitly as we've done here - you could put them in a *.csv* text file, or
    // write a special method that returns a "stream" of ints)

    @ParameterizedTest
    @MethodSource("additionTestCasesProvider")
    /**
     * Test Calculator.add() with multiple test values
     * and expected values.
     *
     * @param num1           First test value to be passed to Calculator.add()
     * @param num1           Second test value to be passed to Calculator.add()
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
                // num1, num2, and expected result.
                arguments(1, 2, 3),
                arguments(3, 7, 10),
                arguments(3, 7, 11),
                arguments(99, 1, 100));
    }
    // Exercises a. 4 test cases
    // b.
    // c. @EnumSource()
    // d. |category |
    // Pytest: |Unit testing,Regression testing|
    // JUnit: |Unit testing |
    // Syntax:
    // Junit uses annotations to defien test methods, while pytest uses standard
    // Python functions with naming conventions to identify test functions.
    // Test discovery:
    // Junit requires tests to be explicitly defined in a test suite or test class,
    // while pytest can automatically discover and run tests based on file and
    // function names.
    // Assertions:
    // Both frameworks support a range of assertions for validating test results,
    // but junit has a more limited set of built-in assertions compared to pytest.
    // Fixtures:
    // Pytest provides a powerful fixture system for setting up and tearing down
    // test environments, while junit has a mreo limited system for handling test
    // fixtures.
    // Test coverage:
    // Pytest has built-in support for generating test coverage reports, while junit
    // requires a separate tool to be used for coverage analysis

    // 2. precon and postcon
    // Exercises:
    // a. the units corresponding to the unitCode have to exist.
    // b. the units will be removed as well as unitCode, you will not find the units
    // in the units table.
    // c. A unit has to have a corresponding unitCode. As the unit has been deleted,
    // the corresponding unitCode will not longer exist.
    // d. should throw exceptions when there is not unit that corresponding to the
    // unitCode.

    // 3. testability
    // a. no, "easy" is ambiguous, specification
    // b. specification, testable.
    // c. requirement, can but hards
}
