/******************************************************************
 菜单管理类CustMenu
 加载和管理菜单
 ******************************************************************/
package one.preqel.com.gridviewfavorite;

import android.content.Context;
import android.util.Log;

import org.w3c.dom.Document;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


import gridview.preqel.com.gridviewlibrary.R;
import one.preqel.com.parse.Parser;
import one.preqel.com.parse.ParserFactory;
import one.preqel.com.ui.Menu;


public class CustMenu {

    private static final String CUST_MENU_NAME = "file:///custmenu.xml";

    private static final String TAG_MENU = "menu";

    private static final String TAG_MENU_ATTR_MENUID = "menuid";

    private static final String TAG_MENU_ATTR_VALUE = "value";

    private static final String TAG_MENU_ATTR_IMG = "img";

    private static final String TAG_MENU_ATTR_ONCLICK = "onclick";

    private Document mDocument;

    private Context mContext;

    private List<Menu> bizList = new ArrayList<Menu>();

    private static CustMenu mCustMenu;
    private InputStream inputStream;

    public static final int ACCOUNT_MANAGE_ID = 0001;
    public static final int REMIT_ID = 0002;
    public static final int SELF_PAYMENT = 0005;
    public static final int FOUND_MARKET_ID = 0006;
    public static final int WESDK_ID = 22 ;

    protected CustMenu(InputStream inputStream) {
        this.mContext  = MyApplication.getApplication();
        this.inputStream = inputStream;
    }

    public static CustMenu getInstance(InputStream inputStream){
        if (mCustMenu == null) {
            mCustMenu = new CustMenu(inputStream);
        }
        return mCustMenu;
    }

    public List<Menu> getBizList() {
        return bizList;
    }

    /**
     * 加载配置文件
     */
    public void load() throws  Exception{
        Parser saxparser = ParserFactory.getParser("sax");  //如果想用pullparser ，则传入 pull ； 如果用sax解析，则传入pull；也可以自定义解析器。
        List<Menu> menus = saxparser.parse(inputStream);
        for (Menu a : menus) {
            Log.d("TAG", a.getName());
        }

        this.bizList = menus;
    }

//    /**
//     * 根据menuId获取menu标签
//     *
//     * @param menuId
//     * @return
//     */
//    public String get(String menuId) {
//        Element element = mDocument.getElementByMenuId(menuId);
//        if (element != null) {
//            return element.getAttribute("url");
//        }
//        return "";
//    }

    /**
     *
     * @return
     */
//    public ArrayList<Biz> getBiz() {
//        if (mDocument == null) {
//            return bizList;
//        }
//        List<Element> elements = mDocument.getElementsByTagName(TAG_MENU);
//        int size = elements.size();
//        bizList.clear();
//        for (int i = 0; i < size; i++) {
//            Element e = elements.get(i);
//            Biz biz = new Biz();
//            biz.setBizId(e.getAttribute(TAG_MENU_ATTR_MENUID));
//            biz.setImg(e.getAttribute(TAG_MENU_ATTR_IMG));
//            biz.setOnClick(e.getAttribute(TAG_MENU_ATTR_ONCLICK));
//            biz.setValue(e.getAttribute(TAG_MENU_ATTR_VALUE));
//            bizList.add(biz);
//        }
//        return bizList;
//    }

    /**
     * 根据recentlyBiz的bizId,到custMenu文件中查询对应的信息
     * @param recentlyBiz
     * @return
     */
//    public ArrayList<Biz> getBizRecently(ArrayList<Biz> recentlyBiz) {
//        int size = recentlyBiz != null ? recentlyBiz.size() : 0;
//        if (size == 0) {
//            return recentlyBiz;
//        }
//
//        for (int i = 0; i < size; i++) {
//            Biz biz = recentlyBiz.get(i);
//            Element e = mDocument.getElementByMenuId(biz.getBizId());
//            biz.setImg(e.getAttribute(TAG_MENU_ATTR_IMG));
//            biz.setOnClick(e.getAttribute(TAG_MENU_ATTR_ONCLICK));
//            biz.setValue(e.getAttribute(TAG_MENU_ATTR_VALUE));
//        }
//        return recentlyBiz;
//    }
}
