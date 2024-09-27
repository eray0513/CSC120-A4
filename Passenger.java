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

    public void boardCar(Car boarding){
        boolean success = boarding.addPassenger(this);
        
    }
}
