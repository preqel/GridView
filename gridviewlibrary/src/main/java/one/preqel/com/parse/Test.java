package one.preqel.com.parse;

import java.io.InputStream;
import java.util.List;

import one.preqel.com.ui.Menu;

/**
 * Created by Administrator on 2017/1/13.
 */
public   class Test implements Parser {

    private static Test test = new Test();
    public static void main(String[] args){
        Test.test.h();

        System.out.println("d");
    }

    @Override
    public List<Menu> parse(InputStream in) throws Exception {
        return null;
    }

    public void h(){

        System.out.println("h");
    }
}
