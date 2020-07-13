package com.liangzai.myapplication.bean

/**
 * @author zhouliang
 * 版本 1.0
 * 创建时间 2020/7/13
 * 描述:测试一些语法
 */
class User private constructor( name :String){
 var name :String = "world"
 var myName = "kotlin"
 var text ="""
      Hi $name!
     My name is $myName.\n
 """.trimMargin()

    init {
        //命名参数
        sayHi(name = "zl",age = 21)
    }

    fun area(width:Int ,height:Int) = println("Hi " + name)


    //Java重载 相同的方法名，参数类型或个数不同
    fun sayHi(name:String = "world\n") = println("Hi " + name)

    fun sayHi(name:String = "world",age :Int){
        println()
        System.out.print(String.format("Hi %s",name))
        //后置改为前置
        System.out.print("Hi $name")
        System.out.print("Hi ${name.length}")

        val intArray = intArrayOf(1,2,3)
        var strList = listOf("a","b","c")
        intArray.forEach {
            i -> println(i)
        }
        //对每个元素进行过滤操作，最终胜生成新的集合
        val newList = intArray.filter { i-> i!=1 }
        var newList1:List<Int> = intArray.map { i -> i + 1 }
        //遍历每个元素，并为每个元素创建新的集合
        val newList2 = intArray.flatMap { i -> listOf("${i + 1}","a","b") }
        //闭区间
        val range : IntRange = 0..100
        var range1 : IntRange = 0 until 100
        for (i in range step 2){
            print("$i,")
        }

        for (i in 19 downTo 1){}

        var x:Int = 1
        when(x){
            1,3->{ x+ 1}
            2->{x * 2}
            in 1..10 ->{
                print("x 在区间 1..10中")}
            else->{ x + 5}
        }


        //?.默认返回
        val str:String? = "Hello"
        val length :Int = str?.length ?: -1

        val str1 = "123"
        val str2 = "123"
        print(str1 == str2)//内容相等，输出：true

        val str11 = "字符串"
        val str22 = str11
        val str33 =  str11
        print(str22 === str33)//引用地址相等，输出：true


    }

    //本地/嵌套函数
    fun login(user:String,password:String){
        fun validate(value:String){
            if(value.isEmpty()){
                throw IllegalArgumentException()
            }
        }
        validate(user)
        validate(password)
    }


    fun main(){
        //练习题 能被3整除（条件不满足 剔除）
        val testList:IntArray = intArrayOf(21, 40, 11, 33, 78)
        testList.filter { i -> i % 3 == 0 }.forEach { i -> print(i)}
    }



}