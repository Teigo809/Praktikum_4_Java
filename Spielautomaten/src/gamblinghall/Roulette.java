package gamblinghall;

import java.util.Random;

public class Roulette extends SlotMachine implements GamblingMachine {
	private RouletteGameType rouletteGameType;
	private int betNumber;
	
	public Roulette(final String name) {
		super(name);//SlotMachine konstruktor aufruf
		this.rouletteGameType = RouletteGameType.BLACK;
	}
	public Roulette(final String name, int betNumber) {	//Konstruktor fuer das Spiel NUMBER
		super(name);//SlotMachine konstruktor aufruf
		if(betNumber < 0 || betNumber > 36) {
			throw new IllegalArgumentException("the Number bet must be between 0 and 36!");
		}
		this.betNumber = betNumber;
		this.rouletteGameType = RouletteGameType.NUMBER;
	}
	public Roulette (String name, RouletteGameType rouletteGameType) {	//Konstruktor fuer all die anderen Spiele
		super(name);//SlotMachine konstruktor aufruf
		if(rouletteGameType == null || rouletteGameType == RouletteGameType.NUMBER) {
			throw new IllegalArgumentException("Game Type must not be null or the type NUMBER!");
		}
		this.rouletteGameType = rouletteGameType;
	}
	
	public RouletteGameType getRouletteGameType() {
		return rouletteGameType;
	}
	public void setRouletteGameType(RouletteGameType rouletteGameType) {
		if(rouletteGameType == null) {
			throw new IllegalArgumentException("Rouelette gametype must not be null!");
		}
		this.rouletteGameType = rouletteGameType;
	}
	public int getBetNumber() {
		return betNumber;
	}
	public void setBetNumber(int betNumber) {
		if(betNumber < 0 || betNumber > 36) {
			throw new IllegalArgumentException("the Number bet must be between 0 and 36!");
		}
		this.betNumber = betNumber;
	}
	
	public double play(double stake) {
		if(stake <= 0 || stake > 10) {//prueft ob sich die Werte von stake vom Konstruktor und der Methode gleichen
			throw new IllegalArgumentException("Stake must be > 0");
		}
		countGames();	//anzahl der Spiele + 1
		calculateRevenue(stake);	//Umsatz berechnen
		int min = 0;	//Grenzen der zufaelligen Zahlen
		int max = 36;
		int random;
		Random x = new Random();	//Zufaellige Zahl generieren
		random = min + x.nextInt(max - min + 1);
		
		int [] redNumbers = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25,
							 27, 30, 32, 34, 36};	//alle roten Zahlen
		int[] blackNumbers = {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24,
							  26, 28, 29, 31, 33, 35};	//alle schwarzen Zahlen
		int[] evenNumbers = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24,
				  			 26, 28, 30, 32, 34, 36};	//alle geraden Zahlen
		int[] oddNumbers = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25,
							27, 29, 31, 33, 35};	//alle ungeraden Zahlen
		
		if(getRouletteGameType() == RouletteGameType.NUMBER) {
			if(random == betNumber) {
				countWins(stake * rouletteGameType.getAuszahlungsfaktor());
				calculateProfit(getCountGames(), getCountWins());
				return stake * rouletteGameType.getAuszahlungsfaktor();
			}
		}
		else if(getRouletteGameType() == RouletteGameType.RED) {
			for(int i = 0; i < redNumbers.length; i++) { //durchlaeuft alle roten Zahlen
				if(random == redNumbers[i]) {	//checkt ob random eine rote Zahl ist
					countWins(stake * rouletteGameType.getAuszahlungsfaktor());
					calculateProfit(getCountGames(), getCountWins());
					return stake * rouletteGameType.getAuszahlungsfaktor();
				}
			}
		}
		else if(getRouletteGameType() == RouletteGameType.BLACK) {
			for(int i = 0; i < blackNumbers.length; i++) { //durchlaeuft alle schwarzen Zahlen
				if(random == blackNumbers[i]) {	//checkt ob random eine schwarze Zahl ist
					countWins(stake * rouletteGameType.getAuszahlungsfaktor());
					calculateProfit(getCountGames(), getCountWins());
					return stake * rouletteGameType.getAuszahlungsfaktor();
				}
			}
		}
		else if(getRouletteGameType() == RouletteGameType.EVEN) {
			for(int i = 0; i < evenNumbers.length; i++) { //durchlaeuft alle geraden Zahlen
				if(random == evenNumbers[i]) {	//checkt ob random eine rote Zahl ist
					countWins((stake * rouletteGameType.getAuszahlungsfaktor()));
					calculateProfit(getCountGames(), getCountWins());
					return stake * rouletteGameType.getAuszahlungsfaktor();
				}
			}
		}
		else if(getRouletteGameType() == RouletteGameType.ODD) {
			for(int i = 0; i < oddNumbers.length; i++) { //durchlaeuft alle ungeraden Zahlen
				if(random == oddNumbers[i]) {	//checkt ob random eine rote Zahl ist
					countWins(stake * rouletteGameType.getAuszahlungsfaktor());
					calculateProfit(getCountGames(), getCountWins());
					return stake * rouletteGameType.getAuszahlungsfaktor();
				}
			}
		}
		else if(getRouletteGameType() == RouletteGameType.LOW) {
			if(random > 0 && random < 19){	//gewinn bei einer Zahl zwischen 0 und 18
				countWins(stake * rouletteGameType.getAuszahlungsfaktor());
				calculateProfit(getCountGames(), getCountWins());
				return stake * rouletteGameType.getAuszahlungsfaktor();
			}
		}
		else if(getRouletteGameType() == RouletteGameType.HIGH) {
			if(random > 18 && random < 37) {//gewinn bei einer Zahl zwischen 19 und 36
				countWins(stake * rouletteGameType.getAuszahlungsfaktor());
				calculateProfit(getCountGames(), getCountWins());
				return stake * rouletteGameType.getAuszahlungsfaktor();
			}
		}
		else if(getRouletteGameType() == RouletteGameType.P12) {
			if(random > 0 && random < 13) {	//gewinn bei einer Zahl im unteren drittel
				countWins(stake * rouletteGameType.getAuszahlungsfaktor());
				calculateProfit(getCountGames(), getCountWins());
				return stake * rouletteGameType.getAuszahlungsfaktor();
			}
		}
		else if(getRouletteGameType() == RouletteGameType.M12) {
			if(random > 12 && random < 25) {//gewinn bei einer Zahl im mittleren drittel
				countWins(stake * rouletteGameType.getAuszahlungsfaktor());
				calculateProfit(getCountGames(), getCountWins());
				return stake * rouletteGameType.getAuszahlungsfaktor();
			}
		}
		else if(getRouletteGameType() == RouletteGameType.D12) {
			if(random > 24 && random < 37) {//gewinn bei einer Zahl im oberen drittel
				countWins(stake * rouletteGameType.getAuszahlungsfaktor());
				calculateProfit(getCountGames(), getCountWins());
				return stake * rouletteGameType.getAuszahlungsfaktor();
			}
		}
		calculateProfit(getCountGames(), getCountWins());
		return 0;
	}
	
	@Override
	public String toString() {
		if(rouletteGameType == RouletteGameType.NUMBER) {
			return String.format("Rouletteautomat %s: Es wird %s(%d) gespielt", getName(), rouletteGameType.getName(), getBetNumber());
		}
		else {
			return String.format("Rouletteautomat %s: Es wird %s gespielt", getName(), rouletteGameType.getName());
		}
	}
	
	@Override
	public double getRealPayOutRate() {	//Interface fuer die Auszahlungsquote
		return (getCountGames() - getProfit()) / getCountGames();
	}
}
