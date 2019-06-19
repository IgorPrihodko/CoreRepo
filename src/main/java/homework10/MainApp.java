package homework10;

public class MainApp {
    public static void main(String[] args) {
        MyHashMap<String, String> hashMap = new MyHashMap<>();
        hashMap.put("1vv", "1");
        hashMap.put("2dd", "2");
        hashMap.put(null, "3");
        System.out.println(hashMap);
        hashMap.put("1", "changed First");
        System.out.println(hashMap);
        System.out.println(hashMap.removeNode("2dd"));
        System.out.println(hashMap);
        hashMap.put("112123", "4");
        hashMap.put("122345", "5");
        hashMap.put("1245m6", "6");
        System.out.println(hashMap.get("234"));
        System.out.println(hashMap.get(null));
        hashMap.put("133f45", "7");
        hashMap.put("15g64", "8");
        hashMap.put("12f35", "9");
        hashMap.put("324n64", "10");
        hashMap.put("472y25", "11");
        hashMap.put("3g254", "12");
        hashMap.put("172g56", "13");
        System.out.println(hashMap);
    }
}
