package domain.squadron;

import domain.classes.Archer;
import domain.classes.Mage;
import domain.classes.Warrior;
import domain.classes.impl.Race;
import domain.squadron.factories.SquadronAbstractFactory;
import domain.squadron.factories.SquadronFactory;

public class Squadron {
    private Mage mage;
    private Archer archer;
    private Warrior warrior;

    public Squadron() {

    }

    public void createSquadron(SquadronAbstractFactory squadronAbstractFactory) {
        mage = squadronAbstractFactory.createMage();
        archer = squadronAbstractFactory.createArcher();
        warrior = squadronAbstractFactory.createWarrior();
    }

    public void attack() {
        mage.cast();
        archer.shoot();
        warrior.attack();
    }

    public static SquadronBuilder newBuilder() {
        return new Squadron().new SquadronBuilder();
    }

    public class SquadronBuilder { // Chained Builder pattern + Factory method
        private final SquadronFactory factory;

        private SquadronBuilder() {
            factory = SquadronFactory.getInstance();
        }

        public SquadronBuilder setMage(Race race) {
            Squadron.this.mage = factory.createMage(race);
            return this;
        }

        public SquadronBuilder setWarrior(Race race) {
            Squadron.this.warrior = factory.createWarrior(race);
            return this;
        }

        public SquadronBuilder setArcher(Race race) {
            Squadron.this.archer = factory.createArcher(race);
            return this;
        }

        public Squadron build() {
            return Squadron.this;
        }
    }
}
