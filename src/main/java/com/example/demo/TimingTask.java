package com.example.demo;

import org.apache.iotdb.rpc.IoTDBConnectionException;
import org.apache.iotdb.rpc.StatementExecutionException;
import org.apache.iotdb.session.Session;
import org.apache.iotdb.session.SessionDataSet;
import org.apache.plc4x.java.PlcDriverManager;
import org.apache.plc4x.java.api.PlcConnection;
import org.apache.plc4x.java.api.exceptions.PlcConnectionException;
import org.apache.plc4x.java.api.messages.PlcReadRequest;
import org.apache.plc4x.java.api.messages.PlcReadResponse;
import org.apache.plc4x.java.api.types.PlcResponseCode;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.apache.iotdb.session.Session;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

@Component
public class TimingTask {
    /**
     * 每五秒执行一次
     */
    int cnt = 0;
    SessionDataSet result;
    String connectionString = "modbus:tcp://localhost:502";
    PlcReadResponse response;
    PlcReadRequest readRequest;
    Session session;
    // 全局变量
    public static final String TIME_FULL_SPRIT = "yyyy-MM-dd HH:mm:ss";
    @Bean
    public void initIoTDB() throws IoTDBConnectionException, StatementExecutionException {
        String host = "111.202.73.135";
        String rpcPort = "14667";
        String username = "root";
        String password = "root";
        session = new Session(host, rpcPort, username, password);
        session.open();
        result = session.executeQueryStatement("show timeseries;");
//        session.executeNonQueryStatement("CREATE TIMESERIES root.modbus.value WITH DATATYPE=FLOAT,ENCODING=PLAIN;");

    }

    @Bean
    public void initModBus() {

        try (PlcConnection plcConnection = new PlcDriverManager().getConnection(connectionString)) {
            if (!plcConnection.getMetadata().canRead()) {
                PlcReadRequest.Builder builder = plcConnection.readRequestBuilder();
//                builder.addItem("value-1", "coil:1");
//                builder.addItem("value-2", "coil:3[4]");
                builder.addItem("value-3", "holding-register:1");
//                builder.addItem("value-4", "holding-register:3[4]");
                readRequest = builder.build();
                response = readRequest.execute().get();
                for (String fieldName : response.getFieldNames()) {
                    if (response.getResponseCode(fieldName) == PlcResponseCode.OK) {
                        int numValues = response.getNumberOfValues(fieldName);
                        // If it's just one element, output just one single line.
                        if (numValues == 1) {
                            System.out.println("Value[" + fieldName + "]: " + response.getObject(fieldName));
                        }
                        // If it's more than one element, output each in a single row.
                        else {
                            System.out.println("Value[" + fieldName + "]:");
                            for (int i = 0; i < numValues; i++) {
                                System.out.println(" - " + response.getObject(fieldName, i));
                            }
                        }
                    }
                    // Something went wrong, to output an error message instead.
                    else {
                        System.out.println("Error[" + fieldName + "]: " + response.getResponseCode(fieldName).name());
                    }
                }

            } else {
                System.out.println("CAN'T READ");
                PlcReadRequest.Builder builder = plcConnection.readRequestBuilder();
                builder.addItem("value-3", "holding-register:1");
                readRequest = builder.build();
                response = readRequest.execute().get();
                for (String fieldName : response.getFieldNames()) {
                    if (response.getResponseCode(fieldName) == PlcResponseCode.OK) {
                        int numValues = response.getNumberOfValues(fieldName);
                        // If it's just one element, output just one single line.
                        if (numValues == 1) {
                            System.out.println("Value[" + fieldName + "]: " + response.getObject(fieldName));
                        }
                        // If it's more than one element, output each in a single row.
                        else {
                            System.out.println("Value[" + fieldName + "]:");
                            for (int i = 0; i < numValues; i++) {
                                System.out.println(" - " + response.getObject(fieldName, i));
                            }
                        }
                    }
                    // Something went wrong, to output an error message instead.
                    else {
                        System.out.println("Error[" + fieldName + "]: " + response.getResponseCode(fieldName).name());
                    }
                }

            }
        } catch (PlcConnectionException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Scheduled(cron = "0/5 * * * * ?")
    public void executeFileDownLoadTask() throws StatementExecutionException, IoTDBConnectionException, ExecutionException, InterruptedException {
        System.out.println("定时任务启动");
        String now = dateToString(new Date(), TIME_FULL_SPRIT);
        System.out.println(now);
        try (PlcConnection plcConnection = new PlcDriverManager().getConnection(connectionString)) {
            if (!plcConnection.getMetadata().canRead()) {
                PlcReadRequest.Builder builder = plcConnection.readRequestBuilder();
//                builder.addItem("value-1", "coil:1");
//                builder.addItem("value-2", "coil:3[4]");
                builder.addItem("value-3", "holding-register:1");
//                builder.addItem("value-4", "holding-register:3[4]");
                readRequest = builder.build();
                response = readRequest.execute().get();
                for (String fieldName : response.getFieldNames()) {
                    if (response.getResponseCode(fieldName) == PlcResponseCode.OK) {
                        int numValues = response.getNumberOfValues(fieldName);
                        // If it's just one element, output just one single line.
                        if (numValues == 1) {
                            System.out.println("Value[" + fieldName + "]: " + response.getObject(fieldName));
                        }
                        // If it's more than one element, output each in a single row.
                        else {
                            System.out.println("Value[" + fieldName + "]:");
                            for (int i = 0; i < numValues; i++) {
                                System.out.println(" - " + response.getObject(fieldName, i));
                            }
                        }
                    }
                    // Something went wrong, to output an error message instead.
                    else {
                        System.out.println("Error[" + fieldName + "]: " + response.getResponseCode(fieldName).name());
                    }
                }

            } else {
                System.out.println("CAN'T READ");
                PlcReadRequest.Builder builder = plcConnection.readRequestBuilder();
                builder.addItem("value-3", "holding-register:1");
                readRequest = builder.build();
                response = readRequest.execute().get();
                for (String fieldName : response.getFieldNames()) {
                    if (response.getResponseCode(fieldName) == PlcResponseCode.OK) {
                        int numValues = response.getNumberOfValues(fieldName);
                        // If it's just one element, output just one single line.
                        if (numValues == 1) {
                            System.out.println("insert into root.modbus(timestamp,value) values("+now+","+response.getObject(fieldName)+")");
                            session.executeNonQueryStatement("insert into root.modbus(timestamp,value) values("+now+","+response.getObject(fieldName)+")");
                            System.out.println("Value[" + fieldName + "]: " + response.getObject(fieldName));
                        }
                        // If it's more than one element, output each in a single row.
                        else {
                            System.out.println("Value[" + fieldName + "]:");
                            for (int i = 0; i < numValues; i++) {
                                System.out.println(" - " + response.getObject(fieldName, i));
                            }
                        }
                    }
                    // Something went wrong, to output an error message instead.
                    else {
                        System.out.println("Error[" + fieldName + "]: " + response.getResponseCode(fieldName).name());
                    }
                }

            }
        } catch (PlcConnectionException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    /**
     * 时间转换成字符串
     *
     * @param date 日期
     * @param formartStr 格式
     * @retur
     */
    public static String dateToString(Date date, String formartStr) {
        String strDate = null;
        if (date != null && formartStr != null && !"".equals(formartStr)) {
            SimpleDateFormat sdf = new SimpleDateFormat(formartStr);
            strDate = sdf.format(date);
        }
        return strDate;
    }



}