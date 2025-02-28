package _03_DesignPatterns._03_BehaviouralPattern;

import java.util.*;

//Iterable Collection can hold objects of different types. Below provides multiple ways to achieve this

/* 1st Method : Using Object type (Not type-safe).
 * This process is not type safe as type is defined as Object whose iterator implementation might fail to work with all types
 * Downside: You need to use instanceof and type casting when retrieving elements
 */
class IterableCollection_Object implements Iterable<Object> {

	private List<Object> items = new ArrayList<>();

	public void addItem(Object item) {
		items.add(item);
	}

	@Override
	public java.util.Iterator<Object> iterator() {
		return items.iterator();
	}
}

/*
 * 2nd Method : Using Generics with Interface This approach ensures type safety
 * and flexibility
 */
interface Animal {
	void speak();
}

class Dog implements Animal {
	public void speak() {
		System.out.println("Woof!");
	}
}

class Cat implements Animal {
	public void speak() {
		System.out.println("Meow!");
	}
}

//Collection that holds different Animal types
class IterableCollection_Generics implements Iterable<Animal> {

	private List<Animal> animals = new ArrayList<>();

	public void addAnimal(Animal animal) {
		animals.add(animal);
	}

	@Override
	public java.util.Iterator<Animal> iterator() {
		return animals.iterator();
	}
}

/*
 * 3rd Method : Java’s Built-in Iterator<Object> in Generic Collections Uses
 * Generics instead of raw.
 * 
 * Object Still allows multiple types, but type safety depends on how it's used
 * 
 * flexible and safer than Object
 */
class IterableCollection_Generics_T<T> implements Iterable<T> {
	private List<T> items = new ArrayList<>();

	public void addItem(T item) {
		items.add(item);
	}

	@Override
	public java.util.Iterator<T> iterator() {
		return items.iterator();
	}
}

public class _05_02_IteratorPattern_MultipleTypes {

	public static void main(String[] args) {

		IterableCollection_Object collectionObj = new IterableCollection_Object();
		collectionObj.addItem("Hello");
		collectionObj.addItem(42);
		collectionObj.addItem(3.14);
		for (Object item : collectionObj)
			System.out.println(item);

		IterableCollection_Generics collectionGenerics = new IterableCollection_Generics();
		collectionGenerics.addAnimal(new Dog());
		collectionGenerics.addAnimal(new Cat());
		for (Animal animal : collectionGenerics)
			animal.speak(); // No casting needed

		IterableCollection_Generics_T<Object> collectionT = new IterableCollection_Generics_T<>();
		collectionT.addItem("String");
		collectionT.addItem(10);
		collectionT.addItem(3.14);

		for (Object obj : collectionT)
			System.out.println(obj);

	}

}