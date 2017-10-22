package one.preqel.com.ui;

/**
 * Created by wangkang on 2017/1/9.
 */
public class Menu {

    private String name;
    private String url;
    private String image;
    private int id;

    public Menu(int id, String name ,String url) {
        this.id = id;
        this.name = name;
        this.image = "grid_icon_add.png";
        this.url = url;
    }

    public Menu(int id, String name, String image,String url) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.url = url;
    }

    public Menu(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
