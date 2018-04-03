# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-keep class com.android.volley.**
-keep class org.acra.**
-keep class com.android.logcat.log.Logcat

-dontnote org.apache.http.**
-dontnote android.net.http.**
-dontnote org.acra.**

-keepclassmembers class com.android.logcat.log.Logcat { public *; }
-keepclassmembers class com.android.volley.**
-keepclassmembers class org.acra.**

-renamesourcefileattribute SourceFile