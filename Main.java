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
		Hand hand1 = new Hand("Ah","8s");
		Hand hand2 = new Hand("2h","2c");

		Board board = new Board("7s","6d","Ac","Ts","2d");
		
		System.out.println("public pair? " + CompareHands.hasPair(board.getCards()));
		
		int[] testFlush = CompareHands.testQuads(hand2, board);
		System.out.println(testFlush[0]);
		
//		CompareHands.compareSameLevel(hand1, hand2, board, 0, null, null);
	}
}

