package edu.up.cs301.pig;

import edu.up.cs301.game.GameMainActivity;
import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    public PigGameState aGame;

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
        public boolean supportsGui() { return false; }
    };

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
        int currentRunningTotal;
        currentRunningTotal = aGame.getTotal();

        if (action instanceof PigHoldAction)
        {
            int currentPlayerScore;
            int currentPlayer2Score;

            if(aGame.getPlayerId() == 0)
            {
                currentPlayerScore = currentRunningTotal + aGame.getPlayer0Score();
                aGame.setPlayer0Score(currentPlayerScore);
            }

            if(aGame.getPlayer2id() == 0)
            {
                currentPlayer2Score = currentRunningTotal + aGame.getPlayer1Score();
                aGame.setPlayer1Score(currentPlayer2Score);
            }
            return true;
        }
        else if (action instanceof PigRollAction)
        {
            int newCurrent;
            Random roll = new Random();
            int diceRoll = roll.nextInt(6);
            aGame.setDiceValue(diceRoll);
            if(aGame.getDiceValue() != 1)
            {
                newCurrent = currentRunningTotal + aGame.getDiceValue();
                aGame.setTotal(newCurrent);
            }
            else if(aGame.getDiceValue() == 1)
            {
                aGame.setTotal(0);

                if(players.length > 1){ //check to see if there is more than one player
                    aGame.setPlayerTurn(aGame.getPlayerTurn() - 1); //make it the other player's turn
                    return true;
                }
            }

            return true;
        }
        else
        {
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
            System.out.println("Congratulations " + aGame.playerId + "! You Won! Your Total Score is: " + aGame.player0Score);
        } else if(aGame.player1Score > 50) {
            System.out.println("Congratulations " + aGame.player2id + "! You Won! Your Total Score is: " + aGame.player1Score);
        }

        return null;
    }

}// class PigLocalGame
