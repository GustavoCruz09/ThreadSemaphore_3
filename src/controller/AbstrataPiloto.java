package controller;

public class AbstrataPiloto {
	
	public int carro;
	public String equipe;
	public int volta;

	public AbstrataPiloto() {
		this(0, "", 0);
	}
	
	public AbstrataPiloto(int carro, String equipe, int volta) {
		carro = carro;
		equipe = equipe;
		volta = volta;
	}

}
