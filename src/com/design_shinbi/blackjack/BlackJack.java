package com.design_shinbi.blackjack;

import java.util.Scanner;

public class BlackJack {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		start(scanner);
		scanner.close();
	}

	public static void start(Scanner scanner) {
		Player player = new Player(scanner);
		Dealer dealer = new Dealer();
		Stock stock = new Stock();

		player.start(stock);
		dealer.start(stock);
		dealer.display();
		dealer.play(stock);
		player.play(stock);
		showResult(player, dealer);
	}

	public static void showResult(Attender player, Attender dealer) {
		dealer.display();
		player.display();
		int dealerResult = dealer.calculateStrength();
		int playerResult = player.calculateStrength();

		if (playerResult > dealerResult) {
			System.out.println("ディーラーの合計 : " + dealerResult);
			System.out.println("あなたの勝ちです！！");
		} else if (playerResult < dealerResult) {
			System.out.println("ディーラーの合計 :  " + dealerResult);
			System.out.println("あなたの負けです");
		} else {
			System.out.println("ディーラーの合計： " + dealerResult);
			System.out.println("引き分けです");
		}
	}

}
