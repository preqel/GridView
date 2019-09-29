package one.preqel.com.gridviewfavorite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import one.preqel.com.ui.GridViewGallery;

/*
    入口Act，demo演示了可滑动的gridview，并且可以配置图片和点击事件，只需要修改menu.xml里面的内容即可
    作者：wangkang
    时间：20171003
 */
public class MainActivity extends AppCompatActivity {

    private GridViewGallery gridViewGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridViewGallery = (GridViewGallery) findViewById(R.id.gridviewgallery);
        gridViewGallery.setDateSource(new DefaultPullCustMenu());
//        try {
//            CustMenu.getInstance().load();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}
