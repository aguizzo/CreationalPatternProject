package domain.classes.impl.humans;

import domain.classes.Archer;

public class HumanArcher implements Archer {
    @Override
    public void shoot() {
        System.out.println("Human Archer shoots.");
    }
}
