package Experimentation;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.text.DateFormat;
import java.util.Date;

import model.GameMaster;

public class ClientProcessor implements Runnable {

    private Socket sock;
    private PrintWriter writer = null;
    private BufferedInputStream reader = null;

    /**
     * commandeResponse la commande de la reponse envoyé par le client.
     */
    private char commandeResponse;

    /**
     * paramCommandeResponse le tableau de string contenant les paramètres de la commande envoyé par
     * le client.
     */
    private String[] paramCommandeResponse;

    public ClientProcessor(Socket pSock) {
        sock = pSock;

    }

    // Le traitement lancé dans un thread séparé
    public void run() {
        System.err.println("Lancement du traitement de la connexion cliente");

        boolean closeConnexion = false;
        // tant que la connexion est active, on traite les demandes
        while (!sock.isClosed()) {

            try {

                // Ici, nous n'utilisons pas les mêmes objets que précédemment
                // Je vous expliquerai pourquoi ensuite
                writer = new PrintWriter(sock.getOutputStream());
                reader = new BufferedInputStream(sock.getInputStream());

                // On attend la demande du client
                String response = read();

                // On transforme la commande reçue en paramètres
                commandeResponse = ProtocoleMonkeyIsland.commandeDuMessage(response);
                paramCommandeResponse = ProtocoleMonkeyIsland.parametresCommande(response,
                        ProtocoleMonkeyIsland.SEPARATEUR_CHAMPS);

                // Si la commande n'est pas reconnue, on ne fait rien
                if (!ProtocoleMonkeyIsland.estUneCommande(response)) {
                    System.out.println("ClientProcessor.java => commande de réponse inconnue");
                } else {
                    System.out.println("ClientProcessor.java => commande de réponse reconnue : ");
                    switch (commandeResponse) {
                        case ProtocoleMonkeyIsland.INSCRIPTION_PIRATE:
                            System.out.println("ClientProcessor.java demande d'inscription : ");
                            String toSend = "/C 5 5 0-0-0-0-0-0-1-1-1-0-0-1-1-1-0-0-1-1-1-0-0-0-0-0-0" + '\n';

                            writer.write(toSend);
                            
                            System.out.println("ClientProcessor.java => envoie carte");
                            writer.flush();

                            
                            toSend = "/i 1-1-1-10" + '\n';
                            writer.write(toSend);
                            System.out.println("ClientProcessor.java => envoie inscription pirate");
                            writer.flush();
//
//                            toSend = "/N";
//                            writer.write(toSend);
//                            writer.flush();
                            break;
                        case ProtocoleMonkeyIsland.DEPLACEMENT_PIRATE:
                            System.out.println("ClientProcessor.java demande de déplacement : ");
                            System.out.println("nbr de parametres = " + paramCommandeResponse.length);
                            System.out.println("taille param 2 = " + paramCommandeResponse[1].length());
                            System.out.println( paramCommandeResponse[1].contains("0"));
                            System.out.println( paramCommandeResponse[1].contains("\n"));

                            
                            
                            System.out.println("deplacement vers x=" + paramCommandeResponse[0]);
                            System.out.println("deplacement vers y=" + paramCommandeResponse[1]);
                            
                            int x = Integer.parseInt(paramCommandeResponse[0]);
                            int y = Integer.parseInt(paramCommandeResponse[1]);
                            x+=1;
                            
                            
                            //Répondre acceptation ou non du déplacement
                            
                            //Acceation avec energie = 1
                            toSend = "/A " + x + "-" + y + "-9" + '\n';
                            System.out.println("ClientProcessor.java => toSend = " + toSend);
                            writer.write(toSend);
                            writer.flush();
                            
                            //Refus
//                            toSend = "/R" + '\n';
//                            writer.write(toSend);
//                            writer.flush();
                            break;
                        default:
                            System.out.println("ClientProcessor.java => Comande reçue inconnue");
                    }
                }

//                InetSocketAddress remote = (InetSocketAddress) sock.getRemoteSocketAddress();
//
//                // On affiche quelques infos, pour le débuggage
//                String debug = "";
//                debug = "Thread : " + Thread.currentThread().getName() + ". ";
//                debug += "Demande de l'adresse : " + remote.getAddress().getHostAddress() + ".";
//                debug += " Sur le port : " + remote.getPort() + ".\n";
//                debug += "\t -> Commande reçue : " + response + "\n";
//                System.err.println("\n" + debug);

//                 On traite la demande du client en fonction de la commande envoyée
//                String toSend = "";
//
//                switch (response.toUpperCase()) {
//                    case "FULL":
//                        toSend = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM)
//                                .format(new Date());
//                        break;
//                    case "DATE":
//                        toSend = DateFormat.getDateInstance(DateFormat.FULL).format(new Date());
//                        break;
//                    case "HOUR":
//                        toSend = DateFormat.getTimeInstance(DateFormat.MEDIUM).format(new Date());
//                        break;
//                    case "CLOSE":
//                        toSend = "Communication terminée";
//                        closeConnexion = true;
//                        break;
//                    default:
//                        toSend = "Commande inconnu !";
//                        break;
//                }
//
//                // On envoie la réponse au client
//                writer.write(toSend);
//                // Il FAUT IMPERATIVEMENT UTILISER flush()
//                // Sinon les données ne seront pas transmises au client
//                // et il attendra indéfiniment
//                writer.flush();

                if (closeConnexion) {
                    System.err.println("COMMANDE CLOSE DETECTEE ! ");
                    writer = null;
                    reader = null;
                    sock.close();
                    break;
                }
            } catch (SocketException e) {
                System.err.println("LA CONNEXION A ETE INTERROMPUE ! ");
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // La méthode que nous utilisons pour lire les réponses
    private String read() throws IOException {
        String response = "";
        int stream;
        byte[] b = new byte[4096];
        stream = reader.read(b);
        response = new String(b, 0, stream);
        return response;
    }

}