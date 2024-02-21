package Chapter11.Compare;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorEx {

	public static void main(String[] args) {
		String[] strArr = {"cat", "Dog", "lion", "tiger"};
		
		Arrays.sort(strArr);
		System.out.println("strArr=" + Arrays.toString(strArr));
		
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); // 대소문자 구문하지 않는다.
		System.out.println("strArr=" + Arrays.toString(strArr));
		
		Arrays.sort(strArr, new Decending()); // 역순 정렬
		System.out.println("strArr=" + Arrays.toString(strArr));
	}
}


class Decending implements Comparator<Object> {
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable) o1;
			Comparable c2 = (Comparable) o2;
			return c1.compareTo(c2);
		}
		
		return -1;
	}
}
