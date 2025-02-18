package domain.classes.impl.humans;

import domain.classes.Mage;

public class HumanMage implements Mage {

    @Override
    public void cast() {
        System.out.println("Human Mage casts fire magic.");
    }
}
