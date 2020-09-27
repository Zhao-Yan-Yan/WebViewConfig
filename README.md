# WebViewConfig
Android WebView 通用配置 

https://blog.csdn.net/harvic880925/article/details/51464687
https://juejin.im/post/6844903567497789453
https://juejin.im/post/6844903567506014222

**WebView**
```kotlin
//webViewClient 再影响view的事件到来时 会通过webViewClient 中的方法回调通知
//webChromeClient 影响浏览器事件到来时 会通过webChromeClient 中的方法回调通知
webViewClient = ZYWebViewClient()
webChromeClient = WebChromeClient()

//获取触摸焦点
requestFocusFromTouch()
```


**Setting**
method | 作用
---|---
`setSupportZoom` | 是否支持缩放，配合方法`setBuiltInZoomControls`使用，默认true
`mediaPlaybackRequiresUserGesture` | 是否需要用户手势来播放Media，默认true
`builtInZoomControls = false` | 是否使用WebView内置的缩放组件，由浮动在窗口上的缩放控制和手势缩放控制组成，默认false
`displayZoomControls` | 是否显示窗口悬浮的缩放控制，默认true
`allowFileAccess` | 是否允许访问WebView内部文件，默认true
`allowContentAccess` | 是否允许获取WebView的内容URL ，可以让WebView访问ContentProvider存储的内容。 默认true
`loadWithOverviewMode` | 是否启动概述模式浏览界面，当页面宽度超过WebView显示宽度时，缩小页面适应WebView。默认false
`textZoom` | 设置页面文字缩放百分比，默认100%
`useWideViewPort` | 是否支持ViewPort的meta tag属性，如果页面有ViewPort meta tag 指定的宽度，则使用meta tag指定的值，否则默认使用宽屏的视图窗口
`setSupportMultipleWindows` | 是否支持多窗口，如果设置为true ，WebChromeClient#onCreateWindow方法必须被主程序实现，默认false
`layoutAlgorithm` | 指定WebView的页面布局显示形式，调用该方法会引起页面重绘。默认LayoutAlgorithm#NORMAL
`standardFontFamily` | 设置标准的字体族，默认"sans-serif"。font-family 规定元素的字体系列。 font-family 可以把多个字体名称作为一个“回退”系统来保存。如果浏览器不支持第一个字体，则会尝试下一个。也就是说，font-family 属性的值是用于某个元素的字体族名称或/及类族名称的一个优先表。浏览器会使用它可识别的第一个值。
`fixedFontFamily` | 设置混合字体族。默认"monospace"
`sansSerifFontFamily` | 设置SansSerif字体族。默认"sans-serif"
`serifFontFamily` | 设置SerifFont字体族，默认"sans-serif"
`cursiveFontFamily` | 设置CursiveFont字体族，默认"cursive"
`fantasyFontFamily` | 设置FantasyFont字体族，默认"fantasy"
`minimumFontSize` | 设置最小字体，默认8. 取值区间[1-72]，超过范围，使用其上限值。
`minimumLogicalFontSize` | 设置默认字体大小，默认16，取值区间[1-72]，超过范围，使用其上限值。
`defaultFixedFontSize` | 设置默认填充字体大小，默认16，取值区间[1-72]，超过范围，使用其上限值。
`loadsImagesAutomatically` | 设置是否加载图片资源，注意：方法控制所有的资源图片显示，包括嵌入的本地图片资源。<br>使用方法setBlockNetworkImage则只限制网络资源图片的显示。<br>值设置为true后，WebView会自动加载网络图片。默认true
`blockNetworkImage` | 是否加载网络图片资源。<br>注意如果getLoadsImagesAutomatically返回false，则该方法没有效果。<br>如果使用setBlockNetworkLoads设置为false，该方法设置为false，也不会显示网络图片。<br>当值从true改为false时。WebView会自动加载网络图片。
`blockNetworkLoads` | 设置是否加载网络资源。<br>注意如果值从true切换为false后，WebView不会自动加载，除非调用WebView#reload().如果没有android.Manifest.permission#INTERNET权限，<br> 值设为false，则会抛出java.lang.SecurityException异常。<br>默认值：有android.Manifest.permission#INTERNET权限时为false，其他为true。
`javaScriptEnabled` | 设置是否允许执行JS
`databaseEnabled` | 是否允许数据库存储。默认false
`domStorageEnabled` | 是否允许web使用 localStorage 存储数据 默认false
`setGeolocationEnabled` | 是否允许定位，默认true。注意：为了保证定位可以使用，要保证以下几点：<br>需要有android.Manifest.permission#ACCESS_COARSE_LOCATION的权限<br>需要实现WebChromeClient#onGeolocationPermissionsShowPrompt的回调，<br>接收Js定位请求访问地理位置的通知
`javaScriptCanOpenWindowsAutomatically` | 是否允许JS自动打开窗口。默认false
`defaultTextEncodingName` | 设置页面的编码格式，默认UTF-8
`userAgentString` | UA 标识 `userAgentString = userAgentString + "app name/" + "ver name"`
`setNeedInitialFocus` | 通知WebView是否需要设置一个节点获取焦点当 WebView#requestFocus(int,android.graphics.Rect)被调用的时候 默认true
`cacheMode` | 缓存模式<br> `LOAD_DEFAULT` 默认加载方式 <br> `LOAD_CACHE_ELSE_NETWORK` 按网络情况使用缓存<br>`LOAD_NO_CACHE` 不使用缓存<br>`LOAD_CACHE_ONLY` 只使用缓存
`mixedContentMode` | Android 5.0 开启混合加载 设置加载不安全资源的WebView加载行为 `mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW`

**WebChromeClient**
method | 作用
---|---
`onJsAlert` | 网页调用alert 弹出窗时 进行拦截<br>自定义操作<br>1. 具体操作<br>2. result.confirm() 必须调用<br>3. return true<br>result.confirm() 同时网页操作结果  如果不调用只有第一次会进行回调 后续没任何效果
`onJsConfirm` | 当网页调用confirm()来弹出confirm弹出框前回调，用以拦截confirm()函数
`onJsPrompt` | 当网页调用prompt()来弹出prompt弹出框前回调，用以拦截prompt()函数 文字输入弹出窗
`onConsoleMessage` | `console log`
`onProgressChanged` | 网页加载进度
`onReceivedTitle` | 通知获取到的网页标题
`onReceivedIcon` | 获取到网页图标
`onReceivedTouchIconUrl` | 图标按下的url
`onCreateWindow` | 请求主程序创建一个新的Window，如果主程序接收请求，返回true并创建一个新的WebView来装载Window，然后添加到View中，发送带有创建的WebView作为参数的resultMsg的给Target。<br>如果主程序拒绝接收请求，则方法返回false。默认不做任何处理，返回false
`onRequestFocus` | 显示当前WebView，为当前WebView获取焦点
`onCloseWindow` | 通知主程序关闭WebView，并从View中移除，WebCore停止任何的进行中的加载和JS功能。
`onJsBeforeUnload` | 告诉客户端显示离开当前页面的导航提示框。<br>如果返回true，由客户端处理确认提示框，调用合适的JsResult方法。<br>如果返回false，则返回默认值true给javascript接受离开当前页面的导航。<br>默认：false。JsResult设置false，当前页面取消导航提示，否则离开当前页面。
`onGeolocationPermissionsShowPrompt` | 通知主程序web内容尝试使用定位API，但是没有相关的权限。<br>主程序需要调用调用指定的定位权限申请的回调
`onGeolocationPermissionsHidePrompt` | 通知程序有定位权限请求。如果onGeolocationPermissionsShowPrompt权限申请操作被取消，则隐藏相关的UI界面
`onPermissionRequest` | 通知主程序web内容尝试申请指定资源的权限（权限没有授权或已拒绝），主程序必须调用PermissionRequest#grant(String[])或PermissionRequest#deny()。如果没有覆写该方法，默认拒绝。
`onPermissionRequestCanceled` | 通知主程序相关权限被取消。任何相关UI都应该隐藏掉。
`getDefaultVideoPoster` | 当停止播放，Video显示为一张图片。默认图片可以通过HTML的Video的poster属性标签来指定。如果poster属性不存在，则使用默认的poster。该方法允许ChromeClient提供默认图片。
`getVideoLoadingProgressView` | 当用户重放视频，在渲染第一帧前需要花费时间去缓冲足够的数据。在缓冲期间，ChromeClient可以提供一个显示的View。如：可以显示一个加载动画。
`getVisitedHistory` | 获取访问历史Item，用于链接颜色。
`onShowFileChooser` | 通知客户端显示文件选择器。<br>用来处理file类型的HTML标签，响应用户点击选择文件的按钮操作。<br><br>调用filePathCallback.onReceiveValue(null)并返回true取消请求操作。<br>FileChooserParams参数的枚举列表：<br>MODE_OPEN 打开<br>MODE_OPEN_MULTIPLE 选中多个文件打开<br>MODE_OPEN_FOLDER 打开文件夹（暂不支持）<br>MODE_SAVE 保存

**WebViewClient**
method | 作用
---|---
`onPageStarted` | 开始加载
`onPageFinished` | 加载结束
`shouldOverrideUrlLoading` | 拦截url跳转 (app scheme 跳转可以在这里处理) 第一次加载url不会进入回调<br>return true表示拦截WebView加载的url 自己进行处理<br>return true 后仍会请求原url 只是显示加载结果<br>通常return false 足以处理需求 默认return false<br><br>在利用shouldOverrideUrlLoading来拦截URL时，如果return true，则会屏蔽系统默认的显示URL结果的行为，不需要处理的URL也需要调用loadUrl()来加载进WebVIew，不然就会出现白屏；<br>如果return false，则系统默认的加载URL行为是不会被屏蔽的，所以一般建议大家return false，我们只关心我们关心的拦截内容，对于不拦截的内容，让系统自己来处理即可。
`onReceivedError` | 加载错误时回调  可以显示提示页面 ssl https 出错时不会进行回调
`onReceivedSslError` | https出错  当前处理错误的Handler SslErrorHandler.proceed()忽略错误继续加载 SslErrorHandler.cancel()取消加载
`shouldInterceptRequest` | 请求所有资源都会进行回调(js,css,图片 等文件)  非UI线程
`onLoadResource` | 加载每一个资源会调用
`onScaleChanged` | (WebView发生改变时调用)可以参考http://www.it1352.com/191180.html的用法
`shouldOverrideKeyEvent` | 重写此方法才能够处理在浏览器中的按键事件。<br>是否让主程序同步处理Key Event事件，如过滤菜单快捷键的Key Event事件。<br>如果返回true，WebView不会处理Key Event，<br>如果返回false，Key Event总是由WebView处理。默认：false
`onFormResubmission` | 是否重发POST请求数据，默认不重发
`doUpdateVisitedHistory` | 更新访问历史
`onUnhandledKeyEvent` | 通知主程序输入事件不是由WebView调用。是否让主程序处理WebView未处理的Input Event。<br>除了系统按键，WebView总是消耗掉输入事件或shouldOverrideKeyEvent返回true。<br>该方法由event 分发异步调用。注意：如果事件为MotionEvent，则事件的生命周期只存在方法调用过程中，<br>如果WebViewClient想要使用这个Event，则需要复制Event对象。
`onReceivedLoginRequest` | 通知主程序执行了自动登录请求
`onReceivedHttpAuthRequest` | 通知主程序：WebView接收HTTP认证请求，主程序可以使用HttpAuthHandler为请求设置WebView响应。默认取消请求。
`onReceivedClientCertRequest` | 通知主程序处理SSL客户端认证请求。如果需要提供密钥，主程序负责显示UI界面。<br>有三个响应方法：proceed(), cancel() 和 ignore()。<br>如果调用proceed()和cancel()，webview将会记住response，<br>对相同的host和port地址不再调用onReceivedClientCertRequest方法。<br>如果调用ignore()方法，webview则不会记住response。该方法在UI线程中执行，<br>在回调期间，连接被挂起。默认cancel()，即无客户端认证

**setting**
```kotlin
//是否支持缩放，配合方法setBuiltInZoomControls使用，默认true
setSupportZoom(true)
//是否需要用户手势来播放Media，默认true
mediaPlaybackRequiresUserGesture = true
//是否使用WebView内置的缩放组件，由浮动在窗口上的缩放控制和手势缩放控制组成，默认false
builtInZoomControls = false
//是否显示窗口悬浮的缩放控制，默认true
displayZoomControls = true
//是否允许访问WebView内部文件，默认true
allowFileAccess = true
//是否允许获取WebView的内容URL ，可以让WebView访问ContentProvider存储的内容。 默认true
allowContentAccess = true
//是否启动概述模式浏览界面，当页面宽度超过WebView显示宽度时，缩小页面适应WebView。默认false
loadWithOverviewMode = false
//设置页面文字缩放百分比，默认100%
textZoom = 100
//是否支持ViewPort的meta tag属性，如果页面有ViewPort meta tag 指定的宽度，则使用meta tag指定的值，否则默认使用宽屏的视图窗口
useWideViewPort = true
//是否支持多窗口，如果设置为true ，WebChromeClient#onCreateWindow方法必须被主程序实现，默认false
setSupportMultipleWindows(true)
//指定WebView的页面布局显示形式，调用该方法会引起页面重绘。默认LayoutAlgorithm#NORMAL
layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL
/**
  * 设置标准的字体族，默认"sans-serif"。font-family 规定元素的字体系列。
  * font-family 可以把多个字体名称作为一个“回退”系统来保存。如果浏览器不支持第一个字体，
  * 则会尝试下一个。也就是说，font-family 属性的值是用于某个元素的字体族名称或/及类族名称的一个
  * 优先表。浏览器会使用它可识别的第一个值。
  */
standardFontFamily
//设置混合字体族。默认"monospace"
fixedFontFamily
//设置SansSerif字体族。默认"sans-serif"
sansSerifFontFamily
//设置SerifFont字体族，默认"sans-serif"
serifFontFamily
//设置CursiveFont字体族，默认"cursive"
cursiveFontFamily
//设置FantasyFont字体族，默认"fantasy"
fantasyFontFamily
//设置最小字体，默认8. 取值区间[1-72]，超过范围，使用其上限值。
minimumFontSize
//设置默认字体大小，默认16，取值区间[1-72]，超过范围，使用其上限值。
minimumLogicalFontSize
//设置默认填充字体大小，默认16，取值区间[1-72]，超过范围，使用其上限值。
defaultFixedFontSize

/**
 * 设置是否加载图片资源，注意：方法控制所有的资源图片显示，包括嵌入的本地图片资源。
 * 使用方法setBlockNetworkImage则只限制网络资源图片的显示。值设置为true后，
 * WebView会自动加载网络图片。默认true
 */
loadsImagesAutomatically = true

/**
 * 是否加载网络图片资源。注意如果getLoadsImagesAutomatically返回false，则该方法没有效果。
 * 如果使用setBlockNetworkLoads设置为false，该方法设置为false，也不会显示网络图片。
 * 当值从true改为false时。WebView会自动加载网络图片。
 */
blockNetworkImage

/**
 * 设置是否加载网络资源。注意如果值从true切换为false后，WebView不会自动加载，
 * 除非调用WebView#reload().如果没有android.Manifest.permission#INTERNET权限，
 * 值设为false，则会抛出java.lang.SecurityException异常。
 * 默认值：有android.Manifest.permission#INTERNET权限时为false，其他为true。
 */
blockNetworkLoads

//设置是否允许执行JS
javaScriptEnabled = true

//是否允许数据库存储。默认false
databaseEnabled
//是否允许web使用 localStorage 存储数据 默认false
domStorageEnabled = true


/**
 * 是否允许定位，默认true。注意：为了保证定位可以使用，要保证以下几点：
 * 需要有android.Manifest.permission#ACCESS_COARSE_LOCATION的权限
 * 需要实现WebChromeClient#onGeolocationPermissionsShowPrompt的回调，
 * 接收Js定位请求访问地理位置的通知
 */
setGeolocationEnabled(true)

//是否允许JS自动打开窗口。默认false
javaScriptCanOpenWindowsAutomatically = false
//设置页面的编码格式，默认UTF-8
defaultTextEncodingName
//UA 标识
userAgentString = userAgentString + "app name/" + "ver name"
//通知WebView是否需要设置一个节点获取焦点当 WebView#requestFocus(int,android.graphics.Rect)被调用的时候 默认true
setNeedInitialFocus(true)
/**
 * 缓存模式
 * LOAD_DEFAULT 默认加载方式
 * LOAD_CACHE_ELSE_NETWORK 按网络情况使用缓存
 * LOAD_NO_CACHE 不使用缓存
 * LOAD_CACHE_ONLY 只使用缓存
 */
cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK

if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
    //Android 5.0 开启混合加载 设置加载不安全资源的WebView加载行为
    mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
}
```

**WebChromeClient**

```kotlin
class ZYWebChromeClient : WebChromeClient() {
    /**
     * 网页调用alert 弹出窗时 进行拦截
     * 自定义操作
     * 1. 具体操作
     * 2. result.confirm() 必须调用
     * 3. return true
     *
     * result.confirm() 同时网页操作结果  如果不调用只有第一次会进行回调 后续没任何效果
     */
    override fun onJsAlert(view: WebView?,url: String?,message: String?,result: JsResult?): Boolean {
        return super.onJsAlert(view, url, message, result)
    }

    /**
     * 当网页调用confirm()来弹出confirm弹出框前回调，用以拦截confirm()函数
     */
    override fun onJsConfirm(   view: WebView?, url: String?,message: String?,result: JsResult?): Boolean {
        return super.onJsConfirm(view, url, message, result)
    }

    /**
     * 当网页调用prompt()来弹出prompt弹出框前回调，用以拦截prompt()函数
     * 文字输入弹出窗
     */
    override fun onJsPrompt(view: WebView?,url: String?,message: String?,defaultValue: String?,result: JsPromptResult?): Boolean {
        return super.onJsPrompt(view, url, message, defaultValue, result)
    }

    /**
     * console log
     */
    override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {
        return super.onConsoleMessage(consoleMessage)
    }

    /**
     * 网页加载进度
     */
    override fun onProgressChanged(view: WebView?, newProgress: Int) {
        super.onProgressChanged(view, newProgress)
    }

    /**
     * 获取到网页标题 通知
     */
    override fun onReceivedTitle(view: WebView?, title: String?) {
        super.onReceivedTitle(view, title)
    }

    /**
     * 获取到网页图标
     */
    override fun onReceivedIcon(view: WebView?, icon: Bitmap?) {
        super.onReceivedIcon(view, icon)
    }

    /**
     * 图标按下url
     */
    override fun onReceivedTouchIconUrl(view: WebView?, url: String?, precomposed: Boolean) {
        super.onReceivedTouchIconUrl(view, url, precomposed)
    }

    override fun onShowCustomView(view: View?, callback: CustomViewCallback?) {
        super.onShowCustomView(view, callback)
    }

    /*
    * 与onShowCustomView对应，通知主程序当前页面将要关闭Custom View
    */
    override fun onHideCustomView() {
        super.onHideCustomView()
    }

    /**
     * 请求主程序创建一个新的Window，如果主程序接收请求，返回true并创建一个新的WebView来装载Window，然后添加到View中，发送带有创建的WebView作为参数的resultMsg的给Target。
     * 如果主程序拒绝接收请求，则方法返回false。默认不做任何处理，返回false
     */
    override fun onCreateWindow(view: WebView?,isDialog: Boolean,isUserGesture: Boolean,resultMsg: Message?): Boolean {
        return super.onCreateWindow(view, isDialog, isUserGesture, resultMsg)
    }

    /**
     * 显示当前WebView，为当前WebView获取焦点
     */
    override fun onRequestFocus(view: WebView?) {
        super.onRequestFocus(view)
    }

    /**
     * 通知主程序关闭WebView，并从View中移除，WebCore停止任何的进行中的加载和JS功能。
     */
    override fun onCloseWindow(window: WebView?) {
        super.onCloseWindow(window)
    }

    /**
     * 告诉客户端显示离开当前页面的导航提示框。
     * 如果返回true，由客户端处理确认提示框，调用合适的JsResult方法。
     * 如果返回false，则返回默认值true给javascript接受离开当前页面的导航。
     * 默认：false。JsResult设置false，当前页面取消导航提示，否则离开当前页面。
     */
    override fun onJsBeforeUnload(view: WebView?,url: String?,message: String?,result: JsResult?): Boolean {
        return super.onJsBeforeUnload(view, url, message, result)
    }

    /**
     * 通知主程序web内容尝试使用定位API，但是没有相关的权限。
     * 主程序需要调用调用指定的定位权限申请的回调。更多说明查看GeolocationPermissions相关API。
     */
    override fun onGeolocationPermissionsShowPrompt(origin: String?,callback: GeolocationPermissions.Callback?) {
        super.onGeolocationPermissionsShowPrompt(origin, callback)
    }

    /*
     * 通知程序有定位权限请求。如果onGeolocationPermissionsShowPrompt权限申请操作被取消，则隐藏相关的UI界面。
     */
    override fun onGeolocationPermissionsHidePrompt() {
        super.onGeolocationPermissionsHidePrompt()
    }

    /**
     *通知主程序web内容尝试申请指定资源的权限（权限没有授权或已拒绝），主程序必须调用PermissionRequest#grant(String[])或PermissionRequest#deny()。
     * 如果没有覆写该方法，默认拒绝。
     */
    override fun onPermissionRequest(request: PermissionRequest?) {
        super.onPermissionRequest(request)
    }

    /**
     * 通知主程序相关权限被取消。任何相关UI都应该隐藏掉。
     */
    override fun onPermissionRequestCanceled(request: PermissionRequest?) {
        super.onPermissionRequestCanceled(request)
    }

    /**
     *当停止播放，Video显示为一张图片。默认图片可以通过HTML的Video的poster属性标签来指定。如果poster属性不存在，则使用默认的poster。该方法允许ChromeClient提供默认图片。
     */
    override fun getDefaultVideoPoster(): Bitmap? {
        return super.getDefaultVideoPoster()
    }

    /**
     * 当用户重放视频，在渲染第一帧前需要花费时间去缓冲足够的数据。在缓冲期间，ChromeClient可以提供一个显示的View。如：可以显示一个加载动画。
     */
    override fun getVideoLoadingProgressView(): View? {
        return super.getVideoLoadingProgressView()
    }

    /**
     * 获取访问历史Item，用于链接颜色。
     */
    override fun getVisitedHistory(callback: ValueCallback<Array<String>>?) {
        super.getVisitedHistory(callback)
    }

    /**
     * 通知客户端显示文件选择器。
     * 用来处理file类型的HTML标签，响应用户点击选择文件的按钮操作。
     * 调用filePathCallback.onReceiveValue(null)并返回true取消请求操作。
     * FileChooserParams参数的枚举列表：
     *      MODE_OPEN 打开
     *      MODE_OPEN_MULTIPLE 选中多个文件打开
     *      MODE_OPEN_FOLDER 打开文件夹（暂不支持）
     *      MODE_SAVE 保存
     */
    override fun onShowFileChooser(webView: WebView?,filePathCallback: ValueCallback<Array<Uri>>?,fileChooserParams: FileChooserParams?): Boolean {
        return super.onShowFileChooser(webView, filePathCallback, fileChooserParams)
    }
}
```

**WebViewClient**
```kotlin
class ZYWebViewClient : WebViewClient() {
    /**
     * 开始加载
     */
    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        log("onPageStarted")
    }

    /**
     * 加载结束
     */
    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        log("onPageFinished")
    }

    /**
     * 拦截url跳转 (app scheme 跳转可以在这里处理) 第一次加载url不会进入回调
     *
     * @return true表示拦截WebView加载的url 自己进行处理
     *
     * return true 后仍会请求原url 只是显示加载结果
     * 通常return false 足以处理需求 默认return false
     *
     * 在利用shouldOverrideUrlLoading来拦截URL时，
     * 如果return true，则会屏蔽系统默认的显示URL结果的行为，不需要处理的URL也需要调用loadUrl()来加载进WebVIew，不然就会出现白屏；
     * 如果return false，则系统默认的加载URL行为是不会被屏蔽的，所以一般建议大家return false，我们只关心我们关心的拦截内容，对于不拦截的内容，让系统自己来处理即可。
     */
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        log("shouldOverrideUrlLoading")
        //if (request?.url?.toString()?.contains("flutter") == true) {
        //    view?.loadUrl("https://blog.csdn.net/harvic880925/article/details/51523983")
        //}
        return false
    }

    /**
     * 加载错误时回调  可以显示提示页面
     * ssl https 出错时不会进行回调
     */
    override fun onReceivedError(view: WebView?,request: WebResourceRequest?,error: WebResourceError?) {
        log("onReceivedError")
        super.onReceivedError(view, request, error)
    }

    /**
     * https 出错
     * @param handler 当前处理错误的Handler SslErrorHandler.proceed()忽略错误继续加载 SslErrorHandler.cancel()取消加载
     * @param error 错误基本信息
     */
    override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
        log("onReceivedSslError")
        super.onReceivedSslError(view, handler, error)
    }

    /**
     * 请求所有资源都会进行回调(js,css,图片 等文件)
     * 非UI线程
     */
    override fun shouldInterceptRequest(view: WebView?,request: WebResourceRequest?): WebResourceResponse? {
        log("shouldInterceptRequest")
        return super.shouldInterceptRequest(view, request)
    }

    /**
     * 加载每一个资源会调用
     */
    override fun onLoadResource(view: WebView?, url: String?) {
        super.onLoadResource(view, url)
    }

    /**
     *  (WebView发生改变时调用)可以参考http://www.it1352.com/191180.html的用法
     */
    override fun onScaleChanged(view: WebView?, oldScale: Float, newScale: Float) {
        super.onScaleChanged(view, oldScale, newScale)
    }

    /**
     * 重写此方法才能够处理在浏览器中的按键事件。
     * 是否让主程序同步处理Key Event事件，如过滤菜单快捷键的Key Event事件。
     * 如果返回true，WebView不会处理Key Event，
     * 如果返回false，Key Event总是由WebView处理。默认：false
     */
    override fun shouldOverrideKeyEvent(view: WebView?, event: KeyEvent?): Boolean {
        return super.shouldOverrideKeyEvent(view, event)
    }

    /**
     * 是否重发POST请求数据，默认不重发
     */
    override fun onFormResubmission(view: WebView?, dontResend: Message?, resend: Message?) {
        super.onFormResubmission(view, dontResend, resend)
    }

    /**
     * 更新访问历史
     */
    override fun doUpdateVisitedHistory(view: WebView?, url: String?, isReload: Boolean) {
        super.doUpdateVisitedHistory(view, url, isReload)
    }

    /**
     *
     * 通知主程序输入事件不是由WebView调用。是否让主程序处理WebView未处理的Input Event。
     * 除了系统按键，WebView总是消耗掉输入事件或shouldOverrideKeyEvent返回true。
     * 该方法由event 分发异步调用。注意：如果事件为MotionEvent，则事件的生命周期只存在方法调用过程中，
     * 如果WebViewClient想要使用这个Event，则需要复制Event对象。
     */
    override fun onUnhandledKeyEvent(view: WebView?, event: KeyEvent?) {
        super.onUnhandledKeyEvent(view, event)
    }

    /**
     *通知主程序执行了自动登录请求。
     */
    override fun onReceivedLoginRequest(view: WebView?,realm: String?,account: String?,args: String?) {
        super.onReceivedLoginRequest(view, realm, account, args)
    }

    /**
     * 通知主程序：WebView接收HTTP认证请求，主程序可以使用HttpAuthHandler为请求设置WebView响应。默认取消请求。
     */
    override fun onReceivedHttpAuthRequest(view: WebView?,handler: HttpAuthHandler?,host: String?,realm: String?) {
        super.onReceivedHttpAuthRequest(view, handler, host, realm)
    }

    /**
     * 通知主程序处理SSL客户端认证请求。如果需要提供密钥，主程序负责显示UI界面。
     * 有三个响应方法：proceed(), cancel() 和 ignore()。
     * 如果调用proceed()和cancel()，webview将会记住response，
     * 对相同的host和port地址不再调用onReceivedClientCertRequest方法。
     * 如果调用ignore()方法，webview则不会记住response。该方法在UI线程中执行，
     * 在回调期间，连接被挂起。默认cancel()，即无客户端认证
     */
    override fun onReceivedClientCertRequest(view: WebView?, request: ClientCertRequest?) {
        super.onReceivedClientCertRequest(view, request)
    }
}
```
