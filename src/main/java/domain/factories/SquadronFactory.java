package domain.factories;

import domain.classes.Archer;
import domain.classes.Mage;
import domain.classes.Warrior;

public abstract class SquadronFactory {

    public abstract Mage createMage();

    public abstract Archer createArcher();

    public abstract Warrior createWarrior();
}
