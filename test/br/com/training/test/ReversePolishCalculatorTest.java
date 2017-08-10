package br.com.training.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.training.ReversePolishCalculator;

public class ReversePolishCalculatorTest {
	
	@Test
	public void calculateSimpleSumTest() {
		
		final ReversePolishCalculator calculator = new ReversePolishCalculator("3 4 +");
		
		final BigDecimal result = calculator.calculate();
		
		assertEquals(new BigDecimal(7), result);
	}
	
	@Test
	public void calculateSimpleDifferenceTest() {
		
		final ReversePolishCalculator calculator = new ReversePolishCalculator("4 3 -");
		
		final BigDecimal result = calculator.calculate();
		
		assertEquals(new BigDecimal(1), result);
	}
	
	@Test
	public void calculateSimpleMultiplyTest() {
		
		final ReversePolishCalculator calculator = new ReversePolishCalculator("3 4 x");
		
		final BigDecimal result = calculator.calculate();
		
		assertEquals(new BigDecimal(12), result);
	}
	
	@Test
	public void calculateSimpleDivideTest() {
		
		final ReversePolishCalculator calculator = new ReversePolishCalculator("10 2 /");
		
		final BigDecimal result = calculator.calculate();
		
		assertEquals(new BigDecimal(5), result);
	}
	
	@Test
	public void calculateComplexTest() {
		
		final ReversePolishCalculator calculator = new ReversePolishCalculator("3 4 5 x +");
		
		final BigDecimal result = calculator.calculate();
		
		assertEquals(new BigDecimal(23), result);
	}
	
	@Test
	public void calculateMoreComplexTest() {
		
		final ReversePolishCalculator calculator = new ReversePolishCalculator("5 1 2 + 4 x + 3 -");
		
		final BigDecimal result = calculator.calculate();
		
		assertEquals(new BigDecimal(14), result);
	}

	@Test
	public void calculateDecimalTest() {
		
		final ReversePolishCalculator calculator = new ReversePolishCalculator("3.4 5 +");
		
		final BigDecimal result = calculator.calculate();
		
		assertEquals(new BigDecimal("8.4"), result);
	}
	
	@Test
	public void calculateBigDecimalTest() {
		
		final ReversePolishCalculator calculator = new ReversePolishCalculator("32,234.455657 5 +");
		
		final BigDecimal result = calculator.calculate();
		
		assertEquals(new BigDecimal("32239.455657"), result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void calculateTooManySpaces() {
		
		final ReversePolishCalculator calculator = new ReversePolishCalculator("3 4    5 x -");
		calculator.calculate();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void calculateOperatorsAhead() {
		
		final ReversePolishCalculator calculator = new ReversePolishCalculator("x - 3 4");
		
		calculator.calculate();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void calculateNumberNotValidCommaInsteadOfFullStop() {
		
		final ReversePolishCalculator calculator = new ReversePolishCalculator("3 4,34 +");
		
		calculator.calculate();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void calculateNumberNotValidCommaInsteadOfFullStopBigDecimal() {
		
		final ReversePolishCalculator calculator = new ReversePolishCalculator("3 4,56534 +");
		
		calculator.calculate();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void calculateNumberNotValidNonSense() {
		
		final ReversePolishCalculator calculator = new ReversePolishCalculator("3 434#534 +");
		
		calculator.calculate();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void calculateNumberNotValidWrongSeparation() {
		
		final ReversePolishCalculator calculator = new ReversePolishCalculator("3 43.453.4,12 +");
		
		calculator.calculate();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void calculateNumberTooManyOperators() {
		
		final ReversePolishCalculator calculator = new ReversePolishCalculator("3 4 + -");
		
		calculator.calculate();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void calculateNumberTooManyOperands() {
		
		final ReversePolishCalculator calculator = new ReversePolishCalculator("3 4 5 6 -");
		
		calculator.calculate();
	}
}
