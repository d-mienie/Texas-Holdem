package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private double playerBalance;
	private List<Card> hand;

	public Player(double startBalance) {
		this.playerBalance = startBalance;
		this.hand = new ArrayList<>();
	}

	public double getBalance() {
		return playerBalance;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void addCardToHand(Card card) {
		hand.add(card);
	}

	public void emptyHand() {
		hand.clear();
	}

	public void addToBalance(double amount) {
		playerBalance += amount;
	}

	public void subtractFromBalance(double ante) {
		playerBalance -= ante;
	}
}
