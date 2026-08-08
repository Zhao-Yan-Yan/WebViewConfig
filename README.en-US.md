

# WebViewConfig
Universal Configuration for Android WebView 

https://blog.csdn.net/harvic880925/article/details/51464687
https://juejin.im/post/6844903567497789453
https://juejin.im/post/6844903567506014222

**WebView**
```kotlin
// webViewClient callbacks notify when view-related events arrive
// webChromeClient callbacks notify when browser-related events arrive
webViewClient = ZYWebViewClient()
webChromeClient = WebChromeClient()

// Obtain touch focus
requestFocusFromTouch()
```


**Setting**
method | Description
---|---
`setSupportZoom` | Whether zooming is supported, used with `setBuiltInZoomControls`. Default: true
`mediaPlaybackRequiresUserGesture` | Whether user gesture is required to play media. Default: true
`builtInZoomControls = false` | Whether to use WebView's built-in zoom controls, which consist of floating window zoom controls and gesture zoom controls. Default: false
`displayZoomControls` | Whether to display the floating zoom controls in the window. Default: true
`allowFileAccess` | Whether to allow access to files inside WebView. Default: true
`allowContentAccess` | Whether to allow access to the WebView's content URLs, enabling WebView to access content stored in ContentProviders. Default: true
`loadWithOverviewMode` | Whether to start in overview mode. When the page width exceeds the WebView display width, the page is scaled down to fit WebView. Default: false
`textZoom` | Sets the percentage of page text zoom. Default: 100%
`useWideViewPort` | Whether to support the ViewPort meta tag. If the page has a ViewPort meta tag specifying a width, the meta tag value is used; otherwise, a wide-screen viewport is used by default.
`setSupportMultipleWindows` | Whether to support multiple windows. If set to true, `WebChromeClient#onCreateWindow` must be implemented by the host app. Default: false
`layoutAlgorithm` | Specifies the page layout display format for WebView. Calling this method will trigger a page redraw. Default: `LayoutAlgorithm.NORMAL`
`standardFontFamily` | Sets the standard font family. Default: "sans-serif". The `font-family` property defines the font family for an element. `font-family` can store multiple font names as a "fallback" system. If the browser does not support the first font, it tries the next. In other words, the value of the `font-family` property is a priority list of font family names or/and generic family names for an element. The browser will use the first recognizable value.
`fixedFontFamily` | Sets the fixed-width font family. Default: "monospace"
`sansSerifFontFamily` | Sets the SansSerif font family. Default: "sans-serif"
`serifFontFamily` | Sets the Serif font family. Default: "sans-serif"
`cursiveFontFamily` | Sets the Cursive font family. Default: "cursive"
`fantasyFontFamily` | Sets the Fantasy font family. Default: "fantasy"
`minimumFontSize` | Sets the minimum font size. Default: 8. Range: [1-72]. Values outside the range use the upper limit.
`minimumLogicalFontSize` | Sets the default font size. Default: 16. Range: [1-72]. Values outside the range use the upper limit.
`defaultFixedFontSize` | Sets the default fixed-width font size. Default: 16. Range: [1-72]. Values outside the range use the upper limit.
`loadsImagesAutomatically` | Sets whether to load image resources. Note: This method controls the display of all image resources, including embedded local images. <br>Use `setBlockNetworkImage` to only restrict network image displays. <br>When set to true, WebView will automatically load network images. Default: true
`blockNetworkImage` | Whether to load network image resources. <br>Note: If `getLoadsImagesAutomatically` returns false, this method has no effect. <br>If `setBlockNetworkLoads` is set to false, setting this to false will still not display network images. <br>When the value changes from true to false, WebView will automatically load network images.
`blockNetworkLoads` | Sets whether to load network resources. <br>Note: If the value switches from true to false, WebView will not automatically load unless `WebView#reload()` is called. If the `android.Manifest.permission#INTERNET` permission is missing, <br> setting the value to false will throw a `java.lang.SecurityException`. <br>Default: false if `android.Manifest.permission#INTERNET` is granted, otherwise true.
`javaScriptEnabled` | Sets whether JS execution is allowed.
`databaseEnabled` | Whether database storage is allowed. Default: false
`domStorageEnabled` | Whether the web is allowed to use localStorage for data storage. Default: false
`setGeolocationEnabled` | Whether geolocation is allowed. Default: true. Note: To ensure geolocation works, ensure the following: <br>The `android.Manifest.permission#ACCESS_COARSE_LOCATION` permission is required. <br>You need to implement the callback for `WebChromeClient#onGeolocationPermissionsShowPrompt`, <br>to receive notifications for JS location requests accessing geographical locations.
`javaScriptCanOpenWindowsAutomatically` | Whether JS is allowed to open windows automatically. Default: false
`defaultTextEncodingName` | Sets the page encoding format. Default: UTF-8
`userAgentString` | UA Identifier `userAgentString = userAgentString + "app name/" + "ver name"`
`setNeedInitialFocus` | Notifies WebView whether a node needs to be set to gain focus when `WebView#requestFocus(int,android.graphics.Rect)` is called. Default: true
`cacheMode` | Cache mode <br> `LOAD_DEFAULT` Default loading method <br> `LOAD_CACHE_ELSE_NETWORK` Use cache based on network conditions <br>`LOAD_NO_CACHE` Do not use cache <br>`LOAD_CACHE_ONLY` Use only cache
`mixedContentMode` | Android 5.0 enables mixed content loading. Sets WebView loading behavior for insecure resources. `mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW`

**WebChromeClient**
method | Description
---|---
`onJsAlert` | Intercepts when the webpage calls the alert popup. <br>Custom operations: <br>1. Perform specific operations <br>2. `result.confirm()` must be called <br>3. Return true <br>`result.confirm()` also provides the webpage operation result. If not called, callbacks will only occur for the first time, with no effect subsequently.
`onJsConfirm` | Callback invoked before the webpage calls `confirm()` to display a confirm popup, used to intercept the `confirm()` function.
`onJsPrompt` | Callback invoked before the webpage calls `prompt()` to display a prompt popup, used to intercept the `prompt()` function (text input popup).
`onConsoleMessage` | `console log`
`onProgressChanged` | Web page loading progress.
`onReceivedTitle` | Notifies the retrieved web page title.
`onReceivedIcon` | Retrieves the web page icon.
`onReceivedTouchIconUrl` | URL for the pressed icon.
`onCreateWindow` | Requests the host app to create a new Window. If the host app accepts the request, returns true, creates a new WebView to load the Window, adds it to the View, and sends a resultMsg containing the created WebView as a parameter to the Target. <br>If the host app rejects the request, the method returns false. By default, no action is taken and it returns false.
`onRequestFocus` | Displays the current WebView and gives it focus.
`onCloseWindow` | Notifies the host app to close the WebView, remove it from the View, and stops WebCore from any ongoing loads and JS functions.
`onJsBeforeUnload` | Informs the client to display a navigation prompt for leaving the current page. <br>If returning true, the client handles the confirmation prompt by calling the appropriate JsResult method. <br>If returning false, returns the default value true to JavaScript to accept navigation away from the current page. <br>Default: false. If JsResult is set to false, the current page cancels the navigation prompt; otherwise, it leaves the current page.
`onGeolocationPermissionsShowPrompt` | Notifies the host app that web content is attempting to use the Geolocation API, but lacks the relevant permissions. <br>The host app needs to call the specified geolocation permission request callback.
`onGeolocationPermissionsHidePrompt` | Notifies the program of a geolocation permission request. If the permission request operation in `onGeolocationPermissionsShowPrompt` is canceled, the related UI interface should be hidden.
`onPermissionRequest` | Notifies the host app that web content is attempting to request permissions for specific resources (permissions not granted or already denied). The host app must call `PermissionRequest#grant(String[])` or `PermissionRequest#deny()`. If this method is not overridden, it defaults to denial.
`onPermissionRequestCanceled` | Notifies the host app that related permissions have been canceled. Any related UI should be hidden.
`getDefaultVideoPoster` | When playback stops, the video is displayed as an image. The default image can be specified via the HTML video `poster` attribute tag. If the `poster` attribute does not exist, the default poster is used. This method allows the ChromeClient to provide a default image.
`getVideoLoadingProgressView` | When the user replays a video, it takes time to buffer enough data before rendering the first frame. During buffering, the ChromeClient can provide a View for display. For example, it can display a loading animation.
`getVisitedHistory` | Retrieves visited history items, used for link coloring.
`onShowFileChooser` | Notifies the client to display a file chooser. <br>Used to handle HTML `file` type tags and respond to user clicks on file selection buttons. <br><br>Calling `filePathCallback.onReceiveValue(null)` and returning true cancels the request. <br>Enum list for `FileChooserParams` parameters: <br>`MODE_OPEN` Open <br>`MODE_OPEN_MULTIPLE` Select multiple files to open <br>`MODE_OPEN_FOLDER` Open folder (not yet supported) <br>`MODE_SAVE` Save

**WebViewClient**
method | Description
---|---
`onPageStarted` | Loading starts.
`onPageFinished` | Loading ends.
`shouldOverrideUrlLoading` | Intercepts URL jumps (app scheme jumps can be handled here). The first URL load will not trigger this callback. <br>Returning true indicates that WebView's loaded URL is intercepted for custom handling. <br>Even if true is returned, the original URL is still requested, but the display shows the loading result. <br>Usually, returning false is sufficient to meet requirements. Default: false. <br><br>When using `shouldOverrideUrlLoading` to intercept URLs, if you return true, it will block the system's default behavior of displaying URL results. URLs that do not need processing must still call `loadUrl()` to load into the WebView, otherwise, a white screen will appear. <br>If returning false, the system's default URL loading behavior will not be blocked. Therefore, it is generally recommended to return false; we only care about the specific content we want to intercept. For content that is not intercepted, let the system handle it itself.
`onReceivedError` | Callback when a loading error occurs. Can display a prompt page. Does not callback for SSL/HTTPS errors.
`onReceivedSslError` | HTTPS error. Current error handling handler: `SslErrorHandler.proceed()` ignores the error and continues loading, `SslErrorHandler.cancel()` cancels loading.
`shouldInterceptRequest` | All resource requests will trigger callbacks (js, css, images, etc.). Non-UI thread.
`onLoadResource` | Called when loading each resource.
`onScaleChanged` | (Called when WebView changes) Refer to http://www.it1352.com/191180.html for usage.
`shouldOverrideKeyEvent` | Overriding this method is required to handle key events in the browser. <br>Determines whether the host app synchronously handles Key Event events, such as filtering menu shortcut Key Events. <br>If returning true, WebView will not handle the Key Event. <br>If returning false, the Key Event is always handled by WebView. Default: false.
`onFormResubmission` | Whether to resend POST request data. Default: do not resend.
`doUpdateVisitedHistory` | Updates visit history.
`onUnhandledKeyEvent` | Notifies the host app that an input event is not invoked by WebView. Determines whether the host app handles Input Events not handled by WebView. <br>Except for system buttons, WebView always consumes input events or `shouldOverrideKeyEvent` returns true. <br>This method is called asynchronously by event distribution. Note: If the event is a MotionEvent, the event's lifecycle only exists during the method call. <br>If WebViewClient wants to use this Event, it needs to clone the Event object.
`onReceivedLoginRequest` | Notifies the host app that an automatic login request was executed.
`onReceivedHttpAuthRequest` | Notifies the host app: WebView received an HTTP authentication request. The host app can use HttpAuthHandler to set the WebView response for the request. Default: cancel request.
`onReceivedClientCertRequest` | Notifies the host app to handle the SSL client authentication request. If a key needs to be provided, the host app is responsible for displaying the UI. <br>There are three response methods: `proceed()`, `cancel()`, and `ignore()`. <br>If `proceed()` and `cancel()` are called, WebView will remember the response. <br>For the same host and port addresses, `onReceivedClientCertRequest` will not be called again. <br>If `ignore()` is called, WebView will not remember the response. This method executes on the UI thread. <br>During the callback, the connection is suspended. Default: `cancel()`, meaning no client authentication.

**setting**
```kotlin
// Whether zooming is supported, used with setBuiltInZoomControls. Default: true
setSupportZoom(true)
// Whether user gesture is required to play media. Default: true
mediaPlaybackRequiresUserGesture = true
// Whether to use WebView's built-in zoom controls. Default: false
builtInZoomControls = false
// Whether to display floating zoom controls in the window. Default: true
displayZoomControls = true
// Whether to allow access to files inside WebView. Default: true
allowFileAccess = true
// Whether to allow access to the WebView's content URLs. Default: true
allowContentAccess = true
// Whether to start in overview mode. Default: false
loadWithOverviewMode = false
// Sets the percentage of page text zoom. Default: 100%
textZoom = 100
// Whether to support the ViewPort meta tag. Default: true
useWideViewPort = true
// Whether to support multiple windows. Default: false
setSupportMultipleWindows(true)
// Specifies the page layout display format. Default: LayoutAlgorithm#NORMAL
layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL
/**
 * Sets the standard font family. Default: "sans-serif".
 * The font-family property defines the font family for an element.
 * font-family can store multiple font names as a "fallback" system.
 * If the browser does not support the first font, it tries the next.
 * In other words, the value of the font-family property is a priority list
 * of font family names or/and generic family names for an element.
 * The browser will use the first recognizable value.
 */
standardFontFamily
// Sets the fixed-width font family. Default: "monospace"
fixedFontFamily
// Sets the SansSerif font family. Default: "sans-serif"
sansSerifFontFamily
// Sets the Serif font family. Default: "sans-serif"
serifFontFamily
// Sets the Cursive font family. Default: "cursive"
cursiveFontFamily
// Sets the Fantasy font family. Default: "fantasy"
fantasyFontFamily
// Sets the minimum font size. Default: 8. Range: [1-72].
minimumFontSize
// Sets the default font size. Default: 16. Range: [1-72].
minimumLogicalFontSize
// Sets the default fixed-width font size. Default: 16. Range: [1-72].
defaultFixedFontSize

/**
 * Sets whether to load image resources.
 * Note: This method controls the display of all image resources, including embedded local images.
 * Use setBlockNetworkImage to only restrict network image displays.
 * When set to true, WebView will automatically load network images. Default: true
 */
loadsImagesAutomatically = true

/**
 * Whether to load network image resources.
 * Note: If getLoadsImagesAutomatically returns false, this method has no effect.
 * If setBlockNetworkLoads is set to false, setting this to false will still not display network images.
 * When the value changes from true to false, WebView will automatically load network images.
 */
blockNetworkImage

/**
 * Sets whether to load network resources.
 * Note: If the value switches from true to false, WebView will not automatically load,
 * unless WebView#reload() is called. If the android.Manifest.permission#INTERNET permission is missing,
 * setting the value to false will throw a java.lang.SecurityException.
 * Default: false if android.Manifest.permission#INTERNET is granted, otherwise true.
 */
blockNetworkLoads

// Sets whether JS execution is allowed
javaScriptEnabled = true

// Whether database storage is allowed. Default: false
databaseEnabled
// Whether the web is allowed to use localStorage for data storage. Default: false
domStorageEnabled = true


/**
 * Whether geolocation is allowed. Default: true.
 * Note: To ensure geolocation works, ensure the following:
 * - The android.Manifest.permission#ACCESS_COARSE_LOCATION permission is required.
 * - You need to implement the callback for WebChromeClient#onGeolocationPermissionsShowPrompt
 *   to receive notifications for JS location requests accessing geographical locations.
 */
setGeolocationEnabled(true)

// Whether JS is allowed to open windows automatically. Default: false
javaScriptCanOpenWindowsAutomatically = false
// Sets the page encoding format. Default: UTF-8
defaultTextEncodingName
// UA Identifier
userAgentString = userAgentString + "app name/" + "ver name"
// Notifies WebView whether a node needs to be set to gain focus when WebView#requestFocus(int,android.graphics.Rect) is called. Default: true
setNeedInitialFocus(true)
/**
 * Cache mode
 * LOAD_DEFAULT Default loading method
 * LOAD_CACHE_ELSE_NETWORK Use cache based on network conditions
 * LOAD_NO_CACHE Do not use cache
 * LOAD_CACHE_ONLY Use only cache
 */
cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK

if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
    // Android 5.0 enables mixed content loading. Sets WebView loading behavior for insecure resources.
    mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
}
```

**WebChromeClient**

```kotlin
class ZYWebChromeClient : WebChromeClient() {
    /**
     * Intercepts when the webpage calls the alert popup.
     * Custom operations:
     * 1. Perform specific operations
     * 2. result.confirm() must be called
     * 3. Return true
     *
     * result.confirm() also provides the webpage operation result.
     * If not called, callbacks will only occur for the first time, with no effect subsequently.
     */
    override fun onJsAlert(view: WebView?,url: String?,message: String?,result: JsResult?): Boolean {
        return super.onJsAlert(view, url, message, result)
    }

    /**
     * Callback invoked before the webpage calls confirm() to display a confirm popup.
     */
    override fun onJsConfirm(   view: WebView?, url: String?,message: String?,result: JsResult?): Boolean {
        return super.onJsConfirm(view, url, message, result)
    }

    /**
     * Callback invoked before the webpage calls prompt() to display a prompt popup.
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
     * Web page loading progress
     */
    override fun onProgressChanged(view: WebView?, newProgress: Int) {
        super.onProgressChanged(view, newProgress)
    }

    /**
     * Notifies the retrieved web page title
     */
    override fun onReceivedTitle(view: WebView?, title: String?) {
        super.onReceivedTitle(view, title)
    }

    /**
     * Retrieves the web page icon
     */
    override fun onReceivedIcon(view: WebView?, icon: Bitmap?) {
        super.onReceivedIcon(view, icon)
    }

    /**
     * URL for the pressed icon
     */
    override fun onReceivedTouchIconUrl(view: WebView?, url: String?, precomposed: Boolean) {
        super.onReceivedTouchIconUrl(view, url, precomposed)
    }

    override fun onShowCustomView(view: View?, callback: CustomViewCallback?) {
        super.onShowCustomView(view, callback)
    }

    /*
    * Corresponds to onShowCustomView, notifies the host app that the Custom View on the current page is about to close.
    */
    override fun onHideCustomView() {
        super.onHideCustomView()
    }

    /**
     * Requests the host app to create a new Window.
     * If accepted, returns true, creates a new WebView, adds it to the View, and sends a resultMsg to the Target.
     * If rejected, returns false. By default, no action is taken and it returns false.
     */
    override fun onCreateWindow(view: WebView?,isDialog: Boolean,isUserGesture: Boolean,resultMsg: Message?): Boolean {
        return super.onCreateWindow(view, isDialog, isUserGesture, resultMsg)
    }

    /**
     * Displays the current WebView and gives it focus.
     */
    override fun onRequestFocus(view: WebView?) {
        super.onRequestFocus(view)
    }

    /**
     * Notifies the host app to close the WebView, remove it from the View, and stops WebCore loads and JS.
     */
    override fun onCloseWindow(window: WebView?) {
        super.onCloseWindow(window)
    }

    /**
     * Informs the client to display a navigation prompt for leaving the current page.
     * If returning true, the client handles the confirmation prompt.
     * If returning false, returns default true to JS to accept navigation.
     * Default: false. If JsResult is false, the page cancels the prompt; otherwise, it leaves.
     */
    override fun onJsBeforeUnload(view: WebView?,url: String?,message: String?,result: JsResult?): Boolean {
        return super.onJsBeforeUnload(view, url, message, result)
    }

    /**
     * Notifies the host app that web content is attempting to use the Geolocation API without permissions.
     * The host app needs to call the specified geolocation permission request callback.
     */
    override fun onGeolocationPermissionsShowPrompt(origin: String?,callback: GeolocationPermissions.Callback?) {
        super.onGeolocationPermissionsShowPrompt(origin, callback)
    }

    /*
     * Notifies the program of a geolocation permission request.
     * Hides related UI if the permission request in onGeolocationPermissionsShowPrompt is canceled.
     */
    override fun onGeolocationPermissionsHidePrompt() {
        super.onGeolocationPermissionsHidePrompt()
    }

    /**
     * Notifies the host app that web content is attempting to request permissions for specific resources.
     * The host app must call PermissionRequest#grant(String[]) or PermissionRequest#deny().
     * Defaults to denial if not overridden.
     */
    override fun onPermissionRequest(request: PermissionRequest?) {
        super.onPermissionRequest(request)
    }

    /**
     * Notifies the host app that related permissions have been canceled. Hide related UI.
     */
    override fun onPermissionRequestCanceled(request: PermissionRequest?) {
        super.onPermissionRequestCanceled(request)
    }

    /**
     * When playback stops, the video is displayed as an image.
     * Allows ChromeClient to provide a default image.
     */
    override fun getDefaultVideoPoster(): Bitmap? {
        return super.getDefaultVideoPoster()
    }

    /**
     * During video buffering, the ChromeClient can provide a View for display (e.g., a loading animation).
     */
    override fun getVideoLoadingProgressView(): View? {
        return super.getVideoLoadingProgressView()
    }

    /**
     * Retrieves visited history items, used for link coloring.
     */
    override fun getVisitedHistory(callback: ValueCallback<Array<String>>?) {
        super.getVisitedHistory(callback)
    }

    /**
     * Notifies the client to display a file chooser.
     * Handles HTML file type tags and user file selection button clicks.
     * Call filePathCallback.onReceiveValue(null) and return true to cancel.
     * FileChooserParams enum:
     *      MODE_OPEN Open
     *      MODE_OPEN_MULTIPLE Select multiple files to open
     *      MODE_OPEN_FOLDER Open folder (not yet supported)
     *      MODE_SAVE Save
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
     * Loading starts
     */
    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        log("onPageStarted")
    }

    /**
     * Loading ends
     */
    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        log("onPageFinished")
    }

    /**
     * Intercepts URL jumps (app scheme jumps can be handled here).
     * The first URL load will not trigger this callback.
     *
     * @return true indicates that WebView's loaded URL is intercepted for custom handling.
     *
     * Even if true is returned, the original URL is still requested, but the display shows the loading result.
     * Usually, returning false is sufficient. Default: false.
     *
     * When using shouldOverrideUrlLoading to intercept URLs,
     * if returning true, it will block the system's default behavior of displaying URL results.
     * URLs that do not need processing must still call loadUrl() to load into the WebView, otherwise, a white screen will appear;
     * if returning false, the system's default URL loading behavior will not be blocked.
     * Therefore, it is generally recommended to return false; we only care about specific content to intercept.
     */
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        log("shouldOverrideUrlLoading")
        //if (request?.url?.toString()?.contains("flutter") == true) {
        //    view?.loadUrl("https://blog.csdn.net/harvic880925/article/details/51523983")
        //}
        return false
    }

    /**
     * Callback when a loading error occurs. Can display a prompt page.
     * Does not callback for SSL/HTTPS errors.
     */
    override fun onReceivedError(view: WebView?,request: WebResourceRequest?,error: WebResourceError?) {
        log("onReceivedError")
        super.onReceivedError(view, request, error)
    }

    /**
     * HTTPS error.
     * @param handler Error handler: SslErrorHandler.proceed() ignores the error and continues loading, SslErrorHandler.cancel() cancels loading.
     * @error Basic error information.
     */
    override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
        log("onReceivedSslError")
        super.onReceivedSslError(view, handler, error)
    }

    /**
     * All resource requests will trigger callbacks (js, css, images, etc.).
     * Non-UI thread.
     */
    override fun shouldInterceptRequest(view: WebView?,request: WebResourceRequest?): WebResourceResponse? {
        log("shouldInterceptRequest")
        return super.shouldInterceptRequest(view, request)
    }

    /**
     * Called when loading each resource.
     */
    override fun onLoadResource(view: WebView?, url: String?) {
        super.onLoadResource(view, url)
    }

    /**
     * (Called when WebView changes) Refer to http://www.it1352.com/191180.html for usage.
     */
    override fun onScaleChanged(view: WebView?, oldScale: Float, newScale: Float) {
        super.onScaleChanged(view, oldScale, newScale)
    }

    /**
     * Overriding this method is required to handle key events in the browser.
     * Determines whether the host app synchronously handles Key Event events, such as filtering menu shortcuts.
     * If returning true, WebView will not handle the Key Event.
     * If returning false, the Key Event is always handled by WebView. Default: false.
     */
    override fun shouldOverrideKeyEvent(view: WebView?, event: KeyEvent?): Boolean {
        return super.shouldOverrideKeyEvent(view, event)
    }

    /**
     * Whether to resend POST request data. Default: do not resend.
     */
    override fun onFormResubmission(view: WebView?, dontResend: Message?, resend: Message?) {
        super.onFormResubmission(view, dontResend, resend)
    }

    /**
     * Updates visit history.
     */
    override fun doUpdateVisitedHistory(view: WebView?, url: String?, isReload: Boolean) {
        super.doUpdateVisitedHistory(view, url, isReload)
    }

    /**
     * Notifies the host app that an input event is not invoked by WebView.
     * Determines whether the host app handles Input Events not handled by WebView.
     * Except for system buttons, WebView always consumes input events or shouldOverrideKeyEvent returns true.
     * This method is called asynchronously by event distribution. Note: If the event is a MotionEvent,
     * the event's lifecycle only exists during the method call.
     * If WebViewClient wants to use this Event, it needs to clone the Event object.
     */
    override fun onUnhandledKeyEvent(view: WebView?, event: KeyEvent?) {
        super.onUnhandledKeyEvent(view, event)
    }

    /**
     * Notifies the host app that an automatic login request was executed.
     */
    override fun onReceivedLoginRequest(view: WebView?,realm: String?,account: String?,args: String?) {
        super.onReceivedLoginRequest(view, realm, account, args)
    }

    /**
     * Notifies the host app: WebView received an HTTP authentication request.
     * The host app can use HttpAuthHandler to set the WebView response for the request. Default: cancel request.
     */
    override fun onReceivedHttpAuthRequest(view: WebView?,handler: HttpAuthHandler?,host: String?,realm: String?) {
        super.onReceivedHttpAuthRequest(view, handler, host, realm)
    }

    /**
     * Notifies the host app to handle the SSL client authentication request.
     * If a key needs to be provided, the host app is responsible for displaying the UI.
     * Three response methods: proceed(), cancel() and ignore().
     * If proceed() and cancel() are called, WebView will remember the response.
     * For the same host and port addresses, onReceivedClientCertRequest will not be called again.
     * If ignore() is called, WebView will not remember the response. This method executes on the UI thread.
     * During the callback, the connection is suspended. Default: cancel().
     */
    override fun onReceivedClientCertRequest(view: WebView?, request: ClientCertRequest?) {
        super.onReceivedClientCertRequest(view, request)
    }
}
```
