package one.preqel.com.reflect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import one.preqel.com.gridviewfavorite.MyApplication;
import one.preqel.com.gridviewfavorite.SecondActivity;

/**
 * Created by Administrator on 2017/1/12.
 */
public class Reflector {

    private static Reflector reflector;

//    public static Reflector getInstance() {
//        if (reflector == null) {
//            reflector = new Reflector();
//        }
//        return reflector;
//    }

//    private Reflector(){
//        this.mContext  = MyApplication.getApplication();
//    }


    public Reflector( ) {

    }

    public void regesterContext(Context context){
    }

    public void unregesterContext(Context context){
    }

    public void a(Context mContext){
        Toast.makeText(mContext,"a",Toast.LENGTH_SHORT).show();
    }

    public void b(Context mContext){
        Toast.makeText(mContext,"b",Toast.LENGTH_SHORT).show();
    }

    public void go(Context mContext)
    {
        Intent i = new Intent(mContext, SecondActivity.class);
        ((Activity)mContext).startActivity(i);
    }




}
