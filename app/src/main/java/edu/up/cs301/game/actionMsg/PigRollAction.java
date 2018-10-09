package edu.up.cs301.game.actionMsg;

import edu.up.cs301.game.GamePlayer;

/**
 * An action by which the player tells the game that it wants to roll.
 * (typically the human's name, if it's a GameHumanPlayer).
 *
 * @author Ashley Kim
 * @version Oct 2018
 */
public class PigRollAction extends GameAction{

    /** constructor
     *
     * @param p
     * 		the player who sent the action
     */
    public PigRollAction(GamePlayer p) { super(p); }

}

