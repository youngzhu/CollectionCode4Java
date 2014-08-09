测试注解处理器
===

编译命令如下：

	javac -processor org.young.jvm.ch10.NameCheckProcessor org/young/jvm/ch10/BADLY_NAMED_CODE.java


执行时注意：
---

0. 确保 **当前路径(.)** 在 CLASSPATH 里

	最好在设置 CLASSPATH 时就加上。    
	命令：
	
		export CLASSPATH=${CLASSPATH}:.
		
	如果想临时用一下，直接在终端执行上面的命令也可以。   
	有效范围：当前的终端
	
0. 在src目录下执行，即 org 的上一层目录
0. **NameCheckProcessor** 的class文件需要和 **BADLY_NAMED_CODE.java** 在同一目录
