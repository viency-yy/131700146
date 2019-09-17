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
      //д����Ӧ���ļ�
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
		//��ȡ����
		int index = str.indexOf(',');
		String name = str.substring(0,index);
		object.put("����",name);
		
		str = str.substring(index+1);
		
		//��ȡ�绰����
		 // ��������������ʽ���뵽ģʽ��
		Pattern pattern = Pattern.compile("((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}");
		// ����ƥ������������ģʽ��ƥ������
		Matcher matcher = pattern.matcher(str);
		//�����ַ������Ƿ��з��ϵ����ַ���
		while(matcher.find()){
		    //�õ��绰����
			String phone = matcher.group();
		
			object.put("�ֻ�",phone);
			//���绰����ӵ�ַ���г�
			str = str.substring(0,matcher.start(0))+str.substring(matcher.end(0));
			
			break;
		}
		String s="";
		//��ȡʡ��
		String province="";
		if(str.indexOf("ʡ")!=-1)
		{
			province=str.substring(0, str.indexOf("ʡ")+1);
			str=str.substring(str.indexOf("ʡ")+1);
		}else if(str.indexOf("��")!=-1)
		{
			province=str.substring(0, str.indexOf("��"));
		}else
		{
			province=str.substring(0,2)+"ʡ";
			str=str.substring(2);
		}
		s+="[\""+province+"\",";
		
		//��ȡ��
		String city="";
		if(str.indexOf("��")!=-1)
		{
			city=str.substring(0, str.indexOf("��")+1);
			str=str.substring(str.indexOf("��")+1);
		}else
		{
			city=str.substring(0,2)+"��";
			str=str.substring(2);
		}
		s+="\""+city+"\",";
		
		//��ȡ����
		String region="";
		if(str.indexOf("��")!=-1)
		{
			region=str.substring(0, str.indexOf("��")+1);
			str=str.substring(str.indexOf("��")+1);
		}else if(str.indexOf("��")!=-1)
		{
			region=str.substring(0, str.indexOf("��")+1);
			str=str.substring(str.indexOf("��")+1);
		}
		s+="\""+region+"\",";
		
		//��ȡ�ֵ�/��
		String town="";
		if(str.indexOf("�ֵ�")!=-1)
		{
			town=str.substring(0, str.indexOf("�ֵ�")+2);
			str=str.substring(str.indexOf("�ֵ�")+2);
		}else if(str.indexOf("��")!=-1)
		{
			town=str.substring(0, str.indexOf("��")+1);
			str=str.substring(str.indexOf("��")+1);
		}
		s+="\""+town+"\",";
		s+="\""+str+"\"]";
		object.put("��ַ",s);
		return object;
	}
	public JSONObject method2(String str)
	{
		JSONObject object = new JSONObject();
		//��ȡ����
		int index = str.indexOf(',');
		String name = str.substring(0,index);
		object.put("����",name);
		
		str = str.substring(index+1);
		
		//��ȡ�绰����
		 // ��������������ʽ���뵽ģʽ��
		Pattern pattern = Pattern.compile("((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}");
		// ����ƥ������������ģʽ��ƥ������
		Matcher matcher = pattern.matcher(str);
		//�����ַ������Ƿ��з��ϵ����ַ���
		while(matcher.find()){
		    //�õ��绰����
			String phone = matcher.group();
		
			object.put("�ֻ�",phone);
			//���绰����ӵ�ַ���г�
			str = str.substring(0,matcher.start(0))+str.substring(matcher.end(0));
			
			break;
		}
		String s="";
		//��ȡʡ��
		String province="";
		if(str.indexOf("ʡ")!=-1)
		{
			province=str.substring(0, str.indexOf("ʡ")+1);
			str=str.substring(str.indexOf("ʡ")+1);
		}else if(str.indexOf("��")!=-1)
		{
			province=str.substring(0, str.indexOf("��"));
		}else
		{
			province=str.substring(0,2)+"ʡ";
			str=str.substring(2);
		}
		s+="[\""+province+"\",";
		
		//��ȡ��
		String city="";
		if(str.indexOf("��")!=-1)
		{
			city=str.substring(0, str.indexOf("��")+1);
			str=str.substring(str.indexOf("��")+1);
		}else
		{
			city=str.substring(0,2)+"��";
			str=str.substring(2);
		}
		s+="\""+city+"\",";
		
		//��ȡ����
		String region="";
		if(str.indexOf("��")!=-1)
		{
			region=str.substring(0, str.indexOf("��")+1);
			str=str.substring(str.indexOf("��")+1);
		}else if(str.indexOf("��")!=-1)
		{
			region=str.substring(0, str.indexOf("��")+1);
			str=str.substring(str.indexOf("��")+1);
		}
		s+="\""+region+"\",";
		
		//��ȡ�ֵ�/��
		String town="";
		if(str.indexOf("�ֵ�")!=-1)
		{
			town=str.substring(0, str.indexOf("�ֵ�")+2);
			str=str.substring(str.indexOf("�ֵ�")+2);
		}else if(str.indexOf("��")!=-1)
		{
			town=str.substring(0, str.indexOf("��")+1);
			str=str.substring(str.indexOf("��")+1);
		}
		s+="\""+town+"\",";
		
		//��ȡ·
		String way="";
		if(str.indexOf("·")!=-1)
		{
			way=str.substring(0, str.indexOf("·")+1);
			str=str.substring(str.indexOf("·")+1);
		}else if(str.indexOf("��")!=-1)
		{
			way=str.substring(0, str.indexOf("��")+1);
			str=str.substring(str.indexOf("��")+1);
		}else if(str.indexOf("��")!=-1)
		{
			way=str.substring(0, str.indexOf("��")+1);
			str=str.substring(str.indexOf("��")+1);
		}
		s+="\""+way+"\",";
		
		//��ȡ���ƺ�
		String tablet="";
		if(str.indexOf("��")!=-1)
		{
			tablet=str.substring(0, str.indexOf("��")+1);
			str=str.substring(str.indexOf("��")+1);
		}
		s+="\""+tablet+"\",";
		
		s+="\""+str+"\"]";
		object.put("��ַ",s);
		return object;
	}
	
}
