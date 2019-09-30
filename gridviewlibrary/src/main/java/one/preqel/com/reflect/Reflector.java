package one.preqel.com.reflect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import one.preqel.com.ui.Menu;


/**
 * Created by wangkang on 2017/1/12.
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
//        Menu menu = datamanager.generateDate().get(position + currenindex * pageitemcount);
//        try {
//            Class<?> re = Class.forName("one.preqel.com.reflect.Reflector");
//            for (Method m : re.getMethods()) {
//                try {
//                    if (m.getName().equals(menu.getUrl())) {
//                        m.invoke(re.newInstance(), mcontext);
//                    }
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                } catch (InvocationTargetException e) {
//                    e.printStackTrace();
//                } catch (InstantiationException e) {
//                    e.printStackTrace();
//                }
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        Intent i = new Intent(mContext, SecondActivity.class);
//        ((Activity)mContext).startActivity(i);
    }




}
