package Spring_IOC_XML;


import org.apache.commons.lang3.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-05-10 20:31
 */
public class XmlUtils {

    public static void main(String[] args) throws DocumentException {
        XmlUtils xmlUtils = new XmlUtils();
        xmlUtils.test001();
    }


    public void test001() throws DocumentException {
        SAXReader saxReader = new SAXReader();

        Document read = saxReader.read(getClassPath("student.xml"));

        // 获取根节点
        Element rootElement= read.getRootElement();
        getNodes(rootElement);
    }

    public InputStream getClassPath(String xmlPath){
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(xmlPath);
        return resourceAsStream;
    }

    public static void getNodes(Element rootElement){
        System.out.println("获取当前名称:" + rootElement.getName());
        // 获取属性信息
        List<Attribute> attributes = rootElement.attributes();
        for (Attribute attribute : attributes){
            System.out.println("属性:" + attribute.getName() + "---" + attribute.getText());
        }
        // 获取属性value
        String value = rootElement.getTextTrim();
        if (!StringUtils.isEmpty(value)){
            System.out.println("value:" + value);
        }
        // 使用迭代器遍历,继续遍历子节点
        Iterator elementIterator = rootElement.elementIterator();
        while (elementIterator.hasNext()){
            Element next = (Element) elementIterator.next();
            getNodes(next);
        }
    }

}
