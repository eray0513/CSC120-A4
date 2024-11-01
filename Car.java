import java.util.ArrayList; // Import the arraylist class

public class Car {

    // Attributes
    private ArrayList<Passenger> onboard;
    private int maxCapacity;

    /**
     * Constructors a car object
     * @param maxCap max amt of passengers
     */
    public Car(int maxCap){
        this.maxCapacity = maxCap;
        this.onboard = new ArrayList<Passenger>(maxCap);
    }

    /**
     * Allows the max capacity to be accessed outside the class
     * @return int for maxCapacity
     */
    public int getCapacity(){
        return this.maxCapacity;
    }

    /**
     * Allows the seats remaining to be accessed outside the class
     * @return int for number of seats remaining open
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
     * @param adding passenger being added
     * @return t/f if it was sucessful
     */
    public boolean addPassenger(Passenger adding){
        boolean sucess = false;
        boolean alreadyOnboard = this.onboard.contains(adding);
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
     * @param removing passenger being removed
     * @return t/f whether the action was completed
     */
    public boolean removePassenger(Passenger removing){
        boolean sucessful = false;
        if(this.onboard.contains(removing)){
            sucessful = true;
            this.onboard.remove(removing);
            return sucessful;
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
        }else{
            System.out.println("This car is empty.");
        }
    }
}