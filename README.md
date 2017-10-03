现在app首页都会采用九宫格菜单的组件，点击每个菜单，进入具体的业务页面。自己封装了一个这种菜单组件。
# 组件介绍
可以左右滑动的九宫格控件，每次页面可以放置八个菜单，可以在xml里面配置就可以每个菜单的点击事件函数。
# 如何引用
在allprojects 里面 maven { url 'https://jitpack.io' }
在项目的build.gradle里面增加 compile 'com.github.preqel:GridView:1.0.0' 的依赖
# 介绍
在布局文件里面直接引入代码

# 更新日志
20170301初步编码
20171001改造成library库，方便引用
