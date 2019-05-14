package text;
import java.util.*;
public class Demo_Info {

    public static void main(String[] args) {
        // input data
    		
        Receipt rc11=new Receipt(2010,01,02,1.2,20,200);
        Receipt rc12=new Receipt(2010,01,03,1.5,60,550);
        Receipt rc13=new Receipt(2010,02,02,1.1,70,700);
        Receipt rc14=new Receipt(2010,02,04,1.7,90,900);
        Receipt rc15=new Receipt(2010,03,03,1.4,40,300);
        Receipt rc16=new Receipt(2010,03,12,1.6,30,250);
        /*ArrayList<Receipt> rc1=new ArrayList<Receipt>();//arraylist of taxi1
        rc1.add(rc11);
        rc1.add(rc12);
        rc1.add(rc13);
        rc1.add(rc14);
        rc1.add(rc15);
        rc1.add(rc16);
        for(int i=0;i<rc1.size();i++)
        {
            rc1.get(i).setRNum(rc1.get(i).getRNum()+""+i);//add index to the recept number
        }*/
        Receipt rc21=new Receipt(2010,1,5,1.2,20,100);
        Receipt rc22=new Receipt(2010,1,7,1.9,60,450);
        Receipt rc23=new Receipt(2010,2,8,1.8,70,600);
        Receipt rc24=new Receipt(2010,2,9,1.8,90,800);
        Receipt rc25=new Receipt(2010,3,20,1.6,40,200);
        Receipt rc26=new Receipt(2010,3,21,1.7,30,150);
        /*ArrayList<Receipt> rc2=new ArrayList<Receipt>();//arraylist of taxi2
        rc2.add(rc21);
        rc2.add(rc22);
        rc2.add(rc23);
        rc2.add(rc24);
        rc2.add(rc25);
        rc2.add(rc26);
        for(int i=0;i<rc2.size();i++)
        {
            rc2.get(i).setRNum(rc2.get(i).getRNum()+""+i);//add index to the receipt number
        }*/
        Taxi taxi1=new Taxi("A", "Toyota", "black");
        taxi1.addReceipt(rc11);
        taxi1.addReceipt(rc12);
        taxi1.addReceipt(rc13);
        taxi1.addReceipt(rc14);
        taxi1.addReceipt(rc15);
        taxi1.addReceipt(rc16);
        Taxi taxi2=new Taxi("B", "Chrysler", "white");
        taxi2.addReceipt(rc21);
        taxi2.addReceipt(rc22);
        taxi2.addReceipt(rc23);
        taxi2.addReceipt(rc24);
        taxi2.addReceipt(rc25);
        taxi2.addReceipt(rc26);
        Tracker taxilist=new Tracker();//this should be in tracker
        taxilist.addToEnd(taxi1);//should call method in tracker and add
        taxilist.addToEnd(taxi2);
        //end of data input
       
        int [] choice=new int[5];
        ArrayList<Taxi> calculateList=new ArrayList<Taxi>();
        Scanner kb=new Scanner(System.in);
        int option=0;//1 is car option;2 is company option
        System.out.println("Please choose statistics based on: Car(1)\tCompany(2)\t-1 to exit: ");
        option=kb.nextInt();
        while(option!=-1)
        {

            if(option==1)//report of selected taxi(s)
            {
                String t="0";
                //it should be a check box:search from the list of taxi
                while(!t.equals("-1"))
                {
                    System.out.println("Please choose car/cars that you want to generate the report(end by -1): ");
                    t=kb.next();
                    
                    for(int i=0;i<taxilist.getCount();i++)
                    {
                        Taxi temp=taxilist.getTaxi(i);
                        if(temp.getTaxiID().equalsIgnoreCase(t))
                        {
                            calculateList.add(temp);
                        }
                    }
                }
                //type of report method:daily;weekly;monthly
                choice= reportChoice();
                reportCars(calculateList,choice);
            }
            else if(option==2)//report of the whole company
            {
                choice= reportChoice();
                reportCompany(taxilist,choice);
            }
            System.out.println();
            System.out.println("Please choose statistics based on: Car(1)\tCompany(2)\t-1 to exit: ");
            option=kb.nextInt();
        }
    }
    //choose date/weekly/monthly method
        public static int[] reportChoice()
        {
            Scanner kb=new Scanner(System.in);
            int [] type=new int[5];
            System.out.println("Start from which month: ");
            type[0]=kb.nextInt();
            System.out.println("End at which month: ");
            type[1]=kb.nextInt();
            System.out.println("How many days: ");
            type[2]=kb.nextInt();
            System.out.println("How many weeks: ");
            type[3]=kb.nextInt();
            
           
            return type;
        }

        //calculate methods
        public static void reportCompany(Tracker t,int[]type)
        {
            System.out.print("Result of the entire company: ");
          
            Node curr=t.getFront();
    		while(curr!=null) {
    			ArrayList<Double> a=t.companyAveCost(type);
    			
    			System.out.print("Daliy"+a.get(0)+"\nWeekly"+a.get(1)+"\nMonthly"+a.get(2));
    			curr=curr.getNext();
    		}
    		curr=t.getFront();
    		while(curr!=null) {
    			ArrayList<Double> b=t.companyAveDistance(type);
    			
    			System.out.print("Daliy"+b.get(0)+"\nWeekly"+b.get(1)+"\nMonthly"+b.get(2));
    			curr=curr.getNext();
    		}
            //tracker's calculate methods
        }

        public static void reportCars(ArrayList<Taxi> c,int[]type)
        {	
        		System.out.print("Result of selected car(s): ");
        		Tracker tracker=new Tracker();
        		for(int i=0;i<c.size();i++) {
        			ArrayList<Double> a=tracker.singleCarAveCost(c.get(i),type);
        			System.out.print("Daliy"+a.get(0)+"\nWeekly"+a.get(1)+"\nMonthly"+a.get(2));
        		}
        		for(int i=0;i<c.size();i++) {
        			ArrayList<Double> b=tracker.singleCarAveDistance(c.get(i),type);
        			System.out.print("Daliy"+b.get(0)+"\nWeekly"+b.get(1)+"\nMonthly"+b.get(2));
        		}
        		
            //tracker's calculate methods
        }

}
