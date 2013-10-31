import java.util.Comparator;


public class MyComparator2 implements Comparator<Student> {

	@Override
	public int compare(Student a, Student b) {
		
		return a.getApellido().compareTo(b.getApellido());
	}

}
