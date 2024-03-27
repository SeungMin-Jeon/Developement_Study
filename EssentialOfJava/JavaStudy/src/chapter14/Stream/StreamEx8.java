package chapter14.Stream;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class StreamEx8 {

	public static void main(String[] args) {
		Student[] stuArr = {
				new Student("���ڹ�", true, 1, 1, 300),
				new Student("���ڹ�", false, 1, 1, 250),
				new Student("���ڹ�", true, 1, 1, 200),
				new Student("���ڹ�", false, 1, 2, 100),
				new Student("���ڹ�", true, 1, 2, 150),
				new Student("���ڹ�", false, 1, 2, 50),
				new Student("���ڹ�", false, 1, 3, 200),
				new Student("���ڹ�", false, 1, 3, 180),
				new Student("���ڹ�", true, 1, 3, 90),
				
				new Student("���ڹ�", true, 2, 1, 300),
				new Student("���ڹ�", false, 2, 1, 300),
				new Student("���ڹ�", true, 2, 1, 300),
				new Student("���ڹ�", false, 2, 2, 300),
				new Student("���ڹ�", false, 2, 2, 300),
				new Student("���ڹ�", true, 2, 3, 300)
		};
		
		System.out.printf("1. �ܼ��׷�ȭ(�ݺ��� �׷�ȭ) %n");
		Map<Integer, List<Student>> stuByBan = Stream.of(stuArr)
				.collect(groupingBy(Student::getBan));
		
		for(List<Student> ban : stuByBan.values()) {
			for (Student s : ban) {
				System.out.println(s);
			}
		}
		
		System.out.printf("%n2. �ܼ��׷�ȭ(�������� �׷�ȭ)%n");
		Map<Student.Level, List<Student>> stuByLevel = Stream.of(stuArr)
				.collect(groupingBy(s -> {
					if(s.getScore() >= 200) return Student.Level.HIGH;
					else if(s.getScore() >= 100) return Student.Level.MID;
					else return Student.Level.LOW;
				}));
		
		TreeSet<Student.Level> keySet = new TreeSet<>(stuByLevel.keySet());
		
		for(Student.Level key : keySet) {
			System.out.println("[" + key + "]");
			
			for(Student s : stuByLevel.get(key))
				System.out.println(s);
			System.out.println();
		}
		
		System.out.printf("%n3. �ܼ��׷�ȭ + ���(������ �л���) %n");
		Map<Student.Level, Long> stuCntByLevel = Stream.of(stuArr)
				.collect(groupingBy(s -> {
					if(s.getScore() >= 200) return Student.Level.HIGH;
					else if(s.getScore() >= 100) return Student.Level.MID;
					else return Student.Level.LOW;
				}, counting()));
		
		for(Student.Level key : stuCntByLevel.keySet())
			System.out.printf("[%s] - %d��, ", key, stuCntByLevel.get(key));
		System.out.println();
		
		System.out.printf("%n4, ���߱׷�ȭ(�г⺰, �ݺ�)");
		Map<Integer, Map<Integer, List<Student>>> stuByHakAndBan =
				Stream.of(stuArr)
					.collect(groupingBy(Student::getHak,
							groupingBy(Student::getBan)));
		
		for(Map<Integer, List<Student>> hak : stuByHakAndBan.values()) {
			for(List<Student> ban : hak.values()) {
				System.out.println();
				for(Student s : ban)
					System.out.println(s);
			}
		}
		
	}

}
