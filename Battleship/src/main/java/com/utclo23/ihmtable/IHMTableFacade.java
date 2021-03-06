/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utclo23.ihmtable;

import com.utclo23.data.structure.Coordinate;
import com.utclo23.data.structure.StatGame;
import com.utclo23.data.facade.IDataIHMTable;
import com.utclo23.data.structure.Game;
import com.utclo23.data.structure.Message;
import com.utclo23.data.structure.LightPublicUser;
import com.utclo23.ihmmain.controller.AbstractController;
import com.utclo23.ihmmain.facade.IHMMainToIhmTable;
import com.utclo23.ihmtable.controller.InGameGUIController;
import java.io.IOException;

import java.rmi.server.UID;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author pjeannot
 */
public class IHMTableFacade implements IIHMTableToIHMMain, IIHMTableToData {

    /**
     * The path of the inGameGUI.fxml.
     */
    private final String FXML_PATH = "/fxml/ihmtable/InGame.fxml";

    /**
     * The Data facade.
     */
    private IDataIHMTable facadeData;

    /**
     * @return the facadeData
     */
    public IDataIHMTable getFacadeData() {
        return facadeData;
    }

    /**
     * @return the facadeIHMMain
     */
    public IHMMainToIhmTable getFacadeIHMMain() {
        return facadeIHMMain;
    }

    /**
     * The facade of IHM Main.
     */
    private IHMMainToIhmTable facadeIHMMain;

    /**
     * True if the 2 players are ready.
     * /!\ Reset to false when the game ends.
     */
    private boolean gameReady;

    /**
     * Constructor
     * @param iDataIHMtable Interface Data IHMTable
     */
    public IHMTableFacade(IDataIHMTable iDataIHMtable) {
        this.facadeData = iDataIHMtable;
        this.gameReady = false;
    }

    /**
     * Set a reference to the facade of IHM Main.
     * @param iHMMainTOIhmTable : interface of the facade of ihm main for ihm table.
     */
    public void setIhmMainLink(IHMMainToIhmTable iHMMainTOIhmTable) {
        this.facadeIHMMain = iHMMainTOIhmTable;
    }

    /**
     * The message of the exception thrown by unimplemented methods.
     */
    public static final String EXCEPTION_MESSAGE = "Not supported yet";

    /**
     * Replay a saved game.
     * @param id : id of the game.
     */
    @Override
    public void showSavedGameWithId(int id) {
        throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
    }

    /**
     * Launch a new game.
     * @param primaryStage Primary stage from IHMMain
     */
    @Override
    public void createInGameGUI(Stage primaryStage) {
        FXMLLoader paneLoader = new FXMLLoader(getClass().getResource(FXML_PATH));
        Parent pane;
        try {
            InGameGUIController controller = new InGameGUIController();
            controller.setFacade(this);
            paneLoader.setController(controller);
            pane = paneLoader.load();
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Game");
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(IHMTableFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Pause a playing saved game.
     */
    @Override
    public void stopTimer() {
        throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
    }

    /**
     * Join a current game.
     * @param guid : id of the game.
     */
    @Override
    public void showGame(UID guid) {
        //Cr??er la fen??tre
        FXMLLoader paneLoader = new FXMLLoader(getClass().getResource(FXML_PATH));
        Parent pane;
        InGameGUIController controller = null;
        Stage primaryStage = facadeIHMMain.getPrimaryStage();
        try {
            controller = new InGameGUIController();
            controller.setFacade(this);
            paneLoader.setController(controller);
            pane = paneLoader.load();
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Game");
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(IHMTableFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //G??rer les cas spectateur/utilisateur standard
       /* boolean startSpectateur = false;
        Game game = facadeData.getGame();
        LightPublicUser user = facadeData.getUser();
        for(int i=0;i<game.getSpectators().size() && !startSpectateur;++i)
            if(game.getSpectators().get(i).getId() == user.getId())
                startSpectateur = true;
        if(startSpectateur && controller != null)
           controller.refreshBoardForSpectator();*/

            
        throw new UnsupportedOperationException("En cours");
    }

    /**
     * Notify that the two players are ready to play.
     */
    @Override
    public void notifyGameReady() {
        this.gameReady = true;
    }

    /**
     * Display a message in the chat.
     * @param message : the message to display.
     */
    public void printMessage(Message message) {
        //throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
        InGameGUIController controller = new InGameGUIController();
        controller.showMessageChat(message); 
    }

    /**
     * Show on the board if the shot has hit or not a ship.
     * @param coord : the coordinates of the hit.
     * @param bool : true if a ship is hit.
     */
    @Override
    public void feedBack(Coordinate coord, boolean bool) {
        throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
    }

    /**
     * Display the new stats of the player.
     * @param stGame : ths stats
     */
    @Override
    public void finishGame(StatGame stGame) {
        throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
    }

    /**
     * The opponent has quit the game.
     */
    @Override
    public void opponentHasLeftGame() {
        throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
    }

    /**
     * Connection has been lost with your opponent.
     */
    @Override
    public void connectionLostWithOpponent() {
        throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
    }

    /**
     * @return the gameReady
     */
    public boolean isGameReady() {
        return gameReady;
    }

    /**
     * @param gameReady the gameReady to set
     */
    public void setGameReady(boolean gameReady) {
        this.gameReady = gameReady;
    }

}
