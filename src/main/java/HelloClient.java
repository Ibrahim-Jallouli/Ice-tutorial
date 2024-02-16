import Demo.HelloPrx;
import Demo._HelloPrxI;


public class HelloClient {
    public static void main(String[] args) {
        com.zeroc.Ice.Communicator communicator = null;
        try {
            // Initialize Ice communicator
            communicator = com.zeroc.Ice.Util.initialize(args);

            // Create proxy
            com.zeroc.Ice.ObjectPrx base =
                    communicator.stringToProxy("hello:default -p 10000");

            // Narrow proxy to correct type
            HelloPrx hello = Demo.HelloPrx.checkedCast(base);
            if (hello == null) {
                throw new Error("Invalid proxy");
            }

            // Call remote method
            hello.sayHello();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (communicator != null) {
                // Clean up
                communicator.destroy();
            }
        }
    }
}
