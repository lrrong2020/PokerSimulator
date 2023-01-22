import java.util.ArrayList;
import java.util.stream.Collectors;

//5
class Board
{
	private ArrayList<Card> cards = new ArrayList<Card>(5);

	Board()
	{

	}

	Board(String s1, String s2, String s3, String s4, String s5)
	{
		this.cards.add(new Card(s1));
		this.cards.add(new Card(s2));
		this.cards.add(new Card(s3));
		this.cards.add(new Card(s4));
		this.cards.add(new Card(s5));

		this.sort();
	}

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
		return this.cards.stream().map(x -> x.toString()).collect(Collectors.joining(","));
	}
}
