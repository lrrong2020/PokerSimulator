import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

class CompareHands
{	
	public static final String[] STRAIGHTS = {"AKQJT","KQJT9","QJT98","JT987","T9876","98765","87654","76543","65432","5432A"};
	public static final String[] FLUSHES = {"sssss","ccccc","ddddd","hhhhh"};

	public static int compare(Hand hand1, Hand hand2, Board board)
	{	
		int level1 = compareLevel(hand1, board)[0];
		int level2 = compareLevel(hand2, board)[0];

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
			return compareSameLevel(hand1, hand2, board, level1, compareLevel(hand1, board), compareLevel(hand2, board));
		}
	}

	static int compareSameLevel(Hand hand1, Hand hand2, Board board, int level, int[] params1, int[] params2) 
	{
		if(level == 0) //high card
		{	
			//pre-condition!
			//			hand1.sort();
			//			hand2.sort();
			//			board.sort();

			Card hand1Higher = hand1.getCards().get(0);
			Card hand1Lower = hand1.getCards().get(1);

			System.out.println("hand1Higher: " + hand1Higher);
			System.out.println("hand1Lower: " + hand1Lower);

			Card hand2Higher = hand2.getCards().get(0);
			Card hand2Lower = hand2.getCards().get(1);

			System.out.println("hand2Higher: " + hand2Higher);
			System.out.println("hand2Lower: " + hand2Lower);

			Card boardLowest = board.getCards().get(4);
			System.out.println("boardLowest: " + boardLowest);

			if(hand1Higher.compareTo(boardLowest) < 0
					&& hand2Higher.compareTo(boardLowest) < 0)
			{
				//highest cards are board - chop

				System.out.println("highest cards are board - chop");

				return 0;
			}
			else if(hand1Higher.compareTo(hand2Higher) == 0
					&& hand1Lower.compareTo(boardLowest) < 0
					&& hand2Lower.compareTo(boardLowest) < 0)
			{
				//1 + 4 - chop

				System.out.println("1 + 4 - chop");

				return 0;

			}
			else if(hand1Higher.compareTo(hand2Higher) == 0
					&& hand1Lower.compareTo(hand2Lower) == 0)
			{
				//2 + 3 - chop

				System.out.println("2 + 3 - chop");

				return 0;
			}
			else 
			{
				//compare high card

				System.out.println("compare high card");

				return hand1Higher.compareTo(hand2Higher);
			}
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

	static int[] compareLevel(Hand hand, Board board) 
	{
		int[] params = null;

		int[] resStraightFlush = testStraightFlush(hand, board);
		int[] resQuads = testQuads(hand, board);
		int[] resFullHouse = testFullHouse(hand, board);
		int[] resFlush = testFlush(hand, board);
		int[] resStraight = testStraight(hand, board);
		int[] resSet = testSet(hand, board);
		int[] resTwoPair = testTwoPair(hand, board);
		int[] resPair = testPair(hand, board);

		if(resStraightFlush != null) 
		{	
			params = new int[2];
			params[0] = 8;
		}
		else if(resQuads != null) 
		{
			params = new int[2];
			params[0] = 7;
		}
		else if(resFullHouse != null) 
		{
			params = new int[2];
			params[0] = 6;
		}
		else if(resFlush != null) 
		{
			params = new int[2];
			params[0] = 5;
		}
		else if(resStraight != null) 
		{
			params = new int[2];
			params[0] = 4;
		}
		else if(resSet != null) 
		{
			params = new int[2];
			params[0] = 3;
		}
		else if(resTwoPair != null) 
		{
			params = new int[2];
			params[0] = 2;
		}
		else if(resPair != null) 
		{
			params = new int[2];
			params[0] = 1;
		}
		else 
		{
			params = new int[1];
			params[0] = 0;
		}

		return params;
	}

	static int[] testStraightFlush(Hand hand, Board board) {
		int[] resStraight = testStraight(hand, board);
		int[] resFlush = testFlush(hand, board);

		if ((resStraight == null) && (resFlush == null)) 
		{
			return null;
		}
		else if(resStraight != null)
		{
			//only straight
			return resStraight;
		}
		else
		{
			//only flush
			return resFlush;
		}
	}

	static int[] testQuads(Hand hand, Board board) {
		return null;
	}

	static int[] testFullHouse(Hand hand, Board board) {
		return null;
	}

	static int[] testFlush(Hand hand, Board board) {
		int[] params = new int[1];
		ArrayList<Card> newList = new ArrayList<Card>(7);
		newList.addAll(hand.getCards());
		newList.addAll(board.getCards());

		//sort new List
		Card.sortCards(newList);

		//suit string
		String suits = newList.stream().map(x -> x.getSuit().toString()).collect(Collectors.joining(""));

		//sort Array
		char temp[] = suits.toCharArray();
		Arrays.sort(temp);
		suits = new String(temp);

		System.out.println("suits:" + suits);

		//check 5 cards in same suit
		for(int i = 0; i < FLUSHES.length; i++) 
		{
			if (suits.contains(FLUSHES[i])) 
			{	
				String flushSuit = FLUSHES[i].substring(0, 1);
				System.out.println("found: " + FLUSHES[i]);

				for(int j = 0; j < newList.size(); j++) 
				{	
					Card currentCard = newList.get(j);
					if(currentCard.getSuit().equals(flushSuit)) 
					{
						params[0] = Card.CARD_ORDER_ASC.indexOf(currentCard.getNumber());//x-high straight
						return params;
					}
					else continue;
				}
			}
			else continue;
		}

		return null;
	}

	static int[] testStraight(Hand hand, Board board) {
		int[] params = new int[1];
		ArrayList<Card> newList = new ArrayList<Card>(7);
		newList.addAll(hand.getCards());
		newList.addAll(board.getCards());

		//sort new List
		Card.sortCards(newList);

		//number string
		String numbers = newList.stream().map(x -> x.getNumber().toString()).collect(Collectors.joining(""));

		//remove duplicate
		String numbersNoDuplicate = "";
		LinkedHashSet<Character> lhs = new LinkedHashSet<>();
		for(int i = 0; i < numbers.length(); i++) lhs.add(numbers.charAt(i));
		for(Character ch : lhs) numbersNoDuplicate += ch;

		System.out.println("numbersNoDuplicate: " + numbersNoDuplicate); 

		//if A exists, add to the end
		if(numbersNoDuplicate.substring(0, 1).equals("A")) 
		{
			numbersNoDuplicate += "A";
		}

		//exist one of straight types
		for(int i = 0; i < STRAIGHTS.length; i++) 
		{	
			String straightNumber = STRAIGHTS[i];
			if (numbersNoDuplicate.contains(straightNumber)) 
			{
				System.out.println("found: " + straightNumber);
				params[0] = Card.CARD_ORDER_ASC.indexOf(straightNumber.substring(0, 1));//x-high straight
				return params;
			}
			else continue;
		}
		return null;
	}

	static int[] testSet(Hand hand, Board board) {
		return null;
	}

	static int[] testTwoPair(Hand hand, Board board) {
		return null;
	}

	static int[] testPair(Hand hand, Board board) {
		return null;
	}
}