package one.preqel.com.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;

import java.lang.reflect.Field;

import gridview.preqel.com.gridviewlibrary.R;


/**
 * 图片辅助类
 * Created by wangkang on 2017/1/03.
 */
public class ImageUtil {

    /*
     根据path名称 得到bitmap
     @param 上下文
     @param filepath图片名称
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static Drawable getBitmap(Context context, String imgpath)  {
        imgpath = dealFilePath(imgpath);
        Class drawable = R.drawable.class;
        Field filed = null;
        int res_id = R.drawable.grid_icon_add;
        try {
            filed = drawable.getField(imgpath);
            res_id = filed.getInt(filed.getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
       return  context.getDrawable(res_id);
    }

    private static String dealFilePath(String imagepath) {
        if(imagepath.contains(".png")){
            return  imagepath.replaceAll(".png","");
        } else return imagepath;
    }

}
