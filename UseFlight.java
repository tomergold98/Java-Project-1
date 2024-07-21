import java.util.Scanner;

public class UseFlight {

	public static void main(String[] args) {
		
		Flight f1 = new Flight();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Flight Number: ");
		int flightNum = Integer.parseInt(scan.nextLine());
		
		System.out.println("Enter Origin Country: ");
		String originCo = scan.nextLine();
		
		System.out.println("Enter Destination Country: ");
		String destinationCo = scan.nextLine();
		
		System.out.println("Enter Flight Company: ");
		String flightCom = scan.nextLine();
		
		System.out.println("Enter Hour Departure: ");
		int hourDepar = Integer.parseInt(scan.nextLine());
		
		System.out.println("Enter minute Departure: ");
		int minuteDepar = Integer.parseInt(scan.nextLine());
		
		System.out.println("Enter Total Seats Number: ");
		int totalseatsNum = Integer.parseInt(scan.nextLine());
		
	    Flight f2 = new Flight(flightNum,originCo,destinationCo,flightCom,hourDepar,minuteDepar,totalseatsNum);
	    
	    Flight f3 = new Flight(f2);
	    
		System.out.println("Enter Origin Country: ");
		String originCo1 = scan.nextLine();
		
		System.out.println("Enter Destination Country: ");
		String destinationCo1 = scan.nextLine();
		
		System.out.println("Enter Flight Company: ");
		String flightCom1 = scan.nextLine();
		
		System.out.println("Enter Hour Departure: ");
		int hourDepar1 = Integer.parseInt(scan.nextLine());
		
		System.out.println("Enter minute Departure: ");
		int minuteDepar1 = Integer.parseInt(scan.nextLine());
		
		System.out.println("Enter Total Seats Number: ");
		int totalseatsNum1 = Integer.parseInt(scan.nextLine());
		
		f3.setOriginCountry(originCo1);
		f3.setDestinationCountry(destinationCo1);
		f3.setFlightCompany(flightCom1);
		f3.setHourDeparture(hourDepar1);
		f3.setMinuteDeparture(minuteDepar1);
		f3.setTotalseatsNumber(totalseatsNum1);
		
		System.out.print("What would you like to do?\n"
				+ "\t1. Print details of all three flghts.\n"
				+ "\t2. Compare between f2 and f3.\n"
				+ "\t3. is f2 greater than f3?\n"
				+ "\t4. is f2 smaller than f3?\n"
				+ "\t5. is f1 departure at night?\n"
				+ "\t6. How many seats are available in all three flights?\n"
				+ "\t7. Order seats for flight f1.\n"
				+ "\t8. Cancel seats for flight f1.\n");
		
		boolean flag = true;
		while(flag) {
			int choice = scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("The First flight: " + f1);
				System.out.println("The Second flight: " + f2);
				System.out.println("The Third flight: " + f3);
				break;
			case 2:
				if(f2.equals(f3)) 
					System.out.println("The Flights is equals");
				else {
					System.out.println("The Flights is not equals");
				}
				break;
			case 3:
				if(f2.isGreater(f3)) 
					System.out.println("f2 is greater than f3");
				else {
					System.out.println("f2 is not greater than f3");
				}
				break;			
			case 4:
				if(f2.isSmaller(f3)) 
					System.out.println("f2 is smaller than f3");
				else {
					System.out.println("f2 is not smaller than f3");
				}
				break;
			case 5:
				if(f2.isNight()) 
					System.out.println("f2 departure is at night");
				else {
					System.out.println("f2 departure is not at night");
				}
				break;
			case 6: 
				System.out.println("flight f1 have " + f1.howManySeatsAvailable() + " available seats\n"
						+ "flight f2 have " + f2.howManySeatsAvailable() + " available seats\n"
						+ "flight f3 have " + f3.howManySeatsAvailable() + " available seats\n"
						+ "all three flights have " + (f1.howManySeatsAvailable() + f2.howManySeatsAvailable() + f3.howManySeatsAvailable()) + " available seats");
				break;
			case 7:
				System.out.println("Enter the order number seats:");
				int orderse = scan.nextInt();
				if(orderse >= 0) {
					if(f1.orderSeats(orderse)) 
						System.out.println("The order number seats are: " + orderse+ "\n"
								+ "number of seats left are: " + f1.howManySeatsAvailable());
					else {
						System.out.println("the number is not correct");
					}
				}
				else {
					System.out.println("the number is not correct");
					}

				break;
			case 8:
				System.out.println("Enter the cancel number seats:");
				int cancelse = scan.nextInt();
				if(cancelse >= 0) {
					if(f1.cancelSeats(cancelse)) 
						System.out.println("The cancel number seats are: " + cancelse + "\n"
								+ "number of seats left are: " + f1.howManySeatsAvailable());
					else {
						System.out.println("The number is not correct");
					}
				}
				else {
					System.out.println("the number is not correct");
				}
				
				break;
			default:
				System.out.println("the number is not correct, try again");
				break;
			
			}								
		}
	}		
}

							
		
		
		
					
			


