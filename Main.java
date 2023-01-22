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
		Hand hand1 = new Hand("Td","4h");
		Hand hand2 = new Hand("Ts","2c");

		Board board = new Board("Qs","Qc","Qd","Qh","8h");

		CompareHands.compareSameLevel(hand1, hand2, board, 0);
	}
}

