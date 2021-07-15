package game;

import java.util.ArrayList;
import java.util.Scanner;

public class game {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        int masterNum = 0;
        ArrayList<String[]> chara = new ArrayList();
        
        while (true) {
        	System.out.println("turn : " + masterNum);
        	chara.add(addChar(masterNum, sc));
        	
        	System.out.println("Number | Name | Job | HP |");
        	for (String[] c: chara) {
        		for(String a : c) {
        			System.out.print(a + " | ");
        		}
        		System.out.println("");
        	}
        	System.out.println("Select charactor's number to edit status");
        	int num = sc.nextInt();
        	int counter = 0; 
        	for (String[] c : chara) {
        		if(c[0].equals(Integer.toString(num))) {
        			if(!(Integer.parseInt(c[3]) < 1)) {        				
        				String[] jobs = {"none", "magician", "warrior"};
        				boolean jobBool = true;
        				boolean hpBool = true;
        				String job = null;
        				String name = c[1];
        				int hp = 1;
        				System.out.println("type " + name + "'s job. Now " + c[2]);
        				while (jobBool) {
        					for (String job1 : jobs) System.out.print(job1 + " | ");
        					System.out.println('\n');
        					job = sc.nextLine(); //한번 공백으로 처리됨.
        					if(checkJob(jobs, job)) jobBool = false;
        				}
        				
        				while (hpBool) {        	
        					System.out.println("type " + name + "'s health point. Now " + c[3]);
        					hp = sc.nextInt(); //여긴 공백처리 없음.
        					if(hp < 0) {
        						System.out.println("it's to small!");
        					} else if(hp > 100) {
        						System.out.println("max hp is 100!");
        					} else {
        						hpBool = false;
        					}
        				}
        				String[] result = {c[0], name, job, Integer.toString(hp)};
        				chara.set(counter, result);
        	        }
        		}
        		counter++;
        	}
        	masterNum++;
        }
        
    }

    public static String[] addChar(int masterNum, Scanner sc) {
    	boolean nameBool = true;
    	boolean jobBool = true;
    	boolean hpBool = true;
    	int hp = 1;
    	String job = null;
        String toStr = Integer.toString(masterNum);
        String[] result = new String[4];
        String[] jobs = {"none", "magician", "warrior"};
        String name = null;
        
        while(nameBool) {
        	System.out.println("type Charactor's name");
        	name = sc.nextLine(); //공백처리
        	if(name.replaceAll("\\s+","") != "") nameBool = false;
        }
        
        System.out.println("type " + name + "'s job");
        while (jobBool) {
        	for (String job1 : jobs) System.out.print(job1 + " | ");
        	System.out.println('\n');
        	job = sc.nextLine(); //공백처리 없음
        	if(checkJob(jobs, job)) jobBool = false;
        }
        
        while (hpBool) {        	
        	System.out.println("type " + name + "'s health point");
        	hp = sc.nextInt(); //공백처리 없음.
        	if(hp < 0) {
        		System.out.println("it's to small!");
        	} else if(hp > 100) {
        		System.out.println("max hp is 100!");
        	} else {
        		hpBool = false;
        	}
        }
        
        result[0] = toStr;
        result[1] = name;
        result[2] = job;
        result[3] = Integer.toString(hp);
        
        return result;
    }
    
    public static boolean checkJob(String[] jobs, String job) {
    	if(
        		job.equals(jobs[0]) ||
        		job.equals(jobs[1]) ||
        		job.equals(jobs[2])
    		) return true;
    	return false;
    }
}
