import customtreemap.CustomTreeMap;

public class Test {
    public static void main(String[] args) {
        CustomTreeMap<Integer, String> map = new CustomTreeMap<>();
        map.put(12, "Hello World!");
        map.put(16, "Hello!");
        map.put(19, "!");
        map.put(10, "I");
        System.out.println(map.get(10));
        System.out.println();
        map.remove(19);
        System.out.println(map.get(19));
        System.out.println();
        map.clear();
        System.out.println(map.get(12));
    }
}
