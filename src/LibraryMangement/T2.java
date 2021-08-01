
 package LibraryMangement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class T2 {
	public static void main(String args)
	{
		LocalDate ld=LocalDate.now();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		LocalDate nextWeek = ld.plus(1, ChronoUnit.WEEKS);
		
		System.out.println("{today is "+ld);
		System.out.println("one week is "+nextWeek);
	}

}
