package one.preqel.com.gridviewfavorite;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.InputStream;

import gridview.preqel.com.gridviewlibrary.CustomUtil;
import one.preqel.com.ui.GridViewGallery;

/*
    入口类，demo演示了可滑动的gridview，并且可以配置图片和点击事件，只需要修改menu.xml里面的内容即可
    底层的原理，就是利用java反射技术把xml里面的东西反射到对应的点击事件
    作者：wangkang
    时间：20171003
    ok
 */
public class MainActivity extends AppCompatActivity {

    private GridViewGallery gridViewGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = MainActivity.this;
        InputStream inputStream = context.getResources().openRawResource(R.raw.menus);
        gridViewGallery = (GridViewGallery) findViewById(R.id.gridviewgallery);
//        try {
//            gridViewGallery.initDate(inputStream);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //test
        InputStream inputStream2 = getResources().openRawResource(R.raw.menus);
        try {
            CustMenu.getInstance(inputStream2).load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //gridViewGallery.initDate( CustMenu.getInstance(inputStream2).getBizList());
        Log.d("TAG","preqel：" + CustomUtil.getMyHello());
    }


}
