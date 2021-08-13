package demo;

import io.grpc.example.helloworld.GreeterGrpc;
import io.grpc.example.helloworld.HelloReply;
import io.grpc.example.helloworld.HelloRequest;
import io.grpc.stub.StreamObserver;

public class GreeterImpl extends GreeterGrpc.GreeterImplBase {

    public void sayHello(HelloRequest reqest, StreamObserver<HelloReply> responseObserver) {

        HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + reqest.getName()).build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
    
}