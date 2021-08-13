package demo;

import io.grpc.BindableService;
import io.grpc.ServerBuilder;

public class Server {

    public static void main(String[] args) throws Exception {

        int port = 8080;

        io.grpc.Server server = ServerBuilder.forPort(port).addService((BindableService) new GreeterImpl()).build();
        System.out.println("starting");
        server.start();
        server.awaitTermination();
    }
    /*
    public static class SimpleHelloServiceImpl extends GreeterImplBase {
        Logger logger = Logger.getLogger(getClass().getName());

        public void sayHello(HelloRequest request, CallStreamObserver<HelloReply> responseObserver) {
            logger.info(String.format("request: name = %s", request.getName()));
            HelloReply reply = HelloReply.newBuilder().setMessage("Hello, " + request.getName()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
    */
}

