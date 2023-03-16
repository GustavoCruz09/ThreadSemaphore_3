package controller;

import java.util.concurrent.Semaphore;

public class ThreadFormula1 extends Thread {
	
	private AbstrataPiloto acarro;
	private int piloto;
	private String[] vetorEquipe;
	private String[] vetor;
	private Semaphore mutex;
	private Semaphore semaforopista;
	private static int ctd = 1;
	private static int i = 0;
	private static int indice = 0;
	private static String frase = "";

	public ThreadFormula1(AbstrataPiloto acarro, int piloto, String[] vetorEquipe, String[] vetor, Semaphore mutex, Semaphore semaforopista) {
		this.acarro = acarro;
		this.piloto = piloto;
		this.vetorEquipe = vetorEquipe;
		this.vetor = vetor;
		this.mutex = mutex;
		this.semaforopista = semaforopista;
	}
	
	@Override
	public void run() {
		
		try {
			mutex.acquire();
			preeencheEquipe();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mutex.release();
		}
		
		try {
			semaforopista.acquire();
			Corrida();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforopista.release();
		}
		
	}

	private void preeencheEquipe() {
		
		if(ctd < 2) {
			acarro.equipe = vetorEquipe[i];
			acarro.carro = piloto;
			frase = "Piloto " + acarro.carro + " da Escuderia " + acarro.equipe ;
			System.out.println(frase);
			ctd++;
		} else{
			if(ctd ==2) {
				acarro.equipe = vetorEquipe[i];
				acarro.carro = piloto;
				frase = "Piloto " + acarro.carro + " da Escuderia " + acarro.equipe ;
				System.out.println(frase);
			} 
			i++;
			ctd = 1;
		}
		
	}
	
	private void Corrida() {
		System.out.println("O piloto " + acarro.carro + " (" + acarro.equipe + ") saiu da pista");
		int TamanhoPista = 100;
		int percorrida = 0;
		int movimento = (int) ((Math.random() * 50) + 0);
		int tempo = 1000;
		while(percorrida < TamanhoPista) {
			percorrida += movimento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("O piloto " + acarro.carro + " (" + acarro.equipe + ") andou " + percorrida + " metros");
		}
		System.out.println("O piloto " + acarro.carro + " (" + acarro.equipe + ") saiu da pista");
	}
	
}
