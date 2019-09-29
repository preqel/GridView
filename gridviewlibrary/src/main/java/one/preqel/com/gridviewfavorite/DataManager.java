package one.preqel.com.gridviewfavorite;

import java.io.InputStream;
import java.util.ArrayList;

import one.preqel.com.ui.Menu;

/**
 * 数据源类
 *
 * Created by wangkang on 2017/1/9.
 */
public class DataManager {

    private static final int TEST_DATE = 0;
    private static final int XML_DATE = 1;
    //  如果是0 则表示测试 如果是 1 则表示xml获取
    private int TYPE  = XML_DATE;
    private static DataManager instance;

    private ArrayList<Menu>  menus = new ArrayList<Menu>();

    private DataManager() {

    }

    public static DataManager getInstance() {  //单例模型
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    /**
     * 生成数据
     * @return
     */
    public ArrayList<Menu> generateDate()   {
        if(TYPE == TEST_DATE) {
            menus.add(new Menu(1, "菜单1", "www.baidu.com"));
            menus.add(new Menu(21, "菜单2", "www.baidu.com2"));
            menus.add(new Menu(31, "菜单3", "www.baidu.co23m"));
            menus.add(new Menu(41, "菜单4", "www.baid23u.com"));
            menus.add(new Menu(51, "菜单5", "www.bai23du.com"));
            menus.add(new Menu(61, "菜单6", "www.bai2du.com"));
            menus.add(new Menu(71, "菜单7", "www.baid4u.com"));
            menus.add(new Menu(81, "菜单8", "www.bai6du.com"));
            menus.add(new Menu(91, "菜单9", "www.ba5idu.com"));
        }else if(TYPE == XML_DATE ){
            try {
                CustMenu custMenu = CustMenu.getInstance( );
                custMenu.load();
                menus = (ArrayList) custMenu.getBizList();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return menus;
    }
}
