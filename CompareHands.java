class CompareHands
{
	public static int compare(Hand hand1, Hand hand2, Board board)
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

			}
			else if(hand1Higher.compareTo(hand2Higher) == 0
					&& hand1Lower.compareTo(hand2Lower) == 0)
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