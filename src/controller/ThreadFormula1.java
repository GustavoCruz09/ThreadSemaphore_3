package controller;

import java.util.concurrent.Semaphore;

public class ThreadFormula1 extends Thread {

	public AbstrataPiloto[] acarro;
	private int piloto;
	private String[] vetorEquipe;
	private Semaphore mutex;
	private Semaphore semaforopista;

	public ThreadFormula1(AbstrataPiloto[] acarro, int piloto, String[] vetorEquipe, int[] vetor, Semaphore mutex, Semaphore semaforopista) {
		this.acarro = acarro;
		this.piloto = piloto;
		this.vetorEquipe = vetorEquipe;
		this.mutex = mutex;
		this.semaforopista = semaforopista;
	}

	@Override
	public void run() {

		try {
//			System.out.println("APRESENTACAO DOS PILOTOS");
			mutex.acquire();
			preeencheEquipe();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mutex.release();
		}

		try {
			semaforopista.acquire();
			Qualificacao();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforopista.release();
		}

	}

	private void preeencheEquipe() {
		
		if(piloto == 0 || piloto == 1) {
			acarro[piloto].carro = piloto;
			acarro[piloto].equipe = vetorEquipe[0];
		} 
		if(piloto == 2 || piloto == 3) {
			acarro[piloto].carro = piloto;
			acarro[piloto].equipe = vetorEquipe[1];
		} 
		if(piloto == 4 || piloto == 5) {
			acarro[piloto].carro = piloto;
			acarro[piloto].equipe = vetorEquipe[2];
		} 
		if(piloto == 6 || piloto == 7 ) {
			acarro[piloto].carro = piloto;
			acarro[piloto].equipe = vetorEquipe[3];
		}
		if(piloto == 8 || piloto == 9) {
			acarro[piloto].carro = piloto;
			acarro[piloto].equipe = vetorEquipe[4];
		} 
		if(piloto == 10 || piloto == 11) {
			acarro[piloto].carro = piloto;
			acarro[piloto].equipe = vetorEquipe[5];
		}
		if(piloto == 12 || piloto == 13) {
			acarro[piloto].carro = piloto;
			acarro[piloto].equipe = vetorEquipe[6];
		} 
		
		System.out.println("O piloto " + acarro[piloto].carro + " da escuderia " + acarro[piloto].equipe + " está pronto");
		
	}

	private void Qualificacao() {
		
		
		
	}

}
