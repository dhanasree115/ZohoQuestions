package calendar;

public class CalendarImplementation {
	 public static void printCalendar(int date, int month, int year) {
	        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	        if (isLeapYear(year)) months[1] = 29;  
	        int start_day = getDayOfWeek(1, month, year);  
	        System.out.println("SUN\tMON\tTUE\tWED\tTHU\tFRI\tSAT");
	        for (int i = 0; i < start_day; i++) {
	            System.out.print("\t");
	        }
	        for (int day = 1; day <= months[month - 1]; day++) {
	            System.out.print(day + "\t");
	            if ((day + start_day) % 7 == 0) {  
	                System.out.println();
	            }
	        }
	        System.out.println();
	    }
	    public static int getDayOfWeek(int date, int month, int year) {
	        int[] month_code = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
	        int century_code = getCenturyCode(year);
	        int last_two_digits = year % 100;
	        int quotient = last_two_digits / 4;
	        if (isLeapYear(year) && (month == 1 || month == 2)) {
	            month_code[1] = 4;  
	        }
	        int day_of_week = (last_two_digits + quotient + date + month_code[month - 1] + century_code) % 7;
	        if (isLeapYear(year) && (month == 1 || month == 2)) {
	            day_of_week--;
	        }
	        return day_of_week;
	    }
	    public static boolean isValidDate(int date, int month, int year) {
	        if (month < 1 || month > 12) {
	            return false;  
	        }
	        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	        if (isLeapYear(year)) {
	            months[1] = 29;  
	        }
	        return date >= 1 && date <= months[month - 1];
	    }
	    public static boolean isLeapYear(int year) {
	        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	    }
	    public static int getCenturyCode(int year) {
	        int century_code;
	        if (year >= 1600 && year <= 1699) century_code = 6;
	        else if (year >= 1700 && year <= 1799) century_code = 4;
	        else if (year >= 1800 && year <= 1899) century_code = 2;
	        else if (year >= 1900 && year <= 1999) century_code = 0;
	        else century_code = 6; 
	        return century_code;
	    }
	}