@echo off
chcp 65001 >nul
echo ========================================
echo LSPosed 模块编译脚本
echo ========================================
echo.

cd /d %~dp0

echo 检查 Java 环境...
java -version >nul 2>&1
if %ERRORLEVEL% neq 0 (
    echo [错误] 未找到 Java，请先安装 JDK
    echo.
    echo 下载地址: https://adoptium.net/
    echo 或使用 Android Studio（会自动安装 JDK）
    echo.
    pause
    exit /b 1
)

echo [成功] Java 已安装
echo.

echo 开始编译...
echo.

if exist gradlew.bat (
    call gradlew.bat assembleDebug
) else (
    echo [错误] 未找到 gradlew.bat
    echo 请使用 Android Studio 打开项目进行编译
    echo.
    pause
    exit /b 1
)

if %ERRORLEVEL% equ 0 (
    echo.
    echo ========================================
    echo 编译成功！
    echo ========================================
    echo.
    echo APK 位置: app\build\outputs\apk\debug\app-debug.apk
    echo.
    if exist "app\build\outputs\apk\debug\app-debug.apk" (
        echo 文件大小: 
        dir "app\build\outputs\apk\debug\app-debug.apk" | find "app-debug.apk"
        echo.
        echo 可以直接安装此 APK 到 Android 设备
    )
) else (
    echo.
    echo ========================================
    echo 编译失败
    echo ========================================
    echo.
    echo 请检查错误信息，或使用 Android Studio 编译
    echo.
)

pause
