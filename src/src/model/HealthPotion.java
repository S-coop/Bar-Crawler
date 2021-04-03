package src.model;

public class HealthPotion {

    private int heals;

    /**
     * Constructor for a health potion
     * @param heals the amount the potion heals for
     */
    public HealthPotion(int heals) {
        this.heals = 5;
    }

    /**
     * Getter to access the heals of a health potion.
     * @return the heals of the potion.
     */
    public int getHeals() {
        return this.heals;
    }
}
