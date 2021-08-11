package casestudy;

public class DateNotFoundException extends Exception {
	public DateNotFoundException(){
		super("Date should be after current date");
	}

}
