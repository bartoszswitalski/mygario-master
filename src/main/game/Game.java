package main.game;

import java.awt.Point;
import main.model.*;

public class Game {
    
    private static final int NUM_OF_PELLETS = 1000;

    private Player mainPlayer;
    private Player botPlayer;
    private Pellets pellets;

    public static enum STATE{

        MENU,
        GAME,
        WIN,
        LOSE,
        TEST,

    };

    private static STATE state = STATE.MENU;

    public Game() {

        mainPlayer  = new Player();
        botPlayer   = new Player();
        pellets     = new Pellets(NUM_OF_PELLETS);

        state       = STATE.MENU;

    }

    public void handleWinLose() {

        if( mainPlayer.overlays( botPlayer ) ){

            state = STATE.WIN;

        } 
        else if( botPlayer.overlays( mainPlayer) ){

            state = STATE.LOSE;

        } 

    }

    public Player getMainPlayer()                   { return this.mainPlayer; }
    public void setMainPlayer( Player player )      { this.mainPlayer = player; }

    public Player getBotPlayer()                    { return this.botPlayer; }
    public void setBotPlayer( Player bot )          { this.botPlayer = bot; }

    public Pellets getPellets()                     { return this.pellets; }
    public void setPellets( Pellets pellets )       { this.pellets = pellets; }

    public static STATE getState()                  { return state; }
    public static void setState( STATE newState )   { state = newState; }

    public Point getMPPosition()                    { return new Point( (int)( mainPlayer.getX() ), (int)(mainPlayer.getY() ) ); }

}