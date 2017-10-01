package one.preqel.com.parse;

import android.util.Log;
import android.util.Xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import one.preqel.com.ui.Menu;

/**
 * pull方式进行解析
 * Created by wangkang on 2017/1/10.
 */
public class PullParser implements Parser {

    @Override
    public List<Menu> parse(InputStream in) throws Exception {

        List<Menu> lists = null;
        Menu menu = null;
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(in,"utf-8");
        int eventtype = parser.getEventType();
        while(eventtype!= XmlPullParser.END_DOCUMENT) {
            switch (eventtype) {
                case XmlPullParser.END_DOCUMENT:

                    break;
                case XmlPullParser.START_DOCUMENT:
                    lists = new ArrayList<Menu>();

                    break;
                case XmlPullParser.END_TAG:
                    if (parser.getName().equals("menu")) {
                        lists.add(menu);
                        menu = null;
                    }
                    break;
                case XmlPullParser.START_TAG:

                    if (parser.getName().equals("menu")) {
                        menu = new Menu();
                    } else if (parser.getName().equals("id")) {
                        eventtype = parser.next();

                        menu.setId(Integer.parseInt(parser.getText()));
                    } else if (parser.getName().equals("name")) {
                        eventtype = parser.next();
                        menu.setName(parser.getText());
                    } else if (parser.getName().equals("url")) {
                        eventtype = parser.next();
                        menu.setUrl(parser.getText());
                    } else if(parser.getName().equals("img")){

                        eventtype = parser.next();
                        menu.setImage(parser.getText());
                        Log.i("TAG","image;" + menu.getImage());
                    }
                    break;
            }
            eventtype = parser.next();
            Log.d("TAG",eventtype + "is parser.next");
        }

        return lists;
    }

}
