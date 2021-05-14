package com.example.firstdemo.utils;

import org.ansj.splitWord.analysis.ToAnalysis;

import java.io.*;
import java.util.*;

public class NLPTools {
 
    public static List<String> wordFrequency(String article) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Map<String,String > info = new HashMap<String, String>();
        String result = ToAnalysis.parse(article).toStringWithOutNature();
        System.out.println(result);
        String[] words = result.split(",");
 
 
        for(String word: words){
            String str = word.trim();
            // 过滤空白字符
            if (str.equals(""))
                continue;
                // 过滤一些高频率的符号
            else if(str.matches("[）|（|.|，|。|+|-|“|”|：|？|\\s]"))
                continue;
                // 此处过滤长度为1的str
            else if (str.length() < 2)
                continue;
 
            if (!map.containsKey(word)){
                map.put(word, 1);
            } else {
                int n = map.get(word);
                map.put(word, ++n);
            }
        }
 
        StringBuffer cp = new StringBuffer();// 词频
        StringBuffer rc = new StringBuffer();// 热词
        List<String> hotwords=new ArrayList<>();
 
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            cp.append(entry.getKey() + ": " + entry.getValue()+"\t");
            //System.out.print(entry.getKey() + ": " + entry.getValue()+"\t");
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>();
        Map.Entry<String, Integer> entry;
        while ((entry = getMax(map)) != null){
            list.add(entry);
        }
//        System.out.print("\n前五热词为:");
        rc.append("前五热词为:");
        for (int i = 0; i < (list.size()>5?5:list.size()); i++) {
            rc.append(""+list.get(i)+"\t");
            int index = (list.get(i) + "").indexOf("=");
            hotwords.add((list.get(i) + "").substring(0,index));
//            System.out.print("list  "+list.get(i)+"\t");
        }
        info.put("cp",cp.toString());
        info.put("rc",rc.toString());
        return hotwords;
//        System.out.println(Arrays.toString(list.toArray()));
 
    }
 
 
    /**
     * 找出map中value最大的entry, 返回此entry, 并在map删除此entry
     * @param map
     * @return
     */
    public static Map.Entry<String, Integer> getMax(Map<String, Integer> map){
        if (map.size() == 0){
            return null;
        }
        Map.Entry<String, Integer> maxEntry = null;
        boolean flag = false;
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            if (!flag){
                maxEntry = entry;
                flag = true;
            }
            if (entry.getValue() > maxEntry.getValue()){
                maxEntry = entry;
            }
        }
        map.remove(maxEntry.getKey());
        return maxEntry;
    }
 
    /**
     * 从文件中读取待分割的文章素材.
     * @return
     * @throws IOException
     */
    public static String getString() throws IOException {
        FileInputStream inputStream = new FileInputStream(new File("e://a.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder strBuilder = new StringBuilder();
 
        String line;
        while((line = reader.readLine()) != null){
            strBuilder.append(line);
        }
        reader.close();
        inputStream.close();
        return strBuilder.toString();
    }
}