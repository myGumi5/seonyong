package com.ssafy.algo.live20221207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class PRO92341 {

//	public static void main(String[] args) {
//		int[] fees = {120, 0, 60, 591};
//		String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
//		
//		System.out.println(Arrays.toString(solution(fees, records)));
//		
//
//	}
	
	
	static Map<String, int[]> manage;
	static Map<String, Integer> stack;
	static int[] last_order = {23, 59};
	static int[] fees;
	static public int[] solution(int[] fees, String[] records) {
        fees = fees;
        
        manage = new HashMap<>();
        stack = new HashMap<>();
        for(int i = 0; i < records.length; i++) {
        	StringTokenizer st = new StringTokenizer(records[i], ": ");
        	int[] arr = new int[2];
        	arr[0] = Integer.parseInt(st.nextToken());
        	arr[1] = Integer.parseInt(st.nextToken());
        	
        	String str = st.nextToken();
        	if(manage.get(str) == null) {
        		manage.put(str, arr);
        	} else {
        		int hour = (arr[0] - manage.get(str)[0]) * 60;
        		int min = (arr[1] - manage.get(str)[1]) + hour;
        		if(stack.get(str) == null) {
        			stack.put(str, min);
        		} else {
        			stack.put(str, stack.get(str) + min);
        		}
        		manage.remove(str);
        	}
        }
		
		// 남은애 정산
        for(String str : manage.keySet()) {
        	int [] sub = manage.get(str);
        	int hour = (last_order[0] - sub[0]) * 60;
        	int min = last_order[1] - sub[1] + hour; 
        	if(stack.get(str) == null) {
    			stack.put(str, min);
    		} else {
    			stack.put(str, stack.get(str) + min);
    		}
        }
		
        ArrayList<Car> list = new ArrayList<>();
        for(String str : stack.keySet()) {
        	list.add(new Car(Integer.parseInt(str), stack.get(str)));
        }
        
        Collections.sort(list);
        
		int[] answer = new int[list.size()];
        
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).cost - fees[0] <= 0) {
				answer[i] = fees[1];
				continue;
			}
			
			int cal = (list.get(i).cost - fees[0]) % fees[2] == 0 ? 
						((int)Math.floor((list.get(i).cost - fees[0]) / fees[2])) : 
						((int)Math.floor((list.get(i).cost - fees[0]) / fees[2]))+1;
						
			answer[i] = fees[1] + cal * fees[3];
		}
        
        return answer;
    }
	
	static class Car implements Comparable<Car>{
		int number;
		Integer cost;

		public Car(int number, Integer cost) {
			this.number = number;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "car [number=" + number + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Car o) {
			// TODO Auto-generated method stub
			return this.number - o.number;
		}
		
		
	}

}
