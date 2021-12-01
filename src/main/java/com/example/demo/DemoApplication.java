package com.example.demo;

import org.apache.iotdb.session.SessionDataSet;
import org.apache.plc4x.java.PlcDriverManager;
import org.apache.plc4x.java.api.PlcConnection;
import org.apache.plc4x.java.api.exceptions.PlcConnectionException;
import org.apache.plc4x.java.api.messages.PlcReadRequest;
import org.apache.plc4x.java.api.messages.PlcReadResponse;
import org.apache.plc4x.java.api.messages.PlcWriteRequest;
import org.apache.plc4x.java.api.messages.PlcWriteResponse;
import org.apache.plc4x.java.api.types.PlcResponseCode;
import org.apache.iotdb.session.Session;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {

        return args -> {
//            String host = "111.202.73.135";
//            String rpcPort = "14667";
//            String username = "root";
//            String password = "root";
//            Session session = new Session(host, rpcPort, username, password);
//            session.open();
//            SessionDataSet result = session.executeQueryStatement("show timeseries;");
//            System.out.println(result.toString());
//            while(result.hasNext()){
//                System.out.println(result.next());
//            }
        };
//        return args -> {
//
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//            String connectionString = "modbus:tcp://localhost:502";
//
//            try(PlcConnection plcConnection = new PlcDriverManager().getConnection(connectionString)) {
//                if (!plcConnection.getMetadata().canRead()) {
//                    PlcReadRequest.Builder builder = plcConnection.readRequestBuilder();
//                    builder.addItem("value-1", "coil:1");
//                    builder.addItem("value-2", "coil:3[4]");
//                    builder.addItem("value-3", "holding-register:1");
//                    builder.addItem("value-4", "holding-register:3[4]");
//                    PlcReadRequest readRequest = builder.build();
//                    PlcReadResponse response = readRequest.execute().get();
//                    for (String fieldName : response.getFieldNames()) {
//                        if(response.getResponseCode(fieldName) == PlcResponseCode.OK) {
//                            int numValues = response.getNumberOfValues(fieldName);
//                            // If it's just one element, output just one single line.
//                            if(numValues == 1) {
//                                System.out.println("Value[" + fieldName + "]: " + response.getObject(fieldName));
//                            }
//                            // If it's more than one element, output each in a single row.
//                            else {
//                                System.out.println("Value[" + fieldName + "]:");
//                                for(int i = 0; i < numValues; i++) {
//                                    System.out.println(" - " + response.getObject(fieldName, i));
//                                }
//                            }
//                        }
//                        // Something went wrong, to output an error message instead.
//                        else {
//                            System.out.println("Error[" + fieldName + "]: " + response.getResponseCode(fieldName).name());
//                        }
//                    }
//
//                }
//                else{
//                    System.out.println("CAN'T READ");
//                    System.out.println(plcConnection.getMetadata().toString());
//                    PlcReadRequest.Builder builder = plcConnection.readRequestBuilder();
//                    builder.addItem("value-1", "coil:1");
//                    builder.addItem("value-2", "coil:3[4]");
//                    builder.addItem("value-3", "holding-register:1");
//                    builder.addItem("value-4", "holding-register:3[4]");
//                    PlcReadRequest readRequest = builder.build();
//                    PlcReadResponse response = readRequest.execute().get();
//                    for (String fieldName : response.getFieldNames()) {
//                        if(response.getResponseCode(fieldName) == PlcResponseCode.OK) {
//                            int numValues = response.getNumberOfValues(fieldName);
//                            // If it's just one element, output just one single line.
//                            if(numValues == 1) {
//                                System.out.println("Value[" + fieldName + "]: " + response.getObject(fieldName));
//                            }
//                            // If it's more than one element, output each in a single row.
//                            else {
//                                System.out.println("Value[" + fieldName + "]:");
//                                for(int i = 0; i < numValues; i++) {
//                                    System.out.println(" - " + response.getObject(fieldName, i));
//                                }
//                            }
//                        }
//                        // Something went wrong, to output an error message instead.
//                        else {
//                            System.out.println("Error[" + fieldName + "]: " + response.getResponseCode(fieldName).name());
//                        }
//                    }
//
//                    PlcWriteRequest.Builder builder1 = plcConnection.writeRequestBuilder();
//                    builder1.addItem("value-1", "coil:1", true);
//                    builder1.addItem("value-2", "coil:3[4]", true, false, true, true);
//                    builder1.addItem("value-3", "holding-register:1", 42);
//                    builder1.addItem("value-4", "holding-register:3[4]", 1, 2, 3, 4);
//                    PlcWriteRequest writeRequest = builder1.build();
//                    PlcWriteResponse response1 = writeRequest.execute().get();
//                    for (String fieldName : response.getFieldNames()) {
//                        if(response.getResponseCode(fieldName) == PlcResponseCode.OK) {
//                            System.out.println("Value[" + fieldName + "]: successfully written to device.");
//                        }
//                        // Something went wrong, to output an error message instead.
//                        else {
//                            System.out.println("Error[" + fieldName + "]: " + response.getResponseCode(fieldName).name());
//                        }
//                    }
//                }
//
//            } catch (
//                    PlcConnectionException e) {
//                e.printStackTrace();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        };
    }



}
