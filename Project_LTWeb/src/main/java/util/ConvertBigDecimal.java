package util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ConvertBigDecimal {
	public static BigDecimal createBigDecimalFromString(String string) {
		BigDecimal value = null;
		try {
			Number number = NumberFormat.getNumberInstance(new Locale("pt", "BR")).parse(string);
			value = new BigDecimal(number.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return value;
	}
}
