package br.com.training.entities;

import java.math.BigDecimal;

public class MathSimpleExpression implements MathExpression {
	
	private BigDecimal a;
	private BigDecimal b;
	
	private MathOperator operator;
	
	public MathSimpleExpression( final BigDecimal a, final BigDecimal b, final MathOperator operator ) {
		this.a = a;
		this.b = b;
		this.operator = operator;
	}
	
	@Override
	public BigDecimal calculate() {
		
		switch (operator) {
		case SUM:
			return a.add(b);
		case SUBTRACT:
			return a.subtract(b);
		case MULTIPLY:
			return a.multiply(b);
		case DIVIDE:
			return a.divide(b);
		default:
			throw new IllegalArgumentException("Invalid operator on passed expression.");
		}
	}
}
