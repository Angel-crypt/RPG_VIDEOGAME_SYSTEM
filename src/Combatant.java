public interface Combatant {
    void attack(Character target);
    void defend();
    void useSpecialAbility();
    default void showCombatStatus(){
        System.out.println("Preparado para el combate!");
    };
}
