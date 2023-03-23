package controller;

import java.util.concurrent.Semaphore;

public class ThreadFormula1 extends Thread {

	public AbstrataPiloto[] acarro;
	private int piloto;
	private int[] vetorEquipe;
	private Semaphore mutex;
	private Semaphore[] vetorPista;
	private Semaphore farol5;
	private int x = 1;
	private int[] vetorGrid;
	private Semaphore grid;
	private static int z = 0;

	public ThreadFormula1(AbstrataPiloto[] acarro, int piloto, int[] vetorEquipe, int[] vetor, Semaphore mutex,
			Semaphore[] vetorPista, Semaphore farol5, int vetorGrid[], Semaphore grid) {
		this.acarro = acarro;
		this.piloto = piloto;
		this.vetorEquipe = vetorEquipe;
		this.mutex = mutex;
		this.vetorPista = vetorPista;
		this.farol5 = farol5;
		this.vetorGrid = vetorGrid;
		this.grid = grid;
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
			sleep(1500);
			SelecaoPorEscuderia();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			sleep(1500);
			GridDeLargada();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void preeencheEquipe() {

		if (piloto == 0 || piloto == 1) {
			acarro[piloto].carro = piloto;
			acarro[piloto].equipe = vetorEquipe[0];
		}
		if (piloto == 2 || piloto == 3) {
			acarro[piloto].carro = piloto;
			acarro[piloto].equipe = vetorEquipe[1];
		}
		if (piloto == 4 || piloto == 5) {
			acarro[piloto].carro = piloto;
			acarro[piloto].equipe = vetorEquipe[2];
		}
		if (piloto == 6 || piloto == 7) {
			acarro[piloto].carro = piloto;
			acarro[piloto].equipe = vetorEquipe[3];
		}
		if (piloto == 8 || piloto == 9) {
			acarro[piloto].carro = piloto;
			acarro[piloto].equipe = vetorEquipe[4];
		}
		if (piloto == 10 || piloto == 11) {
			acarro[piloto].carro = piloto;
			acarro[piloto].equipe = vetorEquipe[5];
		}
		if (piloto == 12 || piloto == 13) {
			acarro[piloto].carro = piloto;
			acarro[piloto].equipe = vetorEquipe[6];
		}

		System.out.println(
				"O piloto " + acarro[piloto].carro + " da escuderia " + acarro[piloto].equipe + " está pronto");

	}

	private void SelecaoPorEscuderia() {

		if (acarro[piloto].equipe == 0) {
			try {
				vetorPista[0].acquire();
				Qualificacao();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				vetorPista[0].release();
			}

		}
		if (acarro[piloto].equipe == 1) {
			try {
				vetorPista[1].acquire();
				Qualificacao();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

				vetorPista[1].release();
			}
		}
		if (acarro[piloto].equipe == 2) {
			try {
				vetorPista[2].acquire();
				Qualificacao();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

				vetorPista[2].release();
			}
		}
		if (acarro[piloto].equipe == 3) {
			try {
				vetorPista[3].acquire();
				Qualificacao();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				vetorPista[3].release();
			}
		}
		if (acarro[piloto].equipe == 4) {
			try {
				vetorPista[4].acquire();
				Qualificacao();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				vetorPista[4].release();
			}
		}
		if (acarro[piloto].equipe == 5) {
			try {
				vetorPista[5].acquire();
				Qualificacao();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				vetorPista[5].release();
			}
		}
		if (acarro[piloto].equipe == 6) {
			try {
				vetorPista[6].acquire();
				Qualificacao();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

				vetorPista[6].release();
			}
		}

	}

	private void Qualificacao() {
		int volta;

		try {
			farol5.acquire();
			System.out.println(
					"O piloto " + acarro[piloto].carro + " (escuderia " + acarro[piloto].equipe + ") entrou na pista");
			while (x <= 3) {
				if (x == 1) {
					acarro[piloto].volta = (int) (Math.random() * 91) + 30;
					System.out
							.println("O piloto " + piloto + " fez a " + x + " volta em " + acarro[piloto].volta + ".s");
				} else {
					volta = (int) (Math.random() * 91) + 30;
					System.out.println("O piloto " + piloto + " fez a " + x + " volta em " + volta + ".s");
					if (volta < acarro[piloto].volta) {
						acarro[piloto].volta = volta;
					}
				}
				x++;
			}
			System.out.println(
					"O piloto " + acarro[piloto].carro + " (escuderia " + acarro[piloto].equipe + ") saiu da pista");
			vetorGrid[piloto] = acarro[piloto].volta;

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			farol5.release();

		}

	}

	private void GridDeLargada() {
		int aux = 0, i = 0, j = 0, cta = 0;
		
		try {
			grid.acquire();
			for (i = 0; i < 14; i++) {
				for (j = i + 1; j < 14; j++) {
					if (vetorGrid[i] > vetorGrid[j]) {
						aux = vetorGrid[i];
						vetorGrid[i] = vetorGrid[j];
						vetorGrid[j] = aux;
					}
				}
			}
			for (cta = 0; cta < 14; cta++) {
				System.out.println(acarro[cta].carro + " (" + acarro[cta].equipe + ") volta:" + vetorGrid[cta]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			grid.release();
		}
		
	}

}
