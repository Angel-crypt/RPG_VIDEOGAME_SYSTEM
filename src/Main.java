public class Main {
    public static void main(String[] args) {
        gameSettings.showGameInformation();
        Character [] characters = new Character[3];
        characters[0] = new Warrior("Ashgaroth");
        characters[1] = new Magician("Eldryn");
        characters[2] = new Goalkeeper("Grendalock");

        for (Character character : characters) {
            System.out.println(character.toString());
            System.out.println(gameSettings.getRangeLevel(character.getLevel()));
        }
    }

    private static void performCombat(Character attackingCharacter, Character defendingCharacter){

    }
}