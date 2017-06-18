package main;

import java.util.HashMap;

public class query {
//	public static final String driver="org.gjt.mm.mysql.Driver";
//	public static final String url="jdbc:mysql://localhost:3306/express?user=root&password=123456&useUnicode=true&characterEncoding=utf8";
//	public static Connection conn = null;
//	public static PreparedStatement pstmt;
//	
//	public static int getDistance(int start,int end){
//		int value=0;
//	    try {
//	        Class.forName(driver); //classLoader,加载对应驱动
//	        conn = (Connection) DriverManager.getConnection(url);
//	        String sql="select value from distance where distance_from="+start+" and distance_to="+end;
//	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
//	        ResultSet rs = pstmt.executeQuery();
//	        if(rs.next())value=rs.getInt("value");
//	    } catch (ClassNotFoundException e) {
//	        e.printStackTrace();
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }finally{
//	    	 if (null != conn) {  
//	    	 try {
//				conn.close();
//			} catch (SQLException e) {
//				throw new RuntimeException("关闭Connection出现异常:"  
//                        + e.getMessage());  
//			}
//	    	 }
//	    }
//	    return value;
//	}
	public static int getDistance(int start,int end){
	     HashMap hm=new HashMap();
	     
	     hm.put("01,02",137);hm.put("01,03",1213);hm.put("01,04",1276);hm.put("01,05",1065);
	     hm.put("02,01",137);hm.put("02,03",1318);hm.put("02,04",1151);hm.put("02,05",893);
	     hm.put("03,01",1213);hm.put("03,02",1318);hm.put("03,04",175);hm.put("03,05",330);
	     hm.put("04,01",1276);hm.put("04,02",1151);hm.put("04,03",175);hm.put("04,05",279);
	     hm.put("05,01",1065);hm.put("05,02",893);hm.put("05,03",330);hm.put("05,04",279);

	     hm.put("01,0101",120);hm.put("01,0102",103);hm.put("01,0103",156);
	     hm.put("0101,01",120);hm.put("0102,01",103);hm.put("0103,01",156);
	     hm.put("02,0201",79);hm.put("02,0202",64);hm.put("02,0203",101);
	     hm.put("0201,02",79);hm.put("0202,02",64);hm.put("0203,02",101);
	     hm.put("03,0301",89);hm.put("03,0302",63);hm.put("03,0303",52);
	     hm.put("0301,03",89);hm.put("0302,03",63);hm.put("0303,03",52);
	     hm.put("04,0401",34);hm.put("04,0402",57);hm.put("04,0403",39);
	     hm.put("0401,04",34);hm.put("0402,04",57);hm.put("0403,04",39);
	     hm.put("05,0501",56);hm.put("05,0502",42);hm.put("05,0503",127);
	     hm.put("0501,05",56);hm.put("0502,05",42);hm.put("0503,05",127);

	     hm.put("0101,0102",76);hm.put("0101,0103",63);hm.put("0102,0103",84);
	     hm.put("0102,0101",76);hm.put("0103,0101",63);hm.put("0103,0102",84);

	     hm.put("0201,0202",48);hm.put("0201,0203",43);hm.put("0202,0203",59);
	     hm.put("0202,0201",48);hm.put("0203,0201",43);hm.put("0203,0202",59);

	     hm.put("0301,0302",82);hm.put("0301,0303",43);hm.put("0302,0303",39);
	     hm.put("0302,0301",82);hm.put("0303,0301",43);hm.put("0303,0302",39);

	     hm.put("0401,0402",26);hm.put("0401,0403",62);hm.put("0402,0403",31);
	     hm.put("0402,0401",26);hm.put("0403,0401",62);hm.put("0403,0402",31);

	     hm.put("0501,0502",72);hm.put("0501,0503",61);hm.put("0502,0503",118);
	     hm.put("0502,0501",72);hm.put("0503,0501",61);hm.put("0503,0502",118);
	     
	     String key="0"+Integer.toString(start)+",0"+Integer.toString(end);
//	     System.out.println(key);
	     return (int) hm.get(key);
	}

	public static void main(String[] args) {
		System.out.println(query.getDistance(1, 2));
	}
}
