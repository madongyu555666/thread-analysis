package com;





import com.turo.pushy.apns.ApnsClient;
import com.turo.pushy.apns.ApnsClientBuilder;
import com.turo.pushy.apns.PushNotificationResponse;
import com.turo.pushy.apns.auth.ApnsSigningKey;
import com.turo.pushy.apns.util.ApnsPayloadBuilder;
import com.turo.pushy.apns.util.SimpleApnsPushNotification;
import com.turo.pushy.apns.util.TokenUtil;
import com.turo.pushy.apns.util.concurrent.PushNotificationFuture;
import com.turo.pushy.apns.util.concurrent.PushNotificationResponseListener;
import org.apache.commons.lang3.RandomUtils;

import javax.net.ssl.SSLException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.regex.Pattern;

import static com.sun.xml.internal.ws.util.xml.XMLReaderComposite.State.Payload;

/**
 * @author madongyu
 * @projectName ems.git
 * @description: TODO
 * @date 2019/6/1513:56
 */
public class test {



    public static void main(String[] args) {
       /* try {
            final ApnsClient apnsClient = new ApnsClientBuilder()
                    .setApnsServer(ApnsClientBuilder.DEVELOPMENT_APNS_HOST)
                    .setClientCredentials(new File("meiban_pre.p12"), "meiban")
                    .build();

            final SimpleApnsPushNotification pushNotification;

            final ApnsPayloadBuilder payloadBuilder = new ApnsPayloadBuilder();
            payloadBuilder.setAlertBody("Example!");

            final String payload = payloadBuilder.buildWithDefaultMaximumLength();
            final String token = TokenUtil.sanitizeTokenString("<efc7492 bdbd8209>");

            pushNotification = new SimpleApnsPushNotification(token, "com.example.myApp", payload);

            final PushNotificationFuture<SimpleApnsPushNotification, PushNotificationResponse<SimpleApnsPushNotification>>
                    sendNotificationFuture = apnsClient.sendNotification(pushNotification);


            //���첽�жϷ��ص����
            try {
                final PushNotificationResponse<SimpleApnsPushNotification> pushNotificationResponse =
                        sendNotificationFuture.get();

                if (pushNotificationResponse.isAccepted()) {
                    //���ؽ��ܸ�֪ͨ���������Խ��䴫�ݵ�Ŀ���豸��
                    System.out.println("Push notification accepted by APNs gateway.");
                } else {
                    //���ؾܾ���֪ͨ����Ӧ��Ϊ������ʧ�ܣ����Ҳ�Ӧ�ٴη���֪ͨ�����⣬APNs���ؿ���ָʾĿ�ĵ����Ʊ�Ϊ��Ч��ʱ�����
                    // ������������������Ӧ��ֹͣ����������Ʒ����κ�֪ͨ�������Ը�ʱ����������������ѱ�����ע�ᡣ
                    System.out.println("Notification rejected by the APNs gateway: " +
                            pushNotificationResponse.getRejectionReason());

                    //������Ч
                    //getTokenInvalidationTimestamp
                    if (pushNotificationResponse.getTokenInvalidationTimestamp() != null) {
                        final String deviceToken = pushNotificationResponse.getPushNotification().getToken();
                        Date expirationTimestamp = pushNotificationResponse.getTokenInvalidationTimestamp();
                        *//*final String expirationTimestamp = pushNotificationResponse.getTokenInvalidationTimestamp();*//*
                        *//*if (shouldStopSendingToDeviceToken(deviceToken, expirationTimestamp)) {
                            stopSendingToDeviceToken(deviceToken);
                        }*//*


                        String rejectionReason = pushNotificationResponse.getRejectionReason();
                        if(rejectionReason.equals("Unregistered")){
                            //ͨ���жϷ���ֵΪUnregistered�������ж������Ƿ���ڣ����ھ������µ����ƣ������·��͸���Ϣ

                        }
                        System.out.println("\t��and the token is invalid as of " +
                                pushNotificationResponse.getTokenInvalidationTimestamp());
                    }
                }
            } catch (final ExecutionException e) {
                //��Futureʧ�ܲ��׳��쳣��ͨ��Ӧ������Ϊ��ʱ�Թ��ϣ��������󣬵��÷�Ӧ�����ٴη���֪ͨ
                System.err.println("Failed to send push notification.");
                e.printStackTrace();
            }



            //ע�������
            sendNotificationFuture.addListener(new PushNotificationResponseListener<SimpleApnsPushNotification>() {

                @Override
                public void operationComplete(final PushNotificationFuture<SimpleApnsPushNotification, PushNotificationResponse<SimpleApnsPushNotification>> future) throws Exception {
                    // When using a listener, callers should check for a failure to send a
                    // notification by checking whether the future itself was successful
                    // since an exception will not be thrown.
                    //��ʹ�ü�������������Ӧ���ʧ�ܷ���
                    //ͨ����齫�������Ƿ�ɹ�֪ͨ
                    //��Ϊ���������쳣��
                    if (future.isSuccess()) {
                        final PushNotificationResponse<SimpleApnsPushNotification> pushNotificationResponse =
                                sendNotificationFuture.getNow();
                        //�Ӵ˴�����ǰһ����������֪ͨ��Ӧ��
                        // Handle the push notification response as before from here.
                    } else {
                        //���Խ�֪ͨ���͵�
                        // APNs����
                        //ʱ���˵����⡣���ǿ��Է��֣�����ʧ�ܵ��쳣//ͨ����ȡfuture.cause������

                        // Something went wrong when trying to send the notification to the
                        // APNs gateway. We can find the exception that caused the failure
                        // by getting future.cause().
                        future.cause().printStackTrace();
                    }
                }
            });





            *//*final PushNotificationResponse<SimpleApnsPushNotification> pushNotificationResponse =
                    apnsClient.sendNotification(pushNotification).get();

            if (!pushNotificationResponse.isAccepted()) {
                if (pushNotificationResponse.getTokenInvalidationTimestamp() != null) {
                    final String deviceToken = pushNotificationResponse.getPushNotification().getToken();
                    final String expirationTimestamp = pushNotificationResponse.getTokenInvalidationTimestamp();

                    if (shouldStopSendingToDeviceToken(deviceToken, expirationTimestamp)) {
                        stopSendingToDeviceToken(deviceToken);
                    }
                }
            }*//*

            //�ر�
            *//*final Future<Void> closeFuture = apnsClient.close();
            sendNotificationFuture.await();*//*
        } catch (Exception e) {
            e.printStackTrace();
        }

*/



        /* String content = "db_consultation_gomeplus_pro_111111_46";
         *//* String pattern = ".*db_consultation_gomeplus_pro_.*[1-9]\\d{0,2}+";*//*
        String pattern = ".*db_consultation_gomeplus_pro_[1-9]\\d{0,2}$";
        boolean isMatch =Pattern.matches(pattern, content);
        System.out.println(isMatch);*/









        /*"intent:#Intent;launchFlags=0x10000000;component=%s/%s;%s=%s;end"*/
        /*String  s="intent://com.gome.smartoffice/notification?action="++"#Intent;scheme=wonderfullpush;action=android.intent.action.VIEW;launchFlags=0x10000000;end";
        String.format()



       /* String objectextent1 = "depart|inner_90&inner_82808";
        String objectextent2 = "depart|inner_90&inner_80862&inner_82808";*/


     /*   String s="[{\n" +
                "\"billCode\":\"WJ20190902BP26452\",\n" +
                "\"mainTitle\":\"����\",\n" +
                "\"subTitle\":\"������ļ�������\",\n" +
                "\"billName\":\"����PS004�ӿ�����Խ�\",\n" +
                "\"billTitle\":\"�ļ�������\",\n" +
                "\"billLinkUrl\":\"https:\\/\\/office.gome.com.cn\\/mobile\\/index.html?smartPath=approveDetail&intoEnv=todo&env=3&requisitionUserName=����&createTime=undefined&billName=�ļ�������&billTitle=����PS004�ӿ�����Խ�&search=searchBill&runTaskId=4312685&userBillId=520081&billNo=WJ20190902BP26452&origin=1&userId=d82e61a9a3a0455f979931f897024e46\"\n" +
                "}]";

        List<Bill> bills = JSON.parseArray(s, Bill.class);
        for (Bill bill : bills) {
            System.out.println(bill.getSubTitle());
        }*/





     /*   String[] split = objectextent1.split("&");
        for (int i=0;i<split.length;i++){
            String[] s = split[i].split("_");


            String[] split2 = objectextent2.split("&");
            for (int j=0;j<split2.length;j++){
                String[] s1 = split2[j].split("_");
                System.out.println("s---"+s[0]+"---"+s[1]);
                System.out.println("s1----"+s1[0]+"---"+s1[1]);
                if(!s[1].equals(s1[1])){
                    System.out.println(s1[1]);
                }
            }
        }*/


        /*String[] split2 = objectextent2.split("&");
        for (int i=0;i<split2.length;i++){
            String[] s = split2[i].split("_");
            System.out.println(s[1]);
        }*/



        /*int length = objectextent1.length();
        String substring = objectextent2.substring(length+1, objectextent2.length());
        String[] split = substring.split("&");
        for (int i=0;i<split.length;i++){
            String[] s = split[i].split("_");
            System.out.println(s[1]);
        }*/
    }

    private static void stopSendingToDeviceToken(String deviceToken) {
    }
}
