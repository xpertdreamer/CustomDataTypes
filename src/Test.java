import customhashmap.CustomHashMap;

public class Test {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        System.out.println(map.put("Eleven", 11));

        System.out.println(map.containsKey("Three"));
        System.out.println(map.containsKey("Four"));
        System.out.println(map.size());
        System.out.println(map.get("Two"));
        map.put("Two", 22);
        System.out.println(map.get("Two"));
        map.remove("Three");
        System.out.println(map.get("Three"));
    }
}
