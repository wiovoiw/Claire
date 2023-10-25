package data;

import java.io.IOException;
import java.io.NotSerializableException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Exp1 {
    public static void main(String[] args) throws IOException,NotSerializableException{
		int sel;
		StudList L=new StudList();
		Scanner in=new Scanner(System.in);
		while(true){
			System.out.print("1.显示全部记录 2.输入 3.删除 0:退出");
			System.out.print("  请选择:");
			sel=in.nextInt();
			switch(sel){
				case 0:break;
				case 1:L.Dispstud();break;
				case 2:L.Addstud();break;
				case 3:L.Delstud();break;
			}
			if(sel == 0)break;
		}
	}
}


class Stud{
	int no;
	String name;
	String course;
	int grade;
	public Stud (int no1, String name1, String course1, int grade1){
		no = no1;
		name = name1;
		course = course1;
		grade = grade1;
	}
	public int getno(){
		return no;
	}
	public String getcourse(){
		return course;
	}
	public int getgrade(){
		return grade;
	}
	public void disp(){
		System.out.println("学号:"+no+"姓名:"+name+"课程:"+course+"分数:"+grade);
	}
}

class StudList{
	ArrayList<Stud>sl;
	public StudList(){
		sl=new ArrayList<Stud>();
	}
	public void Addstud(){
		Scanner in=new Scanner(System.in);
		System.out.println("输入一个学生记录");
		System.out.print("学号:");
		int no1=in.nextInt();
		System.out.print("姓名:");
		String name1=in.next();
		System.out.print("课程:");
		String course1=in.next();
		System.out.print("分数:");
		int grade1=in.nextInt();
		sl.add(new Stud(no1,name1,course1,grade1));
	}
	public void Dispstud(){
		if(sl.size()>0)
		{	System.out.println("**所有学生记录");
			for(int i=0;i<sl.size();i++)
				sl.get(i).disp();
		}
		else System.out.println("**没有任何学生记录");
	}
	public void Delstud(){
		Scanner in=new Scanner(System.in);
		System.out.print("删除的学号:");
		int no1=in.nextInt();
		System.out.print("课程:");
		String course1=in.next();
		int i=0;
		boolean find=false;
		while(i < sl.size()){
			Stud s=sl.get(i);
			if(s.no==no1 && s.course.equals(course1)){
				find=true;break;
			}
			i++;
		}
		if(find){
			sl.remove(i);
			System.out.println("**成功删除该学号学生的成绩记录");
		}
		else
		System.out.println("**没有找到该学生的成绩记录");
	}
	public void Sort1(){
		sl.sort(Comparator.comparing(Stud::getno));
		Dispstud();
	}
	public void Sort2(){
		sl.sort(Comparator.comparing(Stud::getcourse).thenComparing(Stud::getgrade).reversed());
		Dispstud();
	}
}