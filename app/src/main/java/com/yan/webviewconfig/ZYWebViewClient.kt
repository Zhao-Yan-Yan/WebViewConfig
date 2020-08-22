package com.yan.webviewconfig

import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Message
import android.view.KeyEvent
import android.webkit.*

/**
 * <p>文件描述：<p>
 * <p>作者：admin (赵岩)<p>
 * <p>创建时间：2020/8/22<p>
 */
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
    override fun onReceivedError(
        view: WebView?,
        request: WebResourceRequest?,
        error: WebResourceError?
    ) {
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
    override fun shouldInterceptRequest(
        view: WebView?,
        request: WebResourceRequest?
    ): WebResourceResponse? {
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
    override fun onReceivedLoginRequest(
        view: WebView?,
        realm: String?,
        account: String?,
        args: String?
    ) {
        super.onReceivedLoginRequest(view, realm, account, args)
    }

    /**
     * 通知主程序：WebView接收HTTP认证请求，主程序可以使用HttpAuthHandler为请求设置WebView响应。默认取消请求。
     */
    override fun onReceivedHttpAuthRequest(
        view: WebView?,
        handler: HttpAuthHandler?,
        host: String?,
        realm: String?
    ) {
        super.onReceivedHttpAuthRequest(view, handler, host, realm)
    }

    /**
     *
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
