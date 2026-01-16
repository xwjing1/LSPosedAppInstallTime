# 安装 Java 指南

## 问题：未找到 Java

编译 Android 项目需要 Java JDK。

## 解决方案

### 方案1：安装 Android Studio（推荐 ⭐⭐⭐⭐⭐）

**最简单的方法**，Android Studio 会自动安装所有需要的工具：

1. **下载 Android Studio**
   - 访问：https://developer.android.com/studio
   - 点击 "Download Android Studio"
   - 下载约 1GB

2. **安装 Android Studio**
   - 运行安装程序
   - 选择 "Standard" 安装（推荐）
   - 会自动安装：
     - Java JDK
     - Android SDK
     - Gradle
   - 等待安装完成（约 10-20 分钟）

3. **打开项目**
   - 启动 Android Studio
   - File -> Open -> 选择 `LSPosedAppInstallTime` 文件夹
   - 等待 Gradle 同步

4. **编译 APK**
   - Build -> Build APK
   - 完成！

**优点**：
- ✅ 一键安装所有工具
- ✅ 图形界面，操作简单
- ✅ 自动处理依赖
- ✅ 官方工具，稳定可靠

### 方案2：单独安装 Java JDK

如果不想安装 Android Studio，可以单独安装 Java：

1. **下载 JDK**
   - 访问：https://adoptium.net/
   - 选择 JDK 17 或更高版本
   - 选择 Windows x64
   - 下载安装程序

2. **安装 JDK**
   - 运行安装程序
   - 选择安装路径（记住这个路径）
   - 完成安装

3. **设置环境变量**
   - 右键"此电脑" -> 属性
   - 高级系统设置 -> 环境变量
   - 在"系统变量"中：
     - 新建变量名：`JAVA_HOME`
     - 变量值：JDK 安装路径（如：`C:\Program Files\Java\jdk-17`）
   - 编辑"Path"变量，添加：`%JAVA_HOME%\bin`
   - 确定保存

4. **验证安装**
   ```cmd
   java -version
   ```
   应该显示 Java 版本信息

5. **重新编译**
   ```cmd
   cd C:\Users\Administrator\Downloads\LSPosedAppInstallTime
   gradlew.bat assembleDebug
   ```

### 方案3：使用在线编译服务

如果不想在本地安装工具：

1. **GitHub Codespaces**
   - 上传项目到 GitHub
   - 使用 Codespaces 在线编译

2. **Gitpod**
   - 访问：https://gitpod.io/
   - 在线编译

## 推荐方案

**最推荐**：使用 Android Studio
- 时间：约 30 分钟（下载+安装）
- 难度：简单
- 后续：可以轻松编译任何 Android 项目

**最快**：如果有朋友有 Android Studio
- 让他帮忙编译
- 只需要几分钟

## 检查 Java 是否已安装但未配置

如果 Java 已安装但未在 PATH 中：

1. 找到 Java 安装路径
2. 设置 JAVA_HOME 环境变量
3. 添加到 PATH

## 快速检查

运行以下命令检查：

```cmd
where java
java -version
echo %JAVA_HOME%
```

如果都没有输出，说明 Java 未安装或未配置。
