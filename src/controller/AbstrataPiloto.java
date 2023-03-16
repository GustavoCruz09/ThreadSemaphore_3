package controller;

public class AbstrataPiloto {
	
	int carro;
	String equipe;
	int volta;

	public AbstrataPiloto() {
		this(0, "", 0);
	}
	
	public AbstrataPiloto(int carro, String equipe, int volta) {
		carro = carro;
		equipe = equipe;
		volta = volta;
	}

}
