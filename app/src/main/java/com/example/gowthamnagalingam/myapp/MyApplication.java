package com.example.gowthamnagalingam.myapp;
/**
 * Created by Gowtham Nagalingam on 15-Sep-15.
 */

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class MyApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        Log.d("KeyHash:", "xxyy");
        printHashKey();
        Log.d("KeyHash:","xx");
    }
    public void printHashKey() {
        // Add code to print out the key hash
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.example.gowthamnagalingam.myapp",
                    //"net.simplifiedcoding.androidlogin",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("KeyHash:","error1");
        } catch (NoSuchAlgorithmException e) {
            Log.d("KeyHash:","error2");
        } catch (Exception e)
        {Log.d("KeyHash:","general error");}
    }
}