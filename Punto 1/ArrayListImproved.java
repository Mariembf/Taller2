
import java.util.Comparator;
import java.util.Scanner;



public class ArrayListImproved<E> extends java.util.ArrayList <E>  { //agregar , Comparable para el sort comparador


	


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


	
	public static int binarySeach (ArrayListImproved <Student> a , Double key){

		if (a ==null || key == null){
			throw new
			NullPointerException ("a == null || key == null");
		}

		if (a.size()==0){
			return -1;
		}
		int izq=0, der= a.size()-1;
		int x=0;
		while (der>=izq) {
			//x= (izq+der)/2;
			x=(izq+der)>>1;

		if(a.get(x).getPromediot().compareTo(key)==0){
			return x;
		}

		if (a.get(x).getPromediot().compareTo(key)>0)
			der= x-1;
		else{
			izq = x+1;
		}
		}

		return -1;
	}

	public static void main(String[] args) {


		double promed=0;   //se guarda el dato de promedio recibido
		int nores =0;    //se guarda el dato de respuestas queridas
		int idxfind=0;
		Scanner sc = new Scanner(System.in);

//creacion de estudiantes
		Student uno, dos ,tres, cuatro ,cinco , seis, siete, ocho, nueve, diez;
		uno= new Student("Lopez", 258381, 4);
		dos= new Student("Medina", 258382, 4);
		tres= new Student("Fernandez", 258383, 1.9);
		cuatro= new Student("Zuluaga", 258384, 2.2);
		cinco= new Student("Rincon", 258385, 4.2);
		seis= new Student("Acuña", 258386, 2.5);
		siete= new Student("Barrios", 258387, 4.4);
		ocho= new Student("Cardenas", 258388, 3);
		nueve= new Student("Diaz", 258389, 3.9);
		diez= new Student("Fernandez", 258380, 4.1);
		
		ArrayListImproved<Student> a = new ArrayListImproved<>(); //lista de estudiantes
		
		MyComparator compprom = new MyComparator();  //comparador por promedio
		MyComparator2 compapellid = new MyComparator2();  //comparador por Apellido


		//		System.out.println(" Digite el promedio que desea consultar use , para separar decimales ");
		//		promed = sc.nextDouble();
		//		
		//       while (!(promed >=0 && promed <=5)) { //CONDICION DE ACEPTAR EL PROMEDIO INGRESADO
		//    	   System.out.println(" Digite un promedio entre 0 y 5 use , para separar decimales ");
		//   		   promed = sc.nextDouble();
		//		}
		//	
		//		System.out.println(" Digite el numero de personas a consultar ");	
		//		nores = sc.nextInt();
		//		
		//		while (!(nores>0)) {
		//			System.out.println(" Digite un numero mayor 0 porfavor ");
		//	   		   nores = sc.nextInt();
		//		}
		//		
		//		System.out.println("El numero de usuarios pedidos es  " + nores + " El numero promedio pedido mayor o iguaul a " + promed );
		//		


		

		a.add(uno);
		a.add(dos);
		a.add(tres);
		a.add(cuatro);
		a.add(cinco);
		a.add(seis);
		a.add(siete);
		a.add(ocho);
		a.add(nueve);
		a.add(diez);

		System.out.println("La lista de Estudiantes es " );
		for (int i = 0; i < 10; i++) {
			System.out.println("Apellido "  +a.get(i).getApellido()  + "  Codigo " + a.get(i).getCodigo() + " Promedio " + a.get(i).getPromedio());

		}


		a.quicksort(0, 9, compapellid); //quicksort por comparador apelllido 
		System.out.println("La lista de estu ordenada Por apellidos es " );

		for (int i = 0; i < a.size(); i++) {
			System.out.println("Apellido "  +a.get(i).getApellido()  + "  Codigo " + a.get(i).getCodigo() + " Promedio " + a.get(i).getPromedio() );

		}

		System.out.println("La lista ordenada por promedio es ");
		a.quicksort(0, 9, compprom);

		for (int i = 0; i < a.size(); i++) {
			System.out.println("Apellido "  +a.get(i).getApellido()  + "  Codigo " + a.get(i).getCodigo() + " Promedio " + a.get(i).getPromedio() );

		}

		System.out.println(" Probando la busqueda binaria " );
		//estos datos pueden ser inresados por el usuario
		promed=4.8;
		idxfind=	binarySeach(a,  promed);
		nores=10;


		//si no encontro nada
		if (idxfind==-1 && promed <5){
			while(idxfind==-1){
				promed = promed + 0.1;
				idxfind =binarySeach(a,  promed);
				if (promed>5){
					System.out.println(" No existen estudiantes con promedio igual o mayor a esa condición " );
				idxfind=0;
				}	
			}
		}

		if (!(idxfind==-1) && !(idxfind==0))  //si encontro algo
			for (int i = 0; i < nores; i++) {
				if(idxfind< a.size()){
					System.out.println("Apellido "  +a.get(idxfind).getApellido()  + "  Codigo " + a.get(idxfind).getCodigo() + " Promedio "
							+ a.get(idxfind).getPromedio() );
					idxfind++;
				}

			}



	}

}
