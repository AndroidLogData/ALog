# Android Logdata Android Library
| distribute | Current Status |
|--------|--------|
| JitPack | [![](https://jitpack.io/v/AndroidLogData/Logdata-Android.svg)](https://jitpack.io/#AndroidLogData/Logdata-Android) |

안드로이드 로그 데이터 관리를 위한 안드로이드 라이브러리

## Installation
* build.gradle에 추가
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

* dependencies 추가
```gradle
dependencies {
    compile 'com.github.AndroidLogData:Logdata-Android:0.2.0'
}
```

## 사용법
* AndroidManifest.xml에 ```meta-data```추가
```xml
<meta-data android:name="com.logcat.apiKey"
	android:value="<InsertYourKey>"/>
```
* Application 진입점에 코드 추가
```java
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
        * setting
        * Logcat을 사용하기 전에 해야할 설정
        *
        * @param Android Context
        * @param Logcat에서 로그를 보기위한 설정
        * @param 서버로 로그 데이터를 보내기 위한 설정
        */
        Logcat.logSetting(getApplicationContext(), true, true);
        // 서버로 메모리 데이터도 같이 전송
        Logcat.setDebug(true);
    }
}
```

## JSON Structure
### Log Data
```json
{
	"packageName" : "com.android.logdata.myApplication",
	"message" : "MainActivity onCreate",
	"tag" : "[MainActivity::onCreate]",
	"time" : 846516546863,
	"level" : "e",
	"memoryInfo" : {
		"memoryPercentage" : 31.041206627151695,
		"dalvikPss" : 2660,
		"lowMemory" : false,
		"nativePss" : 1889,
		"totalPss" : 17418,
		"availMemory" : 1093652480,
		"threshold" : 150994944,
		"totalMemory" : 1585950720,
		"otherPss" : 12869
	}
}
```
* debug 모드에 따라 memoryInfo가 안들어갈수있다.

### Crash Data
```json
{
    "time" : 1616620993635,
    "androidVersion" : "5.0",
    "appVersionCode" : "1",
    "appVersionName" : "1.0",
    "availableMemorySize" : 1309798400,
    "brand" : "samsung",
    "logcat" : "01-22 20:19:51.195 D/[MainActivity::onCreate](21800): debug\n01-22 20:19:51.195 I/System.out(21800): (HTTPLog)-Static: isSBSettingEnabled false\n01-22 20:19:51.195 W/[MainActivity::onCreate](21800): warning\n01-22 20:19:51.195 I/System.out(21800): (HTTPLog)-Static: isShipBuild true\n01-22 20:19:51.195 I/System.out(21800): (HTTPLog)-Thread-140221-34964680: SmartBonding Enabling is false, SHIP_BUILD is true, log to file is false, DBG is false\n01-22 20:19:51.195 I/System.out(21800): (HTTPLog)-Static: isSBSettingEnabled false\n01-22 20:19:51.195 V/[MainActivity::onCreate](21800): verb\n01-22 20:19:51.195 D/Activity(21800): performCreate Call secproduct feature valuefalse\n01-22 20:19:51.195 D/Activity(21800): performCreate Call debug elastic valuetrue\n01-22 20:19:51.195 I/System.out(21800): KnoxVpnUidStorageknoxVpnSupported API value returned is false\n01-22 20:19:51.195 I/qtaguid (21800): Tagging socket 55 with tag 355f55a00000000{55965018,0} uid -1, pid: 21800, getuid(): 10522\n01-22 20:19:51.215 D/OpenGLRenderer(21800): Render dirty regions requested: true\n01-22 20:19:51.285 I/Adreno-EGL(21800): <qeglDrvAPI_eglInitialize:410>: EGL 1.4 QUALCOMM build: AU_LINUX_ANDROID_LA.BF.1.1_RB1.05.00.00.002.025_msm8974_LA.BF.1.1_RB1__release_AU ()\n01-22 20:19:51.285 I/Adreno-EGL(21800): OpenGL ES Shader Compiler Version: E031.25.01.03\n01-22 20:19:51.285 I/Adreno-EGL(21800): Build Date: 11/19/14 Wed\n01-22 20:19:51.285 I/Adreno-EGL(21800): Local Branch: mybranch5813579\n01-22 20:19:51.285 I/Adreno-EGL(21800): Remote Branch: quic/LA.BF.1.1_rb1.11\n01-22 20:19:51.285 I/Adreno-EGL(21800): Local Patches: NONE\n01-22 20:19:51.285 I/Adreno-EGL(21800): Reconstruct Branch: AU_LINUX_ANDROID_LA.BF.1.1_RB1.05.00.00.002.025 + 30e7589 +  NOTHING\n01-22 20:19:51.285 I/OpenGLRenderer(21800): Initialized EGL, version 1.4\n01-22 20:19:51.305 I/OpenGLRenderer(21800): HWUI protection enabled for context ,  &this =0xae994218 ,&mEglDisplay = 1 , &mEglConfig = 8 \n01-22 20:19:51.305 D/OpenGLRenderer(21800): Enabling debug mode 0\n01-22 20:19:51.345 I/qtaguid (21800): Untagging socket 55\n01-22 20:19:51.375 W/art     (21800): Before Android 4.1, method int android.support.v7.widget.ListViewCompat.lookForSelectablePosition(int, boolean) would have incorrectly overridden the package-private method in android.widget.ListView\n01-22 20:19:51.425 I/Response(21800): success\n01-22 20:19:51.435 I/System.out(21800): (HTTPLog)-Static: isSBSettingEnabled false\n01-22 20:19:51.435 I/qtaguid (21800): Tagging socket 55 with tag 355f55a00000000{55965018,0} uid -1, pid: 21800, getuid(): 10522\n01-22 20:19:51.445 I/System.out(21800): (HTTPLog)-Static: isSBSettingEnabled false\n01-22 20:19:51.445 I/System.out(21800): KnoxVpnUidStorageknoxVpnSupported API value returned is false\n01-22 20:19:51.445 I/Timeline(21800): Timeline: Activity_idle id: android.os.BinderProxy@188dd2e3 time:1082145136\n01-22 20:19:51.445 I/System.out(21800): (HTTPLog)-Static: isSBSettingEnabled false\n01-22 20:19:51.445 I/qtaguid (21800): Tagging socket 70 with tag 355f55a00000000{55965018,0} uid -1, pid: 21800, getuid(): 10522\n01-22 20:19:51.445 I/System.out(21800): KnoxVpnUidStorageknoxVpnSupported API value returned is false\n01-22 20:19:51.445 I/qtaguid (21800): Tagging socket 71 with tag 355f55a00000000{55965018,0} uid -1, pid: 21800, getuid(): 10522\n01-22 20:19:51.455 I/System.out(21800): (HTTPLog)-Static: isSBSettingEnabled false\n01-22 20:19:51.455 I/System.out(21800): KnoxVpnUidStorageknoxVpnSupported API value returned is false\n01-22 20:19:51.455 I/qtaguid (21800): Tagging socket 75 with tag 355f55a00000000{55965018,0} uid -1, pid: 21800, getuid(): 10522\n01-22 20:19:51.455 I/qtaguid (21800): Untagging socket 55\n01-22 20:19:51.465 I/qtaguid (21800): Untagging socket 70\n01-22 20:19:51.465 I/qtaguid (21800): Untagging socket 71\n01-22 20:19:51.465 I/qtaguid (21800): Untagging socket 75\n01-22 20:19:51.475 I/Response(21800): success\n01-22 20:19:51.475 I/System.out(21800): (HTTPLog)-Static: isSBSettingEnabled false\n01-22 20:19:51.475 I/qtaguid (21800): Tagging socket 55 with tag 355f55a00000000{55965018,0} uid -1, pid: 21800, getuid(): 10522\n01-22 20:19:51.475 I/Response(21800): success\n01-22 20:19:51.475 I/Response(21800): success\n01-22 20:19:51.475 I/Response(21800): success\n01-22 20:19:51.475 I/System.out(21800): (HTTPLog)-Static: isSBSettingEnabled false\n01-22 20:19:51.475 I/qtaguid (21800): Tagging socket 70 with tag 355f55a00000000{55965018,0} uid -1, pid: 21800, getuid(): 10522\n01-22 20:19:51.475 I/System.out(21800): (HTTPLog)-Static: isSBSettingEnabled false\n01-22 20:19:51.475 I/System.out(21800): (HTTPLog)-Static: isSBSettingEnabled false\n01-22 20:19:51.475 I/qtaguid (21800): Tagging socket 71 with tag 355f55a00000000{55965018,0} uid -1, pid: 21800, getuid(): 10522\n01-22 20:19:51.475 I/qtaguid (21800): Tagging socket 75 with tag 355f55a00000000{55965018,0} uid -1, pid: 21800, getuid(): 10522\n01-22 20:19:51.485 I/qtaguid (21800): Untagging socket 55\n01-22 20:19:51.495 I/Response(21800): success\n01-22 20:19:51.495 I/System.out(21800): (HTTPLog)-Static: isSBSettingEnabled false\n01-22 20:19:51.495 I/qtaguid (21800): Tagging socket 55 with tag 355f55a00000000{55965018,0} uid -1, pid: 21800, getuid(): 10522\n01-22 20:19:51.495 I/qtaguid (21800): Untagging socket 75\n01-22 20:19:51.495 I/Response(21800): success\n01-22 20:19:51.495 I/System.out(21800): (HTTPLog)-Static: isSBSettingEnabled false\n01-22 20:19:51.495 I/qtaguid (21800): Untagging socket 71\n01-22 20:19:51.495 I/qtaguid (21800): Tagging socket 75 with tag 355f55a00000000{55965018,0} uid -1, pid: 21800, getuid(): 10522\n01-22 20:19:51.495 I/qtaguid (21800): Untagging socket 70\n01-22 20:19:51.495 I/Response(21800): success\n01-22 20:19:51.495 I/System.out(21800): (HTTPLog)-Static: isSBSettingEnabled false\n01-22 20:19:51.495 I/qtaguid (21800): Tagging socket 71 with tag 355f55a00000000{55965018,0} uid -1, pid: 21800, getuid(): 10522\n01-22 20:19:51.505 I/Response(21800): success\n01-22 20:19:51.505 I/System.out(21800): (HTTPLog)-Static: isSBSettingEnabled false\n01-22 20:19:51.505 I/qtaguid (21800): Tagging socket 70 with tag 355f55a00000000{55965018,0} uid -1, pid: 21800, getuid(): 10522\n01-22 20:19:51.505 I/qtaguid (21800): Untagging socket 75\n01-22 20:19:51.505 I/qtaguid (21800): Untagging socket 55\n01-22 20:19:51.515 I/Response(21800): success\n01-22 20:19:51.515 I/System.out(21800): (HTTPLog)-Static: isSBSettingEnabled false\n01-22 20:19:51.515 I/qtaguid (21800): Tagging socket 55 with tag 355f55a00000000{55965018,0} uid -1, pid: 21800, getuid(): 10522\n01-22 20:19:51.515 I/Response(21800): success\n01-22 20:19:51.515 I/System.out(21800): (HTTPLog)-Static: isSBSettingEnabled false\n01-22 20:19:51.515 I/qtaguid (21800): Tagging socket 75 with tag 355f55a00000000{55965018,0} uid -1, pid: 21800, getuid(): 10522\n01-22 20:19:51.515 I/qtaguid (21800): Untagging socket 71\n01-22 20:19:51.515 I/qtaguid (21800): Untagging socket 70\n01-22 20:19:51.515 I/Response(21800): success\n01-22 20:19:51.515 I/Response(21800): success\n01-22 20:19:51.525 I/qtaguid (21800): Untagging socket 75\n01-22 20:19:51.525 I/Response(21800): success\n01-22 20:19:51.535 I/qtaguid (21800): Untagging socket 55\n01-22 20:19:51.535 I/Response(21800): success\n01-22 20:19:53.005 D/ViewRootImpl(21800): ViewPostImeInputStage ACTION_DOWN\n01-22 20:19:53.175 D/AndroidRuntime(21800): Shutting down VM\n01-22 20:19:53.175 E/ACRA    (21800): ACRA caught a NullPointerException for com.android.logdata.logdata_android\n01-22 20:19:53.175 E/ACRA    (21800): java.lang.NullPointerException\n01-22 20:19:53.175 E/ACRA    (21800): \tat com.android.logdata.logdata_android.MainActivity$1.onClick(MainActivity.java:38)\n01-22 20:19:53.175 E/ACRA    (21800): \tat android.view.View.performClick(View.java:5194)\n01-22 20:19:53.175 E/ACRA    (21800): \tat android.view.View$PerformClick.run(View.java:20903)\n01-22 20:19:53.175 E/ACRA    (21800): \tat android.os.Handler.handleCallback(Handler.java:739)\n01-22 20:19:53.175 E/ACRA    (21800): \tat android.os.Handler.dispatchMessage(Handler.java:95)\n01-22 20:19:53.175 E/ACRA    (21800): \tat android.os.Looper.loop(Looper.java:145)\n01-22 20:19:53.175 E/ACRA    (21800): \tat android.app.ActivityThread.main(ActivityThread.java:5942)\n01-22 20:19:53.175 E/ACRA    (21800): \tat java.lang.reflect.Method.invoke(Native Method)\n01-22 20:19:53.175 E/ACRA    (21800): \tat java.lang.reflect.Method.invoke(Method.java:372)\n01-22 20:19:53.175 E/ACRA    (21800): \tat com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1399)\n01-22 20:19:53.175 E/ACRA    (21800): \tat com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1194)",
    "display" : {
            "0" : {
                    "currentSizeRange" : {
                            "smallest" : [
                                    1080,
                                    1005
                            ],
                            "largest" : [
                                    1920,
                                    1845
                            ]
                    },
                    "flags" : "FLAG_SUPPORTS_PROTECTED_BUFFERS+FLAG_SECURE",
                    "metrics" : {
                            "density" : 3,
                            "densityDpi" : 480,
                            "scaledDensity" : "x3.0",
                            "widthPixels" : 1080,
                            "heightPixels" : 1920,
                            "xdpi" : 386.3659973144531,
                            "ydpi" : 387.0469970703125
                    },
                    "realMetrics" : {
                            "density" : 3,
                            "densityDpi" : 480,
                            "scaledDensity" : "x3.0",
                            "widthPixels" : 1080,
                            "heightPixels" : 1920,
                            "xdpi" : 386.3659973144531,
                            "ydpi" : 387.0469970703125
                    },
                    "name" : "기본으로 제공되는 화면",
                    "realSize" : [
                            1080,
                            1920
                    ],
                    "rectSize" : [
                            0,
                            0,
                            1080,
                            1920
                    ],
                    "size" : [
                            1080,
                            1920
                    ],
                    "rotation" : "ROTATION_0",
                    "isValid" : true,
                    "orientation" : 0,
                    "refreshRate" : 60,
                    "height" : 1920,
                    "width" : 1080,
                    "pixelFormat" : 1
            }
    },
    "environment" : {
            "getAndroidSecureContainerDirectory" : "/mnt/asec",
            "getDataDirectory" : "/data",
            "getDownloadCacheDirectory" : "/cache",
            "getEmulatedStorageObbSource" : "/mnt/shell/emulated/obb",
            "getExternalStorageDirectory" : "/storage/emulated/0",
            "getExternalStorageState" : "mounted",
            "getLegacyExternalStorageDirectory" : "/storage/emulated/legacy",
            "getLegacyExternalStorageObbDirectory" : "/storage/emulated/legacy/Android/obb",
            "getMediaBaseStorageDirectory" : "/secdata",
            "getMediaStorageDirectory" : "/data/media/0",
            "getOemDirectory" : "/oem",
            "getRootDirectory" : "/system",
            "getSecureDataDirectory" : "/data",
            "getSystemSecureDirectory" : "/data/system",
            "getVendorDirectory" : "/vendor",
            "isEncryptedFilesystemEnabled" : false,
            "isExternalStorageEmulated" : true,
            "isExternalStorageRemovable" : false
    },
    "deviceFeatures" : {
            "android-hardware-wifi-direct" : true,
            "android-hardware-touchscreen-multitouch" : true,
            "com-sec-feature-cover-flip" : true,
            "com-sec-android-smartface-smart_pause" : true,
            "com-sec-feature-multiwindow-recentui" : true,
            "android-hardware-sensor-stepcounter" : true,
            "android-hardware-sensor-proximity" : true,
            "android-hardware-telephony" : true,
            "com-sec-feature-hovering_ui" : true,
            "android-hardware-bluetooth_le" : true,
            "com-sec-android-mdm" : true,
            "com-sec-feature-motionrecognition_service" : true,
            "android-hardware-usb-host" : true,
            "com-sec-android-secimaging" : true,
            "android-hardware-sensor-stepdetector" : true,
            "com-sec-feature-wfd_support" : true,
            "android-software-voice_recognizers" : true,
            "com-sec-feature-multiwindow-phone" : true,
            "android-hardware-location-gps" : true,
            "com-sec-android-smartface-smart_stay" : true,
            "com-sec-feature-multiwindow-multiwindowlaunch" : true,
            "android-hardware-sensor-gyroscope" : true,
            "com-sec-feature-barcode_emulator" : true,
            "com-sec-feature-sensorhub" : true,
            "android-software-sip" : true,
            "android-hardware-sensor-ambient_temperature" : true,
            "android-software-input_methods" : true,
            "android-software-connectionservice" : true,
            "android-software-webview" : true,
            "android-software-backup" : true,
            "com-sec-feature-multiwindow-styletransition" : true,
            "com-sec-feature-call_vt_support" : true,
            "android-hardware-nfc-hce" : true,
            "android-hardware-camera-front" : true,
            "android-hardware-screen-portrait" : true,
            "android-hardware-touchscreen" : true,
            "com-sec-feature-cover-sview" : true,
            "android-software-live_wallpaper" : true,
            "com-sec-feature-cover-sviewcover" : true,
            "com-sec-feature-spen_usp" : true,
            "android-hardware-wifi" : true,
            "android-software-print" : true,
            "com-sec-feature-findo" : true,
            "com-sec-feature-multiwindow" : true,
            "com-samsung-android-feature-sdl-2101" : true,
            "android-hardware-sensor-accelerometer" : true,
            "android-software-app_widgets" : true,
            "android-software-device_admin" : true,
            "android-hardware-camera-any" : true,
            "android-software-sip-voip" : true,
            "com-sec-feature-multiwindow-scalewindow" : true,
            "android-hardware-camera" : true,
            "com-sec-feature-multiwindow-multiinstance" : true,
            "android-hardware-usb-accessory" : true,
            "android-hardware-touchscreen-multitouch-distinct" : true,
            "com-sec-feature-multiwindow-freestylelaunch" : true,
            "com-sec-feature-multiwindow-freestyle" : true,
            "com-sec-feature-minimode" : true,
            "com-sec-feature-multiwindow-commonui" : true,
            "android-hardware-consumerir" : true,
            "android-hardware-camera-flash" : true,
            "android-hardware-faketouch" : true,
            "android-hardware-sensor-barometer" : true,
            "android-hardware-sensor-relative_humidity" : true,
            "android-hardware-sensor-light" : true,
            "android-hardware-sensor-compass" : true,
            "android-hardware-location" : true,
            "android-hardware-screen-landscape" : true,
            "com-sec-feature-samsunglinkplatform" : true,
            "android-hardware-location-network" : true,
            "android-hardware-telephony-gsm" : true,
            "android-software-managed_users" : true,
            "android-hardware-bluetooth" : true,
            "android-hardware-audio-output" : true,
            "android-hardware-nfc" : true,
            "com-sec-android-smartface-smart_rotation" : true,
            "android-software-home_screen" : true,
            "com-sec-feature-multiwindow-minimizeanimation" : true,
            "android-hardware-touchscreen-multitouch-jazzhand" : true,
            "android-hardware-microphone" : true,
            "com-sec-feature-multiwindow-minimize" : true,
            "android-hardware-camera-autofocus" : true,
            "glEsVersion" : "3.0"
    },
    "build" : {
            "BOARD" : "MSM8974",
            "BOOTLOADER" : "N900SKSU0GPI1",
            "BRAND" : "samsung",
            "CPU_ABI" : "armeabi-v7a",
            "CPU_ABI2" : "armeabi",
            "DEVICE" : "hlteskt",
            "DISPLAY" : "LRX21V.N900SKSU0GPI1",
            "FINGERPRINT" : "samsung/hlteskt/hlteskt:5.0/LRX21V/N900SKSU0GPI1:user/release-keys",
            "FOTA_INFO" : "1473078735",
            "HARDWARE" : "qcom",
            "HOST" : "SWDD6823",
            "ID" : "LRX21V",
            "MANUFACTURER" : "samsung",
            "MODEL" : "SM-N900S",
            "PRODUCT" : "hlteskt",
            "RADIO" : "unknown",
            "SERIAL" : "b72860c2",
            "SUPPORTED_32_BIT_ABIS" : [
                    "armeabi-v7a",
                    "armeabi"
            ],
            "SUPPORTED_64_BIT_ABIS" : [ ],
            "SUPPORTED_ABIS" : [
                    "armeabi-v7a",
                    "armeabi"
            ],
            "TAGS" : "release-keys",
            "TYPE" : "user",
            "UNKNOWN" : "unknown",
            "USER" : "dpi",
            "TIME" : "1473078810000",
            "IS_DEBUGGABLE" : false,
            "IS_SYSTEM_SECURE" : false,
            "isOSUpgradeKK2LL" : true,
            "VERSION" : {
                    "ACTIVE_CODENAMES" : [ ],
                    "BASE_OS" : "",
                    "CODENAME" : "REL",
                    "INCREMENTAL" : "N900SKSU0GPI1",
                    "RELEASE" : "5.0",
                    "SDK" : "21",
                    "SECURITY_PATCH" : "2016-09-01",
                    "RESOURCES_SDK_INT" : 21,
                    "SDK_INT" : 21,
                    "SDL_INT" : 2101
            }
    }
}
```

## Development Stack
* Language : Java
* Framework : Android

## 사용된 오픈소스
* Http 전송을 위한 Volley
	* https://github.com/google/volley
* Java에서 시간 데이터를 얻기 위한 joda-time
	* https://github.com/JodaOrg/joda-time
* Crash Data 만들기 위한 ACRA
	* https://github.com/ACRA/acra

## License
```
MIT License

Copyright (c) 2018 AndroidLogData

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
