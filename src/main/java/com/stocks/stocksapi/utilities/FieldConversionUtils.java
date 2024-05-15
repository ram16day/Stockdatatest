package com.stocks.stocksapi.utilities;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;

import org.apache.commons.lang3.StringUtils;

public class FieldConversionUtils {
	
	public static final String dateFormatPattern ="MM/dd/yyyy";
	public static final DateFormat  dateformate =  new SimpleDateFormat(dateFormatPattern);
	public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatPattern);//)"MM/dd/yyyy";

	
	public static String getCurrencyString(BigDecimal value) {
		return value== null ?"": 	NumberFormat.getCurrencyInstance().format(value);
	}
		public static BigDecimal getCurrency(String currencyString)
		{
			return StringUtils.isEmpty(currencyString)? null: BigDecimal.valueOf(Double.parseDouble(
					currencyString.replace("$", "")));
		}
		
		
		public static String getDateString(java.util.Date date) {
			return dateformate.format(date);
	}
		
		public static Date getDateFormatString(String dateString) {
			return  Date.valueOf(LocalDate.parse(dateString,formatter));
		}

}
