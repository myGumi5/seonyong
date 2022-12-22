package com.ssafy.algo.live20221222;

import java.util.HashMap;

public class PRO118666 {

	public static void main(String[] args) {
		String[] strs = {"AN", "CF", "MJ", "RT", "NA"};
		int [] arr = {5, 3, 2, 7, 5};
		
		solution(strs, arr);
		
	}
	
	static HashMap<Character, Integer> map;
	
	public static String solution(String[] survey, int[] choices) {
        String answer = "";
        map = new HashMap<>();
        
        int [] point = {0, 3, 2, 1, 0, 1, 2, 3};
        for(int i = 0; i < survey.length; i++) {
        	String str = survey[i];
        	int num = choices[i];
        	
        	if(num <= 3) {
				if (map.get(str.charAt(0)) == null) {
					map.put(str.charAt(0), point[num]);
				} else {
					map.put(str.charAt(0), map.get(str.charAt(0))+point[num]);
				}
        	} else if(num >= 5) {
        		if (map.get(str.charAt(1)) == null) {
					map.put(str.charAt(1), point[num]);
				} else {
					map.put(str.charAt(1), map.get(str.charAt(1))+point[num]);
				}
        	}
        }
        
        
        StringBuilder sb = new StringBuilder();
        char[] chars = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        for(int i = 0; i < chars.length; i += 2) {
        	Integer be = map.get(chars[i]);
        	Integer af = map.get(chars[i+1]);
        	
        	if((be == null && af == null) || (be != null && af != null)) {
        		if(be == null && af == null) {
					if (chars[i] < chars[i + 1]) {
						sb.append(chars[i]);
					} else {
						sb.append(chars[i + 1]);
					}
					continue;
        		}
        		
        		if(be > af) {
        			sb.append(chars[i]);
            		continue;
        		} else if(af > be) {
        			sb.append(chars[i+1]);
            		continue;
        		} else {
        			if (chars[i] < chars[i + 1]) {
						sb.append(chars[i]);
					} else {
						sb.append(chars[i + 1]);
					}
        		}
        		continue;
        	} else if(af == null) {
        		sb.append(chars[i]);
        		continue;
        	} else if(be == null ) {
        		sb.append(chars[i+1]);
        		continue;
        	}
        }
        
        answer = sb.toString();
        System.out.println(answer);
        
        return answer;
    }

}
