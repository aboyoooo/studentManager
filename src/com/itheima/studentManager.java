package com.itheima;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Scanner;

/*
    学生管理系统
 */
public class studentManager {
    /*
        1.用输出语句完成主界面
        2.用Scanner实现键盘录入
        3.用switch语句完成选择操作
        4.用循环完成再次回到主界面
     */
    public static void main(String[] args){
        //创建集合对象，用于存储学生数据
        ArrayList<Student> array = new ArrayList<>();


        while(true) {

            //主界面
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看学生");
            System.out.println("5 退出");
            System.out.println("请输入你的选择：");
            //scanner
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            //switch
            switch (line) {
                case "1":
//                    System.out.println("添加学生");
                    addStudent(array);
                    break;
                 case "2":
//                    System.out.println("删除学生");
                     deleteStudent(array);
                     break;
                case "3":
                     updateStudent(array);
//                    System.out.println("修改学生");
                    break;
                case "4":
//                    System.out.println("查看学生");
                    findAllStudent(array);
                    break;

                case "5":
                    System.out.println("谢谢使用");
//                    break;
                    System.exit(0); //JVM退出
            }
        }

    }
    /*
            添加学生
            1.用键盘录入选择添加学生
            2.定义一个方法，用于添加学生
                显示提示信息 要输入何种内容
                键盘录入学生对象所需数据
                创建学生对象，把键盘录入的数据赋值给学生对象的成员变量
                将学生对象添加到集合中
                给出添加成功的提示
            3.调用方法
     */
/*
    public static void addStudent(ArrayList<Student> array){
        //键盘录入
        Scanner sc = new Scanner(System.in);
        //
        System.out.println("请输入学生的学号：");


        String sid = sc.nextLine();
        System.out.println("请输入学生的姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生的年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生的居住地：");
        String address = sc.nextLine();
        //
        Student s = new Student();
        //
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        //
        array.add(s);

        System.out.println("学生添加成功");
    }
    */  //addStudent
    public static void addStudent(ArrayList<Student> array){
        //键盘录入
        Scanner sc = new Scanner(System.in);
        String sid;


        //

        System.out.println("请输入学生的学号：");
        sid = sc.nextLine();

        while(true) {
            final boolean flag = isUsed(array, sid);
            if (flag) {
                System.out.println("该学号已存在，请重新输入");
                break;
            } else {
                System.out.println("请输入学生的姓名：");
                String name = sc.nextLine();
                System.out.println("请输入学生的年龄：");
                String age = sc.nextLine();
                System.out.println("请输入学生的居住地：");
                String address = sc.nextLine();
                //
                Student s = new Student();
                //
                s.setSid(sid);
                s.setName(name);
                s.setAge(age);
                s.setAddress(address);
                //
                array.add(s);

                System.out.println("学生添加成功");
                break;
            }
        }


    }
    public static boolean isUsed(ArrayList<Student> array, String sid){
        boolean flag = false;

        for(Student s : array){
            if(s.getSid().equals(sid))
                flag = true;
                break;
        }


        return flag;
    }
    public static void findAllStudent(ArrayList<Student> array){
        //表头信息
        if(array.size() == 0){
            System.out.println("当前无学生信息，请添加学生信息");
            return;
        }
        System.out.println("学号\t\t\t姓名\t\t年龄\t\t居住地\t\t");

        for(Student s : array) {
            System.out.println(s.getSid() + "\t" + s.getName() + "\t\t" + s.getAge() + "岁\t" + s.getAddress());
        }
    }
    public static void deleteStudent(ArrayList<Student> array){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要删除学生的学号");
        String sid = sc.nextLine();



    }
    public static void updateStudent(ArrayList<Student> array){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改信息的学生的学号：");
        String sid = sc.nextLine();

        for(Student s : array)
            if(s.getSid().equals(sid)) {
                System.out.println("请输入学生新的学号");
                String nsid = sc.nextLine();
                s.setSid(nsid);

                System.out.println("请输入学生新的姓名");
                String name = sc.nextLine();
                s.setName(name);

                System.out.println("请输入学生新的年龄");
                String age = sc.nextLine();
                s.setAge(age);

                System.out.println("请输入学生新的地址");
                String address = sc.nextLine();
                s.setAddress(address);

                System.out.println("修改成功");
                //修改成功后要break不需要继续循环。
                break;
            }
            else
                System.out.println("你要修改的学生不存在");


    }
}
