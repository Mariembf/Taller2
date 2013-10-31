
import java.util.*;

public class  MyComparator  implements Comparator<Student>{

	
	public  int compare(Student a, Student b) {
		return a.getPromediot().compareTo(b.getPromediot());

	}
	


	
}