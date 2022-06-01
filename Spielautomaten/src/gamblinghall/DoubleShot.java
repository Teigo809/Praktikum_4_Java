package gamblinghall;

import java.lang.Math;

public class DoubleShot extends SlotMachine implements GamblingMachine{
	private final int stake;
	private double jackpot;
	private int countJackpot;
	
	public DoubleShot(final String name, final int stake) {
		super(name);//SlotMachine konstruktor aufruf
		if(stake < 1 || stake > 10) {
			throw new IllegalArgumentException("Stake must be between 1 and 10");
		}
		this.stake = stake;
	}
	public DoubleShot(final String name) {
		super(name);
		this.stake = 1;
	}
	
	public int getStake() {
		return stake;
	}
	public double getJackpot() {
		return jackpot;
	}
	public int getCountJackpot() {
		return countJackpot;
	}
	
	public double resetJackpot(double jackpot) {	//Jackpot nach gewinn auf 0 setzen
		return this.jackpot = 0;
	}
	
	public double play(double stake) {
		if(this.stake != stake) {	//prueft ob sich die Werte von stake vom Konstruktor und der Methode gleichen
			throw new IllegalArgumentException("the values of stake must be the same!");
		}
		countGames();	//anzahl der Spiele + 1
		calculateRevenue(stake);	//Einsatz zum Umsatz hinzuzaehlen
		jackpot += 0.1 * stake;		//10 Prozent des Einsatzes in den jackpot
		double random;	//Zufallszahl zwischen 0 und 1 erstellen
		random = Math.random();
		if(random < 0.001) {	//Gewinnchance von 0,1% fuer den jackpot
			countWins(1);	//anzahl der Siege + 1
			countJackpot++;		//Anzahl der jackpot gewinne + 1
			resetJackpot(jackpot);	//Jackpot nach gewinn auf 0 setzen
			return 1;
		}
		else if(random < 0.92) {	//92%ige chance zu gewinnen
			countWins(1);
			return 1;
		}
		calculateProfit(getCountGames(), getCountWins());	//Profit des Automaten berechnen
		return 0;	//falls nichts gewonnen
	}
	
	@Override
	public double getRealPayOutRate() {	//Interface fuer die Auszahlungsquote
		return (getCountGames() - getProfit()) / getCountGames();
	}
}
