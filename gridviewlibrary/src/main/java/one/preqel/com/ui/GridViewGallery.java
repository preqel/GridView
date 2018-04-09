package one.preqel.com.ui;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import gridview.preqel.com.gridviewlibrary.R;
import one.preqel.com.gridviewfavorite.CustMenu;
import one.preqel.com.gridviewfavorite.DataManager;

/**
 * GridViewGallery是一个我的菜单组件，
 * 可以根据xml里面配置的菜单，
 * 来生产九宫格菜单。
 * 支持点击事件都是可以配置的。
 * Created by wangkang on 2017/1/9.
 */
public class GridViewGallery extends LinearLayout {

    private Context mcontext;

    private ViewPager viewpager;

    private ImageView[] dots;

    private List<GridView> list_views = new ArrayList<GridView>();

    private int viewpagersize;

    private final int pageitemcount = 8;

    private DataManager datamanager;

    public GV_Itemadapter gvadapter1, gvadapter2, gvadapter3;

    private List<Menu> lists = new ArrayList<>();  //菜单

    private int currenindex;   //目前所选tab项


    public GridViewGallery(Context context) {
        super(context);
        mcontext = context;
        initView();
//        try {
//            Class<?> re = Class.forName("one.preqel.com.reflect.Reflector");
//            Method m = re.getDeclaredMethod("")
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        addClassifyItem();
    }

    public GridViewGallery(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mcontext = context;
        initView();
    }

    public void initView() {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.gallery_layout, null);
//        this.datamanager = DataManager.getInstance();
        if (list_views == null || list_views.size() <= 0) return;
        this.viewpagersize = lists.size() / pageitemcount + 1;

        Log.d("TAG", "initView" + lists.size() + "is the view's size");
        list_views.clear();
        for (int i = 0; i < viewpagersize; i++) {
            GridView gridview = getViewPagerItem(i);
            list_views.add(gridview);
        }
        viewpager = (ViewPager) view.findViewById(R.id.viewpager);
        viewpager.setAdapter(new GV_adapter(list_views));
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {    //adapter适配器

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currenindex = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        addView(view);
    }

    //调用此方法在activity的oncreate里面
    public void initDate(InputStream inputStream) throws Exception {
        CustMenu custMenu = CustMenu.getInstance(inputStream);
        custMenu.load();
        lists = (ArrayList) custMenu.getBizList();

        initView();
        if(gvadapter1 != null)
        gvadapter1.notifyDataSetChanged();
        if(gvadapter2 != null)
        gvadapter2.notifyDataSetChanged();
        if(gvadapter3!= null)
        gvadapter3.notifyDataSetChanged();
    }

    public void initDate(List<Menu> menulist){
        lists = menulist;
        initView();
        if(gvadapter1 != null)
            gvadapter1.notifyDataSetChanged();
        if(gvadapter2 != null)
            gvadapter2.notifyDataSetChanged();
        if(gvadapter3!= null)
            gvadapter3.notifyDataSetChanged();
        //Log.d("TAG","after initdate num:"+ menulist.size());
    }

    //根据Android布局xml来加载
    private void addClassifyItem() {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View view = getChildAt(i);
            if (view instanceof TextView) {
                TextView textView = (TextView)view;
                Menu menu = new Menu(i,textView.getText().toString(),"www.baidu.com");
                lists.add(menu);
                  //todo 如果是textiview 就把textview读取出来加入到数据当中
            }
        }
    }

    public GridView getViewPagerItem(int index) {
        Log.d("TAG","getViewPagerItem executed"+ index);
        View view = LayoutInflater.from(mcontext).inflate(R.layout.gridview_layout, null);
        GridView gridview = (GridView) view.findViewById(R.id.gridView);
        GV_Itemadapter gvadapter = new GV_Itemadapter(mcontext, index, pageitemcount, (ArrayList<Menu>) lists);
        if (index == 0) {
            if (gvadapter1 != null) {
                gvadapter1.notifyDataSetInvalidated();
            } else {
                Log.d("TAG","set gvadapter1");
                gvadapter1 = gvadapter;
                gridview.setAdapter(gvadapter1);
            }
        } else if (index == 1) {
            if (gvadapter2 != null) {
                gvadapter2.notifyDataSetInvalidated();
            } else {
                Log.d("TAG","set gvadapter2");
                gvadapter2 = gvadapter;
                gridview.setAdapter(gvadapter2);
            }
        } else if (index == 2) {
            if (gvadapter3 != null) {
                gvadapter3.notifyDataSetInvalidated();
            } else {
                Log.d("TAG","set gvadapter3");
                gvadapter3 = gvadapter;
                gridview.setAdapter(gvadapter3);
            }
        } else {
            gridview.setAdapter(gvadapter);
        }
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Menu menu = datamanager.getData().get(position + currenindex * pageitemcount);
//                Log.d("TAG", "pre:" + menu.getUrl() + "currentinde:" + currenindex);
                try {
                    Class<?> re = Class.forName("one.preqel.com.reflect.Reflector");
//                    Method m1 = re.getDeclaredMethod("regesterContext", Context.class);
//                    m1.invoke(re.newInstance(),mcontext);
                    for (Method m : re.getMethods()) {
                        if (m.getName().equals(menu.getUrl()))
                            try {
                                m.invoke(re.newInstance(), mcontext);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            }
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        return gridview;
    }

}

