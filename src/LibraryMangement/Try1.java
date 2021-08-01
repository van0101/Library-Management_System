
 package LibraryMangement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Try1 {
	public static void main(String args[])
	{
		LocalDate ld=LocalDate.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		
		
		LocalDate nextWeek = ld.plus(1, ChronoUnit.WEEKS);
		String t=ld.format(formatter);
		String d=nextWeek.format(formatter);
		System.out.println("{today is "+t);
		System.out.println("one week is "+d);
	}

}
