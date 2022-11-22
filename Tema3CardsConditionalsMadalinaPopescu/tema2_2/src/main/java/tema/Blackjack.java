public class Blackjack {

    public static int  parseCard(String card) {

            switch (card) {
                case "ace":
                    return 11;
                case "two":
                    return 2;
                case "three":
                    return 3;
                case "four":
                    return 4;
                case "five":
                    return 5;
                case "six":
                    return 6;
                case "seven":
                    return 7;
                case "eight":
                    return 8;
                case "nine":
                    return 9;
                case "ten":
                case "jack":
                case "queen":
                case "king":
                    return 10;
                default:
                    return 0;
            }
        }

    public boolean isBlackjack(String card1, String card2) {
        // throw new UnsupportedOperationException("Please implement the Blackjack.isBlackjack method");
      if (parseCard(card1) + parseCard(card2) == 21){
        return true;
      }  
      return false;
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        // throw new UnsupportedOperationException("Please implement the Blackjack.largeHand method");
      if (isBlackjack == true) {
        if (dealerScore < 10) {
          return "W";
        }
          else {
          return "S";
          }
        }
      return "P";
      }
    

    public String smallHand(int handScore, int dealerScore) {
        // throw new UnsupportedOperationException("Please implement the Blackjack.smallHand method");
      if (handScore>=17){
        return "S";
      }
      if (handScore<=11){
        return "H";
      }
      if (handScore >= 12 && handScore <= 16)
       if (dealerScore < 7){
         return "S";
      }
      return "H";
    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }
}
