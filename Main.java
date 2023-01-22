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
		Hand hand1 = new Hand("2d","3h");
		Hand hand2 = new Hand("3s","2c");

		Board board = new Board("As","Ac","Ad","Ah","Kh");

		CompareHands.compareSameLevel(hand1, hand2, board, 0);
	}
}

