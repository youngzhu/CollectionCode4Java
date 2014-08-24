#/bin/bash

# 语言选项，这个必须设置，否则编译后会出现一个 HashTable 的 NPE 错误
export LANG=C

# Bootstrap JDK 的安装路径，即已安装的，比要编译的JDK版本高的JDK的安装路径。必须设置
export ALT_BOOTDIR=/usr/lib/jvm/java-6-openjdk-i386

# 允许自动下载依赖
export ALLOW_DOWNLOADS=true

# 并行编译的线程数，和CPU内核数量一致
#export HOTSPOT_BUILD_JOBS=2
#export ALT_PARALLEL_COMPILE_JOBS=2

# 比较本次build出来的映像与之前版本的差异。
#export SKIP_COMPARE_IMAGES=true

# 使用预编译头文件，不加这个编译会慢一些
#export USE_PRECOMPILED_HEADER=true

# 要编译的内容
#export BUILD_CORBA=true
#export BUILD_HOTSPOT=true
#export BUILD_JAXP=false
#export BUILD_JAXWS=false
#export BUILD_JDK=true
#export BUILD_LANGTOOLS=true

# 把它设置为 false 可以避开 javaws 和浏览器 Java 插件之类的编译
#BUILD_DEPLOY=false

# 把它设置为 false 就不会编译出安装包。安装包里有些奇怪的依赖
#BUILD_INSTALL=false

# 编译结果存放的路径
export ALT_OUTPUTDIR=/home/young/Dev/Java/jdk/build

# 这两个环境变量必须去掉，不然会后诡异的事情发生
unset JAVA_HOME
unset CLASSPATH

#export -n JAVA_HOME

# 禁止编译器把一些警告当错误
# 不加会有这样的错误：cc1plus: error: the "stabs" debug format cannot be used with pre-compiled headers [-Werror=deprecated]
#cc1plus: all warnings being treated as errors
# 必须在 make 后面， export 无效
#export WARNINGS_ARE_ERRORS= 


make WARNINGS_ARE_ERRORS=   2>&1 | tee $ALT_OUTPUTDIR/build.log
