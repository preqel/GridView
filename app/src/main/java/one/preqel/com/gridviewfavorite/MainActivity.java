package one.preqel.com.gridviewfavorite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import gridview.preqel.com.gridviewlibrary.CustomUtil;

/*
    入口类，demo演示了可滑动的gridview，并且可以配置图片和点击事件，只需要修改menu.xml里面的内容即可
    底层的原理，就是利用java反射技术把xml里面的东西反射到对应的点击事件
     作者：wangkang
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            CustMenu.getInstance().load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.d("TAG","preqel：" + CustomUtil.getMyHello());


    }
}
