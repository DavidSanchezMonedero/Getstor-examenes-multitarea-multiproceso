
public class Examinador implements Runnable {
	private Thread hilo;
	BufferExamenes buffer;
	String[] respuesta = {"A","B","C","D","-"};



	public Examinador(String alumno, BufferExamenes generador) {
		// Construye el hilo. El nombre será el nombre del alumno.
		
		hilo = new Thread(this,alumno);

		// Establece el valor de la propiedad buffer
		this.buffer = generador;

		// Inicia el hilo.
		hilo.start();

	}

	@Override
	public void run() {
		
		String frase = this.buffer.consumirExamen();
		if (frase != null) {
			for(int i = 0;i<=10;i++) {
				System.out.println(frase+";"+hilo.getName()+";"+"Pregunta "+i+";"+respuesta[(int) (Math.random()*5)]);
			}
		} else {
			System.out.println("Agotado tiempo de espera y " + "no hay más exámenes");
		}
	}
}
