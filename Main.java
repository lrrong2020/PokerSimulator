import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main
{
	public static void main(String[] args) 
	{
		Hand hand1 = new Hand();
		Hand hand2 = new Hand();
		
		Board board = new Board();
		
		Deck deck = new Deck();
		deck.deal(hand1, hand2, board);
		
		

	}
}

class Card
{	
	Card()
	{
		
	}
	
	Card(String cardString)
	{
		this.number = cardString.substring(0, 1);
		this.suit = cardString.substring(1, 2);
	}
	
	public static final String CARD_ORDER = "AKQJT98765432";
	
	
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
	
	class CardComparator implements Comparator<Card>
	{

		@Override
		public int compare(Card card1, Card card2)
		{
			return Integer.compare(Card.CARD_ORDER.indexOf(card1.getNumber()), Card.CARD_ORDER.indexOf(card2.getNumber()));
		}
		
	}
	
	
	public static ArrayList<Card> sortCards(ArrayList<Card> cards)
	{	
		Collections.sort(cards, new Card() . new CardComparator());
		return cards;
	}
	
	public String toString()
	{
		return this.getNumber() + "" + this.getSuit();
	}
}


//52
class Deck
{	
	Deck()
	{		
		for(int i = 0; i < 52; i++) 
		{	
			Card currentCard = new Card(Card.ALL_CARDS[i]);
//			System.out.println(currentCard.toString());
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

//5
class Board
{
	private ArrayList<Card> cards = new ArrayList<Card>(5);
	
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

class Hand
{
	private ArrayList<Card> cards = new ArrayList<Card>(2);
	
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

class handComparator
{
	static int compareTo(Hand hand1, Hand hand2, Board board)
	{	
		int level1 = getLevel(hand1, board);
		int level2 = getLevel(hand2, board);
		
		if(level1 > level2) 
		{
			return 1;
		}
		else if(level1 < level2) 
		{
			return -1;
		}
		else 
		{
			return compareSameLevel(hand1, hand2, board, level1);
		}

	}
	
	
	static int compareSameLevel(Hand hand1, Hand hand2, Board board, int level) 
	{
		if(level == 0) //high card
		{	
			return 0;
		}
		else if(level == 1) //one pair
		{
			return 0;
		}
		else if(level == 2) //two pair
		{
			return 0;
		}
		else if(level == 3) //set
		{
			return 0;
		}
		else if(level == 4) //straight
		{
			return 0;
		}
		else if(level == 5) //flush
		{
			return 0;
		}
		else if(level == 6) //full house
		{
			return 0;
		}
		else if(level == 7) //quads
		{
			return 0;
		}
		else //straight flush
		{
			return 0;
		}

	}
	
	static int getLevel(Hand hand, Board board) 
	{
		if(hasStraightFlush(hand, board)) 
		{
			return 8;
		}
		else if(hasQuads(hand, board)) 
		{
			return 7;
		}
		else if(hasFullHouse(hand, board)) 
		{
			return 6;
		}
		else if(hasFlush(hand, board)) 
		{
			return 5;
		}
		else if(hasStraight(hand, board)) 
		{
			return 4;
		}
		else if(hasSet(hand, board)) 
		{
			return 3;
		}
		else if(hasTwoPair(hand, board)) 
		{
			return 2;
		}
		else if(hasPair(hand, board)) 
		{
			return 1;
		}
		else return 0;
	}
	
	static boolean hasStraightFlush(Hand hand, Board board) {
		return false;
	}
	
	static boolean hasQuads(Hand hand, Board board) {
		return false;
	}
	
	static boolean hasFullHouse(Hand hand, Board board) {
		return false;
	}
	
	static boolean hasFlush(Hand hand, Board board) {
		return false;
	}
	
	static boolean hasStraight(Hand hand, Board board) {
		return false;
	}
	
	static boolean hasSet(Hand hand, Board board) {
		return false;
	}
	
	static boolean hasTwoPair(Hand hand, Board board) {
		return false;
	}
	
	static boolean hasPair(Hand hand, Board board) {
		return false;
	}
}