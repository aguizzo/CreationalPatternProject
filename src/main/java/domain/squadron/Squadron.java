package domain.squadron;

import domain.classes.Archer;
import domain.classes.Mage;
import domain.classes.Warrior;
import domain.classes.impl.Race;
import domain.classes.impl.elfs.ElfArcher;
import domain.classes.impl.elfs.ElfMage;
import domain.classes.impl.elfs.ElfWarrior;
import domain.classes.impl.humans.HumanArcher;
import domain.classes.impl.humans.HumanMage;
import domain.classes.impl.humans.HumanWarrior;
import domain.factories.SquadronFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Squadron {
    private Mage mage;
    private Archer archer;
    private Warrior warrior;

    public Squadron() {

    }

    public void createSquadron(SquadronFactory squadronFactory) {
        mage = squadronFactory.createMage();
        archer = squadronFactory.createArcher();
        warrior = squadronFactory.createWarrior();
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
        private SquadronBuilder() {
        }

        private static final Map<Race, Supplier<Mage>> mageConstructorMap;
        private static final Map<Race, Supplier<Warrior>> warriorConstructorMap;
        private static final Map<Race, Supplier<Archer>> archerConstructorMap;

        static {
            mageConstructorMap = new HashMap<>();
            mageConstructorMap.put(Race.HUMAN, HumanMage::new);
            mageConstructorMap.put(Race.ELF, ElfMage::new);

            warriorConstructorMap = new HashMap<>();
            warriorConstructorMap.put(Race.HUMAN, HumanWarrior::new);
            warriorConstructorMap.put(Race.ELF, ElfWarrior::new);

            archerConstructorMap = new HashMap<>();
            archerConstructorMap.put(Race.HUMAN, HumanArcher::new);
            archerConstructorMap.put(Race.ELF, ElfArcher::new);
        }

        public SquadronBuilder setMage(Race race) {
            Squadron.this.mage = mageConstructorMap.get(race).get();
            return this;
        }

        public SquadronBuilder setWarrior(Race race) {
            Squadron.this.warrior = warriorConstructorMap.get(race).get();
            return this;
        }

        public SquadronBuilder setArcher(Race race) {
            Squadron.this.archer = archerConstructorMap.get(race).get();
            return this;
        }

        public Squadron build() {
            return Squadron.this;
        }
    }
}
