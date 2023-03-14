import java.util.InputMismatchException;
import java.util.*;
import java.awt.*;

abstract class Ticket
{
    private String destination;
    private int quantity;
    private double price;
    private Flight flight;
    Ticket(){}
    Ticket(String d,int q,double p,Flight f)
    {
        destination = d;
        quantity = q;
        price = p;
        flight = f;
    }
    public String getDestination() {
        return destination;
    }
    public int getQuantity() {
        return quantity;
    }
    public Flight getFlight() {
        return flight;
    }
    public double getPrice() {
        return price;
    }
    public abstract void print();
}
class Business extends Ticket
{
    private String meals;
    Business(){}
    Business(String d,int q,double p,Flight f,String m)
    {
        super(d, q, p, f);
        meals=m;
    }
    public String getMeals() {
        return meals;
    }

    @Override
    public void print() {
        // TODO Auto-generated method stub
        System.out.println("==========BUSINESS CLASS==========");
        System.out.println("Price: RM"+getPrice());
        System.out.println("Thank you for flying with us.");
        System.out.println("Free orange juice will be given before departed from your destination.");
        System.out.println("Also, free meals will be given after 15minutes departed from your destination");
        System.out.println("The free meals given: "+meals);
    }
}
class Economy extends Ticket
{
    private String drinks;
    Economy(){}
    Economy(String d,int q,double p,Flight f,String dK)
    {
        super(d, q, p, f);
        drinks=dK;
    }
    public String getDrinks() {
        return drinks;
    }
    @Override
    public void print() {
        // TODO Auto-generated method stub
        System.out.println("==========ECONOMY CLASS==========");
        System.out.println("Price: RM"+getPrice());
        System.out.println("Thank you for choosing us.");
        System.out.println("Free drink will be given after 20minutes departed from your destination.");
        System.out.println("The free drink given: "+drinks);

    }
}
class Customer
{
    private String name;
    private int age;
    private String address;
    private Ticket ticket;
    public Customer(){}
    public Customer(String n,int age,String address)
    {
        this.name = n;
        this.age = age;
        this.address = address;
    }

    public void buy(Ticket t)
    {
        ticket = t;
    }
    public void print()
    {
        if(age >=18)
        {
            System.out.println("\n=========DETAILS=========");
            System.out.println("Name: " + name);
            System.out.println("Address: " + address);
            System.out.println("Destination: " + ticket.getDestination());
            System.out.println("=========FLIGHT=========");
            ticket.getFlight().print();
            ticket.print();
        }else{
            System.out.println("\n=========DETAILS=========");
            System.out.println("Name: " + name);
            System.out.println("Address: " + address);
            System.out.println("Destination: " + ticket.getDestination());
            System.out.println("=========FLIGHT=========");
            ticket.getFlight().print();
            ticket.print();
            System.out.println("NOTE: YOU MUST HAVE YOUR PARENTS AND/OR GUARDIAN TO BOARD INTO THE AIRCRAFT");
            System.out.println("NOTE: YOU HAVE TO BE AT THE AIRPORT 1 HOUR BEFORE DEPARTED");
        }


    }
}
class Flight
{
    private String flightID;
    private String aircraft;
    Flight(){}
    Flight(String fID,String aC)
    {
        flightID=fID;
        aircraft=aC;
    }
    public String getFlightID() {
        return flightID;
    }
    public String getAircraft() {
        return aircraft;
    }
    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }
    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }
    public void print()
    {
        System.out.println("The FlightID: " + flightID);
        System.out.println("Aircraft: " + aircraft);
    }
}
public class CamarAirFlightReservation
{
    public static void main(String args[])
    {
        Flight flight = new Flight();
        Customer customer = new Customer();
        Ticket ticketEconomy = new Economy();
        Ticket ticketBusiness = new Business();

        Scanner input = new Scanner(System.in);
        int malaysia=0;
        int state=0;
        int flightClass=0;
        String name="";
        int age;
        String address;
        boolean done = false;
        int eastM=0;
        String east="";

        //BOOKING FROM WHERE TO WHERE?
        book:
        while(malaysia != 3)
        {
            System.out.println("=======================CAMAR AIR BOOKING FLIGHT=======================");
            System.out.println("1. WEST MALAYSIA  ");
            System.out.println("2. EAST MALAYSIA  ");
            System.out.println("3. EXIT  ");
            System.out.print("WHERE ARE YOU NOW?(CHOOSE BY NUMBER) =>  ");
            malaysia = input.nextInt();

            if(malaysia == 1)
            {
                //AVAILABLE TICKET FOR WEST MALAYSIA
                System.out.println("***************AVAILABLE FLIGHT DURING MCO(FOR ONE WAY TRIP)***************");
                System.out.println("1.TERENGGANU - KUALA LUMPUR");
                System.out.println("2.JOHOR - KUALA LUMPUR");
                System.out.println("3.KEDAH - KUALA LUMPUR");
                System.out.println("4.KELANTAN - KUALA LUMPUR");
                System.out.println("5.NEGERI SEMBILAN - KUALA LUMPUR");
                System.out.println("6.PAHANG - KUALA LUMPUR");
                System.out.println("7.PULAU PINANG - KUALA LUMPUR");
                System.out.println("8.PERAK - KUALA LUMPUR");
                System.out.println("9.PERLIS - KUALA LUMPUR");
                System.out.println("10.KUALA LUMPUR - ALL STATES IN WEST MALAYSIA");
                System.out.println("11.KUALA LUMPUR - ALL STATES IN EAST MALAYSIA");

                System.out.println("0. BACK/CANCEL ");
                //CHOOSE FROM THE MENU
                System.out.print("WHERE ARE YOU NOW?(CHOOSE BY NUMBER) =>  ");
                state = input.nextInt();

                if(state == 0)
                {
                    malaysia = 0;
                    state = 0;
                    continue book;
                }else{
                    break;
                }
            }
            if(malaysia == 2)
            {
                System.out.println("***************AVAILABLE FLIGHT DURING MCO(FOR ONE WAY TRIP)***************");
                //AVAILABLE TICKET FOR EAST MALAYSIA
                System.out.println("12.SARAWAK - KUALA LUMPUR");
                System.out.println("13.LABUAN - KUALA LUMPUR");
                System.out.println("14.SABAH - KUALA LUMPUR");
                System.out.println("15.LABUAN - ALL EAST MALAYSIA");
                System.out.println("16.SABAH - ALL EAST MALAYSIA");
                System.out.println("17.SARAWAK - ALL EAST MALAYSIA");

                System.out.println("0. BACK/CANCEL ");
                //CHOOSE FROM THE MENU
                System.out.print("WHERE ARE YOU NOW?(CHOOSE BY NUMBER) =>  ");
                state = input.nextInt();
                if(state == 0)
                {
                    malaysia = 0;
                    state = 0;
                    continue book;
                }else{
                    break;
                }
            }
        }
        if(malaysia==3)
        {
            System.out.println("Goodbye, Thank you for using our application");
            System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
        }

        switch(state)
        {
            case 1:
            while(!done)
           {
                System.out.println("1.TERENGGANU - KUALA LUMPUR");
                flight = new Flight("MAS0001","MH2601");
                System.out.print("\n************ENTER THE DETAILS BELOW*************\n");
                try{
                    System.out.print("Name: ");
                    name = input.nextLine();
                    System.out.print("Age: ");
                    age = input.nextInt();
                    if(age <= 0)
                    {
                        throw new InputMismatchException();
                    }
                    System.out.print("Address: ");
                    address = input.next();
                    customer = new Customer(name, age, address);
                    done = true;

                }
                catch(InputMismatchException e)
                {
                    System.out.println("Invalid Age. Please Re-Enter the Details of the Booking. Mr/Mrs " + name);
                    input.next();
                }
           }


            //Exception Handling
            while(done)
            {
                    System.out.print("\n************WHICH CLASS DO YOU WANT TO BOOK?*************\n");
                    System.out.println("1. BUSINESS CLASS ");
                    System.out.println("2. ECONOMY CLASS   ");
                    System.out.println("\n3. TO CANCEL   ");
                    try{
                        flightClass = input.nextInt();

                        if(flightClass == 1)
                        {
                            ticketBusiness = new Business("FROM TERENGGANU TO KUALA LUMPUR", 1, 500.00, flight, "Chicken Briyani/Fish Fillet");
                            customer.buy(ticketBusiness);
                            customer.print();

                            done = false;
                        }
                        if(flightClass == 2)
                        {
                            ticketEconomy = new Economy("FROM TERENGGANU TO KUALA LUMPUR", 1, 300.00, flight, "Apple Juice/Coffee/Tea/Orange Juice/A pack of peanuts for each passengers");
                            customer.buy(ticketEconomy);
                            customer.print();

                            done = false;
                        }
                        if(flightClass == 3)
                        {
                            System.out.println("Goodbye, Thank you for using our application");
                            System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                            break;
                        }
                        if(flightClass<=0 || flightClass > 3)
                        {
                            System.out.println("Invalid Class");
                            System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                            done = true;
                        }
                    }
                catch(InputMismatchException e)
                {
                    System.out.println("Invalid Class.Please Re-Enter the Correct Class Mr/Mrs " + name);
                    input.next();
                }
            }
            break;
            case 2:
            while(!done)
            {
                 System.out.println("2.JOHOR - KUALA LUMPUR");
                 flight = new Flight("MAS0002","MH2602");
                 System.out.print("\n************ENTER THE DETAILS BELOW*************\n");
                 try{
                     System.out.print("Name: ");
                     name = input.next();
                     System.out.print("Age: ");
                     age = input.nextInt();
                     if(age <= 0)
                     {
                         throw new InputMismatchException();
                     }
                     System.out.print("Address: ");
                     address = input.next();
                     customer = new Customer(name, age, address);
                     done = true;
                 }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Age. Please Re-Enter the Details of the Booking. Mr/Mrs " + name);
                     input.next();
                 }
            }


             //Exception Handling
             while(done)
             {
                     System.out.print("\n************WHICH CLASS DO YOU WANT TO BOOK?*************\n");
                     System.out.println("1. BUSINESS CLASS ");
                     System.out.println("2. ECONOMY CLASS   ");
                     System.out.println("\n3. TO CANCEL   ");
                     try{
                         flightClass = input.nextInt();

                         if(flightClass == 1)
                         {
                             ticketBusiness = new Business("FROM JOHOR TO KUALA LUMPUR", 1, 800.00, flight, "Chicken Briyani/Fish Fillet");
                             customer.buy(ticketBusiness);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 2)
                         {
                             ticketEconomy = new Economy("FROM JOHOR TO KUALA LUMPUR", 1, 400.00, flight, "Apple Juice/Coffee/Tea/Orange Juice/A pack of peanuts for each passengers");
                             customer.buy(ticketEconomy);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 3)
                         {
                             System.out.println("Goodbye, Thank you for using our application");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             break;
                         }
                         if(flightClass<=0 || flightClass > 3)
                         {
                             System.out.println("Invalid Class");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             done = true;
                         }
                     }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Class.Please Re-Enter the Correct Class Mr/Mrs " + name);
                     input.next();
                 }
             }
             break;
            case 3:
            while(!done)
            {
                System.out.println("3.KEDAH - KUALA LUMPUR");
                flight = new Flight("MAS0003","MH2603");
                 System.out.print("\n************ENTER THE DETAILS BELOW*************\n");
                 try{
                     System.out.print("Name: ");
                     name = input.next();
                     System.out.print("Age: ");
                     age = input.nextInt();
                     if(age <= 0)
                     {
                         throw new InputMismatchException();
                     }
                     System.out.print("Address: ");
                     address = input.next();
                     customer = new Customer(name, age, address);
                     done = true;
                 }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Age. Please Re-Enter the Details of the Booking. Mr/Mrs " + name);
                     input.next();
                 }
            }


             //Exception Handling
             while(done)
             {
                     System.out.print("\n************WHICH CLASS DO YOU WANT TO BOOK?*************\n");
                     System.out.println("1. BUSINESS CLASS ");
                     System.out.println("2. ECONOMY CLASS   ");
                     System.out.println("\n3. TO CANCEL   ");
                     try{
                         flightClass = input.nextInt();

                         if(flightClass == 1)
                         {
                             ticketBusiness = new Business("FROM KEDAH TO KUALA LUMPUR", 1, 800.00, flight, "Chicken Briyani/Fish Fillet");
                             customer.buy(ticketBusiness);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 2)
                         {
                             ticketEconomy = new Economy("FROM KEDAH TO KUALA LUMPUR", 1, 400.00, flight, "Apple Juice/Coffee/Tea/Orange Juice/A pack of peanuts for each passengers");
                             customer.buy(ticketEconomy);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 3)
                         {
                             System.out.println("Goodbye, Thank you for using our application");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             break;
                         }
                         if(flightClass<=0 || flightClass > 3)
                         {
                             System.out.println("Invalid Class");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             done = true;
                         }
                     }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Class.Please Re-Enter the Correct Class Mr/Mrs " + name);
                     input.next();
                 }
             }
             break;
            case 4:
            while(!done)
            {
                System.out.println("4.KELANTAN - KUALA LUMPUR");
                flight = new Flight("MAS0004","MH2604");
                 System.out.print("\n************ENTER THE DETAILS BELOW*************\n");
                 try{
                     System.out.print("Name: ");
                     name = input.next();
                     System.out.print("Age: ");
                     age = input.nextInt();
                     if(age <= 0)
                     {
                         throw new InputMismatchException();
                     }
                     System.out.print("Address: ");
                     address = input.next();
                     customer = new Customer(name, age, address);
                     done = true;
                 }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Age. Please Re-Enter the Details of the Booking. Mr/Mrs " + name);
                     input.next();
                 }
            }


             //Exception Handling
             while(done)
             {
                     System.out.print("\n************WHICH CLASS DO YOU WANT TO BOOK?*************\n");
                     System.out.println("1. BUSINESS CLASS ");
                     System.out.println("2. ECONOMY CLASS   ");
                     System.out.println("\n3. TO CANCEL   ");
                     try{
                         flightClass = input.nextInt();

                         if(flightClass == 1)
                         {
                             ticketBusiness = new Business("FROM KELANTAN TO KUALA LUMPUR", 1, 800.00, flight, "Chicken Briyani/Fish Fillet");
                             customer.buy(ticketBusiness);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 2)
                         {
                             ticketEconomy = new Economy("FROM KELANTAN TO KUALA LUMPUR", 1, 400.00, flight, "Apple Juice/Coffee/Tea/Orange Juice/A pack of peanuts for each passengers");
                             customer.buy(ticketEconomy);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 3)
                         {
                             System.out.println("Goodbye, Thank you for using our application");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             break;
                         }
                         if(flightClass<=0 || flightClass > 3)
                         {
                             System.out.println("Invalid Class");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             done = true;
                         }
                     }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Class.Please Re-Enter the Correct Class Mr/Mrs " + name);
                     input.next();
                 }
             }
             break;
            case 5:
            while(!done)
            {
                System.out.println("5.NEGERI SEMBILAN - KUALA LUMPUR");
                flight = new Flight("MAS0005","MH2605");
                 System.out.print("\n************ENTER THE DETAILS BELOW*************\n");
                 try{
                     System.out.print("Name: ");
                     name = input.next();
                     System.out.print("Age: ");
                     age = input.nextInt();
                     if(age <= 0)
                     {
                         throw new InputMismatchException();
                     }
                     System.out.print("Address: ");
                     address = input.next();
                     customer = new Customer(name, age, address);
                     done = true;
                 }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Age. Please Re-Enter the Details of the Booking. Mr/Mrs " + name);
                     input.next();
                 }
            }


             //Exception Handling
             while(done)
             {
                     System.out.print("\n************WHICH CLASS DO YOU WANT TO BOOK?*************\n");
                     System.out.println("1. BUSINESS CLASS ");
                     System.out.println("2. ECONOMY CLASS   ");
                     System.out.println("\n3. TO CANCEL   ");
                     try{
                         flightClass = input.nextInt();

                         if(flightClass == 1)
                         {
                             ticketBusiness = new Business("FROM NEGERI SEMBILAN TO KUALA LUMPUR", 1, 800.00, flight, "Chicken Briyani/Fish Fillet");
                             customer.buy(ticketBusiness);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 2)
                         {
                             ticketEconomy = new Economy("FROM NEGERI SEMBILAN TO KUALA LUMPUR", 1, 400.00, flight, "Apple Juice/Coffee/Tea/Orange Juice/A pack of peanuts for each passengers");
                             customer.buy(ticketEconomy);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 3)
                         {
                             System.out.println("Goodbye, Thank you for using our application");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             break;
                         }
                         if(flightClass<=0 || flightClass > 3)
                         {
                             System.out.println("Invalid Class");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             done = true;
                         }
                     }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Class.Please Re-Enter the Correct Class Mr/Mrs " + name);
                     input.next();
                 }
             }
            break;
            case 6:
            while(!done)
            {
                System.out.println("6.PAHANG - KUALA LUMPUR");
                flight = new Flight("MAS0006","MH2606");
                 System.out.print("\n************ENTER THE DETAILS BELOW*************\n");
                 try{
                     System.out.print("Name: ");
                     name = input.next();
                     System.out.print("Age: ");
                     age = input.nextInt();
                     if(age <= 0)
                     {
                         throw new InputMismatchException();
                     }
                     System.out.print("Address: ");
                     address = input.next();
                     customer = new Customer(name, age, address);
                     done = true;
                 }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Age. Please Re-Enter the Details of the Booking. Mr/Mrs " + name);
                     input.next();
                 }
            }


             //Exception Handling
             while(done)
             {
                     System.out.print("\n************WHICH CLASS DO YOU WANT TO BOOK?*************\n");
                     System.out.println("1. BUSINESS CLASS ");
                     System.out.println("2. ECONOMY CLASS   ");
                     System.out.println("\n3. TO CANCEL   ");
                     try{
                         flightClass = input.nextInt();

                         if(flightClass == 1)
                         {
                             ticketBusiness = new Business("FROM PAHANG TO KUALA LUMPUR", 1, 800.00, flight, "Chicken Briyani/Fish Fillet");
                             customer.buy(ticketBusiness);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 2)
                         {
                             ticketEconomy = new Economy("FROM PAHANG TO KUALA LUMPUR", 1, 400.00, flight, "Apple Juice/Coffee/Tea/Orange Juice/A pack of peanuts for each passengers");
                             customer.buy(ticketEconomy);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 3)
                         {
                             System.out.println("Goodbye, Thank you for using our application");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             break;
                         }
                         if(flightClass<=0 || flightClass > 3)
                         {
                             System.out.println("Invalid Class");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             done = true;
                         }
                     }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Class.Please Re-Enter the Correct Class Mr/Mrs " + name);
                     input.next();
                 }
             }
            break;
            case 7:
            while(!done)
            {
                System.out.println("7.PULAU PINANG - KUALA LUMPUR");
                flight = new Flight("MAS0007","MH2607");
                 System.out.print("\n************ENTER THE DETAILS BELOW*************\n");
                 try{
                     System.out.print("Name: ");
                     name = input.next();
                     System.out.print("Age: ");
                     age = input.nextInt();
                     if(age <= 0)
                     {
                         throw new InputMismatchException();
                     }
                     System.out.print("Address: ");
                     address = input.next();
                     customer = new Customer(name, age, address);
                     done = true;
                 }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Age. Please Re-Enter the Details of the Booking. Mr/Mrs " + name);
                     input.next();
                 }
            }


             //Exception Handling
             while(done)
             {
                     System.out.print("\n************WHICH CLASS DO YOU WANT TO BOOK?*************\n");
                     System.out.println("1. BUSINESS CLASS ");
                     System.out.println("2. ECONOMY CLASS   ");
                     System.out.println("\n3. TO CANCEL   ");
                     try{
                         flightClass = input.nextInt();

                         if(flightClass == 1)
                         {
                             ticketBusiness = new Business("FROM PULAU PINANG TO KUALA LUMPUR", 1, 800.00, flight, "Chicken Briyani/Fish Fillet");
                             customer.buy(ticketBusiness);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 2)
                         {
                             ticketEconomy = new Economy("FROM PULAU PINANG TO KUALA LUMPUR", 1, 400.00, flight, "Apple Juice/Coffee/Tea/Orange Juice/A pack of peanuts for each passengers");
                             customer.buy(ticketEconomy);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 3)
                         {
                             System.out.println("Goodbye, Thank you for using our application");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             break;
                         }
                         if(flightClass<=0 || flightClass > 3)
                         {
                             System.out.println("Invalid Class");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             done = true;
                         }
                     }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Class.Please Re-Enter the Correct Class Mr/Mrs " + name);
                     input.next();
                 }
             }
            break;
            case 8:
            while(!done)
            {
                System.out.println("8.PERAK - KUALA LUMPUR");
                flight = new Flight("MAS0008","MH2608");
                 System.out.print("\n************ENTER THE DETAILS BELOW*************\n");
                 try{
                     System.out.print("Name: ");
                     name = input.next();
                     System.out.print("Age: ");
                     age = input.nextInt();
                     if(age <= 0)
                     {
                         throw new InputMismatchException();
                     }
                     System.out.print("Address: ");
                     address = input.next();
                     customer = new Customer(name, age, address);
                     done = true;
                 }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Age. Please Re-Enter the Details of the Booking. Mr/Mrs " + name);
                     input.next();
                 }
            }


             //Exception Handling
             while(done)
             {
                     System.out.print("\n************WHICH CLASS DO YOU WANT TO BOOK?*************\n");
                     System.out.println("1. BUSINESS CLASS ");
                     System.out.println("2. ECONOMY CLASS   ");
                     System.out.println("\n3. TO CANCEL   ");
                     try{
                         flightClass = input.nextInt();

                         if(flightClass == 1)
                         {
                             ticketBusiness = new Business("FROM PERAK TO KUALA LUMPUR", 1, 800.00, flight, "Chicken Briyani/Fish Fillet");
                             customer.buy(ticketBusiness);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 2)
                         {
                             ticketEconomy = new Economy("FROM PERAK TO KUALA LUMPUR", 1, 400.00, flight, "Apple Juice/Coffee/Tea/Orange Juice/A pack of peanuts for each passengers");
                             customer.buy(ticketEconomy);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 3)
                         {
                             System.out.println("Goodbye, Thank you for using our application");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             break;
                         }
                         if(flightClass<=0 || flightClass > 3)
                         {
                             System.out.println("Invalid Class");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             done = true;
                         }
                     }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Class.Please Re-Enter the Correct Class Mr/Mrs " + name);
                     input.next();
                 }
             }
            break;
            case 9:
            while(!done)
            {
                System.out.println("9.PERLIS - KUALA LUMPUR");
                flight = new Flight("MAS0009","MH2609");
                 System.out.print("\n************ENTER THE DETAILS BELOW*************\n");
                 try{
                     System.out.print("Name: ");
                     name = input.next();
                     System.out.print("Age: ");
                     age = input.nextInt();
                     if(age <= 0)
                     {
                         throw new InputMismatchException();
                     }
                     System.out.print("Address: ");
                     address = input.next();
                     customer = new Customer(name, age, address);
                     done = true;
                 }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Age. Please Re-Enter the Details of the Booking. Mr/Mrs " + name);
                     input.next();
                 }
            }


             //Exception Handling
             while(done)
             {
                     System.out.print("\n************WHICH CLASS DO YOU WANT TO BOOK?*************\n");
                     System.out.println("1. BUSINESS CLASS ");
                     System.out.println("2. ECONOMY CLASS   ");
                     System.out.println("\n3. TO CANCEL   ");
                     try{
                         flightClass = input.nextInt();

                         if(flightClass == 1)
                         {
                             ticketBusiness = new Business("FROM PERLIS TO KUALA LUMPUR", 1, 800.00, flight, "Chicken Briyani/Fish Fillet");
                             customer.buy(ticketBusiness);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 2)
                         {
                             ticketEconomy = new Economy("FROM PERLIS TO KUALA LUMPUR", 1, 400.00, flight, "Apple Juice/Coffee/Tea/Orange Juice/A pack of peanuts for each passengers");
                             customer.buy(ticketEconomy);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 3)
                         {
                             System.out.println("Goodbye, Thank you for using our application");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             break;
                         }
                         if(flightClass<=0 || flightClass > 3)
                         {
                             System.out.println("Invalid Class");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             done = true;
                         }
                     }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Class.Please Re-Enter the Correct Class Mr/Mrs " + name);
                     input.next();
                 }
             }
            break;
            case 10:
            while(!done)
            {
                System.out.println("10.KUALA LUMPUR - ALL STATES IN WEST MALAYSIA");
                 System.out.print("\n************ENTER THE DETAILS BELOW*************\n");
                 try{
                     System.out.print("Name: ");
                     name = input.next();
                     System.out.print("Age: ");
                     age = input.nextInt();
                     if(age <= 0)
                     {
                         throw new InputMismatchException();
                     }
                     System.out.print("Address: ");
                     address = input.next();
                     customer = new Customer(name, age, address);
                     done = true;
                 }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Age. Please Re-Enter the Details of the Booking. Mr/Mrs " + name);
                     input.next();
                 }
            }
            boolean isState = false;
            while(!isState)
            {
                System.out.print("\n************WHICH STATE DO YOU WANT TO BOOK FROM KUALA LUMPUR?*************\n");
                System.out.print("\n************AVAILABLE DURING MCO*************\n");
                System.out.println("1.TERENGGANU");
                System.out.println("2.JOHOR");
                System.out.println("3.KEDAH");
                System.out.println("4.KELANTAN");
                System.out.println("5.NEGERI SEMBILAN");
                System.out.println("6.PAHANG");
                System.out.println("7.PULAU PINANG");
                System.out.println("8.PERAK");
                System.out.println("9.PERLIS");
                System.out.println("10.TO CANCEL");

                try{
                System.out.print("\nCHOOSE THE STATE=> ");
                    eastM = input.nextInt();
                    if(eastM == 1)
                    {
                        east = "KUALA LUMPUR TO TERENGGANU";
                        flight = new Flight("MAS0010","MH2610");
                        System.out.println("YOU HAVE CHOOSE: " + east);
                        break;

                    }
                    if(eastM == 2)
                    {
                        east = "KUALA LUMPUR TO JOHOR";
                        flight = new Flight("MAS0011","MH2611");
                        System.out.println("YOU HAVE CHOOSE: " + east);
                        break;
                    }
                    if(eastM == 3)
                    {
                        east = "KUALA LUMPUR TO KEDAH";
                        flight = new Flight("MAS0012","MH2612");
                        System.out.println("YOU HAVE CHOOSE: " + east);
                        break;
                    }
                    if(eastM == 4)
                    {
                        east = "KUALA LUMPUR TO KELANTAN";
                        flight = new Flight("MAS0013","MH2613");
                        System.out.println("YOU HAVE CHOOSE: " + east);
                        break;
                    }
                    if(eastM == 5)
                    {
                        east = "KUALA LUMPUR TO NEGERI SEMBILAN";
                        flight = new Flight("MAS0014","MH2614");
                        System.out.println("YOU HAVE CHOOSE: " + east);
                        break;
                    }
                    if(eastM == 6)
                    {
                        east = "KUALA LUMPUR TO PULAU PINANG";
                        flight = new Flight("MAS0015","MH2615");
                        System.out.println("YOU HAVE CHOOSE: " + east);
                        break;
                    }
                    if(eastM == 7)
                    {
                        east = "KUALA LUMPUR TO PERAK";
                        flight = new Flight("MAS0016","MH2616");
                        System.out.println("YOU HAVE CHOOSE: " + east);
                        break;
                    }
                    if(eastM == 8)
                    {
                        east = "KUALA LUMPUR TO PERLIS";
                        flight = new Flight("MAS0017","MH2617");
                        System.out.println("YOU HAVE CHOOSE: " + east);
                        break;
                    }
                    if(eastM == 9)
                    {
                        east = "KUALA LUMPUR TO TERENGGANU";
                        flight = new Flight("MAS0018","MH2618");
                        System.out.println("YOU HAVE CHOOSE: " + east);
                        break;
                    }
                    if(eastM == 10)
                    {
                        System.out.println("Thank you for using our application");
                        System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                        return;
                    }
                }catch(InputMismatchException e)
                {
                    System.out.println("Invalid State.Please Re-Enter the Correct Class Mr/Mrs " + name);
                    input.next();
                }

            }


             //Exception Handling
             while(done)
             {
                     System.out.print("\n************WHICH CLASS DO YOU WANT TO BOOK?*************\n");
                     System.out.println("1. BUSINESS CLASS ");
                     System.out.println("2. ECONOMY CLASS   ");
                     System.out.println("\n3. TO CANCEL   ");
                     try{
                         flightClass = input.nextInt();

                         if(flightClass == 1)
                         {
                             ticketBusiness = new Business(east, 1, 800.00, flight, "Chicken Briyani/Fish Fillet");
                             customer.buy(ticketBusiness);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 2)
                         {
                             ticketEconomy = new Economy(east, 1, 400.00, flight, "Apple Juice/Coffee/Tea/Orange Juice/A pack of peanuts for each passengers");
                             customer.buy(ticketEconomy);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 3)
                         {
                             System.out.println("Goodbye, Thank you for using our application");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             break;
                         }
                         if(flightClass<=0 || flightClass > 3)
                         {
                             System.out.println("Invalid Class");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             done = true;
                         }
                     }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Class.Please Re-Enter the Correct Class Mr/Mrs " + name);
                     input.next();
                 }
             }
            break;
            case 11:
            while(!done)
            {
                System.out.println("11.KUALA LUMPUR - ALL STATES IN EAST MALAYSIA");
                flight = new Flight("MAS0011","MH2611");
                 System.out.print("\n************ENTER THE DETAILS BELOW*************\n");
                 try{
                     System.out.print("Name: ");
                     name = input.next();
                     System.out.print("Age: ");
                     age = input.nextInt();
                     if(age <= 0)
                     {
                         throw new InputMismatchException();
                     }
                     System.out.print("Address: ");
                     address = input.next();
                     customer = new Customer(name, age, address);
                     done = true;
                 }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Age. Please Re-Enter the Details of the Booking. Mr/Mrs " + name);
                     input.next();
                 }
            }
            boolean isStateW = false;
            while(!isStateW)
            {
                System.out.print("\n************WHICH STATE DO YOU WANT TO BOOK FROM KUALA LUMPUR?*************\n");
                System.out.print("\n************AVAILABLE DURING MCO*************\n");
                System.out.println("1.SARAWAK");
                System.out.println("2.SABAH");
                System.out.println("3.LABUAN");
                System.out.println("4.TO CANCEL");
                int westM = 0;
                try{
                System.out.print("\nCHOOSE THE STATE=> ");
                    westM = input.nextInt();
                    if(westM == 1)
                    {
                        east = "KUALA LUMPUR TO SARAWAK";
                        System.out.println("YOU HAVE CHOOSE: " + east);
                        break;

                    }
                    if(westM == 2)
                    {
                        east = "KUALA LUMPUR TO SABAH";
                        flight = new Flight("MAS0019","MH2619");
                        System.out.println("YOU HAVE CHOOSE: " + east);
                        break;
                    }
                    if(westM == 3)
                    {
                        east = "KUALA LUMPUR TO LABUAN";
                        flight = new Flight("MAS0020","MH2620");
                        System.out.println("YOU HAVE CHOOSE: " + east);
                        break;
                    }
                    if(westM == 4)
                    {
                        System.out.println("Thank you for using our application");
                        System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                        return;
                    }
                }catch(InputMismatchException e)
                {
                    System.out.println("Invalid State.Please Re-Enter the Correct Class Mr/Mrs " + name);
                    input.next();
                }

            }


             //Exception Handling
             while(done)
             {
                     System.out.print("\n************WHICH CLASS DO YOU WANT TO BOOK?*************\n");
                     System.out.println("1. BUSINESS CLASS ");
                     System.out.println("2. ECONOMY CLASS   ");
                     System.out.println("\n3. TO CANCEL   ");
                     try{
                         flightClass = input.nextInt();

                         if(flightClass == 1)
                         {
                             ticketBusiness = new Business(east, 1, 800.00, flight, "Chicken Briyani/Fish Fillet");
                             customer.buy(ticketBusiness);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 2)
                         {
                             ticketEconomy = new Economy(east, 1, 400.00, flight, "Apple Juice/Coffee/Tea/Orange Juice/A pack of peanuts for each passengers");
                             customer.buy(ticketEconomy);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 3)
                         {
                             System.out.println("Goodbye, Thank you for using our application");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             break;
                         }
                         if(flightClass<=0 || flightClass > 3)
                         {
                             System.out.println("Invalid Class");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             done = true;
                         }
                     }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Class.Please Re-Enter the Correct Class Mr/Mrs " + name);
                     input.next();
                 }
             }
            break;

            case 12:
            while(!done)
            {
                System.out.println("12.SARAWAK - KUALA LUMPUR");
                flight = new Flight("MAS0021","MH2621");
                 System.out.print("\n************ENTER THE DETAILS BELOW*************\n");
                 try{
                     System.out.print("Name: ");
                     name = input.next();
                     System.out.print("Age: ");
                     age = input.nextInt();
                     if(age <= 0)
                     {
                         throw new InputMismatchException();
                     }
                     System.out.print("Address: ");
                     address = input.next();
                     customer = new Customer(name, age, address);
                     done = true;
                 }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Age. Please Re-Enter the Details of the Booking. Mr/Mrs " + name);
                     input.next();
                 }
            }


             //Exception Handling
             while(done)
             {
                     System.out.print("\n************WHICH CLASS DO YOU WANT TO BOOK?*************\n");
                     System.out.println("1. BUSINESS CLASS ");
                     System.out.println("2. ECONOMY CLASS   ");
                     System.out.println("\n3. TO CANCEL   ");
                     try{
                         flightClass = input.nextInt();

                         if(flightClass == 1)
                         {
                             ticketBusiness = new Business("FROM SARAWAK TO KUALA LUMPUR", 1, 800.00, flight, "Chicken Briyani/Fish Fillet");
                             customer.buy(ticketBusiness);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 2)
                         {
                             ticketEconomy = new Economy("FROM SARAWAK TO KUALA LUMPUR", 1, 400.00, flight, "Apple Juice/Coffee/Tea/Orange Juice/A pack of peanuts for each passengers");
                             customer.buy(ticketEconomy);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 3)
                         {
                             System.out.println("Goodbye, Thank you for using our application");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             break;
                         }
                         if(flightClass<=0 || flightClass > 3)
                         {
                             System.out.println("Invalid Class");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             done = true;
                         }
                     }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Class.Please Re-Enter the Correct Class Mr/Mrs " + name);
                     input.next();
                 }
             }
            break;
            case 13:
            while(!done)
            {
                System.out.println("13.LABUAN - KUALA LUMPUR");
                flight = new Flight("MAS0022","MH2622");
                 System.out.print("\n************ENTER THE DETAILS BELOW*************\n");
                 try{
                     System.out.print("Name: ");
                     name = input.next();
                     System.out.print("Age: ");
                     age = input.nextInt();
                     if(age <= 0)
                     {
                         throw new InputMismatchException();
                     }
                     System.out.print("Address: ");
                     address = input.next();
                     customer = new Customer(name, age, address);
                     done = true;
                 }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Age. Please Re-Enter the Details of the Booking. Mr/Mrs " + name);
                     input.next();
                 }
            }


             //Exception Handling
             while(done)
             {
                     System.out.print("\n************WHICH CLASS DO YOU WANT TO BOOK?*************\n");
                     System.out.println("1. BUSINESS CLASS ");
                     System.out.println("2. ECONOMY CLASS   ");
                     System.out.println("\n3. TO CANCEL   ");
                     try{
                         flightClass = input.nextInt();

                         if(flightClass == 1)
                         {
                             ticketBusiness = new Business("FROM LABUAN TO KUALA LUMPUR", 1, 800.00, flight, "Chicken Briyani/Fish Fillet");
                             customer.buy(ticketBusiness);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 2)
                         {
                             ticketEconomy = new Economy("FROM LABUAN TO KUALA LUMPUR", 1, 400.00, flight, "Apple Juice/Coffee/Tea/Orange Juice/A pack of peanuts for each passengers");
                             customer.buy(ticketEconomy);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 3)
                         {
                             System.out.println("Goodbye, Thank you for using our application");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             break;
                         }
                         if(flightClass<=0 || flightClass > 3)
                         {
                             System.out.println("Invalid Class");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             done = true;
                         }
                     }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Class.Please Re-Enter the Correct Class Mr/Mrs " + name);
                     input.next();
                 }
             }
            break;
            case 14:
            while(!done)
            {
                System.out.println("14.SABAH - KUALA LUMPUR");
                flight = new Flight("MAS0023","MH2623");
                 System.out.print("\n************ENTER THE DETAILS BELOW*************\n");
                 try{
                     System.out.print("Name: ");
                     name = input.next();
                     System.out.print("Age: ");
                     age = input.nextInt();
                     if(age <= 0)
                     {
                         throw new InputMismatchException();
                     }
                     System.out.print("Address: ");
                     address = input.next();
                     customer = new Customer(name, age, address);
                     done = true;
                 }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Age. Please Re-Enter the Details of the Booking. Mr/Mrs " + name);
                     input.next();
                 }
            }


             //Exception Handling
             while(done)
             {
                     System.out.print("\n************WHICH CLASS DO YOU WANT TO BOOK?*************\n");
                     System.out.println("1. BUSINESS CLASS ");
                     System.out.println("2. ECONOMY CLASS   ");
                     System.out.println("\n3. TO CANCEL   ");
                     try{
                         flightClass = input.nextInt();

                         if(flightClass == 1)
                         {
                             ticketBusiness = new Business("FROM SABAH TO KUALA LUMPUR", 1, 800.00, flight, "Chicken Briyani/Fish Fillet");
                             customer.buy(ticketBusiness);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 2)
                         {
                             ticketEconomy = new Economy("FROM SABAH TO KUALA LUMPUR", 1, 400.00, flight, "Apple Juice/Coffee/Tea/Orange Juice/A pack of peanuts for each passengers");
                             customer.buy(ticketEconomy);
                             customer.print();

                             done = false;
                         }
                         if(flightClass == 3)
                         {
                             System.out.println("Goodbye, Thank you for using our application");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             break;
                         }
                         if(flightClass<=0 || flightClass > 3)
                         {
                             System.out.println("Invalid Class");
                             System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                             done = true;
                         }
                     }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Class.Please Re-Enter the Correct Class Mr/Mrs " + name);
                     input.next();
                 }
             }
            break;
            case 15:
            while(!done)
            {
                System.out.println("15.LABUAN - ALL EAST MALAYSIA");
                 System.out.print("\n************ENTER THE DETAILS BELOW*************\n");
                 try{
                     System.out.print("Name: ");
                     name = input.next();
                     System.out.print("Age: ");
                     age = input.nextInt();
                     if(age <= 0)
                     {
                         throw new InputMismatchException();
                     }
                     System.out.print("Address: ");
                     address = input.next();
                     customer = new Customer(name, age, address);
                     done = true;
                 }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Age. Please Re-Enter the Details of the Booking. Mr/Mrs " + name);
                     input.next();
                 }
            }
            boolean isStateL = false;
            while(!isStateL)
            {
                System.out.print("\n************WHICH STATE DO YOU WANT TO BOOK FROM LABUAN?*************\n");
                System.out.print("\n************AVAILABLE DURING MCO*************\n");
                System.out.println("1.SARAWAK");
                System.out.println("2.SABAH");
                System.out.println("3.TO CANCEL");
                int westM = 0;
                try{
                System.out.print("\nCHOOSE THE STATE=> ");
                    westM = input.nextInt();
                    if(westM == 1)
                    {
                        east = "LABUAN TO SARAWAK";
                        flight = new Flight("MAS0024","MH2624");
                        System.out.println("YOU HAVE CHOOSE: " + east);
                        break;

                    }
                    if(westM == 2)
                    {
                        east = "LABUAN TO SABAH";
                        flight = new Flight("MAS0025","MH2625");
                        System.out.println("YOU HAVE CHOOSE: " + east);
                        break;
                    }
                    if(westM == 3)
                    {
                        System.out.println("Thank you for using our application");
                        System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                        return;
                    }
                }catch(InputMismatchException e)
                {
                    System.out.println("Invalid State.Please Re-Enter the Correct Class Mr/Mrs " + name);
                    input.next();
                }

            }
           //Exception Handling
           while(done)
           {
                   System.out.print("\n************WHICH CLASS DO YOU WANT TO BOOK?*************\n");
                   System.out.println("1. BUSINESS CLASS ");
                   System.out.println("2. ECONOMY CLASS   ");
                   System.out.println("\n3. TO CANCEL   ");
                   try{
                       flightClass = input.nextInt();

                       if(flightClass == 1)
                       {
                           ticketBusiness = new Business(east, 1, 800.00, flight, "Chicken Briyani/Fish Fillet");
                           customer.buy(ticketBusiness);
                           customer.print();

                           done = false;
                       }
                       if(flightClass == 2)
                       {
                           ticketEconomy = new Economy(east, 1, 400.00, flight, "Apple Juice/Coffee/Tea/Orange Juice/A pack of peanuts for each passengers");
                           customer.buy(ticketEconomy);
                           customer.print();

                           done = false;
                       }
                       if(flightClass == 3)
                       {
                           System.out.println("Goodbye, Thank you for using our application");
                           System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                           break;
                       }
                       if(flightClass<=0 || flightClass > 3)
                       {
                           System.out.println("Invalid Class");
                           System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                           done = true;
                       }
                   }
               catch(InputMismatchException e)
               {
                   System.out.println("Invalid Class.Please Re-Enter the Correct Class Mr/Mrs " + name);
                   input.next();
               }
           }
          break;

            case 16:
            while(!done)
            {
                System.out.println("16.SABAH - ALL EAST MALAYSIA");
                 System.out.print("\n************ENTER THE DETAILS BELOW*************\n");
                 try{
                     System.out.print("Name: ");
                     name = input.next();
                     System.out.print("Age: ");
                     age = input.nextInt();
                     if(age <= 0)
                     {
                         throw new InputMismatchException();
                     }
                     System.out.print("Address: ");
                     address = input.next();
                     customer = new Customer(name, age, address);
                     done = true;
                 }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Age. Please Re-Enter the Details of the Booking. Mr/Mrs " + name);
                     input.next();
                 }
            }
            boolean isStateSb = false;
            while(!isStateSb)
            {
                System.out.print("\n************WHICH STATE DO YOU WANT TO BOOK FROM SABAH?*************\n");
                System.out.print("\n************AVAILABLE DURING MCO*************\n");
                System.out.println("1.SARAWAK");
                System.out.println("2.LABUAN");
                System.out.println("3.TO CANCEL");
                int westM = 0;
                try{
                System.out.print("\nCHOOSE THE STATE=> ");
                    westM = input.nextInt();
                    if(westM == 1)
                    {
                        east = "SABAH TO SARAWAK";
                        flight = new Flight("MAS0026","MH2626");
                        System.out.println("YOU HAVE CHOOSE: " + east);
                        break;

                    }
                    if(westM == 2)
                    {
                        east = "SABAH TO LABUAN";
                        flight = new Flight("MAS0027","MH2627");
                        System.out.println("YOU HAVE CHOOSE: " + east);
                        break;
                    }
                    if(westM == 3)
                    {
                        System.out.println("Thank you for using our application");
                        System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                        return;
                    }
                }catch(InputMismatchException e)
                {
                    System.out.println("Invalid State.Please Re-Enter the Correct Class Mr/Mrs " + name);
                    input.next();
                }

            }
           //Exception Handling
           while(done)
           {
                   System.out.print("\n************WHICH CLASS DO YOU WANT TO BOOK?*************\n");
                   System.out.println("1. BUSINESS CLASS ");
                   System.out.println("2. ECONOMY CLASS   ");
                   System.out.println("\n3. TO CANCEL   ");
                   try{
                       flightClass = input.nextInt();

                       if(flightClass == 1)
                       {
                           ticketBusiness = new Business(east, 1, 800.00, flight, "Chicken Briyani/Fish Fillet");
                           customer.buy(ticketBusiness);
                           customer.print();

                           done = false;
                       }
                       if(flightClass == 2)
                       {
                           ticketEconomy = new Economy(east, 1, 400.00, flight, "Apple Juice/Coffee/Tea/Orange Juice/A pack of peanuts for each passengers");
                           customer.buy(ticketEconomy);
                           customer.print();

                           done = false;
                       }
                       if(flightClass == 3)
                       {
                           System.out.println("Goodbye, Thank you for using our application");
                           System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                           break;
                       }
                       if(flightClass<=0 || flightClass > 3)
                       {
                           System.out.println("Invalid Class");
                           System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                           done = true;
                       }
                   }
               catch(InputMismatchException e)
               {
                   System.out.println("Invalid Class.Please Re-Enter the Correct Class Mr/Mrs " + name);
                   input.next();
               }
           }
          break;
            case 17:
            while(!done)
            {
                System.out.println("17.SARAWAK - ALL EAST MALAYSIA");
                 System.out.print("\n************ENTER THE DETAILS BELOW*************\n");
                 try{
                     System.out.print("Name: ");
                     name = input.next();
                     System.out.print("Age: ");
                     age = input.nextInt();
                     if(age <= 0)
                     {
                         throw new InputMismatchException();
                     }
                     System.out.print("Address: ");
                     address = input.next();
                     customer = new Customer(name, age, address);
                     done = true;
                 }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Age. Please Re-Enter the Details of the Booking. Mr/Mrs " + name);
                     input.next();
                 }
            }
            boolean isStateSw = false;
            while(!isStateSw)
            {
                System.out.print("\n************WHICH STATE DO YOU WANT TO BOOK FROM SARAWAK?*************\n");
                System.out.print("\n************AVAILABLE DURING MCO*************\n");
                System.out.println("1.SABAH");
                System.out.println("2.LABUAN");
                System.out.println("3.TO CANCEL");
                int westM = 0;
                try{
                System.out.print("\nCHOOSE THE STATE=> ");
                    westM = input.nextInt();
                    if(westM == 1)
                    {
                        east = "SARAWAK TO SABAH";
                        flight = new Flight("MAS0028","MH2628");
                        System.out.println("YOU HAVE CHOOSE: " + east);
                        break;

                    }
                    if(westM == 2)
                    {
                        east = "SARAWAK TO LABUAN";
                        flight = new Flight("MAS0029","MH2629");
                        System.out.println("YOU HAVE CHOOSE: " + east);
                        break;
                    }
                    if(westM == 3)
                    {
                        System.out.println("Thank you for using our application");
                        System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                        return;
                    }
                }catch(InputMismatchException e)
                {
                    System.out.println("Invalid State.Please Re-Enter the Correct Class Mr/Mrs " + name);
                    input.next();
                }

            }
           //Exception Handling
           while(done)
           {
                   System.out.print("\n************WHICH CLASS DO YOU WANT TO BOOK?*************\n");
                   System.out.println("1. BUSINESS CLASS ");
                   System.out.println("2. ECONOMY CLASS   ");
                   System.out.println("\n3. TO CANCEL   ");
                   try{
                       flightClass = input.nextInt();

                       if(flightClass == 1)
                       {
                           ticketBusiness = new Business(east, 1, 800.00, flight, "Chicken Briyani/Fish Fillet");
                           customer.buy(ticketBusiness);
                           customer.print();

                           done = false;
                       }
                       if(flightClass == 2)
                       {
                           ticketEconomy = new Economy(east, 1, 400.00, flight, "Apple Juice/Coffee/Tea/Orange Juice/A pack of peanuts for each passengers");
                           customer.buy(ticketEconomy);
                           customer.print();

                           done = false;
                       }
                       if(flightClass == 3)
                       {
                           System.out.println("Goodbye, Thank you for using our application");
                           System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                           break;
                       }
                       if(flightClass<=0 || flightClass > 3)
                       {
                           System.out.println("Invalid Class");
                           System.out.println("=========CAMAR AIR FLIGHT RESERVATION==========");
                           done = true;
                       }
                   }
               catch(InputMismatchException e)
               {
                   System.out.println("Invalid Class.Please Re-Enter the Correct Class Mr/Mrs " + name);
                   input.next();
               }
           }
          break;

        }



    }

}