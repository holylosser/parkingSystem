import java.util.*;
public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your session ID :");String sessionID = sc.next();

        System.out.println("Press 1 for Motorcycle\nPress 2 for Car\nPress 3 for SUV");int category = sc.nextInt();
        while(category < 1 || category > 3){
            System.out.println("Invalid vehicle category. Try again :");category = sc.nextInt();
        }

        Parking pk = new Parking(sessionID, category);
        pk.displaySession();

        int choice = 0;
        while(choice != 6){
            System.out.println("\nPress 1 to Update Duration\nPress 2 to Update Vehicle\nPress 3 to Calculate Charges\nPress 4 to Pay\nPress 5 to Display\nPress 6 to Exit");
            choice = sc.nextInt();

            if(choice == 1){
                System.out.println("Enter hours :");
                int hours = sc.nextInt();
                pk.updateHours(hours);
            }
            else if(choice == 2){
                System.out.println("Press 1 for Motorcycle\nPress 2 for Car\nPress 3 for SUV");
                int newCategory = sc.nextInt();
                pk.updateVehicle(newCategory);
            }
            else if(choice == 3){pk.calculateCharges();}
            else if(choice == 4){pk.markPaid();}
            else if(choice == 5){pk.displaySession();}
            else if(choice != 6){System.out.println("Invalid choice.");}
        }

        System.out.println("Final: Session "+pk.getSessionID()+" \n "+pk.getVehicle()+" \n "+pk.getHours()+" hours \n PKR "+pk.getCharges()+" \n "+pk.statusText());
    }
}