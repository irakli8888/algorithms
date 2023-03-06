
import collection.ArrayListCustom;
import collection.ListCustom;



public class Main {
    public static void main(String[] args) {
        ListCustom<String> abstractListCustom = new ArrayListCustom<>();
        System.out.println("add 20 elements");
        for (int i = 0; i <= 20; i++) {
            abstractListCustom.add(i + "");
        }
        for (int i = 0; i < abstractListCustom.size(); i++) {
            System.out.println(abstractListCustom.get(i) + " :" + i);
        }
        System.out.println("deleting an item with index 3");
        abstractListCustom.remove(3);
        for (int i = 0; i < abstractListCustom.size(); i++) {
            System.out.println(abstractListCustom.get(i) + " :" + i);
        }
        System.out.println("adding by index 6");
        abstractListCustom.add("6 new", 6);
        for (int i = 0; i < abstractListCustom.size(); i++) {
            System.out.println(abstractListCustom.get(i) + " :" + i);
        }
    }
}
