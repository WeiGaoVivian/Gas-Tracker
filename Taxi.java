mport java.util.ArrayList;

public class Taxi extends TaxiInfo {
	//attributes
	private ArrayList<Receipt> receipts;
	private static double fuelEconomy; //L/100km
	private double totalPrice;
	private double totalDistTraveled;
	
	//constructor
	public Taxi(String i, String b, String c, ArrayList<Receipt> r) {
		super(i,b,c);	
		receipts = new ArrayList<Receipt>(r);
		fuelEconomyOfTaxi(); // calculate fuel economy 
		for(int j =0; j<r.size();j++) { 
			totalDistTraveled += r.get(j).getDistance(); //adding up distance traveled
			totalPrice += r.get(j).getPrice(); //add up amount spent on gas
		}
	}
	
	//getters
	public ArrayList<Receipt> getReceipts() {return receipts;}
	public double getFuelEconomy() {return fuelEconomy;}
	public double getTotalPrice() {return totalPrice;}
	public double getTotalDistTraveled() {return totalDistTraveled;}
	
	//setters
	public void setReceipts(ArrayList<Receipt> receipts) {this.receipts = receipts;}
	public void setTotalPrice(double totalPrice) {this.totalPrice = totalPrice;}
	public void setDistTraveled(double distTraveled) {this.totalDistTraveled = distTraveled;}
	
	//assumed there is no empty array list since the user puts taxi info and receipt info at the same
	public void fuelEconomyOfTaxi () {
		fuelEconomy = receipts.get(0).getAmount() / receipts.get(0).getDistance();
	}
	
	/*//toString 
	public String toString() {
		 return receipts + "-->"; } */
}
