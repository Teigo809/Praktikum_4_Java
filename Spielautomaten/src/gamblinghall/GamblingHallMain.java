package gamblinghall;

import static java.lang.System.out;

public class GamblingHallMain {

	public static void main(String[] args) {
		DoubleShot ds1 = new DoubleShot("Einarmiger Bandit");
		DoubleShot ds2 = new DoubleShot("Zweiarmiger Bandit", 2);
		
		Roulette r1 = new Roulette("Monte Carlo");
		Roulette r2 = new Roulette("Las Vegas", 3);
		Roulette r3 = new Roulette("Macao", RouletteGameType.EVEN);
		
		ArcadeFun af1 = new ArcadeFun("Crazy Pony");
		ArcadeFun af2 = new ArcadeFun("Flip Flop", 2);

		for (int i = 0; i < 1000000; i++) {
			ds1.play(1);
			ds2.play(2);
			
			r1.play(1);
			r2.play(1);
			r3.play(1);
			
			af1.play(1);
			af2.play(2);
		}
		out.printf("Name: %s, Spiele:%d, Jackpot gewonnen:%d, Wins:%d, Jackpot:%.2f, Profit:%.2f, Revenue:%.2f, Auszahlungsquote: %.2f%% %n",ds1.getName(), ds1.getCountGames(),ds1.getCountJackpot(), ds1.getCountWins(), ds1.getJackpot(),ds1.getProfit(), ds1.getRevenue(), ds1.getRealPayOutRate() * 100);
		out.printf("Name: %s, Spiele:%d, Jackpot gewonnen:%d, Wins:%d, Jackpot:%.2f, Profit:%.2f, Revenue:%.2f, Auszahlungsquote: %.2f%% %n",ds2.getName(), ds2.getCountGames(),ds2.getCountJackpot(), ds2.getCountWins(), ds2.getJackpot(),ds2.getProfit(), ds2.getRevenue(), ds1.getRealPayOutRate() * 100);
		
		out.printf("Name: %s, Spiele:%d, Wins:%d, Profit:%.2f, Revenue:%.2f, Auszahlungsquote: %.2f%% %n",r1.getName(), r1.getCountGames(), r1.getCountWins(),r1.getProfit(), r1.getRevenue(), r1.getRealPayOutRate() * 100);
		out.printf("Name: %s, Spiele:%d, Wins:%d, Profit:%.2f, Revenue:%.2f, Auszahlungsquote: %.2f%% %n",r2.getName(), r2.getCountGames(), r2.getCountWins(),r2.getProfit(), r2.getRevenue(), r2.getRealPayOutRate() * 100);
		out.printf("Name: %s, Spiele:%d, Wins:%d, Profit:%.2f, Revenue:%.2f, Auszahlungsquote: %.2f%% %n",r3.getName(), r3.getCountGames(), r3.getCountWins(),r3.getProfit(), r3.getRevenue(), r3.getRealPayOutRate() * 100);
		out.println(r1.toString());
		out.println(r2.toString());
		out.println(r3.toString());
	}

}
