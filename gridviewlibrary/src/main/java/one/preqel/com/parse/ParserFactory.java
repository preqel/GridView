package one.preqel.com.parse;

/**
 * 简单工厂模式
 * 根据实际需要，来创建到底是pull解析还是sax解析
 * Created by wangkang on 2017/1/13.
 */
public class ParserFactory {

     public static Parser getParser(String name){
         if ("pull".equals(name)) {
             return new PullParser();
         } else if ("sax".equals(name)) {
             return new SaxParser();
         } else {
             return null;
         }

     }


}
