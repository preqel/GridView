package one.preqel.com.gridviewfavorite;

import android.content.Context;
import android.support.annotation.RawRes;
import android.util.Log;

import java.io.InputStream;
import java.util.List;

import one.preqel.com.parse.Parser;
import one.preqel.com.parse.ParserFactory;
import one.preqel.com.ui.Menu;

/**
 * Author: preqel
 * Created on: 2019-09-29.
 * Description:
 *  默认pull类型解析menus菜单
 */
public class DefaultPullCustMenu implements CustMenuInterface {


    private Context mContext;
    private int rawRes;

    public DefaultPullCustMenu(Context mContext, @RawRes int rawRes){
        this.mContext = mContext;
        this.rawRes = rawRes;
    }

    @Override
    public List<Menu> load() {

        if (mContext == null) {
            throw new IllegalArgumentException("mContext must not be null");
        }

        InputStream in = mContext.getResources().openRawResource(rawRes);
        Parser saxparser = ParserFactory.getParser("pull");  //如果想用pullparser ，则传入 pull ； 如果用sax解析，则传入sax；也可以自定义解析器。
        List<Menu> menus = null;
        try {
            menus = saxparser.parse(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //print
        for (Menu a : menus) {
            Log.d("TAG", a.getName());
        }
        return menus;
    }
}
