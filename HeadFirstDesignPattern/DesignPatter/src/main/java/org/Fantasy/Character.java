package org.Fantasy;

public abstract class Character {

    WeaponBehavior weapon;

    public void performFight() {
        weapon.fight();
    }
    public void setFight(WeaponBehavior wb) {
        this.weapon = wb;
    }
}
