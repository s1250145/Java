/*
 * calculating fuel consumption at the end of each day by all the cars
 * 	その日の終わりに全ての車種によって消費された燃料を計算する
 * 
 * How much fuel does the company save when applying new regulations on air conditioner usage?
 * 	エアコンの使用について規則を適用したとき、会社はどれだけ燃料を節約できるでしょうか？
 * 
 * 旧レギュレーション；
 * 常にエアコンをオンにしておく
 * 
 * 新レギュレーション；
 * お客さんを乗せている間だけでエアコンをオンにしておく
 *
 * Maker Code List;
 *	Honda:0
 *	Toyota:1
 *	Nissan:2
 *	Van:3
 *
 */

class SimpleCar{
	protected FuelConsumptionCalculation per;
	public SimpleCar(int start, int finish, int distance, int passanger, int maker) {
		per = new FuelConsumptionCalculation(start,finish,distance,passanger,maker);
	}
	public SimpleCar(SimpleCar[] carArray) {
		per = new FuelConsumptionCalculation(carArray);
	}
	public double calculateFuelConsumptionOldRegulations() {
		return per.getFuelConsumptionOldRegulations();
	}
	public double calculateFuelConsumptionNewRegulations() {
		return per.getFuelConsumptionNewRegulations();
	}
}

class AdvancedCar extends SimpleCar{
	public AdvancedCar(int start, int finish, int distance, int passanger, int maker) {
		super(start,finish,distance,passanger,maker);
	}
	public double calculateFuelConsumptionOldRegulations() {
		return super.calculateFuelConsumptionOldRegulations();
	}
	public double calculateFuelConsumptionNewRegulations() {
		return super.calculateFuelConsumptionNewRegulations();
	}
}

class DeluxeCar extends AdvancedCar{
	public DeluxeCar(int start, int finish, int distance, int passanger, int maker){
		super(start,finish,distance,passanger,maker);
	}
	public double calculateFuelConsumptionOldRegulations() {
		return super.calculateFuelConsumptionOldRegulations();
	}
	public double calculateFuelConsumptionNewRegulations() {
		return super.calculateFuelConsumptionNewRegulations();
	}
}

class FuelConsumptionCalculation{
	private int start,finish,distance,passanger,maker;
	private double fuelConsumptionOldRegulation = 0;
	private double fuelConsumptionNewRegulation = 0;

	/*
	 * Maker Code List
	 * Nissan->2
	 * Toyota->1
	 * Honda->0
	 * Van->3
	 */
	
	private double[] fueleconomy = {14, 15.5, 13, 10.5};
	private double[] airconditoner = {10.5, 9.5, 0, 6};
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
	private void calculateFuelConsumption(){
		if(maker == 1 || maker == 2) {
			fuelConsumptionOldRegulation = distance/fueleconomy[maker] + (finish-start)*airconditoner[maker];
			fuelConsumptionNewRegulation = distance/fueleconomy[maker] + (finish-start)*airconditoner[maker];
		}else {
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
		
		System.out.println("\nHow much fuel does the company save when applying new regulations on air conditioner usage?\n-> "+sumSaveFuel);
		
		/* Success Code
		 * SimpleCar carObjects = new SimpleCar();
		 * carObjects.carArray[0].per.calculateFuelConsumption();
		 * System.out.println("FuelConsumptionOldRegulations -> Honda: " + carObjects.carArray[0].calculateFuelConsumptionOldRegulations() );
		 * System.out.println("FuelConsumptionNewRegulations -> Honda: " + carObjects.carArray[0].calculateFuelConsumptionNewRegulations() );
		 * carObjects.carArray[1].per.calculateFuelConsumption();
		 * System.out.println("FuelConsumptionOldRegulations -> Van: " + carObjects.carArray[1].calculateFuelConsumptionOldRegulations() );
		 * System.out.println("FuelConsumptionNewRegulations -> Van: " + carObjects.carArray[1].calculateFuelConsumptionNewRegulations() );
		 */
		 
	}
}

/* 		作業Memo------
 * 		SimpleCarクラス型配列carsをstatic指定しないとHondaとVanが実行できない
 * 		mainメソッドはstaticなので変数の取り扱いに注意
 */

/*		Eclipse操作Memo------
 * 		デバッグを実行すると、デバッグウィンドウタブの右側付近に操作ボタン一覧が出る。その中の終了ボタンを押して、終了させる。
 * 		実行状態でコードを書き直してコンパイル（Command-S）しようとすると[HotCodeError]が出る。
 */