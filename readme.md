[toc]
#架构
1. 包application
 - `AppConfig`存放常量
1. 包biz
 - `JokeLoader`逻辑层，向网络层请求数据并返回View层
1. 包model
 - `JokeBean`一条笑话
 - `JokeResult`请求api后状态信息
 - `JokeResultBodu`请求api后笑话内容信息
1. 包ui.activity
 - `MainActivity`用于管理Fragment
1. 包ui.fragment
 - `MainFragment`用于管理View显示
1. 包ui.adapter
 -  `JokeListAdapter`用于控制RecyclerView显示
1. 包web
 - `WebHelper`为使用原生HttpURLConnection请求方式
 - `VolleyHelper`为使用volley框架请求
 - `OkHttpHelper`为使用OkHttp框架请求

#web包中为请求网络的类
1. WebHelper为使用原生HttpURLConnection请求方式
1. VolleyHelper为使用volley框架请求
1. OkHttpHelper为使用OkHttp框架请求

#其他
1. ButterKnife框架
1. Gson框架