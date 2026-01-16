package com.example.appinstalltime;

import android.content.pm.PackageInfo;
import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * LSPosed 模块 - 修改悟空浏览器安装时间
 * 目标应用: com.cat.readall (悟空浏览器)
 * 目标时间: 2026-01-01 00:00:00 UTC (时间戳: 1767225600000)
 */
public class MainHook implements IXposedHookLoadPackage {
    
    private static final String TAG = "AppInstallTimeMod";
    
    // 目标应用包名（写死）
    private static final String TARGET_PACKAGE = "com.cat.readall";
    
    // 目标安装时间（写死）- 2026-01-01 00:00:00 UTC
    private static final long TARGET_TIME = 1767225600000L;
    
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        // 只 Hook 系统框架中的 PackageManagerService
        if (!lpparam.packageName.equals("android")) {
            return;
        }
        
        try {
            Log.i(TAG, "==========================================");
            Log.i(TAG, "AppInstallTimeMod 模块已加载");
            Log.i(TAG, "目标应用: " + TARGET_PACKAGE);
            Log.i(TAG, "目标时间: " + TARGET_TIME + " (2026-01-01 00:00:00)");
            Log.i(TAG, "==========================================");
            
            // Hook PackageManagerService
            Class<?> pmsClass = XposedHelpers.findClass(
                "com.android.server.pm.PackageManagerService", 
                lpparam.classLoader
            );
            
            // Hook getPackageInfo 方法（多个重载版本）
            // 版本 1: getPackageInfo(String packageName, int flags, int userId)
            try {
                XposedHelpers.findAndHookMethod(
                    pmsClass,
                    "getPackageInfo",
                    String.class,
                    int.class,
                    int.class,
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            modifyPackageInfo(param);
                        }
                    }
                );
                Log.i(TAG, "✓ Hook getPackageInfo(String, int, int) 成功");
            } catch (Exception e) {
                Log.w(TAG, "✗ Hook getPackageInfo(String, int, int) 失败: " + e.getMessage());
            }
            
            // 版本 2: getPackageInfo(String packageName, int flags)
            try {
                XposedHelpers.findAndHookMethod(
                    pmsClass,
                    "getPackageInfo",
                    String.class,
                    int.class,
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            modifyPackageInfo(param);
                        }
                    }
                );
                Log.i(TAG, "✓ Hook getPackageInfo(String, int) 成功");
            } catch (Exception e) {
                Log.w(TAG, "✗ Hook getPackageInfo(String, int) 失败: " + e.getMessage());
            }
            
            // Hook getPackageInfoAsUser 方法
            try {
                XposedHelpers.findAndHookMethod(
                    pmsClass,
                    "getPackageInfoAsUser",
                    String.class,
                    int.class,
                    int.class,
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            modifyPackageInfo(param);
                        }
                    }
                );
                Log.i(TAG, "✓ Hook getPackageInfoAsUser 成功");
            } catch (Exception e) {
                Log.w(TAG, "✗ Hook getPackageInfoAsUser 失败: " + e.getMessage());
            }
            
            // Hook getPackageInfoAsUser(String packageName, int flags, int userId, int appId)
            try {
                XposedHelpers.findAndHookMethod(
                    pmsClass,
                    "getPackageInfoAsUser",
                    String.class,
                    int.class,
                    int.class,
                    int.class,
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            modifyPackageInfo(param);
                        }
                    }
                );
                Log.i(TAG, "✓ Hook getPackageInfoAsUser(String, int, int, int) 成功");
            } catch (Exception e) {
                Log.w(TAG, "✗ Hook getPackageInfoAsUser(String, int, int, int) 失败: " + e.getMessage());
            }
            
            Log.i(TAG, "Hook 初始化完成");
            
        } catch (Exception e) {
            Log.e(TAG, "Hook 初始化失败", e);
        }
    }
    
    /**
     * 修改 PackageInfo 的安装时间
     */
    private void modifyPackageInfo(XC_MethodHook.MethodHookParam param) {
        try {
            PackageInfo info = (PackageInfo) param.getResult();
            if (info == null || info.packageName == null) {
                return;
            }
            
            String pkgName = info.packageName;
            
            // 只修改目标应用
            if (TARGET_PACKAGE.equals(pkgName)) {
                long originalTime = info.firstInstallTime;
                info.firstInstallTime = TARGET_TIME;
                
                // 可选：同时修改最后更新时间
                // info.lastUpdateTime = TARGET_TIME;
                
                param.setResult(info);
                
                Log.i(TAG, "✓ 修改安装时间: " + pkgName);
                Log.i(TAG, "  原始时间: " + originalTime + " (" + new java.util.Date(originalTime) + ")");
                Log.i(TAG, "  新时间: " + TARGET_TIME + " (" + new java.util.Date(TARGET_TIME) + ")");
            }
        } catch (Exception e) {
            Log.e(TAG, "修改 PackageInfo 失败", e);
        }
    }
}
