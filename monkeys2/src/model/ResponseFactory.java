package model;

import java.util.ArrayList;

/**
 * Factory permettant de créer les String qui seront renvoyés au client par la suite.
 * 
 * @author bij
 *
 */
public class ResponseFactory {

    /**
     * Separateur entre les argument des commandes.
     */
    public static final String SEPARATOR = "-";

    /**
     * Charactere de fin de ligne.
     */
    public static final String EOL = "\n";

    /**
     * Constructeur.
     */
    public ResponseFactory() {
        GameMaster.getInstance();
    }

    /**
     * Méthode créant la string a renvoyer au client suite a son inscription a partir de son pirate.
     * 
     * @param pirate pirate inscrit
     * @return string
     */
    public String acceptedInscription(Pirate pirate) {
        return "/i " + pirate.getId() + SEPARATOR + pirate.getPosX() + SEPARATOR + pirate.getPosY()
                + SEPARATOR + pirate.getEnergy() + '\n';
    }

    /**
     * Méthode créant la strinf a renvoyer au client a partir d'une liste de pirate ainsi que le
     * pirate a séparer de cette liste.
     * 
     * @param listPirate list des pirate
     * @param myPirate   pirate a exclure
     * @return string
     */
    public String listOtherPirates(ArrayList<Pirate> listPirate, Pirate myPirate) {
        StringBuffer sb = new StringBuffer("/P ");
        if (listPirate.size() > 0) {
            for (Pirate pirate : listPirate) {
                if (pirate != myPirate) {
                    sb.append(pirate.getId()).append(SEPARATOR).append(pirate.getPosX())
                            .append(SEPARATOR).append(pirate.getPosY()).append(SEPARATOR);
                }
            }
            sb.deleteCharAt(sb.length());
        }
        return sb.toString() + '\n';
    }

    /**
     * Méthode créant la string a renvoyer au client a partir d'un liste de rhum.
     * 
     * @param listRhum list des rhum
     * @return string
     */
    public String listRhums(ArrayList<Rhum> listRhum) {
        StringBuffer sb = new StringBuffer("/B ");
        if (listRhum.size() > 0) {
            for (Rhum rhum : listRhum) {
                sb.append(rhum.getPosX()).append(SEPARATOR).append(rhum.getPosY()).append(SEPARATOR)
                        .append(rhum.getVisible()).append(SEPARATOR);

            }
            sb.deleteCharAt(sb.length());
        }
        return sb.toString() + '\n';
    }

    /**
     * Méthode créant la string a renvoyer au client pour les information des singes erratiques a
     * partir d'un liste de singe.
     * 
     * @param listMonkey list de singes
     * @return string
     */
    public String listMonkeyErratic(ArrayList<Monkey> listMonkey) {
        StringBuffer sb = new StringBuffer("/e ");
        if (listMonkey.size() > 0) {
            for (Monkey monkey : listMonkey) {
                if (monkey.getType() == EMonkeyType.ERRATIC) {
                    sb.append(monkey.getPosX()).append(SEPARATOR).append(monkey.getPosY())
                            .append(SEPARATOR);
                }

            }
            sb.deleteCharAt(sb.length());
        }
        return sb.toString() + '\n';
    }

    /**
     * Méthode créant la string a renvoyer au client pour les information des singes chasseur a
     * partir d'un liste de singe.
     * 
     * @param listMonkey list des singes
     * @return string
     */
    public String listMonkeyHunter(ArrayList<Monkey> listMonkey) {
        StringBuffer sb = new StringBuffer("/c ");
        if (listMonkey.size() > 0) {
            for (Monkey monkey : listMonkey) {
                if (monkey.getType() == EMonkeyType.HUNTER) {
                    sb.append(monkey.getPosX()).append(SEPARATOR).append(monkey.getPosY())
                            .append(SEPARATOR);
                }

            }
            sb.deleteCharAt(sb.length());
        }
        return sb.toString() + '\n';
    }

    /**
     * .
     * 
     * @param pirate pirate supprimé de la partie
     * @return string
     */
    public String deletePirate(Pirate pirate) {
        return "/s " + pirate.getId() + '\n';
    }
}
