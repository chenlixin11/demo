package utils;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

public class JsonUtil {   
	  
    /**页面传至后台时，json数据在request的参数名称*/  
    public final static String JSON_ATTRIBUTE = "json";   
    public final static String JSON_ATTRIBUTE1 = "json1";   
    public final static String JSON_ATTRIBUTE2 = "json2";   
    public final static String JSON_ATTRIBUTE3 = "json3";   
    public final static String JSON_ATTRIBUTE4 = "json4";

    /**
     * 从一个JSON 对象字符格式中得到一个java对象，形如：  
     * {"id" : idValue, "name" : nameValue, "aBean" : {"aBeanId" : aBeanIdValue, ...}}  
     * @param clazz
     * @return  
     */  
    public static Object getDTO(String jsonString, Class clazz){   
        JSONObject jsonObject = null;
        try{   
            setDataFormat2JAVA();    
            jsonObject = JSONObject.fromObject(jsonString);
        }catch(Exception e){   
            e.printStackTrace();   
        }   
        return JSONObject.toBean(jsonObject, clazz);
    }
    
    /**
     * 从一个JSON 对象字符格式中得到一个java对象,beanCollection是一类的集合(List or Set)
     * {"id" : idValue, "name" : nameValue,"aBean" : {"aBeanId" : aBeanIdValue, ...},"beanCollection" :[{},{},...]}
     * 该方法是对API getDTO(String jsonString, Class clazz, Map map)的再封装装,可不再提供Map解组映射
     * @param jsonString
     * @param clazz
     * @return
     * Object
     */
    public static <T> T getDTONew(String jsonString,Class<T> clazz){
    	return (T) getDTO(jsonString, clazz, analyzeFields(clazz));
    }
    
    /**  
     * 从一个JSON 对象字符格式中得到一个java对象，其中beansList是一类的集合，形如：  
     * {"id" : idValue, "name" : nameValue, "aBean" : {"aBeanId" : aBeanIdValue, ...},  
     * beansList:[{}, {}, ...]}  
     * @param jsonString  
     * @param clazz  
     * @param map 集合属性的类型 (key : 集合属性名, value : 集合属性类型class) eg: ("beansList" : Bean.class)  
     * @return  
     */  
    public static Object getDTO(String jsonString, Class clazz, Map map){   
        JSONObject jsonObject = null;
        try{   
            setDataFormat2JAVA();    
            jsonObject = JSONObject.fromObject(jsonString);
        }catch(Exception e){   
            e.printStackTrace();   
        }   
        return JSONObject.toBean(jsonObject, clazz, map);
    }   
       
    /**  
     * 从一个JSON数组得到一个java对象数组，形如：  
     * [{"id" : idValue, "name" : nameValue}, {"id" : idValue, "name" : nameValue}, ...]  
     * @param clazz
     * @return  
     */  
    public static Object[] getDTOArray(String jsonString, Class clazz){   
        setDataFormat2JAVA();   
        JSONArray array = JSONArray.fromObject(jsonString);
        Object[] obj = new Object[array.size()];   
        for(int i = 0; i < array.size(); i++){   
            JSONObject jsonObject = array.getJSONObject(i);
            obj[i] = JSONObject.toBean(jsonObject, clazz);
        }   
        return obj;   
    }   
       
    /**  
     * 从一个JSON数组得到一个java对象数组，形如：  
     * [{"id" : idValue, "name" : nameValue}, {"id" : idValue, "name" : nameValue}, ...]  
     * @param clazz
     * @param map  
     * @return  
     */  
    public static Object[] getDTOArray(String jsonString, Class clazz, Map map){   
        setDataFormat2JAVA();   
        JSONArray array = JSONArray.fromObject(jsonString);
        Object[] obj = new Object[array.size()];   
        for(int i = 0; i < array.size(); i++){   
            JSONObject jsonObject = array.getJSONObject(i);
            obj[i] = JSONObject.toBean(jsonObject, clazz, map);
        }   
        return obj;   
    }   
       
    /**  
     * 从一个JSON数组得到一个java对象集合  
     * @param clazz
     * @return  
     */  
    public static List getDTOList(String jsonString, Class clazz){   
        setDataFormat2JAVA();   
        JSONArray array = JSONArray.fromObject(jsonString);
        List list = new ArrayList();   
        for(Iterator iter = array.iterator(); iter.hasNext();){   
            JSONObject jsonObject = (JSONObject)iter.next();
            list.add(JSONObject.toBean(jsonObject, clazz));
        }   
        return list;   
    }   
       
    /**  
     * 从一个JSON数组得到一个java对象集合，其中对象中包含有集合属性  
     * @param clazz
     * @param map 集合属性的类型  
     * @return  
     */  
    public static List getDTOList(String jsonString, Class clazz, Map map){   
        setDataFormat2JAVA();   
        JSONArray array = JSONArray.fromObject(jsonString);
        List list = new ArrayList();   
        for(Iterator iter = array.iterator(); iter.hasNext();){   
            JSONObject jsonObject = (JSONObject)iter.next();
            list.add(JSONObject.toBean(jsonObject, clazz, map));
        }   
        return list;   
    }   
       
    /**  
     * 从json HASH表达式中获取一个map，该map支持嵌套功能  
     * 形如：{"id" : "johncon", "name" : "小强"}  
     * 注意commons-collections版本，必须包含org.apache.commons.collections.map.MultiKeyMap  
     * @return
     */  
    public static Map getMapFromJson(String jsonString) {   
        setDataFormat2JAVA();   
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        Map map = new HashMap();   
        for(Iterator iter = jsonObject.keys(); iter.hasNext();){   
            String key = (String)iter.next();   
            map.put(key, jsonObject.get(key));   
        }   
        return map;   
    }   
       
    /**  
     * 从json数组中得到相应java数组  
     * json形如：["123", "456"]  
     * @param jsonString  
     * @return  
     */  
    public static Object[] getObjectArrayFromJson(String jsonString) {   
        JSONArray jsonArray = JSONArray.fromObject(jsonString);
        return jsonArray.toArray();   
    }   
    
    /**  
     * 从List<Object>中得到相应List<Map>
     * json形如：[{"id":1,username":"a"},{"id":2,"username":"b"}]  
     * @param jsonString  
     * @return  List<Map>
     */  
    public static List<Map> getMapListFromJson(String jsonString) {
    	JSONArray array;
		try {
			array = JSONArray.fromObject(JsonUtil.getJSONString(jsonString));
			List<Map> listMap = (List<Map>) JSONArray.toCollection(array, HashMap.class);
			return listMap;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		}
    	
    }   
  
  
    /**  
     * 把数据对象转换成json字符串  
     * DTO对象形如：{"id" : idValue, "name" : nameValue, ...}  
     * 数组对象形如：[{}, {}, {}, ...]  
     * map对象形如：{key1 : {"id" : idValue, "name" : nameValue, ...}, key2 : {}, ...}  
     * @param object  
     * @return  
     */  
    public static String getJSONString(Object object) throws RuntimeException{ 
    	try {
    		String jsonString = null;   
            //日期值处理器   
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(java.util.Date.class, new JsonDateValueProcessor());   
            if(object != null){   
                if(object instanceof Collection || object instanceof Object[]){   
                    jsonString = JSONArray.fromObject(object, jsonConfig).toString();
                }else{   
                    jsonString = JSONObject.fromObject(object, jsonConfig).toString();
                }   
            }   
            return jsonString == null ? "{}" : jsonString;   
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
    }   
       
    private static void setDataFormat2JAVA(){   
        //设定日期转换格式   
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[] {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"}));
    }   
    
    public static String buildJsonFromStrArray(String[] keyArr, String[] valueArr){
    	String jsonStr = "{";
    	for(int i = 0; i < keyArr.length; ++i){
    		if(i!=keyArr.length-1){
    			jsonStr = jsonStr + "'" + keyArr[i] + "':" +"'" +  valueArr[i] + "',";
    		}
    		else{
    			jsonStr = jsonStr + "'" + keyArr[i] + "':" +"'" +  valueArr[i] + "'";
    		}
    	}
    	jsonStr = jsonStr + "}";
    	return jsonStr;
//    	String jsonStr = "";
//    	Map<String,String> map = new HashMap<String,String>();
//    	for(int i = 0; i <keyArr.length; ++i){
//    		map.put(keyArr[i],valueArr[i]);
//    	}
//    	try {
//    		jsonStr = JsonUtil.getJSONString(map);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	return jsonStr;
    }
    
    
    
    
    
    public static String getJsonStr(Object... pairs){
    	
    	JSONObject json = new JSONObject();
    	if (pairs.length%2!=0) {
			throw new RuntimeException("参数必须成对儿出现！");
		}
		
		boolean isName = true;
		String name = "";
		Object value = "";
		int count = 1;
		for (Object param : pairs) {
			if (isName) {
				name = (String)param;
				isName = false;
			}else {
				isName = true;
				if (ValidateUtils.isEmpty(param)) {
					count++;
					continue;
				}
				value = param;
			}
			if(count%2==0){
				json.put(name, value);
			}
			count++;
		}
		
		return json.toString();
    }
    
    /**  
     * 把数据对象转换成json字符串  
     * DTO对象形如：{"id" : idValue, "name" : nameValue, ...}  
     * 数组对象形如：[{}, {}, {}, ...]  
     * map对象形如：{key1 : {"id" : idValue, "name" : nameValue, ...}, key2 : {}, ...}  
     * @return
     */  
    public static String getJSONStringFromListMap(List<Map<String, String>> listMap) throws RuntimeException{ 
    	try {
    		String jsonString = null;   
            JSONArray jsonArray = new JSONArray();
            if(listMap != null && listMap.size()>0){   
            	
            	for(int i=0; i<listMap.size(); i++) {
            		Map<String, String> map = listMap.get(i);
            		JSONObject jsonObject = new JSONObject();
            		for (String key : map.keySet()) {
						jsonObject.put(key, map.get(key));
					}
            		jsonArray.add(jsonObject);
            	}
            	
                jsonString = jsonArray.toString();
            }   
            return jsonString == null ? "{}" : jsonString;   
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
    }   
    
    /**
     * 类属性分析
     * @param clazz
     * @return
     * Map<String,Class<?>>
     */
    private static Map<String,Class<?>> analyzeFields(Class<?> clazz){
    	Map<String,Class<?>> map = new HashMap<String, Class<?>>();
		Field[] fields = clazz.getDeclaredFields();
		for(Field field:fields){ 
			Class<?> fieldClazz = field.getType();
			if(Collection.class.isAssignableFrom(fieldClazz)){//属性为集合类型
				Type fc = field.getGenericType();//如果为集合类型，得到其Generic的类型
				if(fc==null) continue;
				if(fc instanceof ParameterizedType){//如果集合带泛型
					ParameterizedType pt = (ParameterizedType) fc;
					Type t = pt.getActualTypeArguments()[0];
					//Collection<Map<?,?>> or List<?<?>>
					if(t instanceof ParameterizedType) {
						Type rawType = ((ParameterizedType) t).getRawType();
						map.put(field.getName(), (Class<?>)rawType);
						continue;
					}
					//Collection<?>
					Class<?> genericType = (Class<?>) t;
					map.put(field.getName(), genericType);
					
					//递归
					map.putAll(analyzeFields(genericType));
					continue;
				}
			}
		}
		return map;
	}
    public static void main(String[] arg) throws Exception{   
//        String s = "{\"orderId\":\"SS120486988\",\"orderDate\":\"20120425\",\"orderFee\":\"2399040\",\"fee\":\"2399040\",\"type\":\"镀铝锌\",\"allWeight\":\"4.76\",\"detailCount\":\"1\",\"agentId\":\"TTEST1\",\"tradeId\":\"sh00006\",\"remark\":null,\"detail\":{\"orderId\":\"SS120486988\",\"productName\":\"镀铝锌板卷\",\"productBrand\":\"协议品DC51D+AZ\",\"productSerial\":\"1.2*1250*C\",\"productNum\":\"4.76\",\"productUnit\":\"吨\",\"productPrice\":\"504000\",\"productPlace\":\"宝钢梅钢\",\"serialDetail\":\"补充协议品 \",\"resourceId\":\"TL51120300278\",\"packageId\":\"20804423001\"}}";   
//        Map<String, Class<GylDataOrderDetail>> map = new HashMap<String, Class<GylDataOrderDetail>>();
//        map.put("detail", GylDataOrderDetail.class);
//		GylGmOrders gylGmOrders = (GylGmOrders)JsonUtil.getDTO(s, GylGmOrders.class, map);
    	String s="{\"id\":\"1\",\"billingWos\":[{\"id\":\"12\",\"billingDetailWos\":[{\"id\":\"123\"}]}]}";
//    	JSONParser parser=new JSONParser(); 
//    	Map map=new HashMap();
//    	map.put("billingWos", GylBillingWo.class);
//    	map.put("billingDetailWos", GylBillingDetailWo.class);
//    	GylBillingConcourseWo dzspConfirmOrderWo=(GylBillingConcourseWo) JsonUtil.getDTO(s,GylBillingConcourseWo.class,map);
//            System.out.println(dzspConfirmOrderWo.getBillingWos().get(0).getBillingDetailWos().get(0).getId());
    	
//    	JSONObject jsonObject=new JSONObject();
//    	jsonObject=jsonObject.fromObject(s);
//    	jsonObject.t
//    	System.out.println(jsonObject.get("id"));
    	
    	//    	List<User> list = new ArrayList<User>();
////    	Map<String,String> map = new HashMap<String,String>();
////    	map.put("payAcount", "100");
////    	map.put("loanAcount", "100");
////    	map.put("transTime", "100");
//    	User user = new User();
//    	user.setId(1);
//    	user.setUsername("a");
//    	list.add(user);
//    	User user1 = new User();
//    	user1.setId(2);
//    	user1.setUsername("b");
//    	list.add(user1);
////
		JSONObject jsonObject = new JSONObject();
    	jsonObject.put("result", "1");
    	jsonObject.put("exception", "123");
    	jsonObject.put("orderId", "123");
    	jsonObject.put("orderFee", "123");
    	jsonObject.put("fee", "123");
    	jsonObject.put("remainAcount", "123");
    	//jsonObject.put("payDetail", list);
    	String str = jsonObject.toString();
    	JSONObject myJsonObject = JSONObject.fromObject(str);
    	System.out.println(myJsonObject.get("result"));
    	System.out.println(myJsonObject.get("remainAcount"));
//    	
//    	System.out.println(JsonUtil.getJSONString(list));
//    	JSONArray array = JSONArray.fromObject("[{\"amount\":\"35024093\",\"orderId\":\"SX1204827051A\",\"tradeId\":\"sh00009\",\"transTime\":\"20121018152507\",\"transType\":\"01\",\"transTypeName\":\"买方付款至交易中心子账户\"},{\"amount\":\"35024093\",\"orderId\":\"SX1204827051A\",\"tradeId\":\"sh00009\",\"transTime\":\"20121018153533\",\"transType\":\"02\",\"transTypeName\":\"资金解冻并出金至结算账户\"},{\"amount\":\"35024093\",\"orderId\":\"SX1204827051A1\",\"tradeId\":\"sh00009\",\"transTime\":\"20121018154918\",\"transType\":\"01\",\"transTypeName\":\"买方付款至交易中心子账户\"},{\"amount\":\"15024093\",\"orderId\":\"SX1204827051A1\",\"tradeId\":\"sh00009\",\"transTime\":\"20121018155725\",\"transType\":\"02\",\"transTypeName\":\"资金解冻并出金至结算账户\"},{\"amount\":\"15024093\",\"orderId\":\"SX1204827051A1\",\"tradeId\":\"sh00009\",\"transTime\":\"20121018160248\",\"transType\":\"02\",\"transTypeName\":\"资金解冻并出金至结算账户\"}]");
//    	List<Map> test=(List<Map>) JSONArray.toCollection(array, java.util.HashMap.class);
//    	for(int len=0;len<test.size();len++){
//    	System.out.println(test.get(len).get("amount"));
//    	System.out.println(test.get(len).get("orderId"));
//    	System.out.println(test.get(len).get("tradeId"));
//    	System.out.println(test.get(len).get("transTime"));
//    	System.out.println(test.get(len).get("transType"));
//    	System.out.println(test.get(len).get("transTypeName"));
//    	}
    }   
}
