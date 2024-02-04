package com.example.pay;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
Button scan,pay;
EditText amount;
public static TextView data2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        scan=(Button) findViewById(R.id.scan);
        pay=(Button) findViewById(R.id.pay);
        data2=(TextView) findViewById(R.id.data2);
        amount=(EditText) findViewById(R.id.amount);
       
        scan.setOnClickListener(this);



        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(amount==null){
                    Toast.makeText(MainActivity2.this, "Enter Amount", Toast.LENGTH_SHORT).show();
                }
                else {
                    String str=amount.getText().toString();
                    Intent intent=new Intent(MainActivity2.this, Payment.class);
                    intent.putExtra("msg_str",str);
                    intent.putExtra("msg_name",data2.getText());
                    startActivity(intent);
                }
                
            }
        });


}

    @Override
    public void onClick(View v) {
        // we need to create the object
        // of IntentIntegrator class
        // which is the class of QR library
        IntentIntegrator intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.setPrompt("Scan a barcode or QR Code");
        intentIntegrator.setOrientationLocked(true);
        intentIntegrator.initiateScan();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        // if the intentResult is null then 
        // toast a message as "cancelled" 
        if (intentResult != null) {
            if (intentResult.getContents() == null) {
                Toast.makeText(getBaseContext(), "Cancelled", Toast.LENGTH_SHORT).show();
            } else {
                // if the intentResult is not null we'll set  
                // the content and format of scan message 
//                data.setText(intentResult.getContents());
                data2.setText(intentResult.getContents());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}