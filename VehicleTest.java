class PetroleumPrice {
	double gasolinePrice, diesePrice;
	PetroleumPrice(double g, double d) {
		gasolinePrice = g;
		diesePrice = d;
	}
	public double getGasolineCost() { return 100.0*gasolinePrice; }
	public double getDieseCost() { return 100.0*diesePrice; }
}

abstract class Vehicle {
	String modelName, company, owner, engineType;
	double tankSize, fuelConsumption;
	Vehicle(String model, String company, String own, String engine, double tankSize, double fuel) {
		modelName = model;
		this.company = company;
		owner = own;
		engineType = engine;
		this.tankSize = tankSize;
		fuelConsumption = fuel;
	}
	//Vehicle(){ toString(); }
	public String toString() { return "ModelName: "+modelName+", Company: "+company+", Owner: "+owner+", EngineType: "+engineType+", TankSize: "+tankSize+", FuelConsumption: "+fuelConsumption; }
	public double movableDistance() { return tankSize*fuelConsumption; }
	abstract public double costFor100Km(PetroleumPrice a);
	abstract public void setAirConditionON();
	abstract public void setAirConditionOFF();
}

class Car extends Vehicle {
	int numberOfSeats;
	boolean airConditionOn = false;
	
	Car(String model, String company, String own, String engine, double tankSize, double fuel, int seat) {
		super(model, company, own, engine, tankSize, fuel);
		setNumberOfSeat(seat);
	}
	
	//Car() { toString(); }
	
	public void setNumberOfSeat(int seat) { numberOfSeats = seat; }
	public void setAirConditionON() {
		airConditionOn = true;
		fuelConsumption *= 0.85;
	}
	public void setAirConditionOFF() {
		airConditionOn = false;
		fuelConsumption /= 0.85;
	}
	public String toString() { return super.toString()+", NumberOfSeat: "+numberOfSeats; }
	// 車はガソリンのみ
	public double costFor100Km(PetroleumPrice priceInfo) { return priceInfo.getGasolineCost()/fuelConsumption; }
}

class MiniVan extends Vehicle {
	int numberOfSeats;
	boolean airConditionOn = false;
	boolean hasAutoDoor;
	
	MiniVan(String model, String company, String own, String engine, double tankSize, double fuel, int seat, boolean door) {
		super(model, company, own, engine, tankSize, fuel);
		setNumberOfSeat(seat);
		setHasAutoDoor(door);
	}
	
	//MiniVan() { toString(); }
	
	public String toString() { return super.toString()+", NumberOfSeat: "+numberOfSeats+", HasAutoDoor: "+hasAutoDoor; }
	public void setNumberOfSeat(int seat) { numberOfSeats = seat; }
	public void setHasAutoDoor(boolean door) { hasAutoDoor = door; }
	public void setAirConditionON() {
		airConditionOn = true;
		fuelConsumption *= 0.75;
	}
	public void setAirConditionOFF() {
		airConditionOn = false;
		fuelConsumption /= 0.75;
	}
	// ミニバンはガソリンorディーゼル
	public double costFor100Km(PetroleumPrice priceInfo) {
		if (engineType.equals("Gasoline")) return priceInfo.getGasolineCost()/fuelConsumption;
		else return priceInfo.getDieseCost()/fuelConsumption;
	}
}

class Truck extends Vehicle {
	int numberOfSeats;
	boolean airConditionOn = false;
	int power;
	
	Truck(String model, String company, String own, String engine, double tankSize, double fuel, int seat, int power) {
		super(model, company, own, engine, tankSize, fuel);
		setNumberOfSeat(seat);
		setPower(power);
	}
	//Truck() { toString(); }
	
	public String toString() { return super.toString()+", NumberOfSeat: "+numberOfSeats+", HorsePower: "+power; }
	public void setNumberOfSeat(int seat) { numberOfSeats = seat; }
	public void setPower(int power) { this.power = power; }
	// トラックはディーゼルのみ
	public double costFor100Km(PetroleumPrice priceInfo) { return priceInfo.getDieseCost()/fuelConsumption; }
	public void setAirConditionON() {
		airConditionOn = true;
		fuelConsumption *= 0.75;
	}
	public void setAirConditionOFF() {
		airConditionOn = false;
		fuelConsumption /= 0.75;
	}
}

public class VehicleTest {

    public static void describe(Vehicle v) {
        System.out.println(v);
    }

    public static void main(String[] args) {
        Vehicle vehicles[] = {
         new Car("Camley", "Toyota", "Suzuki", "Gasoline", 70., 15.15, 5),
         new Car("Aqua", "Toyota", "Nakajima", "Hybrid", 36., 40.0, 5),
         new MiniVan("Sienna", "Toyota", "Tanaka", "Gasoline", 75.,  9.0, 8, true),
         new MiniVan("Odyssey", "Honda", "Kikuchi", "Diesel", 56., 11.0, 8, false),
         new MiniVan("Presage", "Nissan", "Shirotora", "Gasoline", 60., 7.0, 7, false),
         new Truck("Tundra", "Toyota", "Sugai", "Diesel", 100., 6.76, 5, 310),
         new Truck("Ridgeline", "Honda", "Watanabe", "Diesel", 83.279, 7.23, 5, 250)
         };

        PetroleumPrice priceInfo = new PetroleumPrice(128.7, 105.7);

        for(Vehicle v: vehicles) {
        		describe(v);
            System.out.println("Movable distance: " + v.movableDistance() + " Km");
            System.out.println("Cost for 100 Km: " + v.costFor100Km(priceInfo) + " Yen");
            System.out.println(); 
        }
        
        System.out.println(); 
        System.out.println("After Aircondition is ON\n");
        
        for(Vehicle v: vehicles) {
        		v.setAirConditionON();
        		describe(v);
        		System.out.println("Movable distance: " + v.movableDistance() + " Km");
        		System.out.println("Cost for 100 Km: " + v.costFor100Km(priceInfo) + " Yen");
            System.out.println(); 
        	}
    }
}
