# LSPosed 应用安装时间修改模块

## 功能说明

修改悟空浏览器 (com.cat.readall) 的首次安装时间为 **2026-01-01 00:00:00**。

## 模块信息

- **目标应用**: com.cat.readall (悟空浏览器)
- **目标时间**: 2026-01-01 00:00:00 UTC
- **时间戳**: 1767225600000

## 编译方法

### 方法1：GitHub Actions（推荐，无需安装工具）

1. 上传项目到 GitHub
2. GitHub Actions 会自动编译
3. 在 Actions 页面下载 APK

### 方法2：Android Studio

1. 安装 Android Studio
2. 打开项目
3. Build -> Build APK

### 方法3：命令行

```bash
./gradlew assembleDebug
```

## 安装步骤

1. 安装 LSPosed 框架（Magisk Manager）
2. 安装编译好的 APK
3. 在 LSPosed Manager 中：
   - 启用模块
   - 选择作用域为"系统框架" (android)
4. 重启设备

## 验证

```bash
adb shell "dumpsys package com.cat.readall | grep -i firstinstall"
```

应该显示：`firstInstallTime=2026-01-01 00:00:00`

## 查看日志

```bash
adb logcat | grep AppInstallTimeMod
```

## 技术实现

- Hook `PackageManagerService.getPackageInfo()` 方法
- 修改返回的 `PackageInfo.firstInstallTime` 字段
- 只针对目标应用生效

## 许可证

MIT License
