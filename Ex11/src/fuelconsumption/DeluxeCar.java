package fuelconsumption;
class DeluxeCar extends AdvancedCar{
	public DeluxeCar(int start, int finish, int distance, int passanger, int maker){
		super(start,finish,distance,passanger,maker);
	}
	
	public DeluxeCar(int start, int finish, int distance, int passanger, int maker, int minday){
		super(start,finish,distance,passanger,maker,minday);
	}
	public double calculateFuelConsumptionOldRegulations() {
		return super.calculateFuelConsumptionOldRegulations();
	}
	public double calculateFuelConsumptionNewRegulations() {
		return super.calculateFuelConsumptionNewRegulations();
	}
}