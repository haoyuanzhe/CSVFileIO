package testCSV;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


/***
 * CSV生成传感器数据
 * @author yuanzhehao
 *
 */
public class Test1 {
	public static void main(String[] args) throws IOException {
	
		Long start=1514736000000L;
//		String date = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(start));
//		System.out.println(date);
//		System.out.println();

//		for (int i=0;i<10;i++)
//		System.out.println((double)(0+Math.random()*200)-100);

		String csvFile="/Users/yuanzhehao/Desktop/data.csv";
		FileWriter writer = new FileWriter(csvFile);

		String timestamp;
		String d_id;
		String s_id;
		String value;
		for (Long start_time = start; start_time < 1514736008000L; start_time = start_time + 7000) {
			timestamp = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(start_time));
			for(int i=1;i<=100;i++)
				for(int j=1;j<=150;j++) {
					d_id="d_"+Integer.toString(i);
					s_id="s_"+Integer.toString(j);
					value=String.valueOf((double)(0+Math.random()*200)-100);
					//System.out.println(timestamp+","+d_id+","+s_id+","+value);
					CSVUtils.writeLine(writer, Arrays.asList(timestamp, d_id, s_id, value));
				}
		}


	        writer.flush();
	        writer.close();
		//for(Long start_time=start;start<1514736070000L;start=start+7000)
		
 }
}