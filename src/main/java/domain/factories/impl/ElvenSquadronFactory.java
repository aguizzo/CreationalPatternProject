package domain.factories.impl;

import domain.classes.Archer;
import domain.classes.Mage;
import domain.classes.Warrior;
import domain.classes.impl.elfs.ElfArcher;
import domain.classes.impl.elfs.ElfMage;
import domain.classes.impl.elfs.ElfWarrior;
import domain.factories.SquadronAbstractFactory;

public class ElvenSquadronFactory extends SquadronAbstractFactory {
    @Override
    public Mage createMage() {
        return new ElfMage();
    }

    @Override
    public Archer createArcher() {
        return new ElfArcher();
    }

    @Override
    public Warrior createWarrior() {
        return new ElfWarrior();
    }
}
