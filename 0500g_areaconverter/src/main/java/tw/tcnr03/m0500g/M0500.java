package tw.tcnr03.m0500g;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

import tw.tcnr03.m0500g.R;


public class M0500 extends AppCompatActivity {

    private EditText e001;
    private Button b001;
    private TextView t003;
    private DecimalFormat pondsFormat;
    private String ans;
    private TextView t001;
    private TextView t002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0500);
        setupViewcomponent();   //user define自定義方法
    }

    private void setupViewcomponent() {  //定義配置碼
        e001=(EditText)findViewById(R.id.m0500_e001);//輸入坪數
        b001=(Button)findViewById(R.id.m0500_b001);//轉換按鈕
        t001=(TextView)findViewById(R.id.m0500_t003);//輸出台幣金額
        t002=(TextView)findViewById(R.id.m0500_t005);//輸出台幣金額
        t003=(TextView)findViewById(R.id.m0500_t007);//輸出台幣金額
        b001.setOnClickListener(B001on);
    }

    private  View.OnClickListener B001on = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            pondsFormat = new DecimalFormat("0.00000");//補位到小數點後5位，若是#.000
            if (e001.getText().toString().length()>0){
                ans = pondsFormat.format(Float.parseFloat(e001.getText().toString())*0.3025);
                t001.setText(ans);
                ans = pondsFormat.format(Float.parseFloat(e001.getText().toString())*3.3058);
                t002.setText(ans);
                ans = pondsFormat.format(Float.parseFloat(e001.getText().toString())*0.33058);
                t003.setText(ans);
            }else {
                ans="";
            }



        }
    };
}