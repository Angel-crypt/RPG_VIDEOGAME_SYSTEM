public final class gameSettings {
    public static final String GAME_VERSION = "1.0.0";
    public static final int MAX_LEVEL = 50;
    public static final int EXPERIENCE_BY_LEVEL = 100;

    private gameSettings() {
        throw new UnsupportedOperationException("Clase de utilidades - no instanciar");
    }

    public static void showNumberOfCharacters(){
        System.out.println("Existen " + Character.getTotalCharacters() + " personajes disponibles.");
    }

    public static void showGameInformation(){
        System.out.println("Estas en la version " + GAME_VERSION + " del juego.");
        showNumberOfCharacters();
    }

    public static String getRangeLevel(int level) {
        if (level >= 1 && level <= 10) {
            return "Novato";
        } else if (level >= 11 && level <= 25) {
            return "Experimentado";
        } else if (level >= 26 && level <= 40) {
            return "Veterano";
        }
        return "Legendario";
    }
}
