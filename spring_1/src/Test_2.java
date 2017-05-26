import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.sxt.model.CollectionBean;


public class Test_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建一个Bean工厂
		BeanFactory fac=new XmlBeanFactory(new FileSystemResource("src/applicationCOntext.xml"));
		
		CollectionBean coll=(CollectionBean) fac.getBean("collection");
		//取出list集合中的值
		List list=coll.getList();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("==="+list.get(i));
		}
		//取得set集合中的值
		Set set=coll.getSet();
		Iterator it=set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

		//取得map中的值
		Map map=coll.getMap();
		//将所有键装到set集合中
		Set keySet=map.keySet();
		Iterator itKey=keySet.iterator();
		//取得所有key
		while(itKey.hasNext()){
			String key=itKey.next().toString();
			String value=map.get(key).toString();
			System.out.println(key+"==="+value);
		}
	}

}
