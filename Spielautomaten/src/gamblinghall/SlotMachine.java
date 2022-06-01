package gamblinghall;

import java.util.Objects;

public abstract class SlotMachine {
	private final String name;
	private double revenue;
	private double profit;
	private int countGames;
	private int countWins;
	
	public SlotMachine(final String name) {
		if(name == null || name.isEmpty()) {//name darf nicht null oder leer sein
			throw new IllegalArgumentException("Name must not be null or empty");
		}
		this.name = name;
		this.revenue = 0;
		this.profit = 0;
		this.countGames = 0;
		this.countWins = 0;
	}
	public String getName() {
		return name;
	}
	public double getRevenue() {
		return revenue;
	}
	public double getProfit() {
		return profit;
	}
	public int getCountGames() {
		return countGames;
	}
	public int getCountWins() {
		return countWins;
	}
	
	
	public void payIn(double cash) {	//Stellt eine Einzahlung dar
		if(cash < 0) {
			throw new IllegalArgumentException("Cash must be > 0");
		}
	}
	public void payOut(double cash) {	//Stellt eine Auszahlung dar
		if(cash < 0) {
			throw new IllegalArgumentException("Cash must be > 0");
		}
	}
	
	
	public abstract double play(double stake);	//abstrakte Methode play
	
	
	public double calculateRevenue(double stake) {	//Umsatz des Automaten berechnen
		return this.revenue += stake;
	}
	public double calculateProfit(double countGames, double countWins) {	//Profit berechnen
		return this.profit = getCountGames() - getCountWins();
	}
	public int countGames() {	//Anzahl der gespieleten Spiele zaehlen
		return this.countGames++;
	}
	public int countWins(double stake) {	//Anzahl der gewonnen Spiele zaehlen
		return this.countWins += stake;
	}
	
	
	@Override
	public boolean equals(Object other) {
		if(this == other) {		//Identitaet pruefen
			return true;
		}
		if(other == null) {		//auf null pruefen
			return false;
		}
		if(getClass() != other.getClass()) {	//gleichheit der Typen pruefen
			return false;
		}
		SlotMachine otherSlotMachine = (SlotMachine) other;		//cast
		
		if(!Objects.equals(name, otherSlotMachine.getName())) {	//name als unterscheidendes Merkmal
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s", name);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;	//name als unterscheidendes Merkmal
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
}
