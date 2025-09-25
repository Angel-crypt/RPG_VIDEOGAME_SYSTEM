public class Warrior extends Character {
    private static final int LIFE_MULTIPLIER = 2;
    private static final int MANA_COST_SKILL = 10;

    public Warrior(String name) {
        super(name);
    }

    @Override
    protected void initializeStatistics() {
        maxLife = MAXIMUM_LIFE_BASE * LIFE_MULTIPLIER;
        life = maxLife;

        maxMana = MAXIMUM_MANA_BASE/2;
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
        return "Warrior{" +
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
        return description();
    }

    @Override
    public void attack(Character target) {
        boolean isAlive = isAlive();
        if (!isAlive) {
            System.out.println("ERROR: El personaje esta muerto.");
        }
        int damage = calculateDamage();
        System.out.println("Ataque con espada");
        target.receiveDamage(damage);
    }

    @Override
    public void useSpecialAbility() {
        if (this.mana >= MANA_COST_SKILL) {
            this.mana -= MANA_COST_SKILL;
            System.out.println("FURIA BERSERKER");
        }  else {
            System.out.println("ERROR: No tienes suficiente mana.");
        }
    }

    @Override
    public void defend() {
        defending = true;
    }
}
