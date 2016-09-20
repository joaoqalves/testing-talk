package com.a.testing101.calculator;

import com.schibsted.testing.calculator.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

  @Test
  public void givenACalculatorWhenAddingTwoNumbersThenSucceeds() {
    // Given
    Calculator calculator = new Calculator();

    // When
    Double result = calculator.add(2.0, 4.0);

    // Then
    assertEquals(new Double(6.0), result);
  }
}
