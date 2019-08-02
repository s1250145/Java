package fuelconsumption;
class FuelConsumptionCalculation{
	private int start,finish,distance,passanger,maker,minday;
	private double fuelConsumptionOldRegulation = 0;
	private double fuelConsumptionNewRegulation = 0;

	/*
	 * Maker Code List
	 * Nissan->2
	 * Toyota->1
	 * Honda->0
	 * Van->3
	 */
	
	private double[] fueleconomy = {14, 15.5, 13, 10.5, 6.6};
	private double[] airconditoner = {10.5, 9.5, 0, 6, 11.5};
	private static SimpleCar[] cars;
	
	FuelConsumptionCalculation(int start, int finish, int distance, int passanger,int maker) {
		this.start = start;
		this.finish = finish;
		this.distance = distance;
		this.passanger = passanger;
		this.maker = maker;
	}
	FuelConsumptionCalculation(SimpleCar[] cars){
		this.cars = cars;
	}
	FuelConsumptionCalculation(int start, int finish, int distance, int passanger,int maker, int minday) {
		this.start = start;
		this.finish = finish;
		this.distance = distance;
		this.passanger = passanger;
		this.maker = maker;
		this.minday = minday;
	}
	private void calculateFuelConsumption(){
		if(maker == 1 || maker == 2) {
			fuelConsumptionOldRegulation = distance/fueleconomy[maker] + (finish-start)*airconditoner[maker];
			fuelConsumptionNewRegulation = distance/fueleconomy[maker] + (finish-start)*airconditoner[maker];
		}else if(maker == 4){
			fuelConsumptionOldRegulation = distance/fueleconomy[maker] + (airconditoner[maker]/minday)*(finish-start);
			fuelConsumptionNewRegulation = distance/fueleconomy[maker] + (airconditoner[maker]/minday*passanger);
		}else{
			fuelConsumptionOldRegulation = distance/fueleconomy[maker] + (finish-start)*airconditoner[maker];
			fuelConsumptionNewRegulation = distance/fueleconomy[maker] + passanger*airconditoner[maker];
		}
	}
	
	double getFuelConsumptionOldRegulations() {
		return fuelConsumptionOldRegulation;
	}
	double getFuelConsumptionNewRegulations() {
		return fuelConsumptionNewRegulation;
	}
	public static void main(String[] args) {
		double sumSaveFuel = 0;
		//Nissan(This doesn't have air conditioner. This is a SimpleCar.)
		SimpleCar nissan = new SimpleCar(7,18,200,8,2);
		nissan.per.calculateFuelConsumption();
		sumSaveFuel += ( nissan.calculateFuelConsumptionOldRegulations()-nissan.calculateFuelConsumptionNewRegulations() );
		System.out.println("FuelConsumptionOldRegulations -> Nissan: " + nissan.calculateFuelConsumptionOldRegulations() );
		System.out.println("FuelConsumptionNewRegulations -> Nissan: " + nissan.calculateFuelConsumptionNewRegulations() );
		
		//Toyota(This has air conditioner. This is an AdvancedCar.)
		AdvancedCar toyota = new AdvancedCar(7,8,200,8,1);
		toyota.per.calculateFuelConsumption();
		sumSaveFuel += ( toyota.calculateFuelConsumptionOldRegulations()-toyota.calculateFuelConsumptionNewRegulations() );
		System.out.println("FuelConsumptionOldRegulations -> Toyota: " + toyota.calculateFuelConsumptionOldRegulations() );
		System.out.println("FuelConsumptionNewRegulations -> Toyota: " + toyota.calculateFuelConsumptionNewRegulations() );
		
		//Honda & Van(They have air conditioner. They are a DeluxeCar.)
		DeluxeCar[] carObjects = new DeluxeCar[2];
		carObjects[0] = new DeluxeCar(7,18,200,8,0);
		carObjects[1] = new DeluxeCar(7,18,200,8,3);
		SimpleCar obj = new SimpleCar(carObjects);
		cars[0].per.calculateFuelConsumption();
		sumSaveFuel += ( cars[0].calculateFuelConsumptionOldRegulations()-cars[0].calculateFuelConsumptionNewRegulations() );
		System.out.println("FuelConsumptionOldRegulations -> Honda: " + cars[0].calculateFuelConsumptionOldRegulations() );
		System.out.println("FuelConsumptionNewRegulations -> Honda: " + cars[0].calculateFuelConsumptionNewRegulations() );
		cars[1].per.calculateFuelConsumption();
		sumSaveFuel += ( cars[1].calculateFuelConsumptionOldRegulations()-cars[1].calculateFuelConsumptionNewRegulations() );
		System.out.println("FuelConsumptionOldRegulations -> Van: " + cars[1].calculateFuelConsumptionOldRegulations() );
		System.out.println("FuelConsumptionNewRegulations -> Van: " + cars[1].calculateFuelConsumptionNewRegulations() );
		
		//Mercedes(This have an airconditioner. It's superclass is DeluxeCar.)
		BusTaxi mercedes = new BusTaxi(7,18,200,10,10);
		mercedes.per.calculateFuelConsumption();
		sumSaveFuel += ( mercedes.calculateFuelConsumptionOldRegulations()-mercedes.calculateFuelConsumptionNewRegulations() );
		System.out.println("FuelConsumptionOldRegulations -> Mercedes: " + mercedes.calculateFuelConsumptionOldRegulations() );
		System.out.println("FuelConsumptionNewRegulations -> Mercedes: " + mercedes.calculateFuelConsumptionNewRegulations() );
		
		System.out.println("\nHow much fuel does the company save when applying new regulations on air conditioner usage?\n-> "+sumSaveFuel);
		
		 
	}
}