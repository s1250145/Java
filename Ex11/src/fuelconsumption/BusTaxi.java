package fuelconsumption;
class BusTaxi extends DeluxeCar{
	public BusTaxi(int start, int finish, int distance, int passanger, int minday) {
		super(start, finish, distance, passanger, 4, minday);
	}
	public double calculateFuelConsumptionOldRegulations() {
		return super.calculateFuelConsumptionOldRegulations();
	}
	public double calculateFuelConsumption() {
		return super.calculateFuelConsumptionNewRegulations();
	}
	
}
