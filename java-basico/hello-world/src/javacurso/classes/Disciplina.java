package javacurso.classes;

import java.util.Arrays;

public class Disciplina {

	/* Cada disciplina tera 4 notas */
	private double[] nota = new double[4];

	private String disciplina;

	public double[] getNota() {
		return nota;
	}

	public void setNota(double[] nota) {
		this.nota = nota;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result + Arrays.hashCode(nota);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (!Arrays.equals(nota, other.nota))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListArray [nota=" + nota + ", disciplina=" + disciplina + "]";
	}

	public double getMediaNotas() {

		double somatotal = 0;

		for (int pos = 0; pos < nota.length; pos++) {

			somatotal = nota[pos];
		}

		return somatotal / nota.length;
	}

}
