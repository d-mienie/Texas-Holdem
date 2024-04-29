
//Dante Mienie 

package model;

import java.util.ArrayList;
import java.util.Scanner;

//Coordinates activities. You are asked to have the following main function to 
//instantiate a Game that will have many  of the types described above. 
//You must have a main method that looks something like this
public class Game {

	public static void main(String[] args) {
		Game theGame = new Game();
		theGame.start();
	}

	private void start() {
		Scanner scanner = new Scanner(System.in);
		boolean playAnotherGame = true;
		System.out.println("");
		System.out.println("How many players? ");
		int playerCount = scanner.nextInt();

		Dealer dealer = new Dealer(playerCount);

		while (playAnotherGame) {
			dealer.newGame();
			ArrayList<Card> communityCards = (ArrayList<Card>) dealer.getCommunityCards();
			String commCardsString = "";
			for (Card card : communityCards) {
				commCardsString += card.toString() + " ";
			}
			System.out.println("***************************************************");
			System.out.println("Community Cards: " + commCardsString);
			System.out.println();

			ArrayList<Player> players = (ArrayList<Player>) dealer.getPlayers();
			ArrayList<PokerHand> playerHands = findBestHandPerPlayer(communityCards, players);

			for (int i = 0; i < players.size(); i++) {
				Player player = players.get(i);

				String playerCardsString = "";
				for (Card card : player.getHand()) {
					playerCardsString += card.toString() + " ";
				}
				System.out.println("Player " + (i + 1) + ": $" + player.getBalance() + " - " + playerCardsString);
				System.out.println("Best Hand: " + playerHands.get(i).toString() + "  "
						+ getHandRankName(playerHands.get(i).getHandRank()));
				System.out.println();
			}

			// Determine winner
			ArrayList<Integer> winnerIndices = findWinner(playerHands);
			ArrayList<Player> winners = new ArrayList<>();
			for (int index : winnerIndices) {
				winners.add(players.get(index));
			}
			dealer.payWinner(winners);
			for (int winnerIndex : winnerIndices) {
				Player winner = players.get(winnerIndex);
				System.out.println("Winner: Player " + (winnerIndex + 1) + " $" + winner.getBalance());
				System.out.println("  " + getHandRankName(playerHands.get(winnerIndex).getHandRank()) + "  "
						+ playerHands.get(winnerIndex).toString());
			}
			System.out.println("");
			System.out.println("***************************************************");
			System.out.println("Play another game? (y/n)");
			String playAnotherGameInput = scanner.next().toLowerCase();
			playAnotherGame = playAnotherGameInput.equals("y");

		}

	}

	private ArrayList<PokerHand> findBestHandPerPlayer(ArrayList<Card> communityCards, ArrayList<Player> players) {
		ArrayList<PokerHand> bestHands = new ArrayList<>();

		for (Player player : players) {
			PokerHand bestHandPlayer = null;
			ArrayList<Card> playerCards = new ArrayList<>(player.getHand());

			ArrayList<Card> allCards = new ArrayList<>(communityCards);
			allCards.addAll(playerCards);

			for (int i = 0; i < allCards.size(); i++) {
				for (int j = i + 1; j < allCards.size(); j++) {
					for (int k = j + 1; k < allCards.size(); k++) {
						for (int l = k + 1; l < allCards.size(); l++) {
							for (int m = l + 1; m < allCards.size(); m++) {
								PokerHand currentHand = new PokerHand(allCards.get(i), allCards.get(j), allCards.get(k),
										allCards.get(l), allCards.get(m));

								if (bestHandPlayer == null || currentHand.compareTo(bestHandPlayer) > 0) {
									bestHandPlayer = currentHand;
								}
							}
						}
					}
				}
			}

			bestHands.add(bestHandPlayer);
		}

		return bestHands;
	}

	private String getHandRankName(int rank) {
		ArrayList<String> handRanks = new ArrayList<>();
		handRanks.add("ROYAL FLUSH");
		handRanks.add("STRAIGHT FLUSH");
		handRanks.add("FOUR OF A KIND");
		handRanks.add("FULL HOUSE");
		handRanks.add("FLUSH");
		handRanks.add("STRAIGHT");
		handRanks.add("THREE OF A KIND");
		handRanks.add("TWO PAIR");
		handRanks.add("ONE PAIR");
		handRanks.add("HIGH CARD");

		if (rank >= 1 && rank <= 10) {
			return handRanks.get(rank - 1);
		} else {
			return "Something went wrong";
		}
	}

	private ArrayList<Integer> findWinner(ArrayList<PokerHand> playerHands) {
		ArrayList<Integer> maxIndices = new ArrayList<>();
		int maxRank = playerHands.get(0).getHandRank();
		maxIndices.add(0);

		for (int i = 1; i < playerHands.size(); i++) {
			int comparisonResult = playerHands.get(i).compareTo(playerHands.get(maxIndices.get(0)));
			if (comparisonResult > 0) {
				maxIndices.clear();
				maxIndices.add(i);
			} else if (comparisonResult == 0) {
				maxIndices.add(i);
			}
		}

		return maxIndices;
	}
}