package observer.demo;

/**
 * @author      xuanc
 * @date        2020/2/14 下午3:57
 * @version     1.0
 */ 
public class Main {

    public static void main(String[] args) {
        // subject
        ObjectFor3D subjectFor3D = new ObjectFor3D();
        // observer
        Observer observerOne = new ObserverOne(subjectFor3D);
        Observer observerTwo = new ObserverTwo(subjectFor3D);

        subjectFor3D.setMsg("first");
        subjectFor3D.setMsg("second");
    }

}
