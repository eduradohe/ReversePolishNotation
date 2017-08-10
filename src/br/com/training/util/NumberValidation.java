package br.com.training.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberValidation {

	public static DecimalFormat getBigDecimalFormat( final String pattern, final char groupingSeparator, final char decimalSeparator ) {
		
		final DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setGroupingSeparator(groupingSeparator);
		symbols.setDecimalSeparator(decimalSeparator);
		
		final DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
		decimalFormat.setParseBigDecimal(true);
		
		return decimalFormat;
	}

	public static DecimalFormat getBigDecimalFormat( final String pattern ) {
		return getBigDecimalFormat(pattern, ',', '.');
	}

	public static boolean validateDecimalFormat( final String input ) {
		
		final String regExp = "((([0-9]{1,3}[,])*[0-9]{3})|([0-9]{1,3}))([.][0-9]+)?";
		
		final Pattern pattern = Pattern.compile(regExp);
		
		Matcher matcher = pattern.matcher(input); 
		return matcher.matches();
	}

}
