package com.schibsted.testing;

import com.schibsted.testing.calculator.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

  @Test
  public void sum_shouldAdd2Numbers() throws Exception {
    //Given a calculator
    Calculator calculator = new Calculator();

    //When adding 2 and 4
    Double result = calculator.add(2.0, 4.0);

    //Then result must be 6
    assertEquals(new Double(6.0), result);
  }
}
