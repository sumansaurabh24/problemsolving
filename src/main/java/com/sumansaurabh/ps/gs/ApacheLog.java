package com.sumansaurabh.ps.gs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ApacheLog {

    static String[] findTopIpaddress(String[] lines){
        HashMap<String,Integer> m=new HashMap<>();
        Arrays.stream(lines).forEach(l->{m.compute(l.split(" ")[0],(k,v)->(v==null)? 1: v+1);});
        int max=m.entrySet().stream().max((e1,e2)->e1.getValue().compareTo(e2.getValue())).get().getValue();
        return m.entrySet().stream().filter(e->e.getValue()==max).map(e->e.getKey()).toArray(String[]::new);
    }

    public static void main(String[] args) {
        String lines[] = new String[] { "10.0.0.1 - log entry 1 11", "10.0.0.1 - log entry 2 213",
                "10.0.0.2 - log entry 133132", "10.0.0.2 - log entry 133132" };
        String result[] = findTopIpaddress(lines);

        System.out.println(result[0]);
    }
}
