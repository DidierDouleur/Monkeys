package Experimentation;

import java.io.IOException;
import java.net.Socket;

public class Client {
    
    /**
     * La socket du client.
     */
    private Socket socketClient;
    
    /**
     * l'id ddu client qui se connecte
     */
    private int id;
    
    /**
     * Indique si le jeu est dans une partie.
     */
    private boolean isInGame;

    /**
     * @param socketClient socket
     * @param id id
     */
    public Client(Socket socketClient, int id) {
        this.socketClient = socketClient;
        this.id = id;
        this.isInGame = false;
    }
    
    /**
     * Methode qui ferme la connexion.
     * @throws IOException 
     */
    public void closeConnection() throws IOException{
        this.socketClient.close();
    }

    /**
     * @return the socketClient
     */
    public Socket getSocketClient() {
        return socketClient;
    }

    /**
     * @param socketClient the socketClient to set
     */
    public void setSocketClient(Socket socketClient) {
        this.socketClient = socketClient;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the isInGame
     */
    public boolean isInGame() {
        return isInGame;
    }

    /**
     * @param isInGame the isInGame to set
     */
    public void setInGame(boolean isInGame) {
        this.isInGame = isInGame;
    }
    

    
}
