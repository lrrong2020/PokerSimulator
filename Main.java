public class Main
{
	public static void main(String[] args) 
	{
//				//test deal
//				Hand hand1 = new Hand();
//				Hand hand2 = new Hand();
//				
//				Board board = new Board();
//				
//				Deck deck = new Deck();
//				deck.deal(hand1, hand2, board);

		//test high card
		Hand hand1 = new Hand("5d","6h");
		Hand hand2 = new Hand("As","3c");

		Board board = new Board("2s","3s","4d","5h","8h");

		int[] testStraight = CompareHands.testStraight(hand1, board);
		System.out.println(testStraight[0]);
		
//		CompareHands.compareSameLevel(hand1, hand2, board, 0, null, null);
	}
}

