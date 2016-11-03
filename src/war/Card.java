package war;

public class Card {
	String suit;
	String card;
	int suitValue;
	int cardValue;
	/**
	 * 
	 */
	public Card() {
		super();
		// TODO Auto-generated constructor stub
		this.dealCard();
		this.convertCardValue();
	}
	/**
	 * @param suitValue
	 * @param cardValue
	 */
	public Card(int suitValue, int cardValue) {
		super();
		this.suitValue = suitValue;
		this.cardValue = cardValue;
		this.convertCardValue();
	}
	/**
	 * @param suit
	 * @param card
	 */
	public Card(String suit, String card) {
		super();
		this.suit = suit;
		this.card = card;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Card [suit=" + suit + ", card=" + card + ", suitValue="
				+ suitValue + ", cardValue=" + cardValue + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((card == null) ? 0 : card.hashCode());
		result = prime * result + cardValue;
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		result = prime * result + suitValue;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (card == null) {
			if (other.card != null)
				return false;
		} else if (!card.equals(other.card))
			return false;
		if (cardValue != other.cardValue)
			return false;
		if (suit == null) {
			if (other.suit != null)
				return false;
		} else if (!suit.equals(other.suit))
			return false;
		if (suitValue != other.suitValue)
			return false;
		return true;
	}
	/**
	 * @return the suit
	 */
	public String getSuit() {
		return suit;
	}
	/**
	 * @param suit the suit to set
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}
	/**
	 * @return the card
	 */
	public String getCard() {
		return card;
	}
	/**
	 * @param card the card to set
	 */
	public void setCard(String card) {
		this.card = card;
	}
	/**
	 * @return the suitValue
	 */
	public int getSuitValue() {
		return suitValue;
	}
	/**
	 * @param suitValue the suitValue to set
	 */
	public void setSuitValue(int suitValue) {
		this.suitValue = suitValue;
		this.convertCardValue();
	}
	/**
	 * @return the cardValue
	 */
	public int getCardValue() {
		return cardValue;
		
	}
	/**
	 * @param cardValue the cardValue to set
	 */
	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
		this.convertCardValue();
	}
	
	/**
	 * 0 = Spades
	 * 1 = Hearts
	 * 2 = Diamonds
	 * 3 = Clubs
	 */
	public void dealCard(){
		cardValue = (int) (Math.random() * 13 + 2);
		suitValue = (int) (Math.random() * 4);
		this.convertCardValue();
	}
	
	/**
	 * The class users will never need this method
	 */
	private void convertCardValue(){
		switch(suitValue){
		case 0:
			suit = "Spades";
			break;//stops the switch
		case 1:
			suit = "Hearts";
			break;//stops the switch
		case 2:
			suit = "Diamonds";
			break;//stops the switch
		case 3:
			suit = "Clubs";
			break;//stops the switch
		default:
			suit = "Error";
			break;
		}
		switch(cardValue){
		case 2:
			card = "Two";
			break;
		case 3:
			card = "Three";
			break;
		case 4:
			card = "Four";
			break;
		case 5:
			card = "Five";
			break;
		case 6:
			card = "Six";
			break;
		case 7:
			card = "Seven";
			break;
		case 8:
			card = "Eight";
			break;
		case 9:
			card = "Nine";
			break;
		case 10:
			card = "Ten";
			break;
		case 11:
			card = "Jack";
			break;
		case 12:
			card = "Queen";
			break;
		case 13:
			card = "King";
			break;
		case 14:
			card = "Ace";
			break;
		default:
			card = "error";
			break;
			
		}
	}
	
	private void convertCardString(){
		switch(this.suit.toLowerCase()){
		case "spades":
			this.suitValue = 0;
			break;
		case "hearts":
			this.suitValue = 1;
			break;
		case "diamonds":
			this.suitValue = 2;
			break;
		case "clubs":
			this.suitValue = 3;
			break;
		default:
			this.suitValue = -1;
			break;
		}
	}
	
        
	
	
	
	
	
	
	
	
	
	
	
	
	
}