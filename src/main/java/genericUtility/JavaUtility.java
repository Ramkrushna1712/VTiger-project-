package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * this is a utility class which works with java related operation
 */
public class JavaUtility {
	/**
	 * this is a generic method which is generate random number
	 */
	public int generateRandomNumber(int boundary) {
		Random r=new Random();
		int num=r.nextInt(boundary);
		return num;
	}
	/**
	 * this is a generic method to fetch calendar details
	 */
	public String getCalendarDetails(String pattern) {
		Calendar cal=Calendar.getInstance();
		Date d=cal.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		String data=sdf.format(d);
		return data;
	}

}
 