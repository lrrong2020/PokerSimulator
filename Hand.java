import java.util.ArrayList;

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
