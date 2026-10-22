public class Parking {

    private String sessionID, vehicle;
    private int hours, rate;
    private boolean status;


    Parking(String sessionID, int category){
        this.sessionID = sessionID;
        hours = 0;
        status = false;
        setVehicle(category);
    }


    private boolean setVehicle(int category){
        if(category == 1){
            vehicle = "Motorcycle";
            rate = 30;
            return true;
        }
        else if(category == 2){
            vehicle = "Car";
            rate = 60;
            return true;
        }
        else if(category == 3){
            vehicle = "SUV";
            rate = 100;
            return true;
        }
        return false;
    }

    String getSessionID(){return sessionID;}
    String getVehicle(){return vehicle;}
    int getHours(){return hours;}
    int getRate(){return rate;}
    boolean getStatus(){return status;}

    String statusText(){return status ? "Paid" : "Unpaid";}

    boolean updateHours(int h){
        if(status){
            System.out.println("Cannot update duration: parking session is already Paid.");
            return false;
        }
        if(h < 0){
            System.out.println("Invalid duration: hours cannot be negative.");
            return false;
        }
        hours = h;
        System.out.println("Parking duration updated to "+hours+" hours.");
        return true;
    }

    boolean updateVehicle(int category){
        if(status){
            System.out.println("Cannot update vehicle category: parking session is already Paid.");
            return false;
        }
        if(!setVehicle(category)){
            System.out.println("Invalid vehicle category.");
            return false;
        }
        System.out.println("Vehicle category updated to "+vehicle+" (PKR "+rate+" per hour).");
        return true;
    }


    int getCharges(){
        int total = hours * rate;
        if(hours > 5){total = total + 200;}
        return total;
    }


    int calculateCharges(){
        int total = getCharges();
        if(hours > 5){
            System.out.println("Parking charge: ("+hours+" x "+rate+") + 200 = PKR "+total);
        }
        else{
            System.out.println("Parking charge: ("+hours+" x "+rate+") = PKR "+total);
        }
        return total;
    }

    boolean markPaid(){
        if(status){
            System.out.println("Cannot record payment: parking session is already Paid.");
            return false;
        }
        status = true;
        System.out.println("Payment recorded successfully. Status: "+statusText());
        return true;
    }

    void displaySession(){
        System.out.println("Session ID: "+sessionID+" \n Vehicle: "+vehicle+" \n Hours: "+hours+" \n Status: "+statusText());
    }
}