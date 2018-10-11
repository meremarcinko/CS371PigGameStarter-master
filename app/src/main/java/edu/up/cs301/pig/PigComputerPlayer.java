package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.Game;
import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.GameMainActivity;
import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.actionMsg.PigHoldAction;
import edu.up.cs301.game.actionMsg.PigRollAction;
import edu.up.cs301.game.infoMsg.BindGameInfo;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    Game g  = super.game;
    //generate 50/50 chance
    Random r = new Random();
    int choice = r.nextInt(2);



    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method


        if (info instanceof PigGameState) {
            ((PigGameState)info).getPlayerId(); //cast info
            return;
        } else {
            if(choice == 1) {
                PigHoldAction hold = new PigHoldAction(this);
                g.sendAction(hold);
            } else {
                PigRollAction roll = new PigRollAction(this);
                g.sendAction(roll);
            }
        }
    }//receiveInfo

}
