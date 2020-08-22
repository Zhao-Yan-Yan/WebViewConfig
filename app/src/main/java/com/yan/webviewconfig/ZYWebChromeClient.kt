package com.yan.webviewconfig

import android.graphics.Bitmap
import android.net.Uri
import android.os.Message
import android.view.View
import android.webkit.*

/**
 * <p>文件描述：<p>
 * <p>作者：admin (赵岩)<p>
 * <p>创建时间：2020/8/22<p>
 */
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
    override fun onJsAlert(
        view: WebView?,
        url: String?,
        message: String?,
        result: JsResult?
    ): Boolean {
        return super.onJsAlert(view, url, message, result)
    }

    /**
     * 当网页调用confirm()来弹出confirm弹出框前回调，用以拦截confirm()函数
     */
    override fun onJsConfirm(
        view: WebView?,
        url: String?,
        message: String?,
        result: JsResult?
    ): Boolean {
        return super.onJsConfirm(view, url, message, result)
    }

    /**
     * 当网页调用prompt()来弹出prompt弹出框前回调，用以拦截prompt()函数
     * 文字输入弹出窗
     */
    override fun onJsPrompt(
        view: WebView?,
        url: String?,
        message: String?,
        defaultValue: String?,
        result: JsPromptResult?
    ): Boolean {
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
    override fun onCreateWindow(
        view: WebView?,
        isDialog: Boolean,
        isUserGesture: Boolean,
        resultMsg: Message?
    ): Boolean {
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
    override fun onJsBeforeUnload(
        view: WebView?,
        url: String?,
        message: String?,
        result: JsResult?
    ): Boolean {
        return super.onJsBeforeUnload(view, url, message, result)
    }

    /**
     * 通知主程序web内容尝试使用定位API，但是没有相关的权限。
     * 主程序需要调用调用指定的定位权限申请的回调。更多说明查看GeolocationPermissions相关API。
     */
    override fun onGeolocationPermissionsShowPrompt(
        origin: String?,
        callback: GeolocationPermissions.Callback?
    ) {
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
    override fun onShowFileChooser(
        webView: WebView?,
        filePathCallback: ValueCallback<Array<Uri>>?,
        fileChooserParams: FileChooserParams?
    ): Boolean {
        return super.onShowFileChooser(webView, filePathCallback, fileChooserParams)
    }
}