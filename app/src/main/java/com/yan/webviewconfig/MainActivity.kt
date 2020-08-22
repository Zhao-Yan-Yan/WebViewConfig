package com.yan.webviewconfig

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.KeyEvent
import android.webkit.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webView.settings.apply {
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
        }

        webView.apply {
            //获取触摸焦点
            requestFocusFromTouch()
            //webViewClient 再影响view的事件到来时 会通过webViewClient 中的方法回调通知
            //webChromeClient 影响浏览器事件到来时 会通过webChromeClient 中的方法回调通知
            webViewClient = ZYWebViewClient()
            webChromeClient = WebChromeClient()
        }

        webView.loadUrl("https://flutter.cn/")
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}