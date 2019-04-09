package model;

import java.io.InputStream;
import java.util.Properties;

//import org.json.JSONObject;

/**
 * Classe permettant la configuration de la partie.
 *
 */
public class Config {

    /**
     * Chemin d'accès au fichier de configuration.
     */
    private static String filePath = "config/Config.properties";

    /**
     * Objet permettant d'accéder et de lire le fichier de configuration.
     */
    private Properties properties;

    /**
     * Constructeur.
     */
    public Config() {
        this.initProperties();
    }

    /**
     * méthode initialisant l'attribut properties.
     */
    public void initProperties() {
        try {
            this.properties = new java.util.Properties();
            InputStream is = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream(filePath);
            properties.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * méthode lisant le fichier de configuration en entier pour paramétrer la partie.
     * 
     */
    public void readConfigFile() {
        this.readMapConfig();
        this.readRhumConfig();
        this.readMonkeyConfig();
        this.readTreasureConfig();
    }

    /**
     * Methode lisant un fichier de configuration définissant les paramètres de la carte selon ce
     * fichier.
     * 
     */
    public void readMapConfig() {
        try {
            int width = Integer.parseInt(properties.getProperty("MAP_WIDTH"));
            int height = Integer.parseInt(properties.getProperty("MAP_HEIGHT"));
            String mapShape = properties.getProperty("MAP_SHAPE");

            Map map = GameMaster.getInstance().getIsland().getMap();
            map.setSizeX(width);
            map.setSizeY(height);
            map.createMap(mapShape);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Methode lisant le contenu du fichier relatif au singe et qui créer les singes en fonction d
     * ce contenu.
     * 
     * TODO : construire les singes a un emplacement donné plutot que aléatoirement.
     */
    public void readMonkeyConfig() {
        try {
            int nbrErratic = Integer.parseInt(properties.getProperty("MONKEY_ERRATIC_NBR"));
            int nbrHunter = Integer.parseInt(properties.getProperty("MONKEY_HUNTER_NBR"));
            int upgrade = Integer.parseInt(properties.getProperty("MONKEY_ERRATIC_UPGRADE"));
            int speed = Integer.parseInt(properties.getProperty("MONKEY_ERRATIC_SPEED"));
            MonkeyGroup monkeyGroup = GameMaster.getInstance().getIsland().getMonkeyGroup();
            monkeyGroup.setKillToUpgrade(upgrade);
            monkeyGroup.setSpeed(speed);
            monkeyGroup.createErraticMonkeys(nbrErratic);
            monkeyGroup.createHunterMonkeys(nbrHunter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction lisant les paramètres de configuration pour les bouteille de rhum et qui modifi le
     * RhumGroup en conséquence.
     */
    public void readRhumConfig() {
        try {
            int nbr = Integer.parseInt(properties.getProperty("RHUM_BOTTLE_NBR"));
            int energy = Integer.parseInt(properties.getProperty("RHUM_BOTTLE_ENERGY"));
            int spawnTime = Integer.parseInt(properties.getProperty("RHUM_BOTTLE_SPAW_TIME"));
            GameMaster.getInstance().getIsland().getRhumGroup().createRhums(nbr, energy, spawnTime);
        } catch (NullPointerException npe) {
            System.out.println("Erreur fichier incorrect concernant le nombre de rhum");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Foction lisant les apramètre de configuration pour le trésors et qui en créé l'instance.
     */
    public void readTreasureConfig() {
        try {
            int x = Integer.parseInt(properties.getProperty("TREASURE_POSX"));
            int y = Integer.parseInt(properties.getProperty("TREASURE_POSY"));
            Treasure.getInstance(x, y);
        } catch (NullPointerException npe) {
            Treasure.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
