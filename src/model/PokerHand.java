//Dante Mienie
package model;

import java.util.ArrayList;
import java.util.Collections;

/*
 * When sorted, a list of PokerHand objects will be in ascending order.
 */

public class PokerHand implements Comparable<PokerHand> {
	private ArrayList<Integer> playerHand = new ArrayList<>();
	private int highestCard;
	private int highestCard2Pairs;
	private int kicker2Pairs;

	private String handName;
	private int handRank = 10;

	public PokerHand(Card c1, Card c2, Card c3, Card c4, Card c5) {
		playerHand.add(c1.getValue());
		playerHand.add(c2.getValue());
		playerHand.add(c3.getValue());
		playerHand.add(c4.getValue());
		playerHand.add(c5.getValue());

		Collections.sort(playerHand);
		highestCard = Collections.max(playerHand);
		highestCard2Pairs = Collections.max(playerHand);
		kicker2Pairs = Collections.max(playerHand);

		// Royal flush
		if (isFlush(c1, c2, c3, c4, c5) && playerHand.get(4) == 14) {
			handName = "Royal flush";
			handRank = 1;
			return;
		}

		// Straight flush
		if ((isFlush(c1, c2, c3, c4, c5)
				&& (playerHand.get(1) == playerHand.get(0) + 1 && playerHand.get(2) == playerHand.get(1) + 1
						&& playerHand.get(3) == playerHand.get(2) + 1 && playerHand.get(4) == playerHand.get(3) + 1))) {
			handName = "Straight flush";
			handRank = 2;
			return;
		}
		// Four of a kind
		if (c1.getRank() == c2.getRank() && c2.getRank() == c3.getRank() && c3.getRank() == c4.getRank()
				|| c2.getRank() == c3.getRank() && c3.getRank() == c4.getRank() && c4.getRank() == c5.getRank()) {
			handName = "Four of a kind";
			handRank = 3;
			return;
		}
		// Full house
		if ((c1.getRank() == c2.getRank() && c2.getRank() == c3.getRank()
				|| (c3.getRank() == c4.getRank() && c4.getRank() == c5.getRank())
						&& (c1.getRank() == c2.getRank() || c4.getRank() == c5.getRank()))) {
			handName = "Full house";
			highestCard = c3.getValue();
			handRank = 4;
			return;
		}

		// Flush
		if (isFlush(c1, c2, c3, c4, c5)) {
			handName = "Flush";
			handRank = 5;
		}
		// Straight
		if (playerHand.get(1) == playerHand.get(0) + 1 && playerHand.get(2) == playerHand.get(1) + 1
				&& playerHand.get(3) == playerHand.get(2) + 1 && playerHand.get(4) == playerHand.get(3) + 1) {
			handName = "Straight";
			handRank = 6;
			return;
		}

		// Three of a kind
		if ((c1.getRank() == c2.getRank() && c2.getRank() == c3.getRank())
				|| (c2.getRank() == c3.getRank() && c3.getRank() == c4.getRank()
						|| (c3.getRank() == c4.getRank() && c4.getRank() == c5.getRank()))) {
			handName = "Three of a kind";
			handRank = 7;
			if (c1.getRank() == c2.getRank() && c2.getRank() == c3.getRank()) {
				highestCard = Integer.max(c4.getValue(), c5.getValue());
			} else if (c2.getRank() == c3.getRank() && c3.getRank() == c4.getRank()) {
				highestCard = Integer.max(c1.getValue(), c5.getValue());
			} else {
				highestCard = Integer.max(c1.getValue(), c2.getValue());
			}
			return;
		}
		// Two pair
		if ((c1.getRank() == c2.getRank() && c3.getRank() == c4.getRank())
				|| (c1.getRank() == c2.getRank() && c4.getRank() == c5.getRank())
				|| (c2.getRank() == c3.getRank() && c4.getRank() == c5.getRank())) {
			handName = "Two pair";
			handRank = 8;

			int tempMax = 0;
			int tempMin = 0;

			if (c1.getRank() == c2.getRank() && c3.getRank() == c4.getRank()) {
				tempMax = Integer.max(c1.getValue(), c3.getValue());
				tempMin = Integer.min(c1.getValue(), c3.getValue());
				kicker2Pairs = c5.getValue();
				return;
			}

			if (c1.getRank() == c2.getRank() && c4.getRank() == c5.getRank()) {
				tempMax = Integer.max(c2.getValue(), c4.getValue());
				tempMin = Integer.min(c2.getValue(), c4.getValue());
				kicker2Pairs = c3.getValue();
				return;

			}
			if (c2.getRank() == c3.getRank() && c4.getRank() == c5.getRank()) {
				tempMax = Integer.max(c2.getValue(), c4.getValue());
				tempMin = Integer.max(c2.getValue(), c4.getValue());
				kicker2Pairs = c1.getValue();
				return;

			}

			highestCard = tempMax;
			highestCard2Pairs = tempMin;
			return;

		}
		// Pair
		if ((c1.getRank() == c2.getRank()) || (c2.getRank() == c3.getRank())
				|| (c3.getRank() == c4.getRank() || c4.getRank() == c5.getRank())) {
			handName = "Pair";
			handRank = 9;
			int pairValue = 0;
			if (c1.getRank() == c2.getRank()) {
				pairValue = c1.getValue();
			} else if (c2.getRank() == c3.getRank()) {
				pairValue = c2.getValue();
			} else if (c3.getRank() == c4.getRank()) {
				pairValue = c3.getValue();
			} else if (c4.getRank() == c5.getRank()) {
				pairValue = c4.getValue();
			}
			highestCard = pairValue;

		}
	}

	private boolean isFlush(Card c1, Card c2, Card c3, Card c4, Card c5) {
		if (c1.getSuit() == c2.getSuit() && c2.getSuit() == c3.getSuit() && c3.getSuit() == c4.getSuit()
				&& c4.getSuit() == c5.getSuit()) {
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(PokerHand o) {
		Collections.sort(o.playerHand);
		if (this.handRank > o.handRank) {
			return -1;
		} else if (this.handRank < o.handRank) {
			return 1;
		} else {

			if (this.highestCard > o.highestCard) {
				return 1;
			} else if (this.highestCard < o.highestCard) {
				return -1;

			} else {
				if (this.handRank == 8 && o.handRank == 8 && this.highestCard == o.highestCard) {
					if (this.highestCard2Pairs > o.highestCard2Pairs) {
						return 1;
					} else if (this.highestCard2Pairs < o.highestCard2Pairs) {
						return -1;
					} else {
						if (this.kicker2Pairs > o.kicker2Pairs) {
							return 1;
						} else if (this.kicker2Pairs < o.kicker2Pairs) {
							return -1;
						} else {
							return 0;
						}
					}

				} else {
					for (int i = 4; i >= 0; i--) {
						if (this.playerHand.get(i) < o.playerHand.get(i)) {
							return -1;
						} else if (this.playerHand.get(i) > o.playerHand.get(i)) {
							return 1;
						}
					}
					return 0;
				}
			}
		}
	}
}