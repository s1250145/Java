import java.util.ArrayList;
/**
 * ToyBox Example.
 */
class ToyBox<T> {
    private ArrayList<T> v = new ArrayList<T>();
    
    public void add(T t) { v.add(t); }
    
    public T get(int i) { return v.get(i); }
    
    public int getSize() { return v.size(); }
}

public class ToyBoxTest {
    public static void showToysinBox(ToyBox<? extends Toy> someToyBox) {
    		for(int i=0; i<someToyBox.getSize(); i++) { System.out.println(someToyBox.get(i)); }
    }

    public static void main(String[] args) {
        ToyBox<Car> carBox = new ToyBox<Car>();
        Car t1 = new Car("Yaris", 1500);
        Car t2 = new Car("Corolla", 2500);
        carBox.add(t1);
        carBox.add(t2);
        showToysinBox(carBox);

        ToyBox<Bear> bearBox = new ToyBox<Bear>();
        Bear b1 = new Bear("Bear1", 1000);
        Bear b2 = new Bear("Bear2", 2000);
        bearBox.add(b1);
        bearBox.add(b2);
        showToysinBox(bearBox);

        ToyBox<Toy> toyBox = new ToyBox<Toy>();
        Car t3 = new Car("Tacoma", 3300);
        Bear b3 = new Bear("Bear3", 1200);
        toyBox.add(t3);
        toyBox.add(b3);
        showToysinBox(toyBox);

        ToyBox<? extends Toy> sometoyBox = carBox;
        System.out.println("After assigning the carBox into the \"sometoyBox\"...");
        showToysinBox(sometoyBox);
    }
}

class Toy {
    String name;
    int number;
    Toy(String str, int num) {
        name = str;
        number = num;
    }
    
    public String toString() { return name+"/"+number; }
    
    public int getSize() { return number; }
}

class Car extends Toy { Car(String str, int num) { super(str, num); } }

class Bear extends Toy { Bear(String str, int num) { super(str, num); } }
