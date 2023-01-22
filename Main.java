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
		Hand hand1 = new Hand("Ks","8s");
		Hand hand2 = new Hand("As","6s");

		Board board = new Board("2s","3s","4s","5h","8h");

		int[] testFlush = CompareHands.testStraight(hand2, board);
		System.out.println(testFlush[0]);
		
//		CompareHands.compareSameLevel(hand1, hand2, board, 0, null, null);
	}
}

