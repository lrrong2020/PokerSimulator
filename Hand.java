import java.util.ArrayList;

class Hand
{
	private ArrayList<Card> cards = new ArrayList<Card>(2);

	Hand() 
	{

	}

	Hand(String s1, String s2)
	{
		this.cards.add(new Card(s1));
		this.cards.add(new Card(s2));

		this.sort();
	}

	//	boolean isSuited() 
	//	{
	//		return cards[0].getSuit().equals(cards[1].getSuit());
	//	}

	public ArrayList<Card> getCards()
	{
		return this.cards;
	}

	public void sort() 
	{
		Card.sortCards(this.cards);
	}

	public String toString() 
	{
		return this.cards.get(0).toString() + this.cards.get(1).toString();
	}
}
