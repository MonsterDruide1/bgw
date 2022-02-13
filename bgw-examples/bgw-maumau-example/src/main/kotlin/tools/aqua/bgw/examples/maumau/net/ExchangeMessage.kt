package tools.aqua.bgw.examples.maumau.net

import tools.aqua.bgw.examples.maumau.entity.CardSuit
import tools.aqua.bgw.examples.maumau.entity.CardValue
import tools.aqua.bgw.examples.maumau.entity.GameAction

data class ExchangeMessage(val gameAction : GameAction, val cardSuit: CardSuit, val cardValue: CardValue)

enum class GameAction {
	PLAY,
	DRAW,
	DRAW_TWO,
	SUSPEND,
	REQUEST_COLOR,
}