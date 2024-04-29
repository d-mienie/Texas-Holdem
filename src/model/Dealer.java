//Dante Mienie 

package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealer {
	private Deck deck;
	private ArrayList<Player> players;
	private ArrayList<Card> communityCards;
	private double pot;

	public Dealer(int numberOfPlayers) {
		this.deck = new Deck();
		this.deck.newDeck();
		this.players = new ArrayList<>();
		this.communityCards = new ArrayList<>();
		for (int i = 0; i < numberOfPlayers; i++) {
			Player player = new Player(100.0);
			players.add(player);
		}
		pot = numberOfPlayers * 2.0;
		dealInitialCards();
		dealCommunityCards();
	}

	public void newGame() {
		communityCards.clear();
		for (Player player : players) {
			player.emptyHand();
		}
		collectAnte();
		dealInitialCards();
		dealCommunityCards();
	}

	public void collectAnte() {
		double ante = 2.0;
		for (Player player : players) {
			player.subtractFromBalance(ante);
		}
	}

	public void payWinner(ArrayList<Player> winners) {
		double winningsPerWinner = pot / winners.size();
		for (Player winner : winners) {
			winner.addToBalance(winningsPerWinner);
		}
	}

	public void dealInitialCards() {
		deck.shuffleDeck();
		for (Player player : players) {
			player.addCardToHand(deck.dealCard());
			player.addCardToHand(deck.dealCard());
		}
	}

	public void dealCommunityCards() {
		for (int i = 0; i < 5; i++) {
			communityCards.add(deck.dealCard());
		}
	}

	public List<Player> getPlayers() {
		return players;
	}

	public List<Card> getCommunityCards() {
		return communityCards;
	}
}
