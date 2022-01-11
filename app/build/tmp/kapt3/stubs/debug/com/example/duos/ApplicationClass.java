package com.example.duos;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/example/duos/ApplicationClass;", "Landroid/app/Application;", "()V", "onCreate", "", "Companion", "app_debug"})
public final class ApplicationClass extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.duos.ApplicationClass.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String X_ACCESS_TOKEN = "X-ACCESS-TOKEN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "TEMPLATE-APP";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String APP_DATABASE = "TEMPLATE-APP-DB";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DEV_URL = "http://13.125.121.202/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PROD_URL = "https://api.template.com/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL = "http://13.125.121.202/";
    public static android.content.SharedPreferences mSharedPreferences;
    public static retrofit2.Retrofit retrofit;
    
    public ApplicationClass() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/example/duos/ApplicationClass$Companion;", "", "()V", "APP_DATABASE", "", "BASE_URL", "DEV_URL", "PROD_URL", "TAG", "X_ACCESS_TOKEN", "mSharedPreferences", "Landroid/content/SharedPreferences;", "getMSharedPreferences", "()Landroid/content/SharedPreferences;", "setMSharedPreferences", "(Landroid/content/SharedPreferences;)V", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "setRetrofit", "(Lretrofit2/Retrofit;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.SharedPreferences getMSharedPreferences() {
            return null;
        }
        
        public final void setMSharedPreferences(@org.jetbrains.annotations.NotNull()
        android.content.SharedPreferences p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final retrofit2.Retrofit getRetrofit() {
            return null;
        }
        
        public final void setRetrofit(@org.jetbrains.annotations.NotNull()
        retrofit2.Retrofit p0) {
        }
    }
}