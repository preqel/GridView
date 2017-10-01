package one.preqel.com.parse;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import one.preqel.com.ui.Menu;

/**
 * sax方式进行解析
 * Created by wangkang on 2017/1/10.
 *
 */
public class SaxParser implements Parser {


    @Override
    public List<Menu> parse(InputStream in) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();
        parser.parse(in , handler);
        return handler.getMenus();
    }


    private class MyHandler extends DefaultHandler{
        private List<Menu> menus;
        private Menu menu;
        private StringBuilder sb ;

        public List<Menu> getMenus() {
            return menus;
        }

        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
            menus = new ArrayList<Menu>();
            sb  = new StringBuilder();
        }

        @Override
        public void endDocument() throws SAXException {
            super.endDocument();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

            super.startElement(uri, localName, qName, attributes);

            if(localName.equals("menu")){
                menu = new Menu();
            }
            sb.setLength(0);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);
            if(localName.equals("id")){
                menu.setId(Integer.parseInt(sb.toString()));
            }else if(localName.equals("name")){
                menu.setName(sb.toString());
            }else if(localName.equals("url")){
                menu.setUrl(sb.toString());
            }else if(localName.equals("img")){
                menu.setImage(sb.toString());
            } else if(localName.equals("menu")){
                menus.add(menu);
            }
               // Log.d("TAG", "todo");
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            super.characters(ch, start, length);
            sb.append(ch , start , length);
        }
    }

}
