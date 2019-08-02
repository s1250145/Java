package fuelconsumption;
class AdvancedCar extends SimpleCar{
	public AdvancedCar(int start, int finish, int distance, int passanger, int maker) {
		super(start,finish,distance,passanger,maker);
	}
	
	public AdvancedCar(int start, int finish, int distance, int passanger, int maker,int minday) {
		super(start,finish,distance,passanger,maker, minday);
	}
	public double calculateFuelConsumptionOldRegulations() {
		return super.calculateFuelConsumptionOldRegulations();
	}
	public double calculateFuelConsumptionNewRegulations() {
		return super.calculateFuelConsumptionNewRegulations();
	}
}