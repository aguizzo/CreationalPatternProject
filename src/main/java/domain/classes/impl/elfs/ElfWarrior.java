package domain.classes.impl.elfs;

import domain.classes.Warrior;

public class ElfWarrior implements Warrior {
    @Override
    public void attack() {
        System.out.println("Elf warrior attacks.");
    }
}
