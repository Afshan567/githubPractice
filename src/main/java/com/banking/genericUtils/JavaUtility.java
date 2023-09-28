package com.banking.genericUtils;

import java.util.Date;
import java.util.Random;

/**
 * @author Admin
 */
public class JavaUtility {
	/**
	 * This method is used to get the random number
	 * @return
	 */
public int getRandomNumber()
{
	Random ran=new Random();
	int randNum=ran.nextInt(1000);
	return randNum;
 }
/**
 * This method will fetch system date in IST format
 * @return
 */
public String getSystemDate()
{
	Date date=new Date();
	return date.toString();
}
/**
 * This method is used to fetch system date in required format
 * @return
 */
public String getSystemDateInFormat()
{
	Date dateTime=new Date();
	String[] d = dateTime.toString().split(" ");
	String day=d[0];
	String month=d[1];
	String date=d[2];
	String year=d[5];
	String finalFormat=day+" "+month+" "+date+" "+year;
	return finalFormat;
}
}