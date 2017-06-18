package main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Tool {
	//正态分布
	public static double getNormal(double miu, double sigma2){
		double N = 12; 
		  double x=0,temp=N; 
		  x=0; 
		  for(int i=0;i <N;i++) 
		    x=x+(Math.random()); 
		  x=(x-temp/2)/(Math.sqrt(temp/12)); 
		  x=miu+x*Math.sqrt(sigma2); 
		  return x; 
	}
	//正态分布-正值
	public static double getPosiNormal(double miu, double sigma2){
		double N = 12; 
		  double x=0,temp=N; 
		  do{
		  x=0; 
		  for(int i=0;i <N;i++) 
		    x=x+(Math.random()); 
		  x=(x-temp/2)/(Math.sqrt(temp/12)); 
		  x=miu+x*Math.sqrt(sigma2);
		  }while(x<=0);
		  return x; 
	}
	
	public static int getPrice(double[] size,double weight){
		int price=0;
		if(weight<=1){
			price=10;//起价
		}else{
			price=(int) (10+(Math.ceil(weight)-1)*4);
		}
		//depend if the size is too big
		if(weight/(size[0]*size[1]*size[2])<24){
			weight=size[0]*size[1]*size[2]*24;
			price=(int) (10+(Math.ceil(weight)-1)*4);
		}
		return price;
	}
	
	public static int addTime(int start_time,int passtime){
		int result=0;
		//start_time:16/12/24 12:42
		try{
		String start=Integer.toString(start_time);
		start="20"+start;
		Calendar day_c = new GregorianCalendar();
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
		Date days_d = df.parse(start);    
		day_c.setTime(days_d);
		day_c.add(Calendar.MINUTE, passtime);
		String end = df.format(day_c.getTime());
		end=end.substring(2);
		result=Integer.parseInt(end);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return result;
		}
	}
	
	
	public static void main(String[] args) throws ParseException {
//		System.out.println(Tool.adTime(1612242355, 5));
		System.out.println(Tool.getPosiNormal(0.3, 5.0));
	}
	
}
