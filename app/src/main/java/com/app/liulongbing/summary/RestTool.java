package com.app.liulongbing.summary;

import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by liulongbing on 16/4/27.
 */

public class RestTool {

    private final static String PARTNER_NAME = "android";
    public final static String SECRET_KEY = "bc3aa6d4689ce9c53b1f19952ca486d8";

    public static ArrayList<String> getLoginParams(String mobileNo, String passwd) {
        HashMap<String, String> mLoginPara = new HashMap<String, String>();
        mLoginPara.put("sname", "user.login");
        mLoginPara.put("mobile", mobileNo);
        mLoginPara.put("passwd", passwd);
        return buildParams(mLoginPara);
    }

    public static ArrayList<String> getInterestParams(){
        HashMap<String,String> mInterestParams=new HashMap<String,String>();
        mInterestParams.put("sname","user.tender.statistics.get");
        mInterestParams.put("type","");
        return buildParams(mInterestParams);
    }

    public static ArrayList<String> buildParams(HashMap<String,String> params) {
        params.put("pname", PARTNER_NAME);
        JSONObject content = new JSONObject(params);
        String token = md5(content.toString() +SECRET_KEY);
        ArrayList<String> finalPara = new ArrayList<String>();
        finalPara.add(content.toString());
        finalPara.add(token);
        return finalPara;
    }

    public static String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++)
                if ((0xff & messageDigest[i]) < 0x10) {
                    hexString.append("0"
                            + Integer.toHexString((0xFF & messageDigest[i])));
                } else {
                    hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
                }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
