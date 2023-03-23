package view;

import java.util.concurrent.Semaphore;

import controller.AbstrataPiloto;
import controller.ThreadFormula1;

public class Principal {

	public static void main(String[] args) {
		AbstrataPiloto[] acarro = new AbstrataPiloto[14];
		int vetorEquipe[] = {0, 1, 2, 3, 4, 5, 6} /*{"Ferrari", "Mercedez", "McLaren", "Red Bull", "Willians", "Haas", "Alpha Romeo"}*/;
		int vetor[] = new int[7];
		int permissoes = 1;
		Semaphore mutex = new Semaphore(permissoes);
		Semaphore vetorPista[] = new Semaphore[7];
		Semaphore farol5 = new Semaphore(5);
		Semaphore grid = new Semaphore(1);
		int vetorGrid[] = new int[14];
		
		for(int i = 0; i < 7; i++) {
			vetorPista[i] = new Semaphore(1);
		}
		
		for(int i = 0; i < 14; i++) {
			acarro[i] = new AbstrataPiloto();
		}
		
		for(int piloto = 0; piloto < 14; piloto++) {
			ThreadFormula1 tformula = new ThreadFormula1(acarro, piloto, vetorEquipe, vetor, mutex, vetorPista, farol5, vetorGrid, grid);
			tformula.start();
		}
	}

}
