import java.util.ArrayList;
public class Train {

    // Attributes
    private Engine engine;
    private ArrayList<Car> cars;

    /**
     * Constructs a train object with an initialized engine and an array list of cars that are initialzied
     * @param fuelType type of fuel
     * @param fuelCapacity amt of fuel 
     * @param nCars number of cars
     * @param passengerCapacity amt of passengers
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        this.engine = new Engine(fuelType, fuelCapacity);
        this.cars = new ArrayList<Car>(nCars);
        for(int i = 0; i<nCars; i++){
            Car s = new Car(passengerCapacity);
            cars.add(s);
        }
    }

    /**
     * Allows the train's engine to be accessed outside the class
     * @return Engine object
     */
    public Engine getEngine(){
        return this.engine;
    }

    /**
     * Allows a certain number car to be accessed outside the class, subtract 1 to account for index
     * @param i car number
     * @return Car object at i-1
     */
    public Car getCar(int i){
        return cars.get(i-1);
    }

    /**
     * Iterates through the cars array list and adds up the max capacities
     * @return int for max capacity of all cars
     */
    public int getMaxCapacity(){
        int maxCap = 0;
        for(int s = 0; s<this.cars.size(); s++){
            maxCap += this.cars.get(s).getCapacity();
        }
        return maxCap;
    }

    /**
     * Iterates through the car array list and adds up the remaining available seats
     * @return int for number of available seats
     */
    public int getAvailableSeats(){
        int avail = 0;
        for(int e = 0; e<this.cars.size(); e++){
            avail += this.cars.get(e).seatsRemaining();
        }
        return avail;
    }

    /**
     * Prints out a list off all the passengers in all the cars
     */
    public void printManifest(){
        System.out.println("\n");
        System.out.println("Manifest:");
        System.out.println("");
        for(int r = 0; r<this.cars.size(); r++){
            Car current = this.cars.get(r);
            int numCur = r+1;
            System.out.println("Car " + numCur + ": ");
            current.printManifest();
            System.out.println("");
        }
    }
}
