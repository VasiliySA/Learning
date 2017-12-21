/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordscount;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author vsakin
 */
public class ScannerFile  {
    private int lenght;
    private int iter;
    private int freq; 
    final List<Object> linkedList;
    
    public  ScannerFile() throws IOException {
        
        HashMap<String, Integer> map = new HashMap<>();
        ValueComparator bvc = new ValueComparator(map);
        TreeMap<String, Integer> sorted_map = new TreeMap<>(bvc);
        linkedList = new LinkedList<>();
        
        ReadFile scanner = new ReadFile();
        
        while (scanner.scannerFile.hasNext()) {
            String character = scanner.scannerFile.next();
            String pattern = "(^(?!and|is|to|am|from|a|will|the|are|be|etc|of|no|you|or|I|in\b).*(^[a-zA-Z]*$))";
            Pattern r = Pattern.compile(pattern, Pattern.MULTILINE + Pattern.CASE_INSENSITIVE);
            Matcher m = r.matcher(character);

            if (m.find()) {
             
                linkedList.add(m.group());
                               
            }

        }
            for (iter = 0; iter < linkedList.size(); iter++){
                freq = 0;
                freq += Collections.frequency(linkedList, linkedList.get(iter));
                map.put((String) linkedList.get(iter), freq);
            }
        
        sorted_map.putAll(map);
        System.out.println("results: " + sorted_map);
    
    }

    class ValueComparator implements Comparator<String> {
        Map<String, Integer> base;

        public ValueComparator(Map<String, Integer> base) {
            this.base = base;
        }

        @Override
        public int compare(String a, String b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
                } 
        }   
    }
}

