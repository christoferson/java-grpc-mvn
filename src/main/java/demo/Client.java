package demo;

import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.example.helloworld.GreeterGrpc;
import io.grpc.example.helloworld.HelloReply;
import io.grpc.example.helloworld.HelloRequest;

public class Client {

    public static void main(String[] args) throws Exception {

        String name = "Conan";
        int port = 8080;

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();

        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);

        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply reply = stub.sayHello(request);

        System.out.println("Reply: " + reply.getMessage());
        
        System.out.println("Shutting down within 30 seconds.");
        channel.shutdown();
        channel.awaitTermination(30, TimeUnit.SECONDS);
        
    }
    
}
