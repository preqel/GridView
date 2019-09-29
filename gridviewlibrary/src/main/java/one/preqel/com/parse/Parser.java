package one.preqel.com.parse;

import java.io.InputStream;
import java.util.List;

import one.preqel.com.ui.Menu;

/**
 * 抽象类
 * Created by wangkang on 2017/1/10.
 */
public interface Parser {
    public List<Menu> parse(InputStream in) throws  Exception;

}
