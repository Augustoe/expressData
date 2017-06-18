package main;

import java.util.ArrayList;

public class address {
//every day 3000
	public static int getAddress(){
		//distribute 5*3
		int address=(int)(Math.random()*15);
		int transit=address/3+1;
		int distribute=address%3+1;
		return 100*transit+distribute;
	}
	
	public static ArrayList<Integer> getTimeList(String date){
		ArrayList<Integer> result=new ArrayList<Integer>();
		ArrayList<Integer> staff=new ArrayList<Integer>();//to decide the broken or lost
		//assume the time is 8:00-18:00
//		String start_time=date;
		//date 161224-16/12/24
		int start_time=Integer.parseInt(date);
		int hour=8+(int)(Math.random()*10);
//		if(hour>=10){
//			start_time=start_time+Integer.toString(hour);
//		}else{
//			start_time=start_time+"0"+Integer.toString(hour);
//		}
		start_time=start_time*100+hour;
		int minute=(int)(Math.random()*60);
//		if(minute>=10){
//			start_time=start_time+Integer.toString(minute);
//		}else{
//			start_time=start_time+"0"+Integer.toString(minute);
//		}
		start_time=start_time=start_time*100+minute;
		//get two address
		int address1=getAddress();
		int address2=getAddress();
		while(address2==address1){
			address2=getAddress();
		}
		int road1=(int)(Math.random()*3)+1;
		int num1=(int)(Math.random()*100)+1;
		int road2=(int)(Math.random()*3)+1;
		int num2=(int)(Math.random()*100)+1;
		
		//decide the value
		double[] size=new double[3];
		size[0]=Tool.getPosiNormal(0.3, 5.0);
		size[1]=Tool.getPosiNormal(0.3, 5.0);
		size[2]=Tool.getPosiNormal(0.3, 5.0);
		double weight=Tool.getPosiNormal(3.0, 100.0)+1;
		int price=Tool.getPrice(size, weight);
		
		
			result.add(address1);result.add(address2);
			result.add(road1);result.add(num1);
			result.add(road2);result.add(num2);
			// change size to cm
			result.add((int)(size[0]*100));result.add((int)(size[1]*100));result.add((int)(size[2]*100));
			result.add((int)(weight));
			result.add(price);
		
		//decide the express path and time;
		if(address1/100==address2/100){
			//same transit
			//poster_id-distribute_to-car-distribute-poster
			int poster1_id=address1*100+(int)(1+Math.random()*2);
			int distribute1_time_in=Tool.addTime(start_time, (int)(Tool.getPosiNormal(90, 180)));
			int distribute1_tid=address1*100+3;
			int distribute1_cid=address1*100+4+(int)(Math.random()*2);
			int distribute1_time_out=Tool.addTime(distribute1_time_in, (int)(Tool.getPosiNormal(60, 120)));
			int distance1=query.getDistance(address1,address2);
				double temp=1.3*distance1;
				int time1=(int)(Tool.getPosiNormal(temp, temp*0.6));
			int distribute2_time_in=Tool.addTime(distribute1_time_out,time1);
			int distribute2_tid=address2*100+3;
			int distribute2_time_out=Tool.addTime(distribute2_time_in, (int)(Tool.getPosiNormal(60, 120)));
			int poster2_id=address2*100+(int)(1+Math.random()*2);
			int receive_time=Tool.addTime(distribute2_time_out, (int)(Tool.getPosiNormal(90, 180)));
			
			result.add(start_time);
			result.add(poster1_id);
			result.add(distribute1_time_in);
			result.add(distribute1_tid);
			result.add(distribute1_cid);
			result.add(distribute1_time_out);
			result.add(distance1);
			result.add(distribute2_time_in);
			result.add(distribute2_tid);
			result.add(distribute2_time_out);
			result.add(poster2_id);
			result.add(receive_time);
			
			staff.add(poster1_id);
			staff.add(distribute1_tid);
			staff.add(distribute1_cid);
			staff.add(distribute2_tid);
			staff.add(poster2_id);
			
		}else{
			//different transit
			//poster-distribute-car-transit-x-transit-car-distribute-poster\
			int poster1_id=address1*100+(int)(1+Math.random()*2);
			int distribute1_time_in=Tool.addTime(start_time, (int)(Tool.getPosiNormal(90, 180)));
			int distribute1_tid=address1*100+3;
			int distribute1_cid=address1*100+4+(int)(Math.random()*2);
			int distribute1_time_out=Tool.addTime(distribute1_time_in, (int)(Tool.getPosiNormal(60, 120)));
			int tansit1=address1/100;
			int distance1=query.getDistance(address1,tansit1);
				double temp=1.3*distance1;
				int time1=(int)(Tool.getPosiNormal(temp, temp*0.6));
			int transit1_time_in=Tool.addTime(distribute1_time_out,time1);
			int transit1_tid=tansit1*10000+1+(int)(Math.random()*2);
			int transit1_sid=tansit1*10000+3+(int)(Math.random()*2);
			int transit1_cid=tansit1*10000+5+(int)(Math.random()*2);
			int transit1_time_storein=Tool.addTime(transit1_time_in, (int)(Tool.getPosiNormal(90, 180)));
			int transit1_time_storeout=Tool.addTime(transit1_time_storein, (int)(Tool.getPosiNormal(240, 600)));
			int transit1_time_out=Tool.addTime(transit1_time_storeout,(int)(Tool.getPosiNormal(60, 40)));
			int distance2=query.getDistance(tansit1,address2/100);
			// 1 car 2 train 3 flight
			int transitType=1+(int)(Math.random()*3);
				if(transitType==1)temp=1.3*distance2;
				if(transitType==2)temp=90+1.3*distance2/2.5;
				if(transitType==1)temp=120+1.3*distance2/14;
				int time2=(int)(Tool.getPosiNormal(temp, temp*0.4));
			int tansit2=address2/100;
			int transit2_cid1=tansit2*10000+5+(int)(Math.random()*2);
			int transit2_time_in=Tool.addTime(transit1_time_out,time2);
			int transit2_tid=tansit1*10000+1+(int)(Math.random()*2);
			int transit2_sid=tansit1*10000+3+(int)(Math.random()*2);
			int transit2_cid2=tansit1*10000+5+(int)(Math.random()*2);
			int transit2_time_storein=Tool.addTime(transit2_time_in, (int)(Tool.getPosiNormal(90, 180)));
			int transit2_time_storeout=Tool.addTime(transit2_time_storein, (int)(Tool.getPosiNormal(240, 600)));
			int transit2_time_out=Tool.addTime(transit2_time_storeout,(int)(Tool.getPosiNormal(60, 40)));
			int distance3=query.getDistance(tansit2,address2);
				temp=1.3*distance1;
				int time3=(int)(Tool.getPosiNormal(temp, temp*0.6));
			int distribute2_time_in=Tool.addTime(transit2_time_out,time3);
			int distribute2_tid=address2*100+3;
			int distribute2_time_out=Tool.addTime(distribute2_time_in, (int)(Tool.getPosiNormal(60, 120)));
			int poster2_id=address2*100+(int)(1+Math.random()*2);
			int receive_time=Tool.addTime(distribute2_time_out, (int)(Tool.getPosiNormal(90, 180)));
			
			
			result.add(start_time);
			result.add(poster1_id);
			result.add(distribute1_time_in);
			result.add(distribute1_tid);
			result.add(distribute1_cid);
			result.add(distribute1_time_out);
			result.add(distance1);
			result.add(tansit1);
			result.add(transit1_time_in);
			result.add(transit1_tid);
			result.add(transit1_sid);
			result.add(transit1_cid);
			result.add(transit1_time_storein);
			result.add(transit1_time_storeout);
			result.add(transit1_time_out);
			result.add(distance2);
			result.add(transitType);
			
			result.add(tansit2);
			result.add(transit2_cid1);
			result.add(transit2_time_in);
			result.add(transit2_tid);
			result.add(transit2_sid);
			result.add(transit2_time_storein);
			result.add(transit2_time_storeout);
			result.add(transit2_time_out);
			result.add(transit2_cid2);
			result.add(distance3);
			result.add(distribute2_time_in);
			result.add(distribute2_tid);
			result.add(distribute2_time_out);
			result.add(poster2_id);
			result.add(receive_time);
			
			staff.add(poster1_id);
			staff.add(distribute1_tid);
			staff.add(distribute1_cid);
			staff.add(transit1_tid);
			staff.add(transit1_sid);
			staff.add(transit1_cid);
			staff.add(transit2_cid1);
			staff.add(transit2_tid);
			staff.add(transit2_sid);
			staff.add(transit2_cid2);
			staff.add(distribute2_tid);
			staff.add(poster2_id);
		}
		
		//decide if broken
		if((int)(Math.random()*1000)==0){
			//get broken 
			int num=(int)(Math.random()*staff.size());
			result.add(staff.get(num));
			result.add(0);
		}else if((int)(Math.random()*1000)==0){
			//get lost
			result.add(0);
			int num=(int)(Math.random()*staff.size());
			result.add(staff.get(num));
		}else{
			//express successful
			result.add(0);
			result.add(0);
		}
//			System.out.println(result.size());
		return result;
	}
	
	
//	public static void main(String[] args) {
//		long startTime=System.currentTimeMillis();   //获取开始时间  
//		int count=0;
//		while(count<3000){
//			address.getTimeList("161223");
//			count++;
//		}
//		long endTime=System.currentTimeMillis(); //获取结束时间  
//	    System.out.println("程序运行时间： "+(endTime-startTime)+"ms");  
//	}
}
