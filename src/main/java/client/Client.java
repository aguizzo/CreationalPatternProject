package client;

import domain.classes.impl.Race;
import domain.factories.SquadronAbstractFactory;
import domain.factories.impl.ElvenSquadronFactory;
import domain.factories.impl.HumanSquadronFactory;
import domain.squadron.Squadron;

public class Client {
    public static void main(String[] args) {
        SquadronAbstractFactory elvenFactory = new ElvenSquadronFactory();
        SquadronAbstractFactory humanFactory = new HumanSquadronFactory();

        System.out.println(" ===== Elven squad ===== ");
        Squadron elvenSquad = new Squadron();
        elvenSquad.createSquadron(elvenFactory);
        elvenSquad.attack();

        System.out.println(" ===== Human squad ===== ");
        Squadron humanSquad = new Squadron();
        humanSquad.createSquadron(humanFactory);
        humanSquad.attack();

        System.out.println(" ===== Mixed squad ===== ");
        Squadron mixedSquadron = Squadron.newBuilder()
                .setArcher(Race.ELF)
                .setMage(Race.ELF)
                .setWarrior(Race.HUMAN)
                .build();
        mixedSquadron.attack();

        System.out.println(" ===== Mixed squad 2 ===== ");
        Squadron mixedSquadron2 = Squadron.newBuilder()
                .setArcher(Race.HUMAN)
                .setMage(Race.HUMAN)
                .setWarrior(Race.ELF)
                .build();
        mixedSquadron2.attack();
    }
}