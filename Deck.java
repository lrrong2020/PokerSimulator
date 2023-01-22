import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//52
class Deck
{	
	Deck()
	{		
		for(int i = 0; i < 52; i++) 
		{	
			Card currentCard = new Card(Card.ALL_CARDS[i]);
			//System.out.println(currentCard.toString());
			this.cards.add(currentCard);

		}
		this.shuffle();
	}

	List<Card> cards = new ArrayList<Card>(52);

	void shuffle() 
	{
		Collections.shuffle(this.cards);
	}

	void deal(Hand hand1, Hand hand2, Board board) 
	{
		System.out.println("Dealing...");

		hand1.getCards().add(this.cards.remove(0));
		hand1.getCards().add(this.cards.remove(0));
		hand1.sort();
		System.out.println("Hand 1: " + hand1.toString());

		hand2.getCards().add(this.cards.remove(0));
		hand2.getCards().add(this.cards.remove(0));
		hand2.sort();
		System.out.println("Hand 2: " + hand2.toString());

		board.getCards().add(this.cards.remove(0));
		board.getCards().add(this.cards.remove(0));
		board.getCards().add(this.cards.remove(0));
		board.getCards().add(this.cards.remove(0));
		board.getCards().add(this.cards.remove(0));
		board.sort();
		System.out.println("Board: " + board.toString());
	}
}
