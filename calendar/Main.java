package calendar;

import java.util.Scanner;

public class Main {
		 public static void main(String[] args) {
			 Scanner input = new Scanner(System.in);
		     CalendarImplementation cal = new CalendarImplementation();
		     int date, month, year;
		     while (true) {
		    	 System.out.println("Enter the date:");
		         date = input.nextInt();
		         System.out.println("Enter the month:");
		         month = input.nextInt();
		         System.out.println("Enter the year:");
		         year = input.nextInt();
		         if (cal.isValidDate(date, month, year)) {
		             break;
		         } else {
		             System.out.println("Invalid date! Please enter a valid date.");
		        }
		    }
		        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		        System.out.println("The respective day is: " + days[cal.getDayOfWeek(date, month, year)]);
		        cal.printCalendar(date, month, year);
		    }
		}
