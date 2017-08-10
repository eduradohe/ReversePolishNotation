package br.com.training.entities;

public enum MathOperator {
	
	SUM("+"), SUBTRACT("-"), MULTIPLY("x"), DIVIDE("/");
	
	private String stringDefinition;
	
	private MathOperator( final String stringDefinition ) {
		this.stringDefinition = stringDefinition;
	}
	
	public static MathOperator getOperator(final String stringDefinition) {
		
		if ( stringDefinition.equals(SUM.toString()) ) {
			return SUM;
		} else if ( stringDefinition.equals(SUBTRACT.toString()) ) {
			return SUBTRACT;
		} else if ( stringDefinition.equals(MULTIPLY.toString()) ) {
			return MULTIPLY;
		} else if ( stringDefinition.equals(DIVIDE.toString()) ) {
			return DIVIDE;
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		
		return this.stringDefinition;
	}
}
