-keep class com.example.daw.** { *; }
-keepclassmembers class * {
    public static <fields>;
    public *;
}
-dontnote android.**
-dontwarn android.**