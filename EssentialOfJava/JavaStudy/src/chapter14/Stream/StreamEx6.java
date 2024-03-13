package chapter14.Stream;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx6 {

	public static void main(String[] args) {
		Student[] stuArr = {
				new Student("김자바", 1, 200),
				new Student("박자바", 2, 100),
				new Student("전자바", 3, 150),
				new Student("공자바", 2, 180),
				new Student("이자바", 2, 220),
				new Student("하자바", 1, 190)
		};
		
		List<String> stuNameArr = Stream.of(stuArr).map(Student::getName)
									.collect(Collectors.toList());
		
		System.out.println(stuNameArr);
		
		Student[] stuArr2 = Stream.of(stuArr).toArray(Student[]::new);
		
		Stream.of(stuArr2).forEach(System.out::println);
		
		Map<String, Student> stuMap = Stream.of(stuArr)
									.collect(Collectors.toMap(s -> s.getName(), p -> p));
		
		for (String name : stuMap.keySet()) {
			System.out.println(name + "-" + stuMap.get(name));
		}
		
		long count = Stream.of(stuArr).collect(Collectors.counting());
		long totalScore = Stream.of(stuArr)
									.collect(Collectors.summingInt(Student::getTotalScore));
		
		System.out.println("count=" + count);
		System.out.println("totalScore" + totalScore);
		
		totalScore = Stream.of(stuArr)
					.collect(Collectors.reducing(0, Student::getTotalScore, Integer::sum));
		System.out.println("totalScore=" + totalScore);
		
		Optional<Student> topStudent = Stream.of(stuArr)
							.collect(Collectors.maxBy(Comparator.comparingInt(Student::getTotalScore)));
		System.out.println("topStudent=" + topStudent.get());

		IntSummaryStatistics stat = Stream.of(stuArr)
								.collect(Collectors.summarizingInt(Student::getTotalScore));
		
		System.out.println(stat);
		
		String stuNames = Stream.of(stuArr).map(Student::getName)
							.collect(Collectors.joining(",", "{", "}"));
		System.out.println(stuNames);
	}
}
