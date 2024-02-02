package com.design_shinbi.blackjack;

import java.util.ArrayList;
import java.util.List;

/** 
 * カード管理クラス(1オブジェクトが1枚のカード)
 */
public class Card {
	private Suit suit;
	private int number;

	/**
	 * コンストラクター
	 * @param suit
	 * @param number
	 */
	public Card(Suit suit, int number) {
		this.suit = suit;
		this.number = number;
	}

	/**
	 * カードのマークを取得する
	 * @return カードのマーク
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * カードの数字を取得する
	 * @return カードの数字
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * 数字の文字列の取得
	 * @param number 数字
	 * @return 数字の文字列
	 */
	//	数字の文字列を取得する・・・「1→A」 「11→J」等　static⇔dynamic(書かない)　dynamic=オブジェクトごとの情報や処理　static=オブジェクトに依存しない
	public static String getNumberString(int number) {
		String string = null;

		if (number == 1) {
			string = "A";
		} else if (number == 11) {
			string = "J";
		} else if (number == 12) {
			string = "Q";
		} else if (number == 13) {
			string = "K";
		} else if (number >= 2 && number <= 10) {
			string = Integer.toString(number);
		}

		return string;
	}

	/**
	 * カードの文字列の取得
	 * (例:[スペードのA],[スペードの2],・・・)
	 */
	public String toString() {
		String string = String.format("[%s%s]", this.suit.getName(), getNumberString(this.number));
		return string;
	}

	/**
	 * すべてのカードを取得する
	 * @return すべてのカードのリスト
	 */
	//	すべてのカードを取得
	public static List<Card> getAllCards() {
		List<Card> list = new ArrayList<Card>();

		for (Suit suit : Suit.values()) { //		それぞれのマークの
			for (int number = 1; number <= 13; number++) { //それぞれの数字に対して
				Card card = new Card(suit, number);
				list.add(card);
			}
		}

		return list;
	}
}
