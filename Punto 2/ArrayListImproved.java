import java.util.Comparator;
import java.util.List;
import java.util.Scanner;



public class ArrayListImproved<E> extends java.util.ArrayList <E> { //agregar , Comparable para el sort comparador


	public void quicksort (int start, int end, Comparator <E> c){


		//condiciones para el quicksort
		int i, j, central;
		E pivote;
		central = (start + end)/2;
		pivote = this.get(central);
		i= start;
		j= end;

		do {

			while  ((c.compare(this.get(i),pivote)) <0 )
				i++;

			while  ((c.compare(this.get(j), pivote)) >0)
				j--;


			if (i<=j){  //cambio de elementos
				E tmp = this.get(i);
				this.set(i, this.get(j));
				this.set(j,tmp);
				i++;
				j--;
			}

		} while (i<=j);
		//recursion
		if (start <j)
			quicksort (start, j, c);
		if (i <end)
			quicksort (i, end, c);

	}

	
	//este algoritmo es tomado de la siguiente pagina web :   
	//   http://nayuki.eigenstate.org/res/next-lexicographical-permutation-algorithm/nextperm.java
	public static <E> boolean nextPermutation(ArrayListImproved<Student> array, MyComparator2 comp) {
		// Find non-increasing suffix
		int i = array.size() - 1; 
		while (i > 0 && comp.compare(array.get(i - 1), array.get(i)) >= 0)
			i--;
		if (i <= 0)
			return false;

		// Find successor to pivot
		int j = array.size() - 1;
		while (comp.compare(array.get(j), array.get(i - 1)) <= 0)
			j--;
		Student temp = array.get(i - 1);
		array.set(i - 1, array.get(j));
		array.set(j, temp);

		// Reverse suffix
		j = array.size() - 1;
		while (i < j) {
			temp = array.get(i);
			array.set(i, array.get(j));
			array.set(j, temp);
			i++;
			j--;
		}
		return true;
	}


	public static void main(String[] args) {

		Student uno, dos ,tres, cuatro ,cinco , seis, siete, ocho, nueve, diez;
		
		uno= new Student("Lopez", 258381, 4);
		dos= new Student("Medina", 258382, 4);
		tres= new Student("Fernandez", 258383, 1.9);
		cuatro= new Student("Zuluaga", 258384, 2.2);
		cinco= new Student("Rincon", 258385, 5);
		seis= new Student("Acuña", 258386, 2.5);
		siete= new Student("Barrios", 258387, 4.4);
		ocho= new Student("Cardenas", 258388, 3);
		nueve= new Student("Diaz", 258389, 3.9);
		diez= new Student("Diaz", 258380, 4.8);


		ArrayListImproved<Student> a = new ArrayListImproved<>();
		MyComparator compprom = new MyComparator(); //comparador por promedio
		MyComparator2 compapellid = new MyComparator2();


		a.add(uno);
		a.add(dos);
		a.add(tres);
		a.add(cuatro);


		System.out.println("La lista de Estudiantes es " );
		for (int i = 0; i < a.size(); i++) {
			System.out.println("Apellido "  +a.get(i).getApellido());

		}
			
		
				//Calculo de numero de permutaicones de la lista a
		int fac=1;
		for (int conta=1;conta <= a.size(); conta++){
			fac=fac*conta;
		}

        // calculo de todas las permutaciones
		for (int i = 0; i < fac; i++) {
			nextPermutation(a, compapellid);
			System.out.println("La permutacion " + i + "  es " );
			for (int j = 0; j < a.size(); j++) {
				System.out.println(" Apellido " + a.get(j).getApellido());
			}
		}



	}
}