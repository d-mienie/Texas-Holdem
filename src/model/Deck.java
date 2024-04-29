//Dante Mienie 

package model;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private static ArrayList<Card> cards = new ArrayList<>();

	static void newDeck() {
		cards.add(new Card(Rank.DEUCE, Suit.CLUBS));
		cards.add(new Card(Rank.THREE, Suit.CLUBS));
		cards.add(new Card(Rank.FOUR, Suit.CLUBS));
		cards.add(new Card(Rank.FIVE, Suit.CLUBS));
		cards.add(new Card(Rank.SIX, Suit.CLUBS));
		cards.add(new Card(Rank.SEVEN, Suit.CLUBS));
		cards.add(new Card(Rank.EIGHT, Suit.CLUBS));
		cards.add(new Card(Rank.NINE, Suit.CLUBS));
		cards.add(new Card(Rank.TEN, Suit.CLUBS));
		cards.add(new Card(Rank.JACK, Suit.CLUBS));
		cards.add(new Card(Rank.QUEEN, Suit.CLUBS));
		cards.add(new Card(Rank.KING, Suit.CLUBS));
		cards.add(new Card(Rank.ACE, Suit.CLUBS));

		cards.add(new Card(Rank.DEUCE, Suit.DIAMONDS));
		cards.add(new Card(Rank.THREE, Suit.DIAMONDS));
		cards.add(new Card(Rank.FOUR, Suit.DIAMONDS));
		cards.add(new Card(Rank.FIVE, Suit.DIAMONDS));
		cards.add(new Card(Rank.SIX, Suit.DIAMONDS));
		cards.add(new Card(Rank.SEVEN, Suit.DIAMONDS));
		cards.add(new Card(Rank.EIGHT, Suit.DIAMONDS));
		cards.add(new Card(Rank.NINE, Suit.DIAMONDS));
		cards.add(new Card(Rank.TEN, Suit.DIAMONDS));
		cards.add(new Card(Rank.JACK, Suit.DIAMONDS));
		cards.add(new Card(Rank.QUEEN, Suit.DIAMONDS));
		cards.add(new Card(Rank.KING, Suit.DIAMONDS));
		cards.add(new Card(Rank.ACE, Suit.DIAMONDS));

		cards.add(new Card(Rank.DEUCE, Suit.HEARTS));
		cards.add(new Card(Rank.THREE, Suit.HEARTS));
		cards.add(new Card(Rank.FOUR, Suit.HEARTS));
		cards.add(new Card(Rank.FIVE, Suit.HEARTS));
		cards.add(new Card(Rank.SIX, Suit.HEARTS));
		cards.add(new Card(Rank.SEVEN, Suit.HEARTS));
		cards.add(new Card(Rank.EIGHT, Suit.HEARTS));
		cards.add(new Card(Rank.NINE, Suit.HEARTS));
		cards.add(new Card(Rank.TEN, Suit.HEARTS));
		cards.add(new Card(Rank.JACK, Suit.HEARTS));
		cards.add(new Card(Rank.QUEEN, Suit.HEARTS));
		cards.add(new Card(Rank.KING, Suit.HEARTS));
		cards.add(new Card(Rank.ACE, Suit.HEARTS));

		cards.add(new Card(Rank.DEUCE, Suit.SPADES));
		cards.add(new Card(Rank.THREE, Suit.SPADES));
		cards.add(new Card(Rank.FOUR, Suit.SPADES));
		cards.add(new Card(Rank.FIVE, Suit.SPADES));
		cards.add(new Card(Rank.SIX, Suit.SPADES));
		cards.add(new Card(Rank.SEVEN, Suit.SPADES));
		cards.add(new Card(Rank.EIGHT, Suit.SPADES));
		cards.add(new Card(Rank.NINE, Suit.SPADES));
		cards.add(new Card(Rank.TEN, Suit.SPADES));
		cards.add(new Card(Rank.JACK, Suit.SPADES));
		cards.add(new Card(Rank.QUEEN, Suit.SPADES));
		cards.add(new Card(Rank.KING, Suit.SPADES));
		cards.add(new Card(Rank.ACE, Suit.SPADES));
	}

	public static void shuffleDeck() {
		Collections.shuffle(cards);
	}

	public static Card dealCard() {
		shuffleDeck();
		return cards.remove(0);

	}

}
