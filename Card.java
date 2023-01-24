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
	public static final String CARD_ORDER_DESC = "AKQJT98765432";

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
//		System.out.println("getNumber(): " + this.number);
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
	
	public static int compareHighCards(ArrayList<Card> cards1, ArrayList<Card> cards2) 
	{
		//5 cards (high card no chop)
		
		
		//3 cards (one pair)
		
		
		//2 cards (set)
		
		
		//1 card (Quads, Two-pair)
		
		
		//compare cards one by one
		
		//if the first the same, then the next
		
		System.out.println("comparing cards-----" + 
		"\ncards1.size(): " + cards1.size() + " cards2.size(): " + cards2.size());
		
//		for(Card card: cards1) System.out.println("[card1]" + card); 
//		for(Card card: cards2) System.out.println("[card2]" + card); 
//		
		if(cards1.size() == 5) 
		{
			//one pair removed 2 cards (7 - 2 = 5)

			for(int i = 0; i < 3; i++) 
			{
				if(cards1.get(i).compareTo(cards2.get(i)) > 0) 
				{
					System.out.println("card1 wins");
					return 1;
				}
				else if(cards1.get(i).compareTo(cards2.get(i)) < 0) 
				{
					System.out.println("card2 wins");
					return -1;
				}
				else 
				{
					continue;
				}
			}
			System.out.println("chop chop");
			return 0;
		}
		return 0;
		
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
