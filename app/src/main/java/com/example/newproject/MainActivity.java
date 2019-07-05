package com.example.newproject;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.newproject.R.color.backscreen;

public class MainActivity extends AppCompatActivity {
    LinearLayout mainlinearlayout;
    EditText billamount;
    TextView txtamount,txtamount1;
    public static String amount="";

    Animation frombottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainlinearlayout = findViewById(R.id.mainlinaerlayout);

        billamount=(EditText)findViewById(R.id.billAmount);
       txtamount=findViewById(R.id.amount);

       txtamount1=findViewById(R.id.txtamount);

        frombottom= AnimationUtils.loadAnimation(this,R.anim.frombottom);
    }

    public void PayPrice(View view) {

        findViewById(R.id.firstlayout).setVisibility(View.VISIBLE);
        findViewById(R.id.firstlayout).startAnimation(frombottom);
        mainlinearlayout.animate().alpha((float) 0.33);


    }

    public void exitpage(View view) {

        findViewById(R.id.firstlayout).setVisibility(View.GONE);
        findViewById(R.id.secondlayout).setVisibility(View.INVISIBLE);
        findViewById(R.id.thirdlayout).setVisibility(View.INVISIBLE);
        findViewById(R.id.walletfirstlayout).setVisibility(View.INVISIBLE);
        findViewById(R.id.waitinglayout).setVisibility(View.INVISIBLE);
        findViewById(R.id.detaillayout).setVisibility(View.INVISIBLE);
        findViewById(R.id.chooselayout).setVisibility(View.INVISIBLE);
        mainlinearlayout.animate().alpha(1);
        amount=billamount.getText().toString();
        Log.d("TAG1", "onCreate: "+amount);
        txtamount.setText("Amount \t : \t "+ amount);
        txtamount1.setText(amount);

    }

    public void getotp(View view) {

        exitpage(view);


        findViewById(R.id.secondlayout).setVisibility(View.VISIBLE);
        findViewById(R.id.secondlayout).startAnimation(frombottom);
        mainlinearlayout.animate().alpha((float) 0.33);
    }

    public void submit(View view) {
        exitpage(view);
        findViewById(R.id.thirdlayout).setVisibility(View.VISIBLE);
        findViewById(R.id.thirdlayout).startAnimation(frombottom);
        mainlinearlayout.animate().alpha((float) 0.33);

    }

    public void paymentPage(View view) {
        exitpage(view);


        findViewById(R.id.walletfirstlayout).setVisibility(View.VISIBLE);
        findViewById(R.id.walletfirstlayout).startAnimation(frombottom);
        mainlinearlayout.animate().alpha((float) 0.33);

    }
    public void initRadioButton(){
        findViewById(R.id.debitcard).setVisibility(View.GONE);
        findViewById(R.id.crebitcard).setVisibility(View.GONE);
        findViewById(R.id.debitcard1).setVisibility(View.GONE);
        findViewById(R.id.crebitcard1).setVisibility(View.GONE);

    }

    public void debitPage(View view) {
        initRadioButton();
        findViewById(R.id.debitcard).setVisibility(View.VISIBLE);
    }


    public void ToneTagPage(final View view) {
        initRadioButton();
        exitpage(view);
        findViewById(R.id.waitinglayout).setVisibility(View.VISIBLE);
        findViewById(R.id.waitinglayout).startAnimation(frombottom);
        mainlinearlayout.animate().alpha((float) 0.33);
        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(1000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            findViewById(R.id.waitinglayout).setVisibility(View.INVISIBLE);
                            detailpage();
                        }
                    });//Delay of 10 seconds
                } catch (Exception e) {
                    Log.d("TAGGG", "run: Error ");
                } finally {



                }
            }
        };
        welcomeThread.start();
    }


    public void CreditPage(View view) {
        initRadioButton();
        findViewById(R.id.crebitcard).setVisibility(View.VISIBLE);
    }

    public void detailpage() {

        findViewById(R.id.detaillayout).setVisibility(View.VISIBLE);
        findViewById(R.id.detaillayout).startAnimation(frombottom);
        mainlinearlayout.animate().alpha((float) 0.33);
    }

    public void AddOn(View view) {
        exitpage(view);
        findViewById(R.id.chooselayout).setVisibility(View.VISIBLE);
        findViewById(R.id.chooselayout).startAnimation(frombottom);
        mainlinearlayout.animate().alpha((float) 0.33);
    }


    public void debitPage1(View view) {
        initRadioButton();
        findViewById(R.id.debitcard1).setVisibility(View.VISIBLE);
    }

    public void CrebitPage1(View view) {
        initRadioButton();
        findViewById(R.id.crebitcard1).setVisibility(View.VISIBLE);
    }
}
