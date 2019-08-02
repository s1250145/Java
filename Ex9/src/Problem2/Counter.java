package Problem2;

public class Counter {
	public static void main(String[] args) {
		Animal[] a = {new Dog(), new Cat(), new Cat(), new Dog(), new Dog()};
		for(int i=0; i<a.length; i++) {
			a[i].noise();		
		}
		System.out.println(Dog.getCount()+" Woof "+Cat.getCount()+" Meow");
	}
}
