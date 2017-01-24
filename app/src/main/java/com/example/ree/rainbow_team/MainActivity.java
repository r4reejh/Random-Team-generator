package com.example.ree.rainbow_team;

import java.lang.String;
import java.util.*;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    TextView t[] = new TextView[10];
    int go_count = 0;
    String arr[] = new String[10];
    int input_count = 0;
    Button b1, b2;
    ImageView Im1;
    EditText ed1;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t[0] = (TextView) findViewById(R.id.textView);
        t[1] = (TextView) findViewById(R.id.textView2);
        t[2] = (TextView) findViewById(R.id.textView3);
        t[3] = (TextView) findViewById(R.id.textView4);
        t[4] = (TextView) findViewById(R.id.textView5);
        t[5] = (TextView) findViewById(R.id.textView6);
        t[6] = (TextView) findViewById(R.id.textView7);
        t[7] = (TextView) findViewById(R.id.textView8);
        t[8] = (TextView) findViewById(R.id.textView9);
        t[9] = (TextView) findViewById(R.id.textView10);

        b2 = (Button) findViewById(R.id.button2);
        b1 = (Button) findViewById(R.id.button);

        ed1 = (EditText) findViewById(R.id.editText);
        Im1 = (ImageView) findViewById(R.id.imageView);

        ed1.setText("");
        for (int i = 0; i < 10; i++) {
            t[i].setText("");
        }

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void go(View view) {
        if (go_count >= 10) {
            b1.setBackgroundColor(Color.parseColor("#41D900"));
            b2.performClick();
            ed1.setText("player limit");
        } else {
            arr[input_count++] = (ed1.getText()).toString();
            go_count++;
            b2.setText(Integer.toString(input_count));
            ed1.setText("");
        }


    }

    public void gen(View view) {
        int done[] = new int[input_count];
        Random r = new Random();
        int in_count = 0;

        while (in_count < input_count) {
            int flag = 0;

            int num = r.nextInt(input_count);
            for (int i = 0; i < in_count; i++) {
                if (num == done[i]) {
                    flag = 1;
                }
            }

            if (flag == 0) {
                done[in_count++] = num;
            }
        }
        int k=0;
        for (int i = 0; i < (in_count)/2; i++) {
            t[i].setText(arr[done[k++]]);
        }
        k=((in_count)/2);
        for (int i = 5; i < 5+(in_count-(in_count/2)); i++) {
            t[i].setText(arr[done[k++]]);
        }

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.ree.rainbow_team/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.ree.rainbow_team/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
