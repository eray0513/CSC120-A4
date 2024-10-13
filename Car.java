import java.util.ArrayList; // Import the arraylist class

public class Car {

    // Attributes
    private ArrayList<Passenger> onboard;
    private int maxCapacity;

    /**
     * Constructors a car object
     * @param maxCap
     */
    public Car(int maxCap){
        this.maxCapacity = maxCap;
        this.onboard = new ArrayList<Passenger>(maxCap);
    }

    /**
     * Allows the max capacity to be accessed outside the class
     * @return maxCapacity
     */
    public int getCapacity(){
        return this.maxCapacity;
    }

    /**
     * Allows the seats remaining to be accessed outside the class
     * @return
     */
    public int seatsRemaining(){
        int seatsRemaining = 0; // Keeps track of seats that aren't null
        for(int i = 0; i< this.onboard.size(); i++){ // for every space in the array list
            if(onboard.get(i) != null){ // if the seat is taken
                seatsRemaining ++;
            }else{
                break;
            }
        }
        return this.maxCapacity - seatsRemaining;
    }

    /**
     * Adds a passenger if there is available space in the car
     * @param adding
     * @return if it was sucessful
     */
    public boolean addPassenger(Passenger adding){
        boolean sucess = false;
        boolean alreadyOnboard = false;
        for(int i = 0; i<this.onboard.size(); i++){
            if(this.onboard.get(i)==adding){
                alreadyOnboard = true;
                break;
            }
        }
        if(!alreadyOnboard){
            if(this.seatsRemaining() > 0){
            int nextAvailable = maxCapacity-this.seatsRemaining();
            this.onboard.add(nextAvailable, adding);
            sucess = true;
            return sucess;
            }else{
            return sucess;
            }
        }else{
            return false;
        }
    }


    /**
     * Allows the car to remove a passenger if that passenger exists within the car
     * @param removing
     * @return whether the action was completed
     */
    public boolean removePassenger(Passenger removing){
        boolean sucessful = false;
        for(int s = 0; s<this.onboard.size(); s++){
            if(this.onboard.get(s)==removing){
                sucessful = true;
                this.onboard.remove(s);
                return sucessful;
            }
        }
        return sucessful;
    }

    /**
     * Prints out a list of the passenger names in the car
     */
    public void printManifest(){
        boolean empty = true;
        for(int j = 0; j<onboard.size(); j++){
            if(onboard.get(j)!= null){
                empty = false;
                break;
            }
        }
        if(!empty){
            for(int j = 0; j < this.onboard.size(); j++){
                String current = this.onboard.get(j).getName();
                System.out.println(current);
            }
        }
        else{
            System.out.println("This car is empty.");
        }
    }
}