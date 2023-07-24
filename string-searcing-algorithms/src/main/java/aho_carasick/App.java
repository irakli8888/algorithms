package aho_carasick;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<String> pattern = new ArrayList<>();
        pattern.add("A");
        pattern.add("AS");
        pattern.add("ARAB");
        pattern.add("BAR");
        pattern.add("BASS");
        pattern.add("C");
        pattern.add("CAR");
        pattern.add("RA");
        pattern.add("RAB");

        AhoCarasick ahoCarasick = new AhoCarasick(pattern);

        System.out.println(ahoCarasick.findMatches("CARABASSBARABASS").size());

        System.out.println("");
    }
}
