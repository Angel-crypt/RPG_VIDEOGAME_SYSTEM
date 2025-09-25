public class Main {
    public static void main(String[] args) {
        gameSettings.showGameInformation();
        Character [] characters = new Character[3];
        characters[0] = new Warrior("Ashgaroth");
        characters[1] = new Magician("Eldryn");
        characters[2] = new Goalkeeper("Grendalock");
        gameSettings.showNumberOfCharacters();

        for (Character character : characters) {
            System.out.println("----");
            System.out.println(character.toString());
            System.out.println("El rango del personaje es: " + gameSettings.getRangeLevel(character.getLevel()));
            System.out.println("----");
        }

        performCombat(characters[0],  characters[1]);
    }

    private static void performCombat(Character attackingCharacter, Character defendingCharacter){
        attackingCharacter.showCombatStatus();
        defendingCharacter.defend();
        attackingCharacter.attack(defendingCharacter);

        System.out.println("Estadísticas del atacante: " + attackingCharacter.toString());
        System.out.println("Estadísticas del defensor: " + defendingCharacter.toString());
    }
}