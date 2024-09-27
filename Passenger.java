public class Passenger {
    
    // Attribute
    private String name;

    /**
     * Constructs a passenger object
     * @param name
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Allows the passenger's name to be accessed outside the class
     * @return
     */
    public String getName(){
        return this.name;
    }

    /**
     * Allows a passenger to board a car and prints if it was sucessful
     * @param boarding
     */
    public void boardCar(Car boarding){
        boolean success = boarding.addPassenger(this);
        if(success){
            System.out.println("Boarding was sucessful.");
        }
        else{
            System.out.println("There is no space left in this car.");
        }
    }

    /**
     * Allows a passenger to exit a car and prints if it was sucessful
     * @param exiting
     */
    public void exitCar(Car exiting){
        boolean sucessful = exiting.removePassenger(this);
        if(sucessful){
            System.out.println("The passenger has exited the car.");
        }
        else{
            System.out.println("This passenger is not on this car.");
        }
    }
}
