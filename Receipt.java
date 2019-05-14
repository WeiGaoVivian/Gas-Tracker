public class Receipt
{  //attributes
   private int date;
   private int month;
   private int year;
   private double price;
   private double amount;
   private double distance;
   private String rNum;
   //constructor
   public Receipt(int day, int m, int y,double p, double a, double dist,String r1)
   {
      date=day;
      month=m;
      year=y;
      price=p;
      amount=a;
      distance=dist;
      rNum=r1;
   }
   //get methods
   public int getDate()
   {
      return date;
   }
   
   public int getMonth()
   {
      return month;
   }
   
   public int getYear()
   {
      return year;
   }
   
   public double getPrice()
   {
      return price;
   }
   
   public double getAmount()
   {
      return amount;
   }
   
   public double getDistance()
   {
      return distance;
   }

   public String getRNum()
   {
      return rNum;
   }
   
   //set methods
   public void setDate(int d)
   {
      date=d;
   }
   
   public void setMonth(int m)
   {
      month=m;
   }
   
   public void setYear(int y)
   {
      year=y;
   }
   
   public void setPrice(double p)
   {
      price=p;
   }
   
   public void setAmount(double a)
   {
      amount=a;
   }
   
   public void setDistance(double dist)
   {
      distance=dist;
   }

   public void setRNum(String r1)
   {
      rNum=r1;
   }
   
   //toString method
   public String toString()
   {
      return "Date of fueling(MM/DD/YY): "+month+"/"+date+"/"+year+"\nThe receipt number: "+rNum+"\nThe cost: "+price+"\nAmount of gas purchased: "+amount+"\nDistance travelled: "+distance;
   }
   
   public static void main(String[] args)
   {
      Receipt r=new Receipt(01,02,2010,1.2,20,200,"A20180328001");
      System.out.print(r);
      r.setDate(10);
      r.setMonth(12);
      r.setYear(2015);
      r.setPrice(2.7);
      r.setAmount(50);
      r.setDistance(500);
      System.out.print("\n"+r.getDate()+"\t"+r.getMonth()+"\t"+r.getYear()+"\n"+r.getPrice()+"\t"+r.getDistance()+"\t"+r.getAmount()+"\t");
      
   }
   
}

