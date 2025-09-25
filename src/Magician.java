public class Magician extends Character{
    private static final int MANA_MULTIPLIER = 3;
    private static final int MANA_COST_ATTACK = 15;
    private static final int MANA_COST_SKILL = 25;

    public Magician(String name) {
        super(name);
    }

    @Override
    protected void initializeStatistics() {
        maxLife = MAXIMUM_LIFE_BASE/2;
        life = maxLife;

        maxMana = MAXIMUM_MANA_BASE * MANA_MULTIPLIER;
        mana = maxMana;
    }

    @Override
    protected void increaseStatistics() {
        maxLife += 20;
        life = maxLife;

        maxMana += 5;
        mana = maxMana;
    }

    @Override
    public int calculateDamage() {
        return 25 + (level*5);
    }

    public String description() {
        return "Magician{" +
                "name='" + name + '\'' +
                ", defending=" + defending +
                ", maxMana=" + maxMana +
                ", mana=" + mana +
                ", maxLife=" + maxLife +
                ", life=" + life +
                ", level=" + level +
                '}';
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public void attack(Character target) {
        boolean isAlive = isAlive();
        if (!isAlive) {
            System.out.println("ERROR: El personaje esta muerto.");
        }
        if (this.mana >= MANA_COST_ATTACK){
            int damage = calculateDamage();
            System.out.println("Ataque magico");
            // target.receiveDamage(damage);
        } else {
            System.out.println("ERROR: No tienes suficiente mana.");
        }
    }

    @Override
    public void useSpecialAbility() {
        if (this.mana >= MANA_COST_SKILL) {
            this.mana -= MANA_COST_SKILL;
            life = maxLife;
            System.out.println("VIDA RESTAURADA");
        }  else {
            System.out.println("ERROR: No tienes suficiente mana.");
        }
    }

    @Override
    public void defend() {
        defending = true;
    }
}
