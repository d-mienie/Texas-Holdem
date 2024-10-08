//Dante Mienie
package model;

public class Card implements Comparable<Card> {

	private Rank rank;
	private Suit suit;

	public Card(Rank cardRank, Suit cardSuite) {
		rank = cardRank;
		suit = cardSuite;
	}

	@Override
	public int compareTo(Card other) {
		if (rank.getValue() > other.getValue()) {
			return 1;
		}
		if (rank.getValue() < other.getValue()) {
			return -1;
		}
		return 0;
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public int getValue() {
		return rank.getValue();
	}

	public String toString() {
		String cardNumber;
		String suitIcon;
		cardNumber = String.valueOf(getValue());

		if (suit.equals(Suit.CLUBS)) {
			suitIcon = "\u2663";
		} else if (suit.equals(Suit.DIAMONDS)) {
			suitIcon = "\u2666";
		} else if (suit.equals(Suit.HEARTS)) {
			suitIcon = "\u2665";
		} else {
			suitIcon = "\u2660";

		}
		return cardNumber + suitIcon;
	}

	public boolean equals(Card other) {
		if (rank == other.rank && suit == other.suit) {
			return true;
		}
		return false;

	}
}