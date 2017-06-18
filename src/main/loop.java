package main;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class loop {
	public static final String driver="org.gjt.mm.mysql.Driver";
	public static final String url="jdbc:mysql://localhost:3306/express?user=root&password=123456&useUnicode=true&characterEncoding=utf8";
	public static Connection conn = null;
	public static PreparedStatement pstmt;
	
	public static ArrayList<String> datelist=new ArrayList<String>();
	public static void getAllRecord(String start_date,String end_date){
		try{
			Calendar day_c_start = new GregorianCalendar();
			Calendar day_c_end = new GregorianCalendar();
			DateFormat df = new SimpleDateFormat("yyyyMMdd");
			Date days_d = df.parse(start_date);    
			day_c_start.setTime(days_d);
			days_d = df.parse(end_date);    
			day_c_end.setTime(days_d);
			Calendar current_day=day_c_start;
			String temp="";
			while(current_day.before(day_c_end)){
				temp = df.format(current_day.getTime());
				temp=temp.substring(2);
//				System.out.println(temp);
				datelist.add(temp);
				current_day.add(Calendar.DATE, 1);
			}
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	
	public static void createTable(){
		try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(url);
	        String sql="";
	        //create table distribute_form
	        sql="drop table if exists `distribute_form`";
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        pstmt.executeUpdate();
	        sql="create table `distribute_form`("
	        		+ "`distribute_form_id` varchar(10) not null,"
	        		+ "`address1` int(6) not null,"
	        		+ "`address2` int(6) not null,"    
	        		+ "`road1` int(6) not null,"
	        		+ "`num1` int(6) not null,"
	        		+ "`road2` int(6) not null,"
	        		+ "`num2` int(6) not null,"
	        		+ "`size0` int(6) not null,"
	        		+ "`size1` int(6) not null,"
	        		+ "`size2` int(6) not null,"
	        		+ "`weight` int(6) not null,"
	        		+ "`price` int(6) not null,"
	        		+ "`start_time` int(10) not null,"
	        		+ "`poster1_id` int(6) not null,"
	        		+ "`distribute1_time_in` int(10) not null,"
	        		+ "`distribute1_tid` int(6) not null,"
	        		+ "`distribute1_cid` int(6) not null,"
	        		+ "`distribute1_time_out` int(10) not null,"
	        		+ "`distance1` int(6) not null,"
	        		+ "`distribute2_time_in` int(10) not null,"
	        		+ "`distribute2_tid` int(6) not null,"
	        		+ "`distribute2_time_out` int(10) not null,"
	        		+ "`poster2_id` int(6) not null,"
	        		+ "`receive_time` int(10) not null,"
	        		+ "`broken` int(6) not null,"
	        		+ "`lost` int(6) not null,"
	        		+ "primary key(`distribute_form_id`)"
	        		+ ")default charset utf8;";
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        pstmt.executeUpdate();
	        
	      //create table transit_form 
	        sql="drop table if exists `transit_form`";
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        pstmt.executeUpdate();
	        sql="create table `transit_form`("
	        		+ "`transit_form_id` varchar(10) not null,"
					+ "`address1` int(6) not null,"
					+ "`address2` int(6) not null,"
					+ "`road1` int(6) not null,"
					+ "`num1` int(6) not null,"
					+ "`road2` int(6) not null,"
					+ "`num2` int(6) not null,"
					+ "`size0` int(6) not null,"
					+ "`size1` int(6) not null,"
					+ "`size2` int(6) not null,"
					+ "`weight` int(6) not null,"
					+ "`price` int(6) not null,"
					+ "`start_time` int(10) not null,"
					+ "`poster1_id` int(6) not null,"
					+ "`distribute1_time_in` int(10) not null,"
					+ "`distribute1_tid` int(6) not null,"
					+ "`distribute1_cid` int(6) not null,"
					+ "`distribute1_time_out` int(10) not null,"
					+ "`distance1` int(6) not null,"
					+ "`tansit1` int(6) not null,"
					+ "`transit1_time_in` int(10) not null,"
					+ "`transit1_tid` int(6) not null,"
					+ "`transit1_sid` int(6) not null,"
					+ "`transit1_cid` int(6) not null,"
					+ "`transit1_time_storein` int(10) not null,"
					+ "`transit1_time_storeout` int(10) not null,"
					+ "`transit1_time_out` int(10) not null,"
					+ "`distance2` int(6) not null,"
					+ "`transitType` int(10) not null,"
					+ "`tansit2` int(6) not null,"
					+ "`transit2_cid1` int(6) not null,"
					+ "`transit2_time_in` int(10) not null,"
					+ "`transit2_tid` int(6) not null,"
					+ "`transit2_sid` int(6) not null,"
					+ "`transit2_time_storein` int(10) not null,"
					+ "`transit2_time_storeout` int(10) not null,"
					+ "`transit2_time_out` int(10) not null,"
					+ "`transit2_cid2` int(6) not null,"
					+ "`distance3` int(6) not null,"
					+ "`distribute2_time_in` int(10) not null,"
					+ "`distribute2_tid` int(6) not null,"
					+ "`distribute2_time_out` int(10) not null,"
					+ "`poster2_id` int(6) not null,"
					+ "`receive_time` int(10) not null,"
					+ "`broken` int(6) not null,"
					+ "`lost` int(6) not null,"
					+ "primary key(`transit_form_id`)"
	        		+ ")default charset utf8;";
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        pstmt.executeUpdate();
	        
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }finally{
	    	 if (null != conn) {  
	    	 try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException("关闭Connection出现异常:"  
                        + e.getMessage());  
			}
	    	 }
	    }
	}
	
	
	
	
	public static void insertDate(){
		try{
			Class.forName(driver); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(url);
	        String sql_transit="insert into `transit_form` values ";
	        String sql_distribute="insert into `distribute_form` values ";
			for(int i=0;i<datelist.size();i++){
				String current_day=datelist.get(i);
				int count=0;
				int amount=10;
				while(count<amount){
					count++;
					String id=current_day+String.format("%04d",count);
	//				System.out.println(id);
					ArrayList<Integer> result=address.getTimeList(current_day);
					String temp="('"+id+"'";
					for(int k=0;k<result.size();k++){
						temp=temp+","+result.get(k);
					}
					temp=temp+"),";
					if(result.size()==25){
						sql_distribute+=temp;
					}else{
					//45
						sql_transit+=temp;
					}
				}
			}
			if(sql_transit.length()>40){
				sql_transit=sql_transit.substring(0, sql_transit.length()-1)+";";
				pstmt = (PreparedStatement)conn.prepareStatement(sql_transit);
		        pstmt.executeUpdate();
			}
			if(sql_distribute.length()>40){
				sql_distribute=sql_distribute.substring(0, sql_distribute.length()-1)+";";
				pstmt = (PreparedStatement)conn.prepareStatement(sql_distribute);
		        pstmt.executeUpdate();
			}
		} catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }finally{
	    	 if (null != conn) {  
	    	 try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException("关闭Connection出现异常:"  
                        + e.getMessage());  
			}
	    	 }
	    }
	}
	
	
	public static void main(String[] args) {
		long startTime=System.currentTimeMillis();   //获取开始时间  
		loop.createTable();
		loop.getAllRecord("20140101", "20170701");
		loop.insertDate();
		long endTime=System.currentTimeMillis(); //获取结束时间  
	    System.out.println("程序运行时间： "+(endTime-startTime)+"ms");  
	}
}
