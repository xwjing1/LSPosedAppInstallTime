@echo off
chcp 65001 >nul
echo ========================================
echo 上传代码到 GitHub
echo ========================================
echo.

cd /d %~dp0

echo 检查 Git 是否安装...
git --version >nul 2>&1
if %ERRORLEVEL% neq 0 (
    echo [错误] 未找到 Git
    echo.
    echo 请使用方法1：在 GitHub 网页上直接上传文件
    echo 或下载安装 Git: https://git-scm.com/
    echo.
    pause
    exit /b 1
)

echo [成功] Git 已安装
echo.

echo 初始化 Git 仓库...
git init

echo 添加所有文件...
git add .

echo 提交更改...
git commit -m "Initial commit"

echo 设置分支...
git branch -M main

echo 添加远程仓库...
git remote add origin https://github.com/xwjing1/LSPosedAppInstallTime.git

echo 推送代码...
git push -u origin main

if %ERRORLEVEL% equ 0 (
    echo.
    echo ========================================
    echo 上传成功！
    echo ========================================
    echo.
    echo 现在去 GitHub 查看 Actions：
    echo https://github.com/xwjing1/LSPosedAppInstallTime/actions
    echo.
    echo 等待编译完成后，在 Artifacts 中下载 APK
    echo.
) else (
    echo.
    echo ========================================
    echo 上传失败
    echo ========================================
    echo.
    echo 可能的原因：
    echo 1. 需要登录 GitHub
    echo 2. 需要设置 Git 凭据
    echo.
    echo 建议使用方法1：在 GitHub 网页上直接上传文件
    echo.
)

pause
