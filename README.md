# 背景
现在app首页在开发的过程可能会用到九宫格菜单的组件，点击每个菜单，进入具体的业务页面。这个GridViewGallery组件是一个自定义的组件，封装成库工程的形式，可以快速的完成九宫菜单的配置。
# 组件介绍
可以左右滑动的九宫格控件，每次页面可以放置八个菜单，目前最大可支持3页内容，在xml里面配置就可以每个菜单的名称，图标和点击事件。
# 如何引用
在allprojects 里面 maven { url 'https://jitpack.io' }
在项目的build.gradle里面增加 compile 'com.github.preqel:GridView:1.0.0' 的依赖
# 使用例子
第一步，在布局文件增加raw文件夹，并在该文件夹下面简历menus.xml,试例代码如下：
```
<?xml version="1.0" encoding="utf-8"?>
<menus    xmlns:android="http://schemas.android.com/apk/res/android">    
  <menu>   
    <name>账单</name>            
    <title>caidan1</title>        
    <img>grid_icon_test.png</img>    
  </menu>    
  <menu>      
  <name>转账</name>        
  <title>caidan2</title>       
  <img>grid_icon_add.png</img>    
  </menu>    
  <menu>        
  <name>贷款</name>       
  <title>caidan3</title>       
  <img>grid_icon_add.png</img>    
  </menu>   
  <menu>        
  <name>体检</name>       
  <title>caidan4</title>       
  <img>grid_icon_add.png</img>   
  </menu>  
  <menu>       
  <name>我的最爱</name>      
  <title>caidan4</title>       
  <img>grid_icon_add.png</img>    
  </menu>  
  <menu>       
  <name>其他</name>      
  <title>caidan4</title>        
  <img>grid_icon_add.png</img>   
  </menu>  
  <menu>        
  <name>全部</name>       
  <title>caidan4</title>       
  <img>grid_icon_add.png</img>    
  </menu>
  </menus>
```

name表示菜单的id\n
title表示菜单下方的标题显示文字\n
img表示菜单的图标，本地文件的路径\n
url表示标识点击事件的tag
    
第二步，代码里面动态设置xml文件（重要）
    
     gridViewGallery = (GridViewGallery) findViewById(R.id.gridviewgallery);   //获得组件
     gridViewGallery.setDateSource(new DefaultPullCustMenu(this,R.raw.menus));  //设置数据源
     
第三步，设置点击事件（非必须）
     
     gridViewGallery.setOnItemClickListener(new GridViewGallery.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id, String url) {
                 //可以根据url标识去做相应的处理
            }
        });
完毕。

# 更新日志

20170301初步编码

20171001改造成library库，方便引用
