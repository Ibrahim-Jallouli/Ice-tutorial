package Demo;

import com.zeroc.Ice.Current;

public class Hellol implements Hello{
    @Override
    public void sayHello(Current current) {
        System.out.println("Hello, Ice!");
    }
}
