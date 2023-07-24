package knut_morris_pratt;

public class KMP {

    public static void main(String[] args) {
        Auto auto = new Auto("AABAABAAABA");
        System.out.println(auto.search("AABAABAABAAABA"));
    }
}
