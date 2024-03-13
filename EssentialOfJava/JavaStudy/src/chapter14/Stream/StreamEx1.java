package chapter14.Stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamEx1 {

	public static void main(String[] args) {
		Stream<Student> studentStream = Stream.of(
					new Student("���ڹ�", 3, 300),
					new Student("���ڹ�", 1, 200),
					new Student("���ڹ�", 2, 100),
					new Student("���ڹ�", 2, 150),
					new Student("���ڹ�", 1, 200),
					new Student("���ڹ�", 3, 290),
					new Student("���ڹ�", 3, 180)
				);
		
		studentStream.sorted(Comparator.comparing(Student::getBan)
				.thenComparing(Comparator.naturalOrder()))
				.forEach(System.out::println);
	}

}


