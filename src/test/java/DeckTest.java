import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

	Deck deck;
	Card card1;
	Card card2;

	@Before
	public void before() {
		deck = new Deck();

		card1 = new Card(SuitType.HEARTS, RankType.KING);
		card2 = new Card(SuitType.CLUBS, RankType.SEVEN);
	}

	@Test
	public void testDeckStartsEmpty(){
		assertEquals(0, deck.getDeckCardCount());
	}

	@Test
	public void test52CardsInDeck(){
		deck.populateDeckWithCards();
		assertEquals(52, deck.getDeckCardCount());
	}

//	@Test
//	public void deckHasUniqueCards(){
//		deck.populateDeckWithCards();
//		assertEquals(true, deck.hasUniqueCards());
//	}


	@Test
	public void canShuffleArray(){
		deck.populateDeckWithCards();
		Card initialFirstCard = deck.cards.get(0);
		deck.shuffleCards();
		Card shuffledFirstCard = deck.cards.get(0);
		assertNotEquals(initialFirstCard, shuffledFirstCard);
	}

	@Test
	public void testCanDealCard(){
		deck.populateDeckWithCards();
		deck.shuffleCards();
		Card card = deck.dealOneCard(0);
		assertFalse(0>card.getValueFromEnum());
	}


}
