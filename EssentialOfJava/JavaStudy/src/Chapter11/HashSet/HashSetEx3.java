package Chapter11.HashSet;

import java.util.HashSet;

public class HashSetEx3 {
	public static void main(String[] args) {
		HashSet<Object> set = new HashSet<>();
		
		set.add("abc");
		set.add("abc");
		set.add(new Person("David", 10));
		set.add(new Person("David", 10));
		
		System.out.println(set);
	}
}

class Person {
	String name;
	int age;
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return name + ":" + age;
	}
}