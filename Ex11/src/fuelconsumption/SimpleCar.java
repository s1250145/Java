package fuelconsumption;
class SimpleCar{
	protected FuelConsumptionCalculation per;
	public SimpleCar(int start, int finish, int distance, int passanger, int maker) {
		per = new FuelConsumptionCalculation(start,finish,distance,passanger,maker);
	}
	public SimpleCar(SimpleCar[] carArray) {
		per = new FuelConsumptionCalculation(carArray);
	}
	public SimpleCar(int start, int finish, int distance, int passanger, int maker, int minday) {
		per = new FuelConsumptionCalculation(start,finish,distance,passanger,maker,minday);
	}
	public double calculateFuelConsumptionOldRegulations() {
		return per.getFuelConsumptionOldRegulations();
	}
	public double calculateFuelConsumptionNewRegulations() {
		return per.getFuelConsumptionNewRegulations();
	}
}