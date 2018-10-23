package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.pig.PigGameState;

/**
 * An action by which the player tells the game that it wants to hold.
 * (typically the human's name, if it's a GameHumanPlayer).
 *
 * @author Ashley Kim
 * @version Oct 2018
 */
public class PigHoldAction extends GameAction {

    /** constructor
     *
     * @param p
     * 		the player who sent the action
     */
    public PigHoldAction(GamePlayer p) {
        super(p);
    }

}
