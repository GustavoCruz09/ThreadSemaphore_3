package view;

import java.util.concurrent.Semaphore;

import controller.AbstrataPiloto;
import controller.ThreadFormula1;

public class Principal {

	public static void main(String[] args) {
		AbstrataPiloto acarro = new AbstrataPiloto();
		String vetorEquipe[] = {"Ferrari", "Mercedez", "McLaren", "Red Bull", "Willians", "Haas", "Alpha Romeo"};
		String vetor[] = {"", "", "", "",""}/*new String [5]*/;
//		String frase = ("Piloto " + acarro.carro + " da Escuderia " + acarro.equipe);
		
		for(int i = 0; i < 14; i++) {
			acarro = new AbstrataPiloto();
		}
		
		int permissoes = 1;
		Semaphore mutex = new Semaphore(permissoes);
		int permissoespista = 5;
		Semaphore semaforopista = new Semaphore(permissoespista);
		
		for(int piloto = 1; piloto <= 14; piloto++) {
			ThreadFormula1 tformula = new ThreadFormula1(acarro, piloto, vetorEquipe, vetor, mutex, semaforopista);
			tformula.start();
		}
	}

}
