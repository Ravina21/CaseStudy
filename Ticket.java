package casestudy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import oracle.net.aso.p;

public class Ticket{
	private int counter;
	private String pnr;
	private Date travelDate;
	Train train = new Train();
	Map<Passenger, Integer> passengers = new TreeMap();
	
	public String generatePNR(String s, String d, LocalDate d1 ) throws ParseException {
		String PNR;
		char a = s.charAt(0);
		char b = d.charAt(a);
		int c = 100;
		StringBuilder sb = new StringBuilder();
		sb.append(a);
		sb.append(b);
		sb.append("_");
		sb.append(d1);
		sb.append("_");
		sb.append(c);
		PNR = sb.toString();
		c++;
		return PNR;
	}
	public double calPassengerfare(Passenger passenger) {
		double totalPrice = 0;
		if(passenger.getGender() == "Female") {
			if( passenger.getAge() >= 60 || passenger.getAge() <= 12) {
				return totalPrice = (totalPrice - (totalPrice / 25));
			}
		}
		if(passenger.getAge() <= 12){
			return totalPrice = totalPrice/2;
		}
		if(passenger.getAge() >= 60) {
			return totalPrice = totalPrice - ((3 * totalPrice) / 5);
		}
		return totalPrice;
	}
	
	public void addPassenger(String name, int age, String gender) {
		Passenger passenger = new Passenger(name, age, gender);
		passengers.put(passenger, 1);
	}
	
	public double calTotalTicketPrice() {
		double totalPrice = 0;
		for(Passenger key : passengers.keySet()) {
			totalPrice = totalPrice + passengers.get(key);
		}
		return totalPrice;
	}
	
	public StringBuilder genrateTicket(double fare,double totalPrice) {
		StringBuilder sb = new StringBuilder();
		sb.append("PNR " + '\t' + ":" + pnr );
		sb.append("Train no" + "\t" + ":" + train.getTrainNo());
		sb.append("Train Name" + "\t" + ":" + train.getTrainName());
		sb.append("From" + "\t" + ":" + train.getSource());
		sb.append("To" + "\t" + ":" + train.getDest());
		sb.append("Travel Date" + "\t" + ":" + travelDate);
		sb.append("Passengers : ");
		sb.append("Name" + "\t" + "\t" + "Age" + "\t" + "Gender" + "\t" + "Fare");
		for(Map.Entry<Passenger, Integer> entry : passengers.entrySet()) {
			Passenger passenger = new Passenger();
			sb.append(entry.getValue() + "\t" + fare);
		}
		sb.append("Total Price " + "\t" + ":" + totalPrice);
		return sb;
	}
	
	public void writeTicket( StringBuilder sb) throws IOException {
		File file = new File(pnr);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(sb.toString().getBytes());
	}
	
	public int getCounter() {
		return counter;
	}
	
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public String getPnr() {
		return pnr;
	}
	
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	
	public Date getTravelDate() {
		return travelDate;
	}
	
	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}
	
	public Train getTrain() {
		return train;
	}
	
	public void setTrain(Train t) {
		this.train = t;
	}
	
	
}
