package view;

import java.util.concurrent.Semaphore;

import controller.AbstrataPiloto;
import controller.ThreadFormula1;

public class Principal {

	public static void main(String[] args) {
		AbstrataPiloto[] acarro = new AbstrataPiloto[14];
		String vetorEquipe[] = {"Ferrari", "Mercedez", "McLaren", "Red Bull", "Willians", "Haas", "Alpha Romeo"};
		int vetor[] = new int[7];
		
		for(int i = 0; i < 14; i++) {
			acarro[i] = new AbstrataPiloto();
		}
		
		int permissoes = 1;
		Semaphore mutex = new Semaphore(permissoes);
		int permissoespista = 5;
		Semaphore semaforopista = new Semaphore(permissoespista);
		
		for(int piloto = 0; piloto < 14; piloto++) {
			ThreadFormula1 tformula = new ThreadFormula1(acarro, piloto, vetorEquipe, vetor, mutex, semaforopista);
			tformula.start();
		}
	}

}
