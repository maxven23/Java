package arraylist;



public class Main {
    public static void main(String[] args) {
        List list = new List();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        list.add(4, 2);
        System.out.println(list);

        System.out.println(list.get(1));
        System.out.println(list);
        System.out.println(list.remove(3));
        System.out.println(list);
        System.out.println(list.set(5, 1));
        System.out.println(list);

        System.out.println(list.contains(1));
        System.out.println(list.contains(3));

        System.out.println(list.indexOf(1));
        System.out.println(list.indexOf(3));


        Map map = new Map(16);
        List list1 = new List(5);
        map.put(1, 0);
        map.put(2, 1);
        map.put(3, list1);
        map.put("hello", "mr");
        map.put("mr", "admin");
        map.put("admin", "world");
        System.out.print("Keys: ");
        System.out.println(map.getKeys());
        System.out.println(map);

        System.out.println("key: \"admin\" - value: \"" + map.get("admin") + "\"");
        System.out.println("Removed element with key \"hello\": \"" + map.remove("hello") + "\"");
        map.printMap();

        System.out.println(map.keyContains("hello"));
        System.out.println(map.keyContains(1));
    }
}