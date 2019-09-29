# 背景
现在app首页都会采用九宫格菜单的组件，点击每个菜单，进入具体的业务页面。
# 组件介绍
可以左右滑动的九宫格控件，每次页面可以放置八个菜单，目前最大可支持3页内容，在xml里面配置就可以每个菜单的名称，图标和点击事件。
# 如何引用
在allprojects 里面 maven { url 'https://jitpack.io' }
在项目的build.gradle里面增加 compile 'com.github.preqel:GridView:1.0.0' 的依赖
# 使用例子
在布局文件增加raw文件夹，并在该文件夹下面简历menus.xml,试例代码如下：
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

# 更新日志
20170301初步编码

20171001改造成library库，方便引用


