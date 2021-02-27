package com.codecool.nursery;

import com.codecool.nursery.children.Child;
import com.codecool.nursery.children.ConvenientChild;
import com.codecool.nursery.children.LivelyChild;
import com.codecool.nursery.children.MusicLoverChild;
import com.codecool.nursery.groups.Nursery;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MusicLoverChild musicChild1 = new MusicLoverChild("Joe");
        LivelyChild livelyChild1 = new LivelyChild("Sue");
        ConvenientChild convenientChild1 = new ConvenientChild("Anna");
        MusicLoverChild musicChild2 = new MusicLoverChild("Jenny");
        LivelyChild livelyChild2 = new LivelyChild("Benny");
        ConvenientChild convenientChild2 = new ConvenientChild("Henry");
        MusicLoverChild musicChild3 = new MusicLoverChild("Mary");
        LivelyChild livelyChild3 = new LivelyChild("Britney");
        ConvenientChild convenientChild3 = new ConvenientChild("Christine");
        MusicLoverChild musicChild4 = new MusicLoverChild("Steve");
        LivelyChild livelyChild4 = new LivelyChild("Darren");
        ConvenientChild convenientChild4 = new ConvenientChild("Julie");
        ArrayList<Child> children = new ArrayList<>(
                List.of(
                        musicChild1,
                        livelyChild1,
                        convenientChild1,
                        musicChild2,
                        livelyChild2,
                        convenientChild2,
                        musicChild3,
                        livelyChild3,
                        convenientChild3,
                        musicChild4,
                        livelyChild4,
                        convenientChild4
                )
        );
        Nursery nursery = new Nursery(children, "SUNSHINE Group", "MOON Group", "OCEAN Group");
        nursery.simulateOneDay();
    }

}
