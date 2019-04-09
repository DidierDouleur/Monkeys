package Experimentation;

/**
 * Classe du protocole de communication de MonkeyIsland avec un client Guybrush.
 * 
 * @version 1.0
 * @author Matthias Brun, Camille Constant
 * 
 */
public final class ProtocoleMonkeyIsland {
    /**
     * Taille d'une commande.
     */
    private static final int TAILLE_COMMANDE = 2;

    /**
     * Caractere prefixant une commande.
     */
    static final char CARACTERE_COMMANDE = '/';

    /**
     * Commande de demande d'inscription du pirate.
     */
    static final char INSCRIPTION_PIRATE = 'I';

    /**
     * Commande d'indication de l'identifiant du pirate.
     */
    static final char IDENTIFIANT_PIRATE = 'i';

    /**
     * Commande de demande de deplacement d'un pirate.
     */
    static final char DEPLACEMENT_PIRATE = 'D';

    /**
     * Commande de refus de deplacement d'un pirate.
     */
    static final char REFUS_DEPLACEMENT_PIRATE = 'R';

    /**
     * Commande d'acceptation de deplacement d'un pirate.
     */
    static final char ACCEPTATION_DEPLACEMENT_PIRATE = 'A';

    /**
     * Commande d'indication de tous les pirates.
     */
    static final char TOUS_PIRATES = 'P';

    /**
     * Commande d'indication d'un nouveau pirate.
     */
    static final char NOUVEAU_PIRATE = 'n';

    /**
     * Commande d'indication de suppression d'un pirate.
     */
    static final char SUPPRESSION_PIRATE = 's';

    /**
     * Commande d'indication d'un pirate deplace.
     */
    static final char PIRATE_DEPLACE = 'p';

    /**
     * Commande d'indication de la carte.
     */
    static final char CARTE = 'C';

    /**
     * Commande d'indication des positions des singes erratiques.
     */
    static final char SINGES_ERRATIQUES = 'e';

    /**
     * Commande d'indication des positions des singes chasseurs.
     */
    static final char SINGES_CHASSEURS = 'c';

    /**
     * Commande d'indication des positions et de la visibilite des bananes.
     */
    static final char BANANES = 'B';

    /**
     * Commande d'indication de visibilite d'une banane.
     */
    static final char VISIBILITE_BANANE = 'b';

    /**
     * Commande d'indication du tresor.
     */
    static final char TRESOR = 'T';

    /**
     * Commande d'indication d'une nouvelle partie.
     */
    static final char NOUVELLE_PARTIE = 'N';

    /**
     * Separateur de champs d'information differents.
     */
    static final String SEPARATEUR_CHAMPS = " ";

    /**
     * Separateur de champs d'information pour un objet.
     */
    static final String SEPARATEUR_CHAMPS_OBJET = "-";

    /**
     * Separateur d'objets dans un ensemble d'objets.
     */
    static final String SEPARATEUR_OBJETS = "___";

    /**
     * Message erreur.
     */
    static final String MESSAGE_ERREUR = "Erreur MonkeyIsland : ";

    /**
     * Constructeur privé d'un protocole de communication avec un client.
     * 
     * Ce constructeur privé assure la non-instanciation d'un protocole de communication dans un
     * programme (le protocole n'offre que des attributs et des méthodes statiques).
     */
    private ProtocoleMonkeyIsland() {
        // Constructeur privé pour assurer la non-instanciation d'un protocole de communication.
    }

    /**
     * Formate une commande sans paramètre à partir de son nom.
     * 
     * <p>
     * La construction d'une commande se fait en préfixant son nom par le caractère
     * CARACTERE_COMMANDE et en le suffixant par un espace.
     * </p>
     *
     * @param commande la commande à formater.
     * @return la commande formatée.
     *
     */
    public static final String formateCommande(char commande) {
        return Character.toString(ProtocoleMonkeyIsland.CARACTERE_COMMANDE) + commande + " ";
    }

    /**
     * Retourne les paramètres d'une commande dans un tableau de chaînes de caractères.
     * 
     * @param commande   la commande d'où extraire les paramètres.
     * @param separateur le séparateur permettant de distinguer les paramètres dans la commande.
     * @return le tableau des paramètres de la commande.
     */
    public static final String[] parametresCommande(String commande, String separateur) {
        String chaineParametres = "";
        String[] parametres = null;

        if (commande.length() > ProtocoleMonkeyIsland.TAILLE_COMMANDE + 1) {
            chaineParametres = commande.substring(ProtocoleMonkeyIsland.TAILLE_COMMANDE + 1,
                    commande.length());
            parametres = chaineParametres.split(separateur);
        }
        return parametres;
    }

    /**
     * Valide qu'un message respecte bien le format d'une commande.
     *
     * @param message le message à analyser.
     * 
     * @return vrai (<i>true</i>) si le message est une commande, faux (<i>false</i>) sinon.
     */
    public static final Boolean estUneCommande(String message) {
        return (message.length() > 1)
                && (message.charAt(0) == ProtocoleMonkeyIsland.CARACTERE_COMMANDE);
    }

    /**
     * Donne la commande d'un message.
     * 
     * <p>
     * La commande est identifiée par le second caractère d'un message (le premier caractère étant
     * ProtocoleMonkeyIsland.CARACTERE_COMMANDE).
     * </p>
     * 
     * @param message le message d'où extraire la commande.
     * 
     * @return la commande du message.
     */
    public static final char commandeDuMessage(String message) {
        return message.charAt(1);
    }

}
