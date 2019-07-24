package cn.itcast.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {

        // 2.获取Document对象
        // 2.1 获取student.xml的path

       // String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        // 2.2 解析xml文档，加载进内存，获取dom树  ---->Document
        Document document = Jsoup.parse(new File(path), "utf-8");

        // 3.获取元素对象 Element
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());

        // 3.1. 获取第一个name的element 对象
        Element element = elements.get(0);
        System.out.println(element.text());

    }

}
