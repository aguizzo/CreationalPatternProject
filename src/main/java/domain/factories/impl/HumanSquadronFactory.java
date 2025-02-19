package domain.factories.impl;

import domain.classes.Archer;
import domain.classes.Mage;
import domain.classes.Warrior;
import domain.classes.impl.humans.HumanArcher;
import domain.classes.impl.humans.HumanMage;
import domain.classes.impl.humans.HumanWarrior;
import domain.factories.SquadronAbstractFactory;

public class HumanSquadronFactory extends SquadronAbstractFactory {
    @Override
    public Mage createMage() {
        return new HumanMage();
    }

    @Override
    public Archer createArcher() {
        return new HumanArcher();
    }

    @Override
    public Warrior createWarrior() {
        return new HumanWarrior();
    }
}
