public class Engine {

    // Attributes
    private FuelType fuel;
    private double maxFuel;
    private double currentFuel;

    /**
     * Constructs an engine object
     * @param fuel
     * @param max
     * @param current
     */
    public Engine(FuelType fuel, double max){
        this.fuel = fuel;
        this.maxFuel = max;
    }
    
    /**
     * Allows fuel type to be accessed outside the engine class
     * @return fuel type
     */
    public FuelType getFuel(){
        return fuel;
    }

    /**
     * Allows max fuel capacity to be accessed outside the engine class
     * @return max fuel
     */
    public double getMax(){
        return maxFuel;
    }

    /**
     * Allows current fuel to be accessed outside the engine class
     * @return current fuel
     */
    public double getCurrent(){
        return currentFuel;
    }

    /**
     * Returns the fuel level to max
     */
    public void refuel(){
        this.currentFuel = maxFuel;
    }

    public boolean go(){
        boolean notEmpty = true; // returned to notify the user if their is fuel remaining
        // If current fuel is greater than the amt decreasing
        if(this.currentFuel>20.00){
            this.currentFuel -= 20.00;
        }
        else{
            this.currentFuel = 0;
            notEmpty = false;
        }
        System.out.println("Fuel Remaining: " + this.currentFuel);
        return notEmpty;
    }
}

public static void main(String[] args) {
    Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
    while (myEngine.go()) {
        System.out.println("Choo choo!");
    }
    System.out.println("Out of fuel.");
}