package chapter14.Stream;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

class Student {
	String name;
	boolean isMale;
	int hak;
	int ban;
	int score;
	
	Student(String name, boolean isMale, int hak, int ban, int score) {
		this.name = name;
		this.isMale = isMale;
		this.hak = hak;
		this.ban = ban;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public boolean isMale() {
		return isMale;
	}

	public int getHak() {
		return hak;
	}

	public int getBan() {
		return ban;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", isMale=" + isMale + ", hak=" + hak + ", ban=" + ban + ", score=" + score
				+ "]";
	}
	
	enum Level { HIGH, MID, LOW }
}


public class StreamEx7 {

	public static void main(String[] args) {
		Student[] stuArr = {
				new Student("���ڹ�", true, 1, 1, 300),
				new Student("���ڹ�", true, 1, 1, 100),
				new Student("���ڹ�", true, 1, 2, 50),
				new Student("���ڹ�", true, 1, 2, 80),
				new Student("���ڹ�", true, 1, 3, 100),
				new Student("���ڹ�", true, 1, 3, 250),

				new Student("���ڹ�", false, 2, 1, 60),
				new Student("���ڹ�", false, 2, 1, 300),
				new Student("���ڹ�", false, 2, 1, 180),
				new Student("���ڹ�", false, 2, 2, 100),
				new Student("���ڹ�", false, 2, 2, 90),
				new Student("���ڹ�", false, 2, 2, 280)
				
		};
		
		System.out.println("1. �ܼ�����(������ ����) %n");
		Map<Boolean, List<Student>> stuBySex = Stream.of(stuArr)
				.collect(partitioningBy(Student::isMale));
		
		List<Student> maleStudent = stuBySex.get(true);
		List<Student> femaleStudent = stuBySex.get(false);
		
		for(Student x : maleStudent) {
			System.out.println(x.toString());
		}
		
		for(Student x : femaleStudent) {
			System.out.println(x.toString());
		}
		
		System.out.printf("%n. �ܼ����� + ���(���� �л���)%n");
		Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
				.collect(partitioningBy(Student::isMale, counting()));
		
		System.out.println("���л� �� : " + stuNumBySex.get(true));
		System.out.println("���л� �� : " + stuNumBySex.get(false));
		
		System.out.printf("%n �ܼ����� + ���(���� 1��) %n");
		Map<Boolean, Optional<Student>> topScoreBySex = Stream.of(stuArr)
				.collect(partitioningBy(Student::isMale, maxBy(comparingInt(Student::getScore))
						));
		
		System.out.println("���л� 1�� : " + topScoreBySex.get(true));
		System.out.println("���л� 1�� : " + topScoreBySex.get(false));
		
		Map<Boolean, Student> topScoreBySex2 = Stream.of(stuArr)
				.collect(partitioningBy(Student::isMale,
						collectingAndThen(
								maxBy(comparingInt(Student::getScore)), Optional::get)));
	
		System.out.println("���л� 1�� :" + topScoreBySex2.get(true));
		System.out.println("���л� 1�� :" + topScoreBySex2.get(false));
		
		System.out.printf("%n4. ���ߺ��� (���� ���հ���, 100�� ����)%n");
		
		Map<Boolean, Map<Boolean, List<Student>>> fail = Stream.of(stuArr)
				.collect(partitioningBy(Student::isMale,
						partitioningBy(s -> s.getScore() <= 100)
						));
		
		List<Student> failedMaleStu = fail.get(true).get(true);
		List<Student> failedFemaleStu = fail.get(false).get(true);
		
		for(Student s : failedMaleStu) System.out.println(s.toString());
		for(Student s : failedFemaleStu) System.out.println(s.toString());
	}

}
