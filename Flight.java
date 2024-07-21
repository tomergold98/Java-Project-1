
public class Flight {

	private int flightNumber;
	private String originCountry;
	private String destinationCountry;
	private String flightCompany;
	private int hourDeparture;
	private int minuteDeparture;
	private int totalseatsNumber;
	private int takenseatsNumber;
	
	public Flight(int flightNumber,String originCountry,String destinationCountry,String flightCompany,int hourDeparture,int minuteDeparture,int totalseatsNumber){
		takenseatsNumber = 0;
		this.originCountry = originCountry;
		this.destinationCountry = destinationCountry;
		this.flightCompany = flightCompany;
		if(String.valueOf(flightNumber).length()==4)
			this.flightNumber = flightNumber;
		else {
			this.flightNumber = 1000;
		}
			if(hourDeparture >= 0 && hourDeparture <= 23)
					this.hourDeparture = hourDeparture;
			else {
				this.hourDeparture = 0;
			}
				if(minuteDeparture >= 0 && minuteDeparture <= 59)
					this.minuteDeparture = minuteDeparture;
				else {
					this.minuteDeparture = 0;
				}
					if(totalseatsNumber >= 200 && totalseatsNumber <= 500)
						this.totalseatsNumber = totalseatsNumber;
					else {
						this.totalseatsNumber = 200;
					}
					
	}
	public Flight() { //default constructor
		flightNumber = 1000;
		originCountry = "TLV";
		destinationCountry = "USA";
		flightCompany = "ELAL";
		hourDeparture = 0;
		minuteDeparture = 0;
		totalseatsNumber = 200;
		takenseatsNumber = 0;
	}
	
	public Flight(Flight a) {
		this.originCountry = a.originCountry;
		this.destinationCountry = a.destinationCountry;
		this.flightCompany = a.flightCompany;
		this.flightNumber = a.flightNumber;
		this.hourDeparture = a.hourDeparture;
		this.minuteDeparture = a.minuteDeparture;
		this.totalseatsNumber = a.totalseatsNumber;
		this.takenseatsNumber = a.takenseatsNumber;
		
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public String getOriginCountry() {
		return originCountry;
	}

	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}

	public String getDestinationCountry() {
		return destinationCountry;
	}

	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}

	public String getFlightCompany() {
		return flightCompany;
	}

	public void setFlightCompany(String flightCompany) { 
		this.flightCompany = flightCompany;
	}

	public int getHourDeparture() {
		return hourDeparture;
	}

	public void setHourDeparture(int hourDeparture) {
		if(hourDeparture >= 0 && hourDeparture <= 23)
			this.hourDeparture = hourDeparture;
		else {
			this.hourDeparture = 0;
		}
	}

	public int getMinuteDeparture() {
		return minuteDeparture;
	}

	public void setMinuteDeparture(int minuteDeparture) {
		if(minuteDeparture >= 0 && minuteDeparture <= 59)
			this.minuteDeparture = minuteDeparture;
		else {
			this.minuteDeparture = 0;
		}
	}

	public int getTotalseatsNumber() {
		return totalseatsNumber;
	}

	public void setTotalseatsNumber(int totalseatsNumber) {
		if(totalseatsNumber >= 200 && totalseatsNumber <= 500) {
			this.totalseatsNumber = totalseatsNumber;
			if(totalseatsNumber < takenseatsNumber)
				takenseatsNumber = totalseatsNumber;
		}
		else {
			this.totalseatsNumber = 200;
		}
	}

	public int getTakenseatsNumber() { 
			return takenseatsNumber;
	}
	
	public String toString() {
		int availableseatsNumber = totalseatsNumber - takenseatsNumber;
		if(hourDeparture > 10 && minuteDeparture > 10 ) {
			return "Flight " + flightNumber + " from " + originCountry + " to " 
				+ destinationCountry + " will departure on " + hourDeparture +
				":" + minuteDeparture + "." + " Seats: " + takenseatsNumber + " out of " +
				totalseatsNumber + " seats are taken. " + availableseatsNumber + " seats left"; 
		}
		else {
			if(hourDeparture < 10 && minuteDeparture > 10 ) {
				return "Flight " + flightNumber + " from " + originCountry + " to " 
						+ destinationCountry + " will departure on " + "0" + hourDeparture +
						":" + minuteDeparture + "." + " Seats: " + takenseatsNumber + " out of " +
						totalseatsNumber + " seats are taken. " + availableseatsNumber + " seats left";
			}
			else {
				if(hourDeparture > 10 && minuteDeparture < 10 ) {
					return "Flight " + flightNumber + " from " + originCountry + " to " 
							+ destinationCountry + " will departure on " + hourDeparture +
							":" + "0" + minuteDeparture + "." + " Seats: " + takenseatsNumber + " out of " +
							totalseatsNumber + " seats are taken. " + availableseatsNumber + " seats left";
				}
			return "Flight " + flightNumber + " from " + originCountry + " to " 
								+ destinationCountry + " will departure on " + "0" + hourDeparture +
								":" + "0" + minuteDeparture + "." + " Seats: " + takenseatsNumber + " out of " +
								totalseatsNumber + " seats are taken. " + availableseatsNumber + " seats left";
					}
				}
			}
	
	public boolean equals(Flight a) {
		if(this.flightNumber == a.flightNumber && this.originCountry.equals(a.originCountry)
				&& this.destinationCountry.equals(a.destinationCountry) && this.flightCompany.equals(a.flightCompany)
				&& this.hourDeparture == a.hourDeparture && this.minuteDeparture == a.minuteDeparture
				&& this.totalseatsNumber == a.totalseatsNumber) 
				return true;
		return false;
	}
	public boolean isGreater(Flight a) {
		if(totalseatsNumber > a.totalseatsNumber)
			return true;
		return false;
	}
	public boolean isSmaller(Flight a) { 
		return(a.isGreater(this));
	}
	
	public boolean isNight() {
		if(hourDeparture < 19 && hourDeparture > 3 || hourDeparture == 3 && minuteDeparture != 0) 
			return false;	
		return true;
			
	}
	
	public int howManySeatsAvailable() {
		int availableseatsNum = totalseatsNumber - takenseatsNumber;
		return availableseatsNum;
	}
	public boolean orderSeats(int order) {
		if (this.howManySeatsAvailable() >= order && order > 0) {
			takenseatsNumber += order;
			return true;
		}
		return false;
		
	}
	public boolean cancelSeats(int cancelNumber) {
		if(cancelNumber <= takenseatsNumber && takenseatsNumber > 0 && cancelNumber > 0) {
			takenseatsNumber -= cancelNumber;
			return true;
		}
		return false;
	}
	
}

			

	

