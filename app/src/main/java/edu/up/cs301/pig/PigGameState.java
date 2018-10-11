package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {
int playerId;
int player2id;
int player0Score;
int player1Score;
int total;
int diceValue;

    public PigGameState()
    {
        playerId = 0;
        player2id = 1;
        player0Score = 0;
        player1Score = 0;
        total = 0;
        diceValue = 0;

    }

    public PigGameState(PigGameState pigGameState)
    {
        pigGameState.getPlayerId();
        pigGameState.getPlayer2id();
        pigGameState.getPlayer0Score();
        pigGameState.getPlayer1Score();
        pigGameState.getTotal();
        pigGameState.getDiceValue();

    }

    public int getPlayerId()
    {
        return playerId;
    }

    public int getPlayer2id()
    {
        return player2id;
    }

    public int getPlayer0Score()
    {
        return player0Score;
    }

    public int getPlayer1Score()
    {
        return player1Score;
    }

    public int getTotal()
    {
        return total;
    }

    public int getDiceValue()
    {
        return diceValue;
    }

    public void setPlayerId(int playerId)
    {
        this.playerId = playerId;
    }

    public void setPlayer2id(int player2id)
    {
        this.player2id = player2id;
    }

    public void setPlayer0Score(int player0Score)
    {
        this.player0Score = player0Score;
    }

    public void setPlayer1Score(int player1Score)
    {
        this.player1Score = player1Score;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }

    public void setDiceValue(int diceValue)
    {
        this.diceValue = diceValue;
    }
}
