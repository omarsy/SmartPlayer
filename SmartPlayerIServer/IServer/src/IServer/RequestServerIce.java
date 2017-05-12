package IServer;

public class RequestServerIce {
	    public static void main(String[] args)
	    {
	        int status = 0;
	        Ice.Communicator ic = null;
	        try {
	            ic = Ice.Util.initialize(args);
	            Ice.ObjectAdapter adapter =
	                ic.createObjectAdapterWithEndpoints("requestServer", "ws -h localhost -p 10000");
	            Ice.Object object = new RequestServer();
	            adapter.add(object, ic.stringToIdentity("requestServer"));
	            adapter.activate();
	            ic.waitForShutdown();
	        } catch (Ice.LocalException e) {
	            e.printStackTrace();
	            status = 1;
	        } catch (Exception e) {
	            System.err.println(e.getMessage());
	            status = 1;
	        }
	        if (ic != null) {
	            // Clean up
	            //
	            try {
	                ic.destroy();
	            } catch (Exception e) {
	                System.err.println(e.getMessage());
	                status = 1;
	            }
	        }
	        System.exit(status);
	    }
	}
