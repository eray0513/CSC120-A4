public class Engine {

    // Attributes
    private FuelType fuel;
    private double maxFuel;
    private double currentFuel;

    /**
     * Constructs an engine object
     * @param fuel type
     * @param max fuel amt
     */
    public Engine(FuelType fuel, double max){
        this.fuel = fuel;
        this.maxFuel = max;
        this.currentFuel = max;
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
     * @return double for max fuel
     */
    public double getMax(){
        return maxFuel;
    }

    /**
     * Allows current fuel to be accessed outside the engine class
     * @return double for current fuel
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

    /**
     * Allows the train to go if it has enough fuel
     * @return t/f if there is fuel remaining after the train goes
     */
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

    public static void main(String[] args) {

        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0); // new engine
        // test go method
        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
        myEngine.refuel(); // test refuel

        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");

        // create new passengers
        Passenger myPassenger = new Passenger("Evelyn");
        Passenger myPassenger2 = new Passenger ("Ruby");
        // create a car
        Car myCar = new Car(10);
        // test add and remove and print manifest methods
        myCar.addPassenger(myPassenger);
        System.out.println(myCar.addPassenger(myPassenger));
        myCar.addPassenger(myPassenger2);
        myCar.printManifest();
        myCar.removePassenger(myPassenger);
        System.out.println(myCar.removePassenger(myPassenger));
        myCar.printManifest();

        // create a second car
        Car myCar2 = new Car(2);
        // test passenger boarding and exiting
        Passenger myPassenger3 = new Passenger("Evie");
        myCar2.addPassenger(myPassenger3);
        System.out.println(myCar2.addPassenger(myPassenger3));
        System.out.println(myCar2.addPassenger(myPassenger));
        myPassenger3.getOffCar(myCar2);
        myPassenger3.getOffCar(myCar2);
        myPassenger3.getOffCar(myCar2);
        myPassenger2.boardCar(myCar2);
        myPassenger3.boardCar(myCar2);
        myPassenger.boardCar(myCar2);

        // create a train
        Train myTrain = new Train(FuelType.STEAM, 100, 4, 2);
        // test train methods
        System.out.println(myTrain.getMaxCapacity());
        System.out.println(myTrain.getAvailableSeats());
        System.out.println(myTrain.getCar(1).addPassenger(myPassenger2));
        myTrain.getCar(1).addPassenger(myPassenger3);
        myTrain.getCar(1).removePassenger(myPassenger3);
        myTrain.getCar(1).addPassenger(myPassenger3);
        myTrain.getCar(1).addPassenger(myPassenger2);
        System.out.println(myTrain.getAvailableSeats());
        myTrain.printManifest();

    }
}