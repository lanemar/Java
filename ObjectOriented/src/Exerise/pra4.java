package Exerise;
/*
    2021.12.24
    1、
    定义Student类，包含number、state、score三个属性。
    创建20个Student对象，学号从1-20，年级和成绩随机。
    打印出3年级的学生信息，使用冒泡算法按学生成绩排序并遍历所有学生信息。
    生成随机数：Math.random().返回值为double.
    取整：Math.round(double var).返回值为long.
    2、
    声明一个日期类型MyDate，包含year、month、day三个属性，创建2个日期对象。
*/
class Student{
    private int number;
    private int state;
    private int score;
    public Student(){this(0,0,0);}
    public Student(int number,int state,int score){
        this.number=number;
        this.state=state;
        this.score=score;
    }
    public int getNumber() {return number;}
    public void setNumber(int number) {this.number = number;}
    public int getState() {return state;}
    public void setState(int state) {this.state = state;}
    public int getScore() {return score;}
    public void setScore(int score) {this.score = score;}
    public String getInfo(){return "Number:"+this.number+" State:"+this.state+" Score:"+this.score;}
}
class MyDate{
    private long year;
    private long month;
    private long day;
    public MyDate(){this(1970,01,01);}
    public MyDate(long year,long month,long day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public long getYear() {return year;}
    public void setYear(long year) {this.year = year;}
    public long getMonth() {return month;}
    public void setMonth(long month) {this.month = month;}
    public long getDay() {return day;}
    public void setDay(long day) {this.day = day;}
    public String getInfo(){return "Date:"+this.year+"-"+this.month+"-"+this.day;}
}
public class pra4 {
    public static void main(String[] args) {
        //声明对象数组并创建对象
        Student[] newStd=new Student[20];
        for(int i=0;i<newStd.length;i++){
            newStd[i]=new Student();
            newStd[i].setNumber(i+1);
            /* 这里random()需要强制将类型转换为int。 */
            newStd[i].setState((int)(Math.random()*(6-1+1)+1));
            newStd[i].setScore((int)(Math.random()*(100-0+1)));
        }
        trave(newStd);
        System.out.println("----------------------------------");
        selectState(newStd,3);
        System.out.println("----------------------------------");
        System.out.println("成绩排序:");
        bubbleSort(newStd);
        trave(newStd);
        /*-----------------------------------------------------------------*/
        System.out.println("----------------------------------");
        MyDate t1=new MyDate(2021,12,24);
        MyDate t2=new MyDate(2021,12,25);
        System.out.println(t1.getInfo());
        System.out.println(t2.getInfo());
    }
    /* 遍历数组 */
    /* 与C/C++类似，在进行数组传递的时传递的都是该数组的首地址。 */
    public static void trave(Student[] temp){
        for(int i=0;i<temp.length;i++){
            /* 注意：这里不能直接用newStd[i]的方式进行输出，因为其中存的是堆内存中对象的地址。 */
            System.out.println(temp[i].getInfo());
        }
    }
    /* 选取 */
    public static void selectState(Student[] temp,int stvar){
        for(int i=0;i<temp.length;i++){
            /* 注意：这里不能直接用newStd[i]的方式进行输出，因为其中存的是堆内存中对象的地址。 */
            if(temp[i].getState()==3) {
                System.out.println(temp[i].getInfo());
            }
        }
    }
    /* 排序 */
    public static void bubbleSort(Student[] temp){
        for(int i=0;i<temp.length-1;i++){
            for(int j=0;j<temp.length-1-i;j++){
                /* 冒泡排序 */
                Student stemp;
                if(temp[j].getScore()>temp[j+1].getScore()){
                    /* 这里交换的不是成绩的位置，是地址值的位置。 */
                    stemp=temp[j];
                    temp[j]=temp[j+1];
                    temp[j+1]=stemp;
                }
            }
        }
    }
}
