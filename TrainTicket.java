package casestudy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TrainTicket {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException, IOException {
		Scanner scanner = new Scanner(System.in);
		Passenger passenger = new Passenger();
		Ticket ticket = new Ticket();
		TrainDAO td = new TrainDAO();
		double totalPrice = 0;
		
		System.out.println("Enter the train number ");
		int t = scanner.nextInt();
		Train train = td.findTrain(t);
		
		System.out.println("Enter the travel date in yyyyMMdd format");
		int y = scanner.nextInt();
		int m = scanner.nextInt();
		int d = scanner.nextInt();
		
		LocalDate d1 = LocalDate.of(y, m, d);
		LocalDate d2 = LocalDate.now();
		
		try {
		if(d1.compareTo(d2) < 0)
			throw new DateNotFoundException();
		}
		catch(DateNotFoundException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		System.out.println("Enter the number of passengers");
		int no = scanner.nextInt();
		
		for(int i = 0; i < no; i++) {
		System.out.println("Enter name of passenger");
		String sr = scanner.next();
		passenger.setName(sr);
		
		System.out.println("Enter age of passenger");
		int a = scanner.nextInt();
		passenger.setAge(a);
		
		System.out.println("Enter gender of passenger");
		String str = scanner.next();
		passenger.setGender(str);
	
		ticket.addPassenger(sr, a, str);
		double fare = ticket.calPassengerfare(passenger);
		ticket.calTotalTicketPrice();
		
		StringBuilder sb = ticket.genrateTicket(fare, totalPrice);
		ticket.writeTicket(sb);
		}
		
		String pnr = ticket.generatePNR(train.getSource(), train.getDest(), d1);
		System.out.printf("Ticket booked with PNR ",  pnr);
		
		
	}

}
