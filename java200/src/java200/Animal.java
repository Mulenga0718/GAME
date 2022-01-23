package java200;

abstract class Animal {
	private String name;
	public Animal(String name) {this.name = name;}
	public abstract void bark();
	public String getName() {return name;}
	public abstract String toString();
	public void introduce() {
		System.out.print(toString()+"이다");
	}
}

class Dog extends Animal{
	private String type;
	public Dog(String name, String type) {
		super(name); this.type = type;
	}
	public void bark() {System.out.println("멍멍");}
	public String toString(){
		return type + "의"+ getName();
	}
}

class Cat extends Animal{
	private int age;
	public Cat(String name, int age) {
		super(name); this.age = age;
	}
	public void bark() {System.out.println("야옹");
	}
	public String toString() {
		return age+"의"+getName();
	}
}