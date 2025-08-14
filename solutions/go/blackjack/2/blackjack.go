package blackjack

// ParseCard returns the integer value of a card following blackjack ruleset.
func ParseCard(card string) int {
	switch card {
	case "ace":
		return 11
	case "two":
		return 2
	case "three":
		return 3
	case "four":
		return 4
	case "five":
		return 5
	case "six":
		return 6
	case "seven":
		return 7
	case "eight":
		return 8
	case "nine":
		return 9
	case "joker":
		return 0
	default:
		return 10
	}
}

// FirstTurn returns the decision for the first turn, given two cards of the
// player and one card of the dealer.
func FirstTurn(card1, card2, dealerCard string) string {
	sum := ParseCard(card1) + ParseCard(card2)
	dealerSum := ParseCard(dealerCard)

	if card1 == "ace" && card2 == "ace" {
		return "P"
	} else if sum == 21 && dealerSum < 10 {
		return "W"
	} else if sum == 21 {
		return "S"
	} else if sum >= 17 && sum <= 20 {
		return "S"
	} else if (sum >= 12 && sum <= 16) && dealerSum < 7 {
		return "S"
	} else {
		return "H"
	}
}
