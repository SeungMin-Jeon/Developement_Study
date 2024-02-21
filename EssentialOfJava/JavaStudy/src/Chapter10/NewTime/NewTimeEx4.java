package Chapter10.NewTime;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class NewTimeEx4 {

	public static void main(String[] args) {
		LocalDate date1 = LocalDate.of(2014, 1, 1);
		LocalDate date2 = LocalDate.of(2015, 12, 31);
		
		Period pe = Period.between(date1, date2);
		
		System.out.println("date1=" + date1);
		System.out.println("date2=" + date2);
		System.out.println("pe=" + pe);
		
		System.out.println("YEAR" + pe.get(ChronoUnit.YEARS));
		System.out.println("YEAR" + pe.get(ChronoUnit.YEARS));
		System.out.println("YEAR" + pe.get(ChronoUnit.YEARS));
				
	}

}
