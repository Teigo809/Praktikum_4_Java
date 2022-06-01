package gamblinghall;

public class ArcadeFun	extends SlotMachine {
	private int stake;
	
	public ArcadeFun(final String name) {
		super(name);	//SlotMachine konstruktor aufruf
		this.stake = 1;
	}
	public ArcadeFun(final String name, int stake) {
		super(name);	//SlotMachine konstruktor aufruf
		if(stake < 1 || stake > 10) {
			throw new IllegalArgumentException("Stake must be between 1 and 10");
		}
		this.stake = stake;
	}
	public int getStake() {
		return stake;
	}
	
	public double play(double stake) {
		if(this.stake != stake) {//prueft ob sich die Werte von stake vom Konstruktor und der Methode gleichen
			throw new IllegalArgumentException("the values of stake must be the same!");
		}
		countGames();	//anzahl der Spiele zaehlen
		calculateRevenue(stake); //Umsatz berechnen
		calculateProfit(getCountGames(), getCountWins()); //profit berechnen
		return 0;
	}
}
