

public class Student {
	
	private String apellido;
	private int codigo;
	private double promedio;
	

	public String getApellido() {
		return apellido;
	}
	private void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getCodigo() {
		return codigo;
	}
	private void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getPromedio() {
		return promedio;
	}
	
	public Double getPromediot() {
		return promedio;
	}
	private void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	
	public  Student (String apellido, int codigo, double promedio){
		this.setApellido(apellido);
		this.setCodigo(codigo);
		this.setPromedio(promedio);
	}

}
