package one.preqel.com.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import one.preqel.com.gridviewfavorite.DataManager;
import gridview.preqel.com.gridviewlibrary.R;
import one.preqel.com.ui.ImageUtil;

/**
 * Created by  wangkang on 2017/1/9.
 */
public class GV_Itemadapter extends BaseAdapter{

    private Context mContext;
    private int index;
    private ArrayList<Menu> list;
    private int totalsize ;    //总的数量
    private int pageitemcount; //每页菜单显示数量

    HashMap<String,Drawable > hashMap = new HashMap<
            String,Drawable>();
    public GV_Itemadapter(Context mcontext,int index ,int pageitemcount) {
        this.mContext = mcontext;
        this.index= index;
        this.list = DataManager.getInstance().getData();
        this.totalsize = this.list.size();
        this.pageitemcount = pageitemcount;


        //通过内存的方式加载图片  方式1
        hashMap.put("我的账户", mContext.getResources().getDrawable(R.drawable.grid_icon_wdzh));
        hashMap.put("转账汇款", mContext.getResources().getDrawable(R.drawable.grid_icon_zz));
        hashMap.put("交易明细", mContext.getResources().getDrawable(R.drawable.grid_icon_jymx));
        hashMap.put("工资单查询", mContext.getResources().getDrawable(R.drawable.grid_icon_gzd));
        hashMap.put("网点预约", mContext.getResources().getDrawable(R.drawable.grid_icon_wdyy));
        hashMap.put("预约取款", mContext.getResources().getDrawable(R.drawable.grid_icon_yyqk));
        hashMap.put("信用卡", mContext.getResources().getDrawable(R.drawable.grid_icon_xyk));
        hashMap.put("安全中心", mContext.getResources().getDrawable(R.drawable.grid_icon_aqzx));
        hashMap.put("定期存款", mContext.getResources().getDrawable(R.drawable.grid_icon_dqck));
        hashMap.put("私人银行", mContext.getResources().getDrawable(R.drawable.grid_icon_sryh));
        hashMap.put("消息中心", mContext.getResources().getDrawable(R.drawable.grid_icon_xxzx));
        hashMap.put("手机充值", mContext.getResources().getDrawable(R.drawable.grid_icon_sjcz));
        hashMap.put("手机信贷", mContext.getResources().getDrawable(R.drawable.grid_icon_sjxd));
        hashMap.put("贷款申请", mContext.getResources().getDrawable(R.drawable.grid_icon_dksq));
        hashMap.put("贷款查询", mContext.getResources().getDrawable(R.drawable.grid_icon_dkcx));
        hashMap.put("自助提款", mContext.getResources().getDrawable(R.drawable.grid_icon_zztk));
        hashMap.put("提前还款", mContext.getResources().getDrawable(R.drawable.grid_icon_tqhk));
        hashMap.put("自定义添加", mContext.getResources().getDrawable(R.drawable.grid_icon_add));
        hashMap.put("资金归集", mContext.getResources().getDrawable(R.drawable.grid_icon_zzgj));

        //通过retrofit的方式加载图片  方式2


    }

    @Override
    public int getCount() {
        int max = totalsize / pageitemcount;
        if (index == max) {
            return totalsize - pageitemcount * index;
        } else {
            return pageitemcount;
        }
    }

    @Override
    public Object getItem(int position) {
        return list.get(position + index * pageitemcount);
    }

    @Override
    public long getItemId(int position) {
        return position+ index * pageitemcount;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        ViewHolder viewholder = new ViewHolder();
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.gridview_item_layout, null);
            TextView textview = (TextView) convertView.findViewById(R.id.tv_gv_item_Name);
            ImageView iamgeview = (ImageView) convertView.findViewById(R.id.iv_gv_item_icon);
            viewholder.tv_name = textview;
            viewholder.iv_icon = iamgeview;
            convertView.setTag(viewholder);
        } else {
            viewholder = (ViewHolder) convertView.getTag();
        }
        Menu m = list.get(position + index * pageitemcount);
        viewholder.tv_name.setText(m.getName());
        if(m.getImage()== null || "".equals(m.getImage())){
            viewholder.iv_icon.setImageDrawable(hashMap.get(list.get(position + index * pageitemcount).getName()));
        }else{
            viewholder.iv_icon.setImageDrawable(ImageUtil.getBitmap(convertView.getContext(),m.getImage()));
        }

        return convertView;
    }

    class ViewHolder {
        ImageView iv_icon;
        TextView tv_name;
        RelativeLayout tv_close;
    }
}
