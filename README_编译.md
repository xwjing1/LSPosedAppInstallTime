# 快速编译指南

## 最简单的方法：使用 Android Studio

1. **下载安装 Android Studio**
   - https://developer.android.com/studio
   - 选择 Standard 安装

2. **打开项目**
   - File -> Open -> 选择 `LSPosedAppInstallTime` 文件夹

3. **编译 APK**
   - Build -> Build APK
   - 等待完成

4. **找到 APK**
   - `app/build/outputs/apk/debug/app-debug.apk`

## 使用命令行（如果已安装工具）

```bash
cd LSPosedAppInstallTime
./gradlew assembleDebug
```

Windows:
```cmd
cd LSPosedAppInstallTime
gradlew.bat assembleDebug
```

## 安装步骤

1. 安装 LSPosed 框架（Magisk Manager）
2. 安装编译好的 APK
3. 在 LSPosed Manager 中启用模块
4. 选择作用域为"系统框架"
5. 重启设备

## 模块信息

- **目标应用**: com.cat.readall (悟空浏览器)
- **目标时间**: 2026-01-01 00:00:00
- **时间戳**: 1767225600000

## 验证

```bash
adb shell "dumpsys package com.cat.readall | grep -i firstinstall"
```

应该显示：`firstInstallTime=2026-01-01 00:00:00`
