package exp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

public class Main {

	public static void main(String[] args) throws IOException {
		Main main=new Main();
		
        FileReader fileReader = new FileReader("E:\\test.txt");
        BufferedReader buf = new BufferedReader(fileReader);
        String readLine = "";
        List<JSONObject> ads=new ArrayList<JSONObject>();
        while((readLine = buf.readLine()) != null){
            //System.out.println(readLine);
        	String flag=readLine.substring(0,1);
        	String address=readLine.substring(2);
        	
        	if(flag.equals("1"))
        	{
        		JSONObject ad= main.method1(address);
        		ads.add(ad);

        	}else
        	{
        		JSONObject ad= main.method2(address);
        		ads.add(ad);
        	}

        	
        }
      //写入相应的文件
        FileWriter fw =  new FileWriter("E:\\result.json");
        fw.write("[");
        for(int i=0; i<ads.size(); i++)
        {
        	JSONObject ad=ads.get(i);
        	System.out.println(ad.toString());
        	if(i!=ads.size()-1)
        	{
        		fw.write(ad.toString()+",");
        	}else
        	{
        		fw.write(ad.toString());
        	}
        	
        	
        }
        fw.write("]");
        fw.close();
	}
	
	public JSONObject method1(String str)
	{
		JSONObject object = new JSONObject();
		//获取姓名
		int index = str.indexOf(',');
		String name = str.substring(0,index);
		object.put("姓名",name);
		
		str = str.substring(index+1);
		
		//获取电话号码
		 // 将给定的正则表达式编译到模式中
		Pattern pattern = Pattern.compile("((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}");
		// 创建匹配给定输入与此模式的匹配器。
		Matcher matcher = pattern.matcher(str);
		//查找字符串中是否有符合的子字符串
		while(matcher.find()){
		    //得到电话号码
			String phone = matcher.group();
		
			object.put("手机",phone);
			//将电话号码从地址中切除
			str = str.substring(0,matcher.start(0))+str.substring(matcher.end(0));
			
			break;
		}
		String s="";
		//获取省份
		String province="";
		if(str.indexOf("省")!=-1)
		{
			province=str.substring(0, str.indexOf("省")+1);
			str=str.substring(str.indexOf("省")+1);
		}else if(str.indexOf("市")!=-1)
		{
			province=str.substring(0, str.indexOf("市"));
		}else
		{
			province=str.substring(0,2)+"省";
			str=str.substring(2);
		}
		s+="[\""+province+"\",";
		
		//提取市
		String city="";
		if(str.indexOf("市")!=-1)
		{
			city=str.substring(0, str.indexOf("市")+1);
			str=str.substring(str.indexOf("市")+1);
		}else
		{
			city=str.substring(0,2)+"市";
			str=str.substring(2);
		}
		s+="\""+city+"\",";
		
		//提取区县
		String region="";
		if(str.indexOf("区")!=-1)
		{
			region=str.substring(0, str.indexOf("区")+1);
			str=str.substring(str.indexOf("区")+1);
		}else if(str.indexOf("县")!=-1)
		{
			region=str.substring(0, str.indexOf("县")+1);
			str=str.substring(str.indexOf("县")+1);
		}
		s+="\""+region+"\",";
		
		//提取街道/镇
		String town="";
		if(str.indexOf("街道")!=-1)
		{
			town=str.substring(0, str.indexOf("街道")+2);
			str=str.substring(str.indexOf("街道")+2);
		}else if(str.indexOf("镇")!=-1)
		{
			town=str.substring(0, str.indexOf("镇")+1);
			str=str.substring(str.indexOf("镇")+1);
		}
		s+="\""+town+"\",";
		s+="\""+str+"\"]";
		object.put("地址",s);
		return object;
	}
	public JSONObject method2(String str)
	{
		JSONObject object = new JSONObject();
		//获取姓名
		int index = str.indexOf(',');
		String name = str.substring(0,index);
		object.put("姓名",name);
		
		str = str.substring(index+1);
		
		//获取电话号码
		 // 将给定的正则表达式编译到模式中
		Pattern pattern = Pattern.compile("((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}");
		// 创建匹配给定输入与此模式的匹配器。
		Matcher matcher = pattern.matcher(str);
		//查找字符串中是否有符合的子字符串
		while(matcher.find()){
		    //得到电话号码
			String phone = matcher.group();
		
			object.put("手机",phone);
			//将电话号码从地址中切除
			str = str.substring(0,matcher.start(0))+str.substring(matcher.end(0));
			
			break;
		}
		String s="";
		//获取省份
		String province="";
		if(str.indexOf("省")!=-1)
		{
			province=str.substring(0, str.indexOf("省")+1);
			str=str.substring(str.indexOf("省")+1);
		}else if(str.indexOf("市")!=-1)
		{
			province=str.substring(0, str.indexOf("市"));
		}else
		{
			province=str.substring(0,2)+"省";
			str=str.substring(2);
		}
		s+="[\""+province+"\",";
		
		//提取市
		String city="";
		if(str.indexOf("市")!=-1)
		{
			city=str.substring(0, str.indexOf("市")+1);
			str=str.substring(str.indexOf("市")+1);
		}else
		{
			city=str.substring(0,2)+"市";
			str=str.substring(2);
		}
		s+="\""+city+"\",";
		
		//提取区县
		String region="";
		if(str.indexOf("区")!=-1)
		{
			region=str.substring(0, str.indexOf("区")+1);
			str=str.substring(str.indexOf("区")+1);
		}else if(str.indexOf("县")!=-1)
		{
			region=str.substring(0, str.indexOf("县")+1);
			str=str.substring(str.indexOf("县")+1);
		}
		s+="\""+region+"\",";
		
		//提取街道/镇
		String town="";
		if(str.indexOf("街道")!=-1)
		{
			town=str.substring(0, str.indexOf("街道")+2);
			str=str.substring(str.indexOf("街道")+2);
		}else if(str.indexOf("镇")!=-1)
		{
			town=str.substring(0, str.indexOf("镇")+1);
			str=str.substring(str.indexOf("镇")+1);
		}
		s+="\""+town+"\",";
		
		//提取路
		String way="";
		if(str.indexOf("路")!=-1)
		{
			way=str.substring(0, str.indexOf("路")+1);
			str=str.substring(str.indexOf("路")+1);
		}else if(str.indexOf("街")!=-1)
		{
			way=str.substring(0, str.indexOf("街")+1);
			str=str.substring(str.indexOf("街")+1);
		}else if(str.indexOf("巷")!=-1)
		{
			way=str.substring(0, str.indexOf("巷")+1);
			str=str.substring(str.indexOf("巷")+1);
		}
		s+="\""+way+"\",";
		
		//提取门牌号
		String tablet="";
		if(str.indexOf("号")!=-1)
		{
			tablet=str.substring(0, str.indexOf("号")+1);
			str=str.substring(str.indexOf("号")+1);
		}
		s+="\""+tablet+"\",";
		
		s+="\""+str+"\"]";
		object.put("地址",s);
		return object;
	}
	
}
