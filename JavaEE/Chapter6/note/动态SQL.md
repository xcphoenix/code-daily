# 动态 SQL

MyBatis 通过使用 xml 的里面的简单元素，便能完成动态 sql 的功能，提供了对 sql 语句的组装的能力。



## 元素概述

| 元素                      | 作用                               | 备注                       |
| ------------------------- | :--------------------------------- | -------------------------- |
| `if`                      | 判断语句                           | 单条件分支判断             |
| `choose(when, otherwise)` | 相当于 Java 中 switch 和 case 语句 | 多条件分支判断             |
| `trim(where, set)`        | 辅助元素，处理特定的 SQL 拼装问题  | 处理 SQL 拼装              |
| `foreach`                 | 循环语句                           | 在 in 语句中列举条件时常用 |



## if 元素

类似 Java 中的 if，常与 test 属性联合使用。

<center><u>代码清单</u></center>

```xml
<select id="findRoles" parameterType="string" resultMap="roleResultMap">
	select role_no, role_name, note from t_role where 1=1
    <if test="roleName != null and roleName != ''">
    	and role_name like concat('%', #{roleName}, '%')
    </if> 
</select>
```



## choose、when、otherwise 元素

动态 SQL 还提供了类似 Java 中 switch ... case ... default 功能的语句：choose, when, otherwise

<center><u>代码清单</u></center>

```xml
<select id="findRoles" paramterType="role" resultMap="roleResultMap">
	select role_no, role_name, note from t_role
    where 1=1
    <choose>
        <when test="roleNo != null and roleNo != ''">
        	AND role_no = #{roleNo}
        </when>
        <when test="roleName != null and roleName != ''">
        	AND role_name like concat('%', #{roleName}, '%')
        </when> 
        <otherwise>
        	AND note is not null
        </otherwise>
    </choose>
</select>
```



## trim、where、set 元素

之前的代码中为了保证代码的正确性，添加了 `where 1=1` ，显得很奇怪。

这种情况可以使用 `where` 元素来处理。

<center><u>代码清单</u></center>

```xml
<select id="findRoles" parameterType="role" resultMap="roleResultMap">
	select role_no, role_name, note from t_role
    <where>
    	<if test="roleName != null and roleName != ''">
        	and role_name like concat('%', #{roleName}, '%')
        </if>
        <if test="note != null and note != ''">
        	and note like concat('%', #{note}, '%')
        </if> 
    </where>
</select>
```

仅当 where 元素里面的条件成立时，才会加入 where 这个 SQL 关键字到组装的 SQL 里面。



> | 属性名          | 属性解释                                                     |
> | :-------------- | :----------------------------------------------------------- |
> | prefix          | 要添加的前缀。比如这里因为没有使用**WHERE**，按照语法格式条件必须要有**WHERE**。此时就可以使用prefix属性给整个条件语句块前面添加一个**WHERE**关键字。 |
> | prefixOverrides | 要删除的前缀。如果多出来指定的前缀，则将这些多出来的前缀修剪去除。比如:如果在**整个**语句中需要修剪去`AND |
> | suffix          | 要添加的后缀。使用方式与prefix类似，只是prefix是增加前缀，而suffix是添加一个后缀在被包裹的语句块中。 |
> | suffixOverrides | 要删除的后缀。使用方式与prefixOverrides类似，只是一个是去除前面多余的关键字，suffixOverrides是删除多余后面的。 |
>
> **prefix如果有值，则会替换掉prefixOverrides中的部分。suffix也相同。如果没有值则是默认为空。**
>
> 重点: 其实**where**与**set**都能用`trim`标签来解决。

<center><u>代码清单</u></center>

```xml
<select id="findRoles" parameterType="string" resultMap="roleResultMap">
	select role_no, role_name, note from t_role
    <trim prefix="where" prefixOverrides="and">
    	<if test="roleName != null and roleName != ''">
        	and role_name like concat('%', #{roleName}, '%')
        </if> 
    </trim>
</select>
```



可以使用 set 来更新数据库的部分属性，降低网络带宽。

<center><u>代码清单</u></center>

```xml
<update id="updateRole" parameterType="role">
	update t_role
    <set>
    	<if test="roleName != null and roleName != ''">
        	role_name = #{roleName}
        </if>
        <if test="note != null and note != ''">
        	note = #{note}
        </if>
    </set>
    where role_no = #{roleNo}
</update>
```

set 元素遇到了逗号，会自动把对应的逗号去掉。



## foreach 元素

foreach 元素是一个循环语句，它的作用是遍历集合，很好的支持数组和 List、Set 接口的集合，往往用于 SQL 中的 in 关键字。

<center><u>代码清单</u></center>

```xml
<select id="findUserBySex" resultType="user">
	select * from t_role where role_no in 
    	<foreach item="roleNo" index="index" collection="roleNoList"
                 open="(" separator="," close=")">
    		#{roleNo}
    	</foreach>
</select>
```

collection 是 roleNoList 传递进来的参数名称，可以是数组、List、Set等集合

item: 循环中的当前的元素

index: 当前元素在集合中的位置下标

open、close: 以什么符号将这些集合元素包装起来

separator: 各个元素的间隔符



SQL 经常会用到 in 语句，大量数据的 in 语句会消耗大量的性能。





