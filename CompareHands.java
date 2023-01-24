import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

class CompareHands
{	
	public static final String[] STRAIGHTS = {"AKQJT","KQJT9","QJT98","JT987","T9876","98765","87654","76543","65432","5432A"};
	public static final String[] FLUSHES = {"sssss","ccccc","ddddd","hhhhh"};
	public static final String[] QUADS = {"AAAA","KKKK","QQQQ","JJJJ","TTTT","9999","8888","7777","6666","5555","4444","3333","2222"};
	public static final String[] FULLHOUSE = {
			"AAAKK", "AAAQQ", "AAAJJ", "AAATT", "AAA99", "AAA88", "AAA77", "AAA66", "AAA55", "AAA44", "AAA33", "AAA22",
			"AAKKK", "KKKQQ", "KKKJJ", "KKKTT", "KKK99", "KKK88", "KKK77", "KKK66", "KKK55", "KKK44", "KKK33", "KKK22",
			"AAQQQ", "QQQKK", "QQQJJ", "QQQTT", "QQQ99", "QQQ88", "QQQ77", "QQQ66", "QQQ55", "QQQ44", "QQQ33", "QQQ22",
			"AAJJJ", "KKJJJ", "QQJJJ", "JJJTT", "JJJ99", "JJJ88", "JJJ77", "JJJ66", "JJJ55", "JJJ44", "JJJ33", "JJJ22",
			"AATTT", "KKTTT", "QQTTT", "JJTTT", "TTT99", "TTT88", "TTT77", "TTT66", "TTT55", "TTT44", "TTT33", "TTT22",
			"AA999", "KK999", "QQ999", "JJ999", "TT999", "99988", "99977", "99966", "99955", "99944", "99933", "99922",
			"AA888", "KK888", "QQ888", "JJ888", "TT888", "99888", "88877", "88866", "88855", "88844", "88833", "88822",
			"AA777", "KK777", "QQ777", "JJ777", "TT777", "99777", "88777", "77766", "77755", "77744", "77733", "77722",
			"AA666", "KK666", "QQ666", "JJ666", "TT666", "99666", "88666", "77666", "66655", "66644", "66633", "66622",
			"AA555", "KK555", "QQ555", "JJ555", "TT555", "99555", "88555", "77555", "66555", "55544", "55533", "55522",
			"AA444", "KK444", "QQ444", "JJ444", "TT444", "99444", "88444", "77444", "66444", "55444", "44433", "44422",
			"AA333", "KK333", "QQ333", "JJ333", "TT333", "99333", "88333", "77333", "66333", "55333", "44333", "33322",		
			"AA222", "KK222", "QQ222", "JJ222", "TT222", "99222", "88222", "77222", "66222", "55222", "44222", "33222",
			//(0, 0) -> (0, 1)
			//(1, 0) -> (0, 2)
			//(0, 1) -> (2, 0)
			//(12, 13) -> (12, 11)
			//(i / 13, i % 12)
	};
	
	public static final String[] SET = {"AAA", "KKK", "QQQ", "JJJ", "TTT", "999", "888", "777", "666", "555", "444", "333", "222"};
	
	public static final String[] TWOPAIR = {
			"AAKK", "AAQQ", "AAJJ", "AATT", "AA99", "AA88", "AA77", "AA66", "AA55", "AA44", "AA33", "AA22",
			"KKQQ", "KKJJ", "KKTT", "KK99", "KK88", "KK77", "KK66", "KK55", "KK44", "KK33", "KK22",
			"QQJJ", "QQTT", "QQ99", "QQ88", "QQ77", "QQ66", "QQ55", "QQ44", "QQ33", "QQ22",
			"JJTT", "JJ99", "JJ88", "JJ77", "JJ66", "JJ55", "JJ44", "JJ33", "JJ22",
			"TT99", "TT88", "TT77", "TT66", "TT55", "TT44", "TT33", "TT22",
			"9988", "9977", "9966", "9955", "9944", "9933", "9922",
			"8877", "8866", "8855", "8844", "8833", "8822",
			"7766", "7755", "7744", "7733", "7722",
			"6655", "6644", "6633", "6622",
			"5544", "5533", "5522",
			"4433", "4422",
			"3322", 		
	};


	public static final String[] PAIR_DESC = {"AA", "KK", "QQ", "JJ", "TT", "99", "88", "77", "66", "55", "44", "33", "22"};

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

//			System.out.println("hand1Higher: " + hand1Higher);
//			System.out.println("hand1Lower: " + hand1Lower);

			Card hand2Higher = hand2.getCards().get(0);
			Card hand2Lower = hand2.getCards().get(1);

//			System.out.println("hand2Higher: " + hand2Higher);
//			System.out.println("hand2Lower: " + hand2Lower);

			Card boardLowest = board.getCards().get(4);
//			System.out.println("boardLowest: " + boardLowest);

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
			//compare 5th board card with two hands
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
		int[] resPair = testPairs(hand, board);

		int numberOfPublicPair = countNumberOfPair(board.getCards());
		System.out.println("number of public pair: " + numberOfPublicPair);
		
		
		if(resStraightFlush != null) 
		{	
			
			System.out.println("===================");
			System.out.println("StraightFlush: ");
			System.out.println("");

			params = new int[2];
			params[0] = 8;
		}
		else if(numberOfPublicPair != 0 && resQuads != null) 
		{
			System.out.println("===================");
			System.out.println("Quads: ");
			System.out.println("");

			params = new int[2];
			params[0] = 7;
		}
		else if(numberOfPublicPair != 0 && resFullHouse != null) 
		{
			System.out.println("===================");
			System.out.println("FullHouse: " );
			System.out.println("");

			params = new int[2];
			params[0] = 6;
		}
		else if(resFlush != null) 
		{
			System.out.println("===================");
			System.out.println("Flush: ");
			System.out.println("");

			params = new int[2];
			params[0] = 5;
		}
		else if(resStraight != null) 
		{
			System.out.println("===================");
			System.out.println("Straight: ");
			System.out.println("");

			params = new int[2];
			params[0] = 4;
		}
		else if(resSet != null) 
		{	
			System.out.println("===================");
			System.out.println("Set: ");
			System.out.println("");

			params = new int[2];
			params[0] = 3;
		}
		else if(resPair != null) 
		{
			if(resPair.length == 2) 
			{
				System.out.println("===================");
				System.out.println("Two Pairs");
				System.out.println("");
				params = new int[3];
				params[0] = 2;//two pairs
				
				params[1] = resPair[0];
				params[2] = resPair[1];
			}
			else 
			{	
				System.out.println("===================");
				System.out.println("One Pair: ");
				System.out.println("");
				params = new int[2];
				params[0] = 1;//one pair
				
				params[1] = resPair[0];
			}
		}
		else 
		{
			System.out.println("===================");
			System.out.println("High Card");
			System.out.println("");
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
			testStraight(hand, board);
			return null;
		}
		else
		{
			//only flush
			testFlush(hand, board);
			return null;
		}
	}

	static int[] testQuads(Hand hand, Board board) {
		int[] params = new int[1];
		ArrayList<Card> newList = new ArrayList<Card>(7);
		newList.addAll(hand.getCards());
		newList.addAll(board.getCards());

		//sort new List
		Card.sortCards(newList);

		//number string
		String numbers = newList.stream().map(x -> x.getNumber().toString()).collect(Collectors.joining(""));

		//exist one of quads types
		for(int i = 0; i < QUADS.length; i++) 
		{	
			String quadsNumber = QUADS[i];
			if (numbers.contains(quadsNumber)) 
			{
//				System.out.println("found: " + quadsNumber);
				params[0] = Card.CARD_ORDER_ASC.indexOf(quadsNumber.substring(0, 1));//x-quads
				return params;
			}
			else continue;
		}

		return null;
	}

	static int[] testFullHouse(Hand hand, Board board) {
		//test trips (from larger to smaller)
		int[] resSet = testSet(hand, board);
		if(resSet != null)
		{
			int[] params;
			ArrayList<Card> newList = new ArrayList<Card>(7);
			newList.addAll(hand.getCards());
			newList.addAll(board.getCards());

			//sort new List
			Card.sortCards(newList);

			//number string
			String numbers = newList.stream().map(x -> x.getNumber().toString()).collect(Collectors.joining(""));	
//			System.out.println("numbers: " + numbers);
			
			String setNumber = Card.CARD_ORDER_ASC.substring(resSet[0], resSet[0] + 1);
//			System.out.println("setNumber: " + setNumber);
			
			int indexOfSetNumber = numbers.indexOf(setNumber);
//			System.out.println("indexOfSetNumber: " + indexOfSetNumber);
			
			//remove set
			numbers = numbers.substring(0, indexOfSetNumber) + //before set
//					numbers.substring(indexOfSetNumber, indexOfSetNumber + 3) //set part removed
					numbers.substring(indexOfSetNumber + 3); //after set	
//			System.out.println("numbers removed set: " + numbers);

			
			/* search pair(s) in remaining 4 cards */
			
			//	find larger pair and return
			for(int i = 0; i < PAIR_DESC.length; i++) 
			{
				if(numbers.contains(PAIR_DESC[i])) 
				{
//					System.out.println("i: " + i + " PAIR_DESC[i]: " + PAIR_DESC[i]);							
//					System.out.println("new numbers: " + numbers);			
					params = new int[2];
					params[0] = Card.CARD_ORDER_ASC.indexOf(setNumber);
					params[1] = 12 - i;
					return params;
				}
				else continue;
			}	
			//no pair
			testSet(hand, board);
			return null;
		}
		else 
		{
			return null;
		}
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

//		System.out.println("suits:" + suits);

		//check 5 cards in same suit
		for(int i = 0; i < FLUSHES.length; i++) 
		{
			if (suits.contains(FLUSHES[i])) 
			{	
				String flushSuit = FLUSHES[i].substring(0, 1);
//				System.out.println("found: " + FLUSHES[i]);

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

//		System.out.println("numbersNoDuplicate: " + numbersNoDuplicate); 

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
//				System.out.println("found: " + straightNumber);
				params[0] = Card.CARD_ORDER_ASC.indexOf(straightNumber.substring(0, 1));//x-high straight
				return params;
			}
			else continue;
		}
		return null;
	}

	static int[] testSet(Hand hand, Board board) {
		int[] params = new int[1];
		ArrayList<Card> newList = new ArrayList<Card>(7);
		newList.addAll(hand.getCards());
		newList.addAll(board.getCards());

		//sort new List
		Card.sortCards(newList);

		//number string
		String numbers = newList.stream().map(x -> x.getNumber().toString()).collect(Collectors.joining(""));
		
		//exist one of set types
		for(int i = 0; i < QUADS.length; i++) 
		{	
			String setNumber = SET[i];
			if (numbers.contains(setNumber)) 
			{
//				System.out.println("found: " + setNumber);
				params[0] = Card.CARD_ORDER_ASC.indexOf(setNumber.substring(0, 1));//x-set
				return params;
			}
			else continue;
		}
		
		return null;
	}

	static int[] testPairs(Hand hand, Board board) {
		ArrayList<Card> newList = new ArrayList<Card>(7);
		newList.addAll(hand.getCards());
		newList.addAll(board.getCards());

		//sort new List
		Card.sortCards(newList);
		
//		for(Card card: newList) System.out.println(card);

		ArrayList<Integer> resultList = CompareHands.getPair(newList, new ArrayList<Integer>());
		
		System.out.println("resultList.size(): " + resultList.size());

		if(resultList.size() == 0) 
		{
			return null;
		}
		else 
		{
			int[] res = new int[resultList.size()];
			
			for(int i = 0; i < res.length; i++) 
			{
				res[i] = resultList.get(i);
			}
			
			return res; 	
		}
	}
	
	static ArrayList<Integer> getPair(ArrayList<Card> cards, ArrayList<Integer> pairNumbers ) 
	{
		//test if cards contains pair

//		Card.sortCards(cards);
		int numberOfPair = countNumberOfPair(cards);
		
//		System.out.println("number of pai in getPair(): " + numberOfPair);

		
		if(numberOfPair == 0) return pairNumbers;

		//number string
		String numbers = cards.stream().map(x -> x.getNumber().toString()).collect(Collectors.joining(""));
	
//		System.out.println("numbers in getPair: " + numbers);
		
		//return cards removed one pair with pair
		for(int i = 0; i < PAIR_DESC.length; i++) 
		{
			if(numbers.contains(PAIR_DESC[i])) 
			{
//				System.out.println("i: " + i + " PAIR_DESC[i]: " + PAIR_DESC[i]);							
//				System.out.println("new numbers: " + numbers);	
				
				String pairNumber = Card.CARD_ORDER_DESC.substring(i, i + 1);
				
				System.out.println("pairNumber: " + pairNumber);
				
				int indexOfPairNumber = numbers.indexOf(pairNumber);
				
				String trancatedNumbers = numbers.substring(0, indexOfPairNumber) + numbers.substring(indexOfPairNumber + 2);
				
//				System.out.println("trancatedNumbers: " + trancatedNumbers);
				
//				System.out.println("indexOfPairNumber: " + indexOfPairNumber);
//				
				cards.remove(indexOfPairNumber);
				cards.remove(indexOfPairNumber);
				
				for(Card card: cards) 
				{
					System.out.println(card);
				}

				
				pairNumbers.add(12 - i);
				
				return getPair(cards, pairNumbers);
			}
			else continue;
		}	
		//if no pair, return
		return pairNumbers;
	}
//
//	static int testPairCollection(ArrayList<Card> cards) 
//	{	
//		if(countNumberOfPair(cards) != 0) 
//		{
//			//number string
//			String numbers = cards.stream().map(x -> x.getNumber().toString()).collect(Collectors.joining(""));
//			
//			for(int i = 0; i < PAIR_DESC.length; i++) 
//			{
//				if(numbers.contains(PAIR_DESC[i])) 
//				{
//					return 12 - i;
//				}
//				else continue;
//			}
//		}
//
//		return -1;
//	}
//	
	static int countNumberOfPair(ArrayList<Card> cards) 
	{	
		//number string
		String numbers = cards.stream().map(x -> x.getNumber().toString()).collect(Collectors.joining(""));
		
//		System.out.println("numbers in countNumberOfPair: " + numbers );
		
		int count = 0;
		
		for(int i = 0; i < PAIR_DESC.length; i++) 
		{
			if(numbers.contains(PAIR_DESC[i])) 
			{
				count++;
			}
			else continue;
		}
		
//		System.out.println("countNumberOfPair: " + count);
		return count;
	}
}