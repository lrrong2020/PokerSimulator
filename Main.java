import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main
{
	public static void main(String[] args) 
	{
//		Hand hand1 = new Hand();
//		Hand hand2 = new Hand();
//		
//		Board board = new Board();
//		
//		Deck deck = new Deck();
//		deck.deal(hand1, hand2, board);
		
		Hand hand1 = new Hand("2d","3h");
		Hand hand2 = new Hand("3s","2c");
		
		Board board = new Board("As","Ac","Ad","Ah","Kh");
		
		HandComparator.compareSameLevel(hand1, hand2, board, 0);
		
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
	
	public static ArrayList<Card> sortCards(ArrayList<Card> cards)
	{	
		Collections.sort(cards, new CardComparator());
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

class CardComparator implements Comparator<Card>
{
	@Override
	public int compare(Card card1, Card card2)
	{
		return Integer.compare(Card.CARD_ORDER.indexOf(card1.getNumber()), Card.CARD_ORDER.indexOf(card2.getNumber()));
	}
	
}

class HandComparator
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
			//pre-condition!
//			hand1.sort();
//			hand2.sort();
//			board.sort();
			
			Card hand1Higher = hand1.getCards().get(0);
			Card hand1Lower = hand1.getCards().get(1);
			
			System.out.println("hand1Higher" + hand1Higher);
			System.out.println("hand1Lower" + hand1Lower);
			
			Card hand2Higher = hand2.getCards().get(0);
			Card hand2Lower = hand2.getCards().get(1);
			
			System.out.println("hand2Higher" + hand2Higher);
			System.out.println("hand2Lower" + hand2Lower);
			
			Card boardLowest = board.getCards().get(4);
			System.out.println("boardLowest" + boardLowest);
			

			if(new CardComparator().compare(hand1Higher, boardLowest) < 0
					&& new CardComparator().compare(hand2Higher, boardLowest) < 0)
			{
				//highest cards are board - chop
				
				System.out.println("highest cards are board - chop");
				
				return 0;
			}
			else if(new CardComparator().compare(hand1Higher, hand2Higher) == 0
					&& new CardComparator().compare(hand1Lower, boardLowest) < 0
					&& new CardComparator().compare(hand2Lower, boardLowest) < 0)
			{
				//1 + 4 - chop
				
				System.out.println("1 + 4 - chop");
				
			}
			else if(new CardComparator().compare(hand1Higher, hand2Higher) == 0
					&& new CardComparator().compare(hand1Lower, hand2Lower) == 0)
			{
				//2 + 3 - chop
				
				System.out.println("2 + 3 - chop");
				
			}
			else 
			{
				//compare high card
				
				System.out.println("compare high card");
			}
			
			

			
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