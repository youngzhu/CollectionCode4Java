# THE ABSTRACT FACTORY PATTERN

抽象工厂模式


工厂模式有个缺点：会用到反射机制（Reflection）。

以Java为例，JVM做了很多优化，但大多基于编译时的（Compile-time），而反射是要在运行时（Run-time）执行的。

同样创建一个对象，方法一要比方法二快近十倍。（未验证过）

方法一

```
SomeObject so = new SomeObect();
```

方法二

```
SomeObject so = Class.forName("SomeObject").newInstance();
```

那怎么办呢？

所以有了抽象工厂方法。

抽象工厂方法就是为某一组类似的对象（例如这里的数据库database）各自创建一个工厂类。

Use abstract factory to create families of related classes.


- - - 


