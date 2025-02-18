package domain.classes.impl.elfs;

import domain.classes.Mage;

public class ElfMage implements Mage {
    @Override
    public void cast() {
        System.out.println("Elf Mage casts wind magic.");
    }
}
