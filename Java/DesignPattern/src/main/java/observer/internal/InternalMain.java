package observer.internal;

import java.util.Observer;

/**
 * @author      xuanc
 * @date        2020/2/14 下午4:15
 * @version     1.0
 */ 
public class InternalMain {

    public static void main(String[] args) {
        SubjectFor3D subjectFor3D = new SubjectFor3D();
        SubjectForSsq subjectForSsq = new SubjectForSsq();

        Observer observer = new ObserverOne();

        subjectFor3D.addObserver(observer);
        subjectForSsq.addObserver(observer);

        subjectFor3D.setMsg("hello");
        subjectForSsq.setMsg("world");
    }

}
