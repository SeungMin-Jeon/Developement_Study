package org.Fantasy;

public class War {
    public static void main(String[] args) {
        Character queen = new Queen();
        queen.performFight();
        queen.setFight(new AxeBehavior());
        queen.performFight();
    }
}
