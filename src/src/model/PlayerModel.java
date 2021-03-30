package src.model;

public class PlayerModel {

    private double hp;
    private Weapon weapon;

    /**
     * Player stat and attribute data constructor
     * @param hp the starting health points of the player
     * @param weapon the player's chosen weapon
     */
    public PlayerModel(double hp, Weapon weapon) {
        this.hp = hp;
        this.weapon = weapon;
    }

    /**
     * Getter for the player's HP
     * @return the double value for the player's HP
     */
    public double getPlayerHP() {
        return this.hp;
    }

    /**
     * Setter for the player's HP
     * @param newHP the player's new HP value
     */
    public void setPlayerHP(double newHP) {
        this.hp = newHP;
    }
}

