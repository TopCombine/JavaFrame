package com.wangwen.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.wangwen.model.Collection;

public class Test2 {
	public static void main(String[] args) {
		BeanFactory bf = new XmlBeanFactory(new FileSystemResource("src/applicationContext.xml"));
		Collection collection = (Collection)bf.getBean("collection");
		List list = collection.getList();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("=======================");
		Set set = collection.getSet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println("========================");
		Map map = collection.getMap();
		Set keySet = map.keySet();
		Iterator it2 = keySet.iterator();
		while(it2.hasNext()){
			String key = it2.next().toString();
			String keyValue = (String)map.get(key); 
			System.out.println("key="+key+"-----Value="+keyValue);
		}
	}
}
