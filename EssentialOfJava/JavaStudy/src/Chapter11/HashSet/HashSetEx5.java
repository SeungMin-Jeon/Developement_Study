package Chapter11.HashSet;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetEx5 {

	public static void main(String[] args) {
		HashSet<Object> setA = new HashSet();
		HashSet<Object> setB = new HashSet();
		HashSet<Object> setHab = new HashSet();
		HashSet<Object> setKyo = new HashSet();
		HashSet<Object> setCha = new HashSet();
		
		setA.add("1");
		setA.add("2");
		setA.add("4");
		setA.add("5");
		System.out.println("A = " + setA);
		
		setB.add("4");
		setB.add("5");
		setB.add("6");
		setB.add("7");
		setB.add("8");
		System.out.println("B = " + setB);
		
		Iterator<Object> it = setB.iterator();
		
		while(it.hasNext()) {
			Object tmp = it.next();
			if(setA.contains(tmp)) {
				setKyo.add(tmp);
			}
		}
		
		it = setA.iterator();
		while(it.hasNext()) {
			Object tmp = it.next();
			if(!setB.contains(tmp)) {
				setCha.add(tmp);
			}
		}
		
		it = setA.iterator();
		while(it.hasNext()) {
			Object tmp = it.next();
			if(!setB.contains(tmp)) {
				setCha.add(tmp);
			}
		}
		
		it = setA.iterator();
		while(it.hasNext()) {
			Object tmp = it.next();
			if(!setB.contains(tmp)) {
				setCha.add(tmp);
			}
		}
		
		it = setA.iterator();
		while(it.hasNext()) 
			setHab.add(it.next());
		
		
		it = setB.iterator();
		while(it.hasNext())
			setHab.add(it.next());
		
		System.out.println("A ¡û B = " + setKyo);
		System.out.println("A U B = " + setHab);
		System.out.println("A - B = " + setCha);
	}

}
