package br.ufpe.nti.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate {

	/**
	 * Retorna um java.util.Date para uma data String no formato dd/MM/yyyy
	 * @param data
	 * @throws ParseException 
	 */
	public static Date getDate(String data){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
		  
		Date date = null;
		try {
			date = sdf.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date;
	}
}
