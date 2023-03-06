package funtionsgränssnitt;

public class JavasFuntionsGränssnitt {

    public JavasFuntionsGränssnitt(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hej");

            }
        };
        Runnable r2 = () -> System.out.println("decka");

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();


    }
    public static void main(String[] args){
        JavasFuntionsGränssnitt j = new JavasFuntionsGränssnitt();

    }
}
