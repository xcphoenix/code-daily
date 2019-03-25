**1、为什么 `this()` 、`super()` 要放在构造器的第一行且不能同时出现？**

> 有 `super()` ：
>
> &emsp;&emsp;子类有可能会访问父类对象，所以先要执行父类的构造器。所以 `super()` 如果有，必须在第一行。如果没有，系统在执行子类构造器之前会默认调用父类的构造器。
>
> 有 `this()` :
>
> &emsp;&emsp;为了保证父类对象初始化的唯一性，如果第一行不是 `super()` 也不是 `this()` ，系统会在执行子类构造器之前先调用父类的构造器，当执行到 `this()` 时，会进入到子类的另一个构造器中，而在另一个构造器中，必然也会再调用父类的构造器，所以如果有 `this()`，必须放在第一行。而且不能再出现 `super()`。

**2、加载类的初始化过程**

> - 有继承关系
>
>   父类静态变量/父类静态方法块（以代码中的出现顺序决定） -> 子类静态变量/子类静态方法块 -> 父类成员变量/方法块 -> 父类构造函数 -> 子类成员变量/方法块 -> 子类构造函数
>
> - 无继承关系
>
>   静态变量/静态代码块 -> 成员变量/代码块 -> 构造函数

**３、多态与类初始化实例**

> ```java
> package xuanc;
> 
> class Base {
>     String name = "HelloWorld";
> 
>     public Base() {
>         test();
>     }
> 
>     public void test() {
>         System.out.println("将被子类覆盖的方法");
>     }
> }
> 
> public class Sub extends Base {
>     String name = "test";
> 
>     @Override
>     public void test() {
>         System.out.println("子类重写父类的方法. name = " + name);
>     }
> 
>     public static void main(String[] args) {
>         Sub b = new Sub();
>     }
> }
> ```
>
> 子类重写了父类的 ` test()` 方法，第24行创建 Sub 对象过程中，系统在执行子类的构造函数之前先调用父类的构造器，相当于 `b.super()`，b 的运行时类型是 Base，但现在父类的方法被子类重写，由于多态机制，父类调用 test() 时实际上调用的是子类重写的 test() 方法，在 test() 方法中，使用的 name 实际上是 `this.name`。

