# 如何下载编译好的 APK - 详细步骤

## 方法1：通过 Actions 页面下载（推荐）

### 步骤1：打开 Actions 页面

1. 访问你的仓库：https://github.com/xwjing1/LSPosedAppInstallTime
2. 点击仓库顶部的 **"Actions"** 标签页
   - 位置：在 "Code"、"Issues"、"Pull requests" 旁边
   - 或者直接访问：https://github.com/xwjing1/LSPosedAppInstallTime/actions

### 步骤2：查看编译状态

在 Actions 页面，你会看到：

- **黄色圆圈 + "Running"** = 正在编译，请等待
- **绿色对勾 + "This workflow run completed successfully"** = 编译成功 ✅
- **红色叉号 + "This workflow run failed"** = 编译失败 ❌

### 步骤3：点击最新的 workflow run

1. 找到最新的（最上面的）workflow run
2. 点击它进入详细页面
3. 会看到编译的详细日志

### 步骤4：下载 APK

1. 在 workflow run 详细页面，**滚动到最底部**
2. 会看到一个 **"Artifacts"** 部分（在页面最下方）
3. 里面有一个 **"app-debug"** 文件
4. **点击 "app-debug"** 就会自动下载 APK 文件

## 方法2：如果 Actions 中没有编译记录

可能的原因：
1. **还没有触发编译** - 需要确保上传了 `.github/workflows/build.yml` 文件
2. **编译配置有问题** - 检查 workflow 文件是否正确

解决方法：
1. 确保上传了完整的项目，包括 `.github` 文件夹
2. 手动触发编译：
   - 进入 Actions 页面
   - 点击左侧的 "Build APK"
   - 点击 "Run workflow" 按钮

## 方法3：直接访问下载链接

如果编译成功，可以直接访问：
```
https://github.com/xwjing1/LSPosedAppInstallTime/actions
```
然后按照上面的步骤下载。

## 常见问题

### Q: 看不到 Artifacts？

A: 
- 编译可能还在进行中，等待完成
- 刷新页面（F5）
- 检查编译是否成功（绿色对勾）

### Q: 编译失败了怎么办？

A:
1. 点击失败的 workflow run
2. 查看错误信息
3. 可能需要上传完整的 `app` 文件夹
4. 确保所有源代码文件都已上传

### Q: 下载的文件是什么格式？

A: 下载的是 ZIP 文件，解压后里面有 `app-debug.apk`

## 快速链接

- **仓库页面**: https://github.com/xwjing1/LSPosedAppInstallTime
- **Actions 页面**: https://github.com/xwjing1/LSPosedAppInstallTime/actions

## 提示

如果 Actions 页面是空的或者没有看到 "Build APK" workflow，说明：
1. 可能没有上传 `.github/workflows/build.yml` 文件
2. 需要重新上传完整的项目
