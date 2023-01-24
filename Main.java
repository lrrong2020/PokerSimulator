import java.util.ArrayList;

public class Main
{
	public static void main(String[] args) 
	{
				//test deal
				Hand hand1 = new Hand();
				Hand hand2 = new Hand();
				
				Board board = new Board();
				
				Deck deck = new Deck();
				deck.deal(hand1, hand2, board);
//
		
//		//test levels
//		Hand hand1 = new Hand("6h","8s");
//		Hand hand2 = new Hand("Ah","2c");
//
//		Board board = new Board("As","Ad","Kc","4c","4d");
		
		CompareHands.compareLevel(hand1, board);
		
//		System.out.println("public pair? " + CompareHands.hasPair(board.getCards()));
		
//		int[] testFullHouse = CompareHands.testFullHouse(hand2, board);
//		System.out.println("test full house\n[0]: " + testFullHouse[0] + Card.CARD_ORDER_ASC.substring(testFullHouse[0], testFullHouse[0] + 1) +
//				"\n[1]: " + testFullHouse[1] + Card.CARD_ORDER_ASC.substring(testFullHouse[1], testFullHouse[1] + 1));
	
////		CompareHands.compareSameLevel(hand1, hand2, board, 0, null, null);
		
//		
//		//FullHouse test
//		final String[] FULLHOUSE = {
//				"AAAKK", "AAAQQ", "AAAJJ", "AAATT", "AAA99", "AAA88", "AAA77", "AAA66", "AAA55", "AAA44", "AAA33", "AAA22",
//				"AAKKK", "KKKQQ", "KKKJJ", "KKKTT", "KKK99", "KKK88", "KKK77", "KKK66", "KKK55", "KKK44", "KKK33", "KKK22",
//				"AAQQQ", "QQQKK", "QQQJJ", "QQQTT", "QQQ99", "QQQ88", "QQQ77", "QQQ66", "QQQ55", "QQQ44", "QQQ33", "QQQ22",
//				"AAJJJ", "KKJJJ", "QQJJJ", "JJJTT", "JJJ99", "JJJ88", "JJJ77", "JJJ66", "JJJ55", "JJJ44", "JJJ33", "JJJ22",
//				"AATTT", "KKTTT", "QQTTT", "JJTTT", "TTT99", "TTT88", "TTT77", "TTT66", "TTT55", "TTT44", "TTT33", "TTT22",
//				"AA999", "KK999", "QQ999", "JJ999", "TT999", "99988", "99977", "99966", "99955", "99944", "99933", "99922",
//				"AA888", "KK888", "QQ888", "JJ888", "TT888", "99888", "88877", "88866", "88855", "88844", "88833", "88822",
//				"AA777", "KK777", "QQ777", "JJ777", "TT777", "99777", "88777", "77766", "77755", "77744", "77733", "77722",
//				"AA666", "KK666", "QQ666", "JJ666", "TT666", "99666", "88666", "77666", "66655", "66644", "66633", "66622",
//				"AA555", "KK555", "QQ555", "JJ555", "TT555", "99555", "88555", "77555", "66555", "55544", "55533", "55522",
//				"AA444", "KK444", "QQ444", "JJ444", "TT444", "99444", "88444", "77444", "66444", "55444", "44433", "44422",
//				"AA333", "KK333", "QQ333", "JJ333", "TT333", "99333", "88333", "77333", "66333", "55333", "44333", "33322",		
//				"AA222", "KK222", "QQ222", "JJ222", "TT222", "99222", "88222", "77222", "66222", "55222", "44222", "33222",
//				//(0, 0) -> (0, 1)
//				//(1, 0) -> (0, 2)
//				//(0, 1) -> (2, 0)
//				//(12, 13) -> (12, 11)
//				//(i / 13, i % 12)
//		};
//		
//		int i = 74;
//		
//		int x = i / 13;
//		int y = (i % 12) + 1;
//		
//		String[] array = Card.CARD_ORDER_DESC.split("");
//		
//		String three = array[x];
//		String two = array[y];
//		
//		System.out.println("FullHouse: " + FULLHOUSE[i]);
//		System.out.println("x: " + x + "\ny: " + y);
//		System.out.println("three: " + three + "\ntwo: " + two);
	}
}

