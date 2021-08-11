package casestudy;

public class Train {
	private int trainNo;
	private String trainName;
	private String source;
	private String dest;
	private double price;
	
	public Train() {
		
	}
	
	public Train(int trainNo, String trainName, String source, String dest, double price) {
		super();
		this.trainNo = trainNo;
		this.trainName = trainName;
		this.source = source;
		this.dest = dest;
		this.price = price;
	}

	public int getTrainNo() {
		return trainNo;
	}
	
	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}
	
	public String getTrainName() {
		return trainName;
	}
	
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	
	public String getSource() {
		return source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public String getDest() {
		return dest;
	}
	
	public void setDest(String dest) {
		this.dest = dest;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
