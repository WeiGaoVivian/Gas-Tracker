package text;

import java.util.ArrayList;


public class Tracker {
	
	private Node front;
	private int count;
	/*private double totalPrice;
	private double averagePrice;
	private double totalDistTraveled;
	private double averageDistance;*/

	// constructor
	public Tracker() {
		
		front = null;
		count = 0;
	}
	public int getCount() {
		return count;
	}
	
	// add a node to the front of the linked list
	public void addToFront(Taxi t) {
		Node n = new Node(t, front);
		front = n;
		count++;
	}

	public void addToEnd(Taxi t) {
		
		Node n = new Node(t, null);
		if (count==0) {
			front = n;
		}
		else {
			Node curr = front;
			while (curr.getNext() != null) {
				curr = curr.getNext();
			}
			curr.setNext(n);
		}
		count++;
	}

	public Taxi getTaxi(int c) {//get the taxi object in index c
		Node curr=front;
		for(int count=0;count<c; count++) {
			curr=curr.getNext();
		}
		return curr.getData();
	}

	public void remove(Taxi t) {//remove t taxi
		Node curr = front;
		while (!curr.getNext().getData().getId().equals(t.getId())) {
			curr = curr.getNext();
		}
		curr.setNext(curr.getNext().getNext());
		count--;
	}

	public void enumerate() {
		Node curr = front;
		while (curr != null) {
			System.out.print(curr);
			curr = curr.getNext();
		}
		System.out.println(".");
	}



	public ArrayList<Double> singleCarAveCost(Taxi taxi, int[] type) {//the average cost for a single car
		double totalCost = 0;
		ArrayList<Double> aveCost = new ArrayList<Double>();//store all the average data
		for (int i = 0; i < taxi.getReceipts().size(); i++) {
			if (type[0] == type[1] && taxi.getReceipts().get(i).getMonth() == type[0]) { // if user only input one month
				totalCost += taxi.getReceipts().get(i).getPrice();
				aveCost.add(totalCost / type[2]);//aveCost(0)-daily
				aveCost.add(totalCost / type[3]);//aveCost(1)-weekly
				aveCost.add(totalCost);//aveCost(2)-monthly
			} else if (type[0] != type[1]) {
				for (int t = type[0]; t <= type[1]; t++) {
					if (taxi.getReceipts().get(i).getMonth() == t)
						totalCost += taxi.getReceipts().get(i).getPrice();
				}
				aveCost.add(totalCost / type[2]);//aveCost(0)-daily
				aveCost.add(totalCost / type[3]);//aveCost(1)-weekly
				aveCost.add(totalCost / type[1] - type[0] + 1);//aveCost(2)-monthly

			} else
				continue;
		}
		aveCost.add(totalCost);//aveCost(3)total
		return aveCost;
	}

	public ArrayList<Double> singleCarAveDistance(Taxi taxi, int[] type) {// the average distance for a single car

		double totalDistance = 0;
		ArrayList<Double> aveDistance = new ArrayList<Double>();// aveCost(0)-daily,aveCost(1)-weekly,aveCost(2)-monthly,aveCost(3)total
																// cost
		for (int i = 0; i < taxi.getReceipts().size(); i++) {
			if (type[0] == type[1] && taxi.getReceipts().get(i).getMonth() == type[0]) { // if user only input one month
				totalDistance += taxi.getReceipts().get(i).getDistance();
				aveDistance.add(totalDistance / type[2]);
				aveDistance.add(totalDistance / type[3]);
				aveDistance.add(totalDistance);
			} else if (type[0] != type[1]) {
				for (int t = type[0]; t <= type[1]; t++) {
					if (taxi.getReceipts().get(i).getMonth() == t)
						totalDistance += taxi.getReceipts().get(i).getPrice();
				}
				aveDistance.add(totalDistance / type[2]);
				aveDistance.add(totalDistance / type[3]);
				aveDistance.add(totalDistance / type[1] - type[0] + 1);

			} else
				continue;
		}
		aveDistance.add(totalDistance);
		return aveDistance;
	}
	public Node getFront() {
		return front;
	}

	public ArrayList<Double> companyAveDistance(int[] type) {//the average distance of all the cars
		ArrayList<Double> aveDistance = new ArrayList<Double>();
		double totalDistance = 0;

		Node n =front;
		while (n != null) {
			totalDistance += (singleCarAveCost(n.getData(), type).get(3));
			n = n.getNext();
		}
		aveDistance.add(totalDistance / type[2]);//daily distance
		aveDistance.add(totalDistance / type[3]);//weekly distance
		aveDistance.add(totalDistance / type[1] - type[0] + 1);//monthly distance
		return aveDistance;
	}
	
	public ArrayList<Double> companyAveCost(int[] type) {//the average cost of all the cars
		ArrayList<Double> aveCost = new ArrayList<Double>();// aveCost(0)-daily,aveCost(1)-weekly,aveCost(2)-monthly,aveCost(3)total
		double totalCost = 0;
		Node curr = front;

		Node n = front;
		while (n != null) {
			totalCost += (singleCarAveCost(curr.getData(), type).get(3));
			n = n.getNext();
		}
		aveCost.add(totalCost / type[2]);//daily cost
		aveCost.add(totalCost / type[3]);//weekly cost
		aveCost.add(totalCost / type[1] - type[0] + 1);//monthly cost
		return aveCost;
	}
	/*public void averagePrice() {
		setAveragePrice(totalPrice / count);
	}

	public void totalDistTraveled() {
		Node curr = front;
		while (curr != null) {
			totalDistTraveled += curr.getData().getTotalDistTraveled();
			curr = curr.getNext();
		}

	}

	public void averageDistance() {
		setAverageDistance(totalDistTraveled / count);
	}

	public double getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(double averagePrice) {
		this.averagePrice = averagePrice;
	}

	public double getAverageDistance() {
		return averageDistance;
	}

	public void setAverageDistance(double averageDistance) {
		this.averageDistance = averageDistance;
	}*/
}
