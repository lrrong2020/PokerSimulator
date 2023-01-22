import java.util.ArrayList;
import java.util.Collections;

class Card implements Comparable
{	
	Card()
	{

	}

	Card(String cardString)
	{
		this.number = cardString.substring(0, 1);
		this.suit = cardString.substring(1, 2);
	}

	public static final String CARD_ORDER_ASC = "23456789TJQKA";


	public static final String[] ALL_CARDS = 
		{
				"2s","2h","2d","2c",
				"3s","3h","3d","3c",
				"4s","4h","4d","4c",
				"5s","5h","5d","5c",
				"6s","6h","6d","6c",
				"7s","7h","7d","7c",
				"8s","8h","8d","8c",
				"9s","9h","9d","9c",	
				"Ts","Th","Td","Tc",
				"Js","Jh","Jd","Jc",
				"Qs","Qh","Qd","Qc",
				"Ks","Kh","Kd","Kc",
				"As","Ah","Ad","Ac",
		};


	String number;
	String suit;

	String getNumber() 
	{
		return this.number;
	}

	String getSuit() 
	{
		return this.suit;
	}

	public static ArrayList<Card> sortCards(ArrayList<Card> cards)
	{	
		Collections.sort(cards, (b, a) -> a.compareTo(b));
		return cards;
	}

	public String toString()
	{
		return this.getNumber() + "" + this.getSuit();
	}

	@Override
	public int compareTo(Object o)
	{
		Card card = (Card) o;	
		return Integer.compare(Card.CARD_ORDER_ASC.indexOf(this.number), Card.CARD_ORDER_ASC.indexOf(card.getNumber()));
	}

}
