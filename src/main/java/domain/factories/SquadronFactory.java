package domain.factories;

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

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SquadronFactory {
    private static SquadronFactory instance;
    private static Map<Race, Supplier<Mage>> mageConstructorMap;
    private static Map<Race, Supplier<Warrior>> warriorConstructorMap;
    private static Map<Race, Supplier<Archer>> archerConstructorMap;

    private SquadronFactory() {
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

    public static synchronized SquadronFactory getInstance() {
        if (instance == null) {
            instance = new SquadronFactory();
        }
        return instance;
    }

    public Mage createMage(Race race) {
        return mageConstructorMap.get(race).get();
    }

    public Warrior createWarrior(Race race) {
        return warriorConstructorMap.get(race).get();
    }

    public Archer createArcher(Race race) {
        return archerConstructorMap.get(race).get();
    }
}
