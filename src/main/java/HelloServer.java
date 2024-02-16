import Demo.Hello;
import Demo.HelloPrx;
import Demo.Hellol;
import Demo._HelloPrxI;
import com.zeroc.Ice.Object;
import com.zeroc.Ice.ObjectPrx;
import com.zeroc.Ice.Util;

public class HelloServer {
    public static void main(String[] args) {
        com.zeroc.Ice.Communicator communicator = null;
        try {
            // Initialize Ice communicator
            communicator = com.zeroc.Ice.Util.initialize(args);

            // Create object adapter
            com.zeroc.Ice.ObjectAdapter adapter =
                    communicator.createObjectAdapterWithEndpoints("HelloAdapter", "default -p 10000");

            // Create servant
            Hellol hello = new Hellol();

            // Activate servant
            adapter.add(hello, Util.stringToIdentity("hello"));

            // Activate adapter
            adapter.activate();

            // Wait for shutdown signal
            communicator.waitForShutdown();
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
