package Test;

import java.util.*;

public class Map_Set_List
{

    public static void main(String[] args)
    {
        List<String> list = new ArrayList<>();
        list.add("Vasu");
        list.add("Goel");
        list.add("Vasu");
        System.out.println("list = " + list);
        //System.out.println(list.get(2));
//        for (int i = 0; i < list.size(); i++)
//        {
//            System.out.println(list.get(i));
//        }
        for (String temp : list)  // foreach or customised for loop
        {
            System.out.println(temp);
        }
        Set<String> set = new HashSet<>();  // does not allow the duplicate values and does not allow index based access
        set.add("Vasu");
        set.add("Goel");
        set.add("Vasu");
        System.out.println("set = " + set);  // set also does not maintain the insertion order
        for(String temp : set)
        {
            System.out.println(temp);
        }

        Map<Integer,String> map = new HashMap<>();   // key value storage system in map
        map.put(1,"Vasu Goel");
        map.put(2,"Mudit Pundir");
        map.put(4,"Medisetti Deepak");  // it arranges all the values in ascending order based on the key values
        map.put(3,"Navish Kumar");      // duplicate values are not allowed in map
        map.put(3,"Aditya Kumar Singh");
        System.out.println(map);

        Map<String,String> countriescapital = new HashMap<>();
        countriescapital.put("India","New Delhi");
        countriescapital.put("China","Beijing");
        countriescapital.put("USA","Washington DC");
        System.out.println(countriescapital.get("India"));
        System.out.println(countriescapital.get("Germany")); // it will return the null value as it is not present in map


        Set<Integer> keys = map.keySet();  // converting the keys of map to set and then accessing them through for each loop
        for(Integer x : keys)
        {
            System.out.println(x);
            System.out.println(map.get(x));  // accessing the values of keys using the foreach and set
        }

        Set<String> capitals = countriescapital.keySet();
        for(String str: capitals)
        {
            System.out.println(str + ":" + countriescapital.get(str));
        }
    }
}
