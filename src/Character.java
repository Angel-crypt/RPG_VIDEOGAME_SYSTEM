public abstract class Character implements Combatant {
    // Paso 1: Atributos con modificadores correspondientes
    private static int characterCounter = 0;
    protected static final int MAXIMUM_LIFE_BASE = 100;
    protected static final int MAXIMUM_MANA_BASE = 50;
    protected String name;
    protected int level, life, maxLife, mana, maxMana;
    protected boolean defending;
    private final int id;
    private int experience;

    // Paso 2: Constructor
    public Character(String name){
        characterCounter++;
        this.id = characterCounter;
        this.name = name;
        this.level = 1;
        this.experience = 0;
        this.defending = false;

        initializeStatistics();
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", life=" + life +
                ", maxLife=" + maxLife +
                ", mana=" + mana +
                ", maxMana=" + maxMana +
                ", defending=" + defending +
                ", id=" + id +
                ", experience=" + experience +
                '}';
    }

    // Getters and Setter
    public static int getCharacterCounter() {
        return characterCounter;
    }
    public static void setCharacterCounter(int characterCounter) {
        Character.characterCounter = characterCounter;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    public int getLife() {return life;}
    public boolean isAlive() {
        return life > 0;
    }
    public void setLife(int life) {
        this.life = life;
    }
    public int getMaxLife() {
        return maxLife;
    }
    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public int getMaxMana() {
        return maxMana;
    }
    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public boolean isDefending() {
        return defending;
    }
    public void setDefending(boolean defending) {
        this.defending = defending;
    }

    public int getId() {
        return id;
    }

    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }

    // Paso 3: Métodos concretos
    public final void levelUp(){
        this.level++;
        this.experience = 0;

        increaseStatistics();

        System.out.println("Subiste de nivel!!!! Ahora eres:"+ this.level);
    }

    // Paso 4: Métodos abstractos
    public abstract int calculateDamage();
    public final void receiveDamage(int damage){
        int finalDamage = damage;
        if(isDefending()){
            finalDamage = damage/2;
        }

        life -= finalDamage;
        if(life <= 0){ life = 0;}

        System.out.println("Has recibido " + finalDamage + "puntos de daño. Vida restante: " + life);

        if (life == 0){
            System.out.println("Has sido derrotado!");
        }

        setDefending(false);
    };

    public abstract String getDescription();
    protected abstract void initializeStatistics();
    protected abstract void increaseStatistics();

    // Métodos estáticos
    public static int getTotalCharacters() {
        return characterCounter;
    }
}
