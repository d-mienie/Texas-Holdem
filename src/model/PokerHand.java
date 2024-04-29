
//Dante Mienie
package model;

import java.util.ArrayList;
import java.util.Collections;

/*
 * When sorted, a list of PokerHand objects will be in ascending order.
 */

public class PokerHand implements Comparable<PokerHand> {

	private ArrayList<Card> playerHand = new ArrayList<>();

	private int highestCard;
	public int handRank = 10;

	public PokerHand(Card c1, Card c2, Card c3, Card c4, Card c5) {
		playerHand.add(c1);
		playerHand.add(c2);
		playerHand.add(c3);
		playerHand.add(c4);
		playerHand.add(c5);

		Collections.sort(playerHand);
		highestCard = 0;

	}

	// isFlush
	private boolean isFlush(ArrayList<Card> playerHand) {
		if (playerHand.get(0).getSuit() == playerHand.get(1).getSuit()
				&& playerHand.get(1).getSuit() == playerHand.get(2).getSuit()
				&& playerHand.get(2).getSuit() == playerHand.get(3).getSuit()
				&& playerHand.get(3).getSuit() == playerHand.get(4).getSuit()) {
			return true;
		}
		return false;
	}

	// Royal flush
	private boolean isRoyalFlush(ArrayList<Card> playerHand) {
		if (isFlush(playerHand) && playerHand.get(0).getValue() == 10 && playerHand.get(1).getValue() == 11
				&& playerHand.get(2).getValue() == 12 && playerHand.get(3).getValue() == 13
				&& playerHand.get(4).getValue() == 14) {
			return true;
		}
		return false;
	}

	// Straight flush
	private boolean isStraightFlush(ArrayList<Card> playerHand) {
		if ((isFlush(playerHand) && (playerHand.get(1).getValue() == playerHand.get(0).getValue() + 1
				&& playerHand.get(2).getValue() == playerHand.get(1).getValue() + 1
				&& playerHand.get(3).getValue() == playerHand.get(2).getValue() + 1
				&& playerHand.get(4).getValue() == playerHand.get(3).getValue() + 1))) {
			return true;
		}
		return false;
	}

	// Four of a kind
	private boolean isFourOfKind(ArrayList<Card> playerHand) {
		if (playerHand.get(0).getRank() == playerHand.get(1).getRank()
				&& playerHand.get(1).getRank() == playerHand.get(2).getRank()
				&& playerHand.get(2).getRank() == playerHand.get(3).getRank()
				|| playerHand.get(1).getRank() == playerHand.get(2).getRank()
						&& playerHand.get(2).getRank() == playerHand.get(3).getRank()
						&& playerHand.get(3).getRank() == playerHand.get(4).getRank()) {
			highestCard = playerHand.get(2).getValue();
			return true;
		}
		return false;
	}

	// Full house
	private boolean isFullHouse(ArrayList<Card> playerHand) {
		if ((playerHand.get(0).getRank() == playerHand.get(1).getRank()
				&& playerHand.get(1).getRank() == playerHand.get(2).getRank()
				&& playerHand.get(3).getRank() == playerHand.get(4).getRank())
				|| (playerHand.get(0).getRank() == playerHand.get(1).getRank()
						&& playerHand.get(2).getRank() == playerHand.get(3).getRank()
						&& playerHand.get(3).getRank() == playerHand.get(4).getRank())) {
			highestCard = playerHand.get(2).getValue();
			return true;
		}
		return false;
	}

	// Straight
	private boolean isStraight(ArrayList<Card> playerHand) {
		if (playerHand.get(1).getValue() == playerHand.get(0).getValue() + 1
				&& playerHand.get(2).getValue() == playerHand.get(1).getValue() + 1
				&& playerHand.get(3).getValue() == playerHand.get(2).getValue() + 1
				&& playerHand.get(4).getValue() == playerHand.get(3).getValue() + 1) {
			return true;
		}
		return false;
	}

	// ThreeOfKind
	private boolean isThreeOfKind(ArrayList<Card> playerHand) {
		if ((playerHand.get(0).getRank() == playerHand.get(1).getRank()
				&& playerHand.get(1).getRank() == playerHand.get(2).getRank())
				|| (playerHand.get(1).getRank() == playerHand.get(2).getRank()
						&& playerHand.get(2).getRank() == playerHand.get(3).getRank())
				|| (playerHand.get(2).getRank() == playerHand.get(3).getRank()
						&& playerHand.get(3).getRank() == playerHand.get(4).getRank())) {

			highestCard = playerHand.get(2).getValue();
			return true;
		}
		return false;
	}

	// Pair
	private boolean isPair(ArrayList<Card> playerHand) {
		int pairCount = 0;
		for (int i = 0; i < playerHand.size() - 1; i++) {
			if (playerHand.get(i).getValue() == playerHand.get(i + 1).getValue()) {
				pairCount++;
				highestCard = playerHand.get(i).getValue();
				i++;
			}
		}
		return pairCount == 1;
	}

	// TwoPair
	private boolean isTwoPair(ArrayList<Card> playerHand) {
		int pairCount = 0;
		int maxPairVal = 0;
		for (int i = 0; i < playerHand.size() - 1; i++) {
			if (playerHand.get(i).getValue() == playerHand.get(i + 1).getValue()) {
				pairCount++;
				if (playerHand.get(i).getValue() > maxPairVal) {
					maxPairVal = playerHand.get(i).getValue();
				}
				i++;
			}
		}
		highestCard = maxPairVal;
		return pairCount == 2;
	}

	public int getHandRank() {
		if (isRoyalFlush(playerHand)) {
			return 1;
		} else if (isStraightFlush(playerHand)) {
			return 2;
		} else if (isFourOfKind(playerHand)) {
			return 3;
		} else if (isFullHouse(playerHand)) {
			return 4;
		} else if (isFlush(playerHand)) {
			return 5;
		} else if (isStraight(playerHand)) {
			return 6;
		} else if (isThreeOfKind(playerHand)) {
			return 7;
		} else if (isTwoPair(playerHand)) {
			return 8;
		} else if (isPair(playerHand)) {
			return 9;
		}
		return 10;
	}

	public ArrayList<Card> getArray() {
		return playerHand;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Card card : playerHand) {
			sb.append(card.toString()).append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	@Override
	public int compareTo(PokerHand o) {
		if (this.getHandRank() > o.getHandRank()) {
			return -1;
		} else if (this.getHandRank() < o.getHandRank()) {
			return 1;
		} else {
			if (this.highestCard > o.highestCard) {
				return 1;
			} else if (this.highestCard < o.highestCard) {
				return -1;

			} else {
				for (int i = 4; i >= 0; i--) {
					if (this.playerHand.get(i).getValue() < o.playerHand.get(i).getValue()) {
						return -1;
					} else if (this.playerHand.get(i).getValue() > o.playerHand.get(i).getValue()) {
						return 1;
					}
				}
				return 0;
			}
		}
	}
}