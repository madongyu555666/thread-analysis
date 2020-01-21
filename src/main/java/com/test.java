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


            //非异步判断返回的情况
            try {
                final PushNotificationResponse<SimpleApnsPushNotification> pushNotificationResponse =
                        sendNotificationFuture.get();

                if (pushNotificationResponse.isAccepted()) {
                    //网关接受该通知，并将尝试将其传递到目标设备。
                    System.out.println("Push notification accepted by APNs gateway.");
                } else {
                    //网关拒绝该通知；这应视为永久性失败，并且不应再次发送通知。另外，APNs网关可以指示目的地令牌变为无效的时间戳。
                    // 如果发生这种情况，您应该停止尝试向该令牌发送任何通知，除非自该时间戳记以来该令牌已被重新注册。
                    System.out.println("Notification rejected by the APNs gateway: " +
                            pushNotificationResponse.getRejectionReason());

                    //令牌无效
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
                            //通过判断返回值为Unregistered，可以判断令牌是否过期，过期就申请新的令牌，并重新发送该消息

                        }
                        System.out.println("\t…and the token is invalid as of " +
                                pushNotificationResponse.getTokenInvalidationTimestamp());
                    }
                }
            } catch (final ExecutionException e) {
                //将Future失败并抛出异常。通常应将其视为暂时性故障，解决问题后，调用方应尝试再次发送通知
                System.err.println("Failed to send push notification.");
                e.printStackTrace();
            }



            //注册监听器
            sendNotificationFuture.addListener(new PushNotificationResponseListener<SimpleApnsPushNotification>() {

                @Override
                public void operationComplete(final PushNotificationFuture<SimpleApnsPushNotification, PushNotificationResponse<SimpleApnsPushNotification>> future) throws Exception {
                    // When using a listener, callers should check for a failure to send a
                    // notification by checking whether the future itself was successful
                    // since an exception will not be thrown.
                    //当使用监听器，呼叫者应检查失败发送
                    //通过检查将来本身是否成功通知
                    //因为不会引发异常。
                    if (future.isSuccess()) {
                        final PushNotificationResponse<SimpleApnsPushNotification> pushNotificationResponse =
                                sendNotificationFuture.getNow();
                        //从此处像以前一样处理推送通知响应。
                        // Handle the push notification response as before from here.
                    } else {
                        //尝试将通知发送到
                        // APNs网关
                        //时出了点问题。我们可以发现，导致失败的异常//通过获取future.cause（）。

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

            //关闭
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



        String salt = RandomUtils.getRandomNumbersAndLetters(5);
        System.out.println(salt);
        String abcd123 = CryptographyUtil.encodeByMd5WithSalt("Abcd123", salt);
        System.out.println(abcd123);





        /*"intent:#Intent;launchFlags=0x10000000;component=%s/%s;%s=%s;end"*/
        /*String  s="intent://com.gome.smartoffice/notification?action="++"#Intent;scheme=wonderfullpush;action=android.intent.action.VIEW;launchFlags=0x10000000;end";
        String.format()



       /* String objectextent1 = "depart|inner_90&inner_82808";
        String objectextent2 = "depart|inner_90&inner_80862&inner_82808";*/


     /*   String s="[{\n" +
                "\"billCode\":\"WJ20190902BP26452\",\n" +
                "\"mainTitle\":\"审批\",\n" +
                "\"subTitle\":\"马冬宇的文件报批单\",\n" +
                "\"billName\":\"人资PS004接口需求对接\",\n" +
                "\"billTitle\":\"文件报批单\",\n" +
                "\"billLinkUrl\":\"https:\\/\\/office.gome.com.cn\\/mobile\\/index.html?smartPath=approveDetail&intoEnv=todo&env=3&requisitionUserName=马冬宇&createTime=undefined&billName=文件报批单&billTitle=人资PS004接口需求对接&search=searchBill&runTaskId=4312685&userBillId=520081&billNo=WJ20190902BP26452&origin=1&userId=d82e61a9a3a0455f979931f897024e46\"\n" +
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
