---
title: 学习笔记－疯狂Java讲义[4]
toc: true
tags:
  - Java
  - Note
categories:
  - 学习笔记 - 疯狂Java讲义
author: PhoenixXc
---



## 第四章　流程控制与数组

### 1.流程控制

#### switch

&emsp;&emsp;switch 语句后面控制表达式的数据类型<u>只能是</u>`byte`、`short`、`char`、`int`、枚举类型和`java.lang.String`类型。`switch`中其他类型会隐式向上转换为`int`，`long`比`int`范围大，转换可能会损失精度，Java通过`string`的`hash()`值把`string`也转换为`int`。

#### 控制循环结构

&emsp;&emsp;Java没有提供`goto`语句，与C类似，也有`continue`、`break`语句。不同的是，`break`和`continue`后可以紧跟标签来使得可以结束或直接跳到外层循环。

&emsp;&emsp;标签是一个紧跟英文冒号的标识符，Java中的标签<u>只有放在循环语句前才有用</u>。

<center><u>代码清单</u></center>

```java
public class HelloWorld{
     public static void main(String []args){
        outer:
        for (int i = 0; i < 5; i++) {
           for (int j = 0; j < 3; j++) {
              System.out.println("Hello ~");
              if (j == 1) {
                 break outer;
              }
           }
        }
     }
}
```



### 2.数组

&emsp;&emsp;数组也是一种数据类型，属于引用类型。数组用来存储一组具有相同数据类型的元素。Java中类与类可以继承，会造成一个数组中有多个类型的假象，但归根到底元素都属于同一种类型。<u>数组一旦初始化完成后，其长度将固定不变。</u>

&emsp;&emsp;数组是一种引用类型，定义一个数组后相当于只定义了一个指针，这个指针还没指向任何有效内存。所以<u>定义数组的时候不能指定数组的长度。</u>

---

1. 数组的定义

   ```java
   type[] arrayName; 
   type arrayName[];
   ```

   &emsp;&emsp;为了更好的可读性，推荐使用第一种定义方式。

2. 数组的初始化

   &emsp;&emsp;初始化，即为数组的数组元素分配内存空间，并给每个数组元素赋值，数组的<u>定义和初始化可以同时</u>完成。

   初始化的两种方式：

   - 静态初始化

     &emsp;&emsp;初始化时显式指定数组元素的初值，长度由系统决定（指定长度会报错）。

     语法格式：

     ```java
     arrayName = new type[] {element1, element2, ..., elementn};
     // 数组的定义和静态初始化同时完成可以省略 new type[]
     // type[] arrayName = {element1, element2, ...};
     ```

     初始化时type类型以及元素的类型要与定义数组时指定的类型一致（相同或为定义时指定类型的子类），元素以逗号分隔开。

   - 动态初始化

     &emsp;&emsp;初始化时只指定数组的长度，系统为数组元素分配初值。

     语法格式：

     ```java
     arrayName = new type[length];
     ```

     type类型要求同上。length可以是已初始化的变量。

     系统默认分配的初值为：

     + 整数类型：0
     + 浮点类型：0.0
     + 字符类型：'\u0000'
     + 布尔类型：false
     + 引用类型：null

3. 数组的使用

   - 数组可以通过索引的方式去除数组元素或对其进行赋值

     如果索引超出数组大小范围在运行时会抛出异常：`java.lang.ArrayIndexOutOfBoundsException: N`，N的值即为非法的数组索引。

   - 数组的长度可以通过其`length`属性获得

   - Java5之后，Java提供了更简单的循环：`foreach`循环，可以自动遍历数组和集合的每个元素。

     ```java
     for(type variableName : array | collection) {
         // variableName 自动访问每个元素
     }
     ```

     `foreach`循环中的循环变量variableName是一个临时变量，改变他并不能改变数或集合中元素的值

4. 数组的实质

   &emsp;&emsp;数组引用变量只是一个引用，数组元素和数组变量在内存里分开存储。而引用变量是访问真实对象的根本方式，只能通过数组的引用变量才能访问数组对象本身。

   &emsp;&emsp;实际的数组对象存储在堆中，如果引用数组对象的数组引用变量是局部变量，它被存储在栈中，如果堆中的对象不在有任何变量指向它，会被JVM的垃圾回收机制回收。

   &emsp;&emsp;通过对数组的重新赋值，产生数组长度可变的错觉，但实际堆中实际的数组对象并不可变。

   <center><u>程序清单</u></center>

   ```java
   public class ArrayInRam {
       public static void main(String[] args) {
           int[] a = {5, 7, 20};
           int[] b = new int[4];
           System.out.println("b 数组的长度" + b.length);
           for (int temp : a) {
               System.out.println(temp);
           }
           for (int temp : b) {
               System.out.println(temp);
           }
           b = a;
           System.out.println("b 数组的长度" + b.length);
       }
   }
   ```

5. 多维数组

   &emsp;&emsp;Java支持多维数组，但从本质上来说并没有多维数组。<u>多维数组实质上其元素也是引用变量</u>。

   <center><u>代码清单</u></center>

   ```java
   public class TwoDimensionTest {
      public static void main(String[] args) {
         // 定义一个二维数组
         int[][] a;
         // 初始化数组，数组a有四个元素，每一个元素都是int[]类型
         a = new int[4][];
         // Error!
         // a = new int[][4];
         
         for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
         }
         System.out.println("-----------");
         
         a[0] = new int[2];
         a[0][1] = 6;
         
         for (int i = 0; i < a[0].length; i++) {
            System.out.println(a[0][i]);
         }
         System.out.println("===========");
         
      // 初始化的多种方式
         // One
         // int[][] b = new int[][] {
         //    new int[]{1},
         //    new int[]{1, 2}, 
         //    new int[]{1, 2, 3}
         // };
         // Two
         int[][] b = {
            {1},
            new int[2],
            new int[]{1, 2, 3}
         };
         
         // foreach()
         for (int[] tempArray : b) {
            for (int tempValue : tempArray) {
               System.out.println(tempValue);
            }
         }
         System.out.println("===========");
   
         // Error!      
         // int[][] c = new int[2][] {
         //    1, 2, 3, 4, 5, 6
         // };
         
         int[][] c = new int[2][4];
      }
   }
   ```

6. 使用Arrays类

   &emsp;&emsp;Java中Arrays类中的一些static方法可以直接操作数组，使用这些方法需要导入java.util.Arrays类(`import java.util.Arrays`)，static方法可以直接通过类名调用。

   - int binarySearch(type[] a, type key)

     使用二分法在数组a中查询值为key的元素，返回其索引，查找失败返回负数。要求数组为升序排列。

   - int binarySearch(type[] a, int fromIndex, int toIndex, type key)

     与上一个类似，只是限定查找索引范围为fromIndex到toIndex。

   - type[] copyOf(type[] original, int length)

     将original复制为一个新的数组，新数组长为length，如果length大于原数组的长度，后面元素补充为0、false或null。

   - type[] copyOfRange(type[] original, int from, int to)

     只复制数组的from索引到to索引的元素

   - boolean equals(type[] a, type[] a2)

     判断两个数组是否相等（长度+数组对应元素）

   - void fill(type[] a, type val)

     将数组的所有元素设为val

   - void fill(type[] a, int fromIndex, int toIndex, type val)

     与上一个相同，只是限制了赋值的索引范围

   - void sort(type[] a)

     对数组元素排序（自定义排序方法涉及到重载）

   - void sort(type[] a, int fromIndex, int toIndex)

     作用同上，只限制了排序的范围

   - String toString(type[] a)

     将一个数组转换为字符串

    <center><u>代码清单</u></center>

   ```java
   import java.util.Arrays;
   
   public class TwoDimensionTest {
      public static void main(String[] args) {
         String names[] = new String[]{
            "人生苦短", 
            "来杯Java"
         };
         String namesCopy[] = Arrays.copyOf(names, names.length);
         System.out.println(Arrays.toString(namesCopy));
         names[0] = "HelloWorld";
         System.out.println(Arrays.toString(names));
         System.out.println(Arrays.toString(namesCopy));
      }
   }
   // output------------------------------------------------------
   // [人生苦短, 来杯Java]
   // [HelloWorld, 来杯Java]
   // [人生苦短, 来杯Java]
   ```

   