package edu.up.cs301.pig;

import edu.up.cs301.game.GameMainActivity;
import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.actionMsg.PigHoldAction;
import edu.up.cs301.game.actionMsg.PigRollAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    GamePlayer p = new GamePlayer() {
        @Override
        public void gameSetAsGui(GameMainActivity activity) { }

        @Override
        public void setAsGui(GameMainActivity activity) { }

        @Override
        public void sendInfo(GameInfo info) { }

        @Override
        public void start() { }

        @Override
        public boolean requiresGui() { return false; }

        @Override
        public boolean supportsGui() {
            return false;
        }
    };

    LocalGame local = new LocalGame() {
        @Override
        protected void sendUpdatedStateTo(GamePlayer p) { }

        @Override
        protected boolean canMove(int playerIdx) {
            return false;
        }

        @Override
        protected String checkIfGameOver() {
            return null;
        }

        @Override
        protected boolean makeMove(GameAction action) {
            return false;
        }
    };

    public PigGameState aGame;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor

        aGame = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method

        if(playerIdx == getPlayerIdx(p)){
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method


        if (action instanceof PigHoldAction){
            //p = p + aGame().total;
            
            return true;
        } else if (action instanceof PigRollAction){


            return true;
        } else {
            return false;
        }
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method

        aGame.toString();
        p.sendInfo(aGame);

    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method

        if(aGame.player0Score > 50) {
            System.out.println("Winner: " + aGame.playerId + "Score: " + aGame.player0Score);
        } else if(aGame.player1Score > 50) {
            System.out.println("Winner: " + aGame.player2id + "Score: " + aGame.player1Score);
        }

        return null;
    }

}// class PigLocalGame
