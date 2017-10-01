package one.preqel.com.ui;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.util.List;

/**
 * Created by  wangkang on 2017/1/9.
 */
public class GV_adapter extends PagerAdapter{

    private List<GridView> lists ;

    public GV_adapter(List<GridView> lists) {
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ViewGroup parent = (ViewGroup) lists.get(position).getParent();
        if(parent != null){
            parent.removeView(lists.get(position));
        }
        container.addView(lists.get(position));
        return lists.get(position);
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        ( (ViewGroup)container).removeView(lists.get(position));

    }
}
