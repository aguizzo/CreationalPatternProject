package domain.classes.impl.elfs;

import domain.classes.Archer;

public class ElfArcher implements Archer {
    @Override
    public void shoot() {
        System.out.println("Elf Archer shoots.");
    }
}
