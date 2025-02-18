package domain.classes.impl.humans;

import domain.classes.Warrior;

public class HumanWarrior implements Warrior {
    @Override
    public void attack() {
        System.out.println("Human warrior attacks.");
    }
}
