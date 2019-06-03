package com.neo.util; 

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.neo.entity.UserEntity;
import com.neo.enums.UserSexEnum;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.PropertyFilter;


/** 
 * @author huangruke
 * @E-mail 
 * @dateTime 2010/7/6 下午 4:41:48 
 * 类说明:
 */
public class StringUtils {
	  public String lanIP="192.168.41.81";
	  public String lanIP2="192.168.41.81";
	  public String wanIP="192.168.41.81";
	  public String ServerName="ake";
	  
		public static boolean isChinease(String text) {
			char c = 0;
			for (int i = 0; i < text.length(); i++) {
				c = text.charAt(i);
				if (c > 255)
					return true;
			}
			return false;
		}
		
		   public static boolean isenglishfontfamily(String fontfamily){
				  String[] fontfamilyen={"Arial","Arial Black","Courier New","Comic Sans MS","Georgia","Impact","Lucida Console","Lucida Sans Unicode","Palatino Linotype","Tahoma","Verdana"};
				  for(int i=0;i<fontfamilyen.length;i++){
					  if(fontfamilyen[i].equals(fontfamily))return true;
				  }
				  return false;
			}
	  
	public static boolean isEmpty(String s) {
		return s == null || s.trim().length() == 0 ? true : false;
	}
	
	/**
	 * 字符串轉時間格式
	 */
	public static Date stringToDate(String str){
		Date time = null;
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			time=sf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}

	//去掉字符 空格 换行 中文空格
	public static String isTrim(String str){
		if(str!=null && !"".equals(str)){
			str=str.replaceAll("<[^>]*?>", "").replaceAll("&nbsp;", "").trim();
			Pattern pattern = Pattern.compile("[\\s\\p{Zs}]");
	        Matcher re = pattern.matcher(str);
	        str=re.replaceAll("");
		}
		return str;
	}
	
	
	//分割字符串
	public static String splitStr(String str,int key){
		if(str!=null&&!str.trim().equals("")&&key>=0){
			String[] str1=str.split("-");
			str=str1[key];
			return str;
		}else{
			return null;
		}
	}
	
	//重复数据分割
	public static String[] splitStr(String str,String key){
		String [] str1 = null;
		if(str !=null && !"".equals(str) && key!=null && !"".equals(key)){
			str1 = str.split(key);
		}
		return str1;
	}
	
	//判斷是否包含中文
    public static boolean isContainsChinese(String str)      
	{ 
		boolean flg = false;
		if (str != null && !"".equals(str)) {
			String regEx = "[\u4e00-\u9fa5]";
			Pattern pat = Pattern.compile(regEx);
			Matcher matcher = pat.matcher(str);
			if (matcher.find()) {
				flg = true;
			}
		}
		return flg;      
	  }
    //去掉所有空格
    public static String deleteInnerBlank(String str) {
    	String s = str.replace("\n", "");
        StringBuilder buf = new StringBuilder();
        boolean charStart = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (!charStart) {
                    buf.append(c);
                }
            } else {
                if (!charStart) {
                    charStart = true;
                }
                buf.append(c);
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != ' ') {
                break;
            }
            buf.append(c);
        }

        return buf.toString().trim();
    }

	public static int String2Int(String str) {
		int data = 0;
		try {
			data = Integer.parseInt(str);
		} catch (Exception e) {

		}
		return data;
	}
	public static long String2Long(String str) {
		long data = 0;
		try {
			data = Long.parseLong(str);
		} catch (Exception e) {

		}
		return data;
	}
	public static float String2Float(String str) {
		float data = 0;
		try {
			data = Float.parseFloat(str);
		} catch (Exception e) {

		}
		return data;
	}
	public static String returnxmlforward(String str){
	  	String xmlforward="";
	  	if(str!=null){
		  	int index=str.lastIndexOf(".");
		  	if(index!=-1){
		  		xmlforward=str.substring(0,index);
		  	}
	  	}
	  	return xmlforward;
	}
	public static String String2String(String str, String[] tag) {
		String data = str;
		try {
			for (int i = 0; i < tag.length; i++) {
				// System.out.println(tag[i]);
				data = data.replaceAll(tag[i], "");
			}
		} catch (Exception e) {

		}
		return data;
	}
	/**
	 * @category
	 * @author 
	 * 2010   上午 9:37:04
	 * @param A
	 * @return
	 */
	public static Integer getIntValue(String param) {
		if(param==null)
			return 0;
		param=param.trim();
		if(StringUtils.isEmpty(param))
			return 0;
		
		boolean boo=param.matches("[0-9]+");
		Integer pid= boo? new Integer(param):0;
		return pid;
	}
	public static String ISOTOUTF(String s) throws Exception {
		if (s == null) {
			s = "";
		}
		return new String(s.getBytes("ISO8859_1"), "UTF-8");
	}
	public static double rnd(){
		long seed=new Date().getTime();
		seed=(seed*9301+49297)%233280;
		return seed/(233280.0);
	}
	public static long rand(int number){
		return Math.round(rnd()*number);
	}


	public static boolean isDigit(String str) {
		boolean isdigit = true;

		Pattern p = Pattern.compile("([0-9]+)");
		Matcher m = p.matcher(str);
		boolean b = m.matches();
		if (b) {

		} else {
			return false;
		}
		return isdigit;
	}

	public static boolean isEmail(String email) {
		boolean isemail = true;
		// 检测输入的EMAIL地址是否以 非法符号"."或"@"作为起始字符
		Pattern p = Pattern.compile("^\\.|^\\@");
		Matcher m = p.matcher(email);
		if (m.find()) {
			// System.err.println("Email addresses don't start with dots or @
			// signs.");
			return false;
		}
		// 检测是否以"www."为起始
		/*
		 * p = Pattern.compile("^www\\."); m = p.matcher(email); if (m.find()) {
		 * //System.out.println("Email addresses don't start with \"www.\", only
		 * web pages do."); return false; }
		 */
		// 检测是否包含非法字符
		p = Pattern.compile("[^A-Za-z0-9\\.\\@_\\-~#]+");// ^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$
		m = p.matcher(email);
		StringBuffer sb = new StringBuffer();
		boolean result = m.find();
		boolean deletedIllegalChars = false;
		while (result) {
			// 如果找到了非法字符那么就设下标记
			deletedIllegalChars = true;
			// 如果里面包含非法字符如冒号双引号等，那么就把他们消去，加到SB里面
			// System.out.println("ggggggggggggggggggg");
			m.appendReplacement(sb, "");
			result = m.find();
		}
		m.appendTail(sb);
		email = sb.toString();
		if (deletedIllegalChars) {
			// System.out.println(email+" contained incorrect characters , such
			// as spaces or commas.");
			return false;
		}
		// 这里和后面我已改过来了，原文为： Pattern p =
		// Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}");
		p = Pattern.compile("[\\w[.-]]+\\@+[\\w[.-]]+\\.[a-zA-Z]{2,3}+");// [\\w[.-]]+\\@+[\\w[.-]]+\\.[a-zA-Z]{2,3}+
		m = p.matcher(email);
		boolean b = m.matches();
		if (b) {

		} else {
			// System.out.println(email+"incorrect email");
			return false;
		}
		return isemail;
	}

	public static boolean isMobile(String mobile, String countrycode){
		if(isEmpty(mobile)) {
			return false;
		} else if(countrycode.equals("HK")){
			return Pattern.matches("[5689]\\d{7}", mobile);
		} else if(countrycode.equals("MY")){
			return Pattern.matches("[0]{1}[1]{1}\\d{8,9}", mobile);
		} else if(countrycode.equals("CN")){
			return Pattern.matches("(13[0-9]|14[57]|15[012356789]|18[02356789])\\d{8}", mobile);
		} else if(countrycode.equals("MO")){
			return Pattern.matches("[6]\\d{7}", mobile);
		} else if(countrycode.equals("TW")){
			return Pattern.matches("[9]\\d{8}", mobile);
		}
		return false;
	}

	public static boolean isMobileNO(String mobiles) {
		boolean flag = false;
		try {
			Pattern p = Pattern
					.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
			Matcher m = p.matcher(mobiles);
			flag = m.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public static String parseEmailName(String emailAddress) {
        if (emailAddress == null) {
            return null;
        }
        int atIndex = emailAddress.lastIndexOf("@");
        if (atIndex <= 0) {
            return "";
        }
        else {
            return emailAddress.substring(0, atIndex);
        }
    } 
	public static int showPwRank(String password) {
		int ls = 0;
		if(password.length()<6||Pattern.matches("[0-9]{1,8}", password)){
			return 0;
		}
		Pattern llp = Pattern.compile("([a-z]+)");
		Matcher llm = llp.matcher(password);
		if (llm.find()){
			ls++;
		}
		Pattern ulp = Pattern.compile("([A-Z]+)");
		Matcher ulm = ulp.matcher(password);
		if (ulm.find()){
			ls++;
		}
		Pattern dp = Pattern.compile("([0-9]+)");
		Matcher dm = dp.matcher(password);
		if (dm.find()){
			ls++;
		}
		Pattern np = Pattern.compile("[^a-zA-Z0-9]");
		Matcher nm = np.matcher(password);
		if(nm.find()){
			ls++;
		}
		if (password.length() < 8 && ls > 1){
			ls = 1;
		} 
		if(ls>3) {ls=3;};
		return ls;
	}
	/*****
	 * @category float 保留几位小数
	 * @param value 	double值
	 * @param num       保留小数位数
	 * @return
	 */
	public static float getFloatNum(float value,int num){
		DecimalFormat df=(DecimalFormat)NumberFormat.getInstance();
		df.setMaximumFractionDigits(num);
		String str=df.format(value);
		float dtemp=Float.parseFloat(str.replaceAll(",", ""));
		return dtemp;
	}
	public static Vector addField(String strField,String strTag){
	    StringTokenizer tokenizer=new StringTokenizer(strField,strTag);
	    Vector temp=new Vector();
	    while(tokenizer.hasMoreTokens()){
	      temp.addElement(tokenizer.nextToken());
	    }
	    return temp;
	  }
	/**
	 * 獲取字符串前4位
	 * */
	public static String substring(String s)
	{
	  String t = null;
	  if(s!=null && s.length()>4)
	  {
		  t = s.substring(0, 4);
	  }
	  return t;
	}
	public static String getParamaterbyUrl(String key, String url, String domain){
		String paramsstr=url.substring(domain.length()+1);
		String[] params=paramsstr.split("&");
		String value="";
		if(params.length>0){
			for(int i=0;i<params.length;i++){
				String oneparam=params[i];
				String[] keyvalue=oneparam.split("=");
				if(keyvalue.length>=2){
					if(keyvalue[0].equals(key)){
						value=keyvalue[1];
						break;
					}
				}
			}
		}
		return value;
	}
	public static String filterLink(String link){
		if(link.indexOf(" ")!=-1){
			link=link.replaceAll(" ", "\\\\ ");
		}
		if(link.indexOf("'")!=-1){
			link=link.replaceAll("'", "\\\\'");
		}
		if(link.indexOf("$")!=-1){
			link=link.replaceAll("\\$", "\\\\\\$");
		}
		if(link.indexOf("&")!=-1){
			link=link.replaceAll("&", "\\\\&");
		}
		if(link.indexOf("`")!=-1){
			link=link.replaceAll("`", "\\\\`");
		}
		if(link.indexOf("!")!=-1){
			link=link.replaceAll("!", "\\\\!");
		}
		if(link.indexOf("@")!=-1){
			link=link.replaceAll("@", "\\\\@");
		}
		if(link.indexOf("^")!=-1){
			link=link.replaceAll("\\^", "\\\\^");
		}
		if(link.indexOf("{")!=-1){
			link=link.replaceAll("\\{", "\\\\{");
		}
		if(link.indexOf("}")!=-1){
			link=link.replaceAll("\\}", "\\\\}");
		}
		if(link.indexOf("[")!=-1){
			link=link.replaceAll("\\[", "\\\\[");
		}
		if(link.indexOf("]")!=-1){
			link=link.replaceAll("\\]", "\\\\]");
		}
		if(link.indexOf("(")!=-1){
			link=link.replaceAll("\\(", "\\\\(");
		}
		if(link.indexOf(")")!=-1){
			link=link.replaceAll("\\)", "\\\\)");
		}
		return link;
	}
	/**
	 * @方法說明: 解析json，这段json有可能解析的值为list
	 * @author chenJian E-mail: test_t@163.COM
	 * @createTime 創建時間：2013/12/4 上午9:25:51
	 * @copyright e-print
	 * @param object
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "finally" })
	public static Map<String, List<String>> analyzeToMap3(Object object) {
		Map<String, List<String>> map = null;
		if (object == null || isNull(object.toString())) {
			return map;
		}

		List<String> ids = null;
		try {
			map = new HashMap<String, List<String>>();
			JSONObject o = JSONObject.fromObject(object);
			Map<String, Object> map_obj = (Map<String, Object>) JSONObject.toBean(o, LinkedHashMap.class);
			for (Map.Entry<String, Object> et : map_obj.entrySet()) {
				String key = et.getKey();
				Object value = et.getValue();

				ids = new ArrayList<String>();
				if (value instanceof ArrayList) {
					ids = (List<String>) value;
				} else if (value instanceof String) {
					ids.add((String) value);
				}
				map.put(key, ids);
			}
			// return map;
		} catch (Exception e) {
			System.out.println("解析json出錯!!!");
			e.printStackTrace();
		} finally {
			return map;
		}
	}

	@SuppressWarnings({ "unchecked", "finally" })
	public static Map<String, String> analyzeToMap(Object object) {
		Map<String, String> map = null;
		if (object == null || isNull(object.toString())) {
			return map;
		}
		try {
			JSONObject o = JSONObject.fromObject(object);
			map = (Map<String, String>) JSONObject.toBean(o, LinkedHashMap.class);
			return map;
		} catch (Exception e) {
			System.out.println("解析json出錯!!!");
			e.printStackTrace();
		} finally {
			return map;
		}
	}

	@SuppressWarnings({ "unchecked", "finally" })
	public static Map<String, Object> analyzeToMap2(Object object) {
		Map<String, Object> map = null;
		if (object == null || isNull(object.toString())) {
			return map;
		}
		try {
			JSONObject o = JSONObject.fromObject(object);
			map = (Map<String, Object>) JSONObject.toBean(o, LinkedHashMap.class);
			return map;
		} catch (Exception e) {
			System.out.println("解析json出錯!!!");
			e.printStackTrace();
		} finally {
			return map;
		}
	}

	@SuppressWarnings("finally")
	public static List<?> analyzeToList(Object object, Class<?> clazz) {
		List<?> list = null;
		if (object == null || isNull(object.toString())) {
			return list;
		}
		try {
			JSONArray o = JSONArray.fromObject(object);
			list = (List<?>) JSONArray.toList(o, clazz);
			return list;
		} catch (Exception e) {
			System.out.println("解析json出錯!!!");
			e.printStackTrace();
		} finally {
			return list;
		}
	}

	public static List<?> analyzeToList2(Object object, Class<?> clazz, Map<String, Class> classMap) {
		List<?> list = null;
		if (object == null || isNull(object.toString())) {
			return list;
		}
		try {
			JSONArray o = JSONArray.fromObject(object);
			list = (List<?>) JSONArray.toList(o, clazz, classMap);
			return list;
		} catch (Exception e) {
			System.out.println("解析json出錯!!!");
			e.printStackTrace();
		} finally {
			return list;
		}
	}

	/**
	 * @方法说明:解析json類型的對象
	 * @author oyxl
	 * @creatime 2014年3月24日上午10:45:12
	 * @param object
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "hiding" })
	public static <T> T analyzeToBean(Object object, Class<T> clazz) {
		T t = null;
		if (object == null || isNull(object.toString())) {
			return t;
		}
		try {
			JSONObject o = JSONObject.fromObject(object);
			t = (T) JSONObject.toBean(o, clazz);
			return t;
		} catch (Exception e) {
			System.out.println("解析json出錯!!!");
			e.printStackTrace();
		}
		return t;
	}
	@SuppressWarnings({ "unchecked", "hiding" })
	public static <T> T analyzeToBean(String object, Class<T> clazz) {
		T t = null;
		if (object == null || isNull(object)) {
			return t;
		}
		try {
			if (object.startsWith("[") && object.endsWith("]")) {
				object = object.substring(1, object.length() - 1);
			}
			JSONObject o = JSONObject.fromObject(object);
			t = (T) JSONObject.toBean(o, clazz);
			return t;
		} catch (Exception e) {
			System.out.println("解析json出錯!!!");
			e.printStackTrace();
		}
		return t;
	}
	/**
	 * @方法说明:解析json類型的對象
	 * @author oyxl
	 * @creatime 2014年3月24日上午10:45:12
	 * @param object
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "hiding" })
	public static <T> T analyzeToBean2(Object object, Class<T> clazz, Map<String, Class> classMap) {
		T t = null;
		if (object == null || isNull(object.toString())) {
			return t;
		}
		try {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
				public boolean apply(Object object, String name, Object value) {
					return value == null || "".equals(value.toString()) || "null".equals(value.toString());
				}
			});
			jsonConfig.registerJsonValueProcessor("attrvaluekey", new JsonValueProcessor() {
				public Object processObjectValue(String propertyName, Object value, JsonConfig config) {
					if (value != null) {
						String stripped = value.toString();
						if (stripped.startsWith("\"[") && stripped.endsWith("]\"")) {
							return "*" + stripped.substring(1, stripped.length() - 1);
						}
						if (stripped.startsWith("\"{") && stripped.endsWith("}\"")) {
							return "*" + stripped.substring(1, stripped.length() - 1);
						}
					}
					return value;
				}

				public Object processArrayValue(Object value, JsonConfig config) {
					return value;
				}
			});
			jsonConfig.registerJsonValueProcessor("attrvalue", new JsonValueProcessor() {
				public Object processObjectValue(String propertyName, Object value, JsonConfig config) {
					if (value != null) {
						String stripped = value.toString();
						if (stripped.startsWith("\"[") && stripped.endsWith("]\"")) {
							return "*" + stripped.substring(1, stripped.length() - 1);
						}
						if (stripped.startsWith("\"{") && stripped.endsWith("}\"")) {
							return "*" + stripped.substring(1, stripped.length() - 1);
						}
					}
					return value;
				}

				public Object processArrayValue(Object value, JsonConfig config) {
					return value;
				}
			});
			jsonConfig.registerJsonValueProcessor("jobnoremark", new JsonValueProcessor() {
				public Object processObjectValue(String propertyName, Object value, JsonConfig config) {
					if (value != null) {
						String stripped = value.toString();
						if (stripped.startsWith("\"[") && stripped.endsWith("]\"")) {
							return "*" + stripped.substring(1, stripped.length() - 1);
						}
						if (stripped.startsWith("\"{") && stripped.endsWith("}\"")) {
							return "*" + stripped.substring(1, stripped.length() - 1);
						}
					}
					return value;
				}

				public Object processArrayValue(Object value, JsonConfig config) {
					return value;
				}
			});

			jsonConfig.setRootClass(clazz);
			if (classMap != null) {
				jsonConfig.setClassMap(classMap);
			}
			JSONObject o = JSONObject.fromObject(object, jsonConfig);
			t = (T) JSONObject.toBean(o, jsonConfig);
			return t;
		} catch (Exception e) {
			System.out.println("解析json出錯!!!");
			e.printStackTrace();
		}
		return t;
	}
	/** 為空時返回true */
	public static boolean isNull(String arg) {
		if (arg == null)
			return true;
		if ("".equals(arg))
			return true;
		if ("".equals(arg.trim()))
			return true;
		return false;
	}

	public static String trim(String str) {
		try {
			if (str != null && !str.equals("null") && !str.equals("")) {
				return str.trim();
			}
		} catch (Exception e) {
		}
		return null;
	}
	public static void main(String[] args) {
//		String aa="8-contentcenter-1-1-1-1-1-1-111-1-1-11-11-1";
//		String bb="8-contentcenter";
//		String[] str=aa.split("-");
//		System.out.println(str[1]);
//		System.out.println(StringUtils.isContainsChinese(" - "));
//		System.out.println(StringUtils.deleteInnerBlank("  1 3 4  2   1    "));
//		System.out.println(StringUtils.showPwRank("Afd44fdfddd<>"));
		UserEntity e = new UserEntity();
		e.setId((long) 5455);
		e.setNickName("dsdsd");
		e.setPassWord("55255");
		e.setUserName("dddd");
//		e.setUserSex(UserSexEnum.MAN);
		String s = "{\"userName\":\"贤心\",\"nickName\":\"女\",\"passWord\":\"123456\",\"userSex\":\"MAN\",\"id\":\"\"}";
		System.out.println(s);
		System.out.println(JSONObject.fromObject(e));
//		JSONObject o = JSONObject.fromObject("["+s+"]");
//		UserEntity entity = (UserEntity) JSONObject.toBean(o,  UserEntity.class);
	}
    
   


}
