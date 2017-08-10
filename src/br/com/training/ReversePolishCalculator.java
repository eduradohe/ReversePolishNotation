package br.com.training;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.training.entities.MathExpression;
import br.com.training.entities.MathOperator;
import br.com.training.entities.MathSimpleExpression;
import br.com.training.util.NumberValidation;

public class ReversePolishCalculator {
	
	private String expression;
	
	public ReversePolishCalculator( final String expression ) {
		this.expression = expression;
	}
	
	public BigDecimal calculate () {
		
		final String[] operands = this.expression.split(" ");
		final List<BigDecimal> numericalOperands = new ArrayList<BigDecimal>();
		
		final DecimalFormat decimalFormat = NumberValidation.getBigDecimalFormat("#,##0.0#");
		
		for ( final String operand: operands ) {
			
			if ( operand == null || operand.equals("") ) {
				throw new IllegalArgumentException("The expression is not valid. Maybe too many spaces?");
			}
			
			final MathOperator operator = MathOperator.getOperator(operand);
			
			if ( operator == null ) {
				
				if ( !NumberValidation.validateDecimalFormat(operand) ) {
					throw new IllegalArgumentException("Not a valid number. Please use the #,##0.0# format. Example: 1,000.01");
				}
				
				try {
					numericalOperands.add((BigDecimal) decimalFormat.parse(operand));
				} catch (ParseException e) {
					throw new IllegalArgumentException("Not a valid number. Please use the #,##0.0# format. Example: 1,000.01");
				}
				
			} else {
				
				if ( numericalOperands.size() < 2 ) {
					throw new IllegalArgumentException("Not a valid expression. Too many operators.");
				}
				
				final int lastPosition = numericalOperands.size() - 1;
				
				final MathExpression expression = new MathSimpleExpression(numericalOperands.get(lastPosition - 1), numericalOperands.get(lastPosition), MathOperator.getOperator(operand));
				numericalOperands.remove(lastPosition);
				numericalOperands.remove(lastPosition - 1);
				numericalOperands.add(expression.calculate());
			}
		}
		
		if ( numericalOperands.size() > 1) {
			throw new IllegalArgumentException("Not a valid expression. Too many operands.");
		}
		
		return numericalOperands.get(0);
	}
}
