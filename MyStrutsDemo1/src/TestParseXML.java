import java.util.HashMap;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class TestParseXML {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//新建解析器
			SAXReader read=new SAXReader();
			//加载解析文件
			Document doc=read.read("src/struts.xml");
			//取得根节点
			Element root=doc.getRootElement();
			
			//所有封装类
			HashMap<String,String> formMaps=new HashMap<String,String>();
			
			//取得所有的form元素
			List<Element> formList=root.selectNodes("//form");
			for (Element form : formList) {
				
				System.out.println(form.getName());
				//================找到参数值==================
				//取得form元素中的name属性值
				String name=form.attributeValue("name");
				//取得form元素中的class属性值
				String className=form.attributeValue("class");
				//==================组装==================
				formMaps.put(name, className);
				//==============================
				System.out.println(name+"==="+className);
			}
			
			//大的业务actionMaps
			HashMap<String,HashMap<String,String>> actionMaps=new HashMap<String,HashMap<String,String>>();
			
			
			//取得所有action元素
			List<Element> actionList=root.selectNodes("//action");
			for (Element action : actionList) {
				//一个action用一个hashMap封装
				HashMap<String,String> actionMap=new HashMap<String,String>();
				//=========================找到参数和值====================
				//请求的路径【请求的动作】
				String path=action.attributeValue("path");
				//封装类名
				String name=action.attributeValue("name");
				//业务类名
				String className=action.attributeValue("class");
				//=========================进行数据组装=======================
				//组装单个action
				actionMap.put("actionClassName", className);
				actionMap.put("formClassName", name);
				//将单个action放到大的actionMaps中
				actionMaps.put(path, actionMap);
				//=============================================
				System.out.println(path+"=="+name+"="+className);
			}
			
			System.out.println(root.getName());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
