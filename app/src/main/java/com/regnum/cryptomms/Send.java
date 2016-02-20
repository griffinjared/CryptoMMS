package com.regnum.cryptomms;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by shane on 2/20/16.
 */
class Send extends Activity {


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient mClient;
    private EditText phone;
    private EditText message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        setContentView(R.layout.send);
        mClient = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        phone=(EditText) findViewById(R.id.phoneNum);
        message=(EditText) findViewById(R.id.message);
    }

    @Override
    public void onStart() {
        super.onStart();
        setContentView(R.layout.send);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mClient.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Send Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.regnum.cryptomms/http/host/path")
        );
        AppIndex.AppIndexApi.start(mClient, viewAction);

    }
    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Send Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.regnum.cryptomms/http/host/path")
        );
        AppIndex.AppIndexApi.end(mClient, viewAction);
        mClient.disconnect();
    }

    public void sendMess(View view){
        String ph = phone.getText().toString();
        String mess = message.getText().toString();

        if(ph.length()==10){
            sendSMS(ph,mess);
        }
        throw new IllegalArgumentException("Not Enough Digits");// TODO: 2/20/16


    }

    public void sendSMS(String phoneNum,String message){
        PendingIntent pi = PendingIntent.getActivity(this,0,new Intent(this,Send.class),0);
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNum,null,message,pi,null);



    }






}
