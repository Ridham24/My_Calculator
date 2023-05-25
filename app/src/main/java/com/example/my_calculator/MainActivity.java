package com.example.my_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tv;
    int k=0;
    String op1="",op2="",op="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MaterialButton c=findViewById(R.id.c);
        MaterialButton back=findViewById(R.id.back);
        MaterialButton exp=findViewById(R.id.exp);
        MaterialButton div=findViewById(R.id.div);
        MaterialButton sev=findViewById(R.id.sev);
        MaterialButton eig=findViewById(R.id.eig);
        MaterialButton nine=findViewById(R.id.nine);
        MaterialButton mul=findViewById(R.id.mul);
        MaterialButton four=findViewById(R.id.four);
        MaterialButton five=findViewById(R.id.five);
        MaterialButton six=findViewById(R.id.six);
        MaterialButton min=findViewById(R.id.min);
        MaterialButton one=findViewById(R.id.one);
        MaterialButton two=findViewById(R.id.two);
        MaterialButton three=findViewById(R.id.three);
        MaterialButton plus=findViewById(R.id.plus);
        MaterialButton mod=findViewById(R.id.mod);
        MaterialButton zero=findViewById(R.id.zero);
        MaterialButton dot=findViewById(R.id.dot);
        MaterialButton equal=findViewById(R.id.equal);
        tv=findViewById(R.id.tv);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        sev.setOnClickListener(this);
        eig.setOnClickListener(this);
        nine.setOnClickListener(this);
        back.setOnClickListener(this);
        exp.setOnClickListener(this);
        div.setOnClickListener(this);
        mul.setOnClickListener(this);
        plus.setOnClickListener(this);
        equal.setOnClickListener(this);
        min.setOnClickListener(this);
        mod.setOnClickListener(this);
        c.setOnClickListener(this);
        dot.setOnClickListener(this);
        zero.setOnClickListener(this);
    }
    void calculate()
    {
        float a=Float.parseFloat(op1);
        float b=Float.parseFloat(op2);
        float z=0;
        if(op.equals("+"))
            z=a+b;
        else if(op.equals("-"))
            z=a-b;
        else if(op.equals("*"))
            z=a*b;
        else if(op.equals("/"))
            z=a/b;
        else if(op.equals("^"))
            z= (float) Math.pow(a,b);
        else if(op.equals("%"))
            z=a%b;
        tv.setText(""+z);
    }
    @Override
    public void onClick(View view) {
        MaterialButton bt=(MaterialButton) view;
        String s=bt.getText().toString();
        if("0123456789.".contains(s))
        {
            if(k==0)
            {
                tv.setText(s);
                k=1;
            }
            else
            {
                tv.setText(tv.getText().toString()+s);
            }
        }
        else if("*%^/+-".contains(s))
        {
            op1=tv.getText().toString();
            op=s;
            k=0;

            tv.setText(op1+s);
        }
        else if(s.equals("="))
        {
            op2=tv.getText().toString();
            if(op1.equals("")||op.equals("")||op2.equals(""))
                tv.setText(tv.getText().toString());
            else if(op1.contains("%^*+-/")||op2.contains("%^*+-/"))
                tv.setText(tv.getText().toString());
            else if(op.length()>1)
                tv.setText(tv.getText().toString());
           else
            {

                calculate();
                op1="";
                op2="";
                op="";
            }

        }
        else if(s.equals("C"))
        {
            op1="";
            op2="";
            op="";
            tv.setText("");
        }
        else
        {
            String str=tv.getText().toString();
            String o;
            if(str.equals(""))
                o="null";
            else if(str.length()>1)
                o=str.substring(str.length() - 2, str.length() - 1);
            else
                o="";
            if(o=="null")
                tv.setText("");
            else {
                str = str.substring(0, str.length() - 1);
                tv.setText(str);
                if ("%^*+-/".contains(o))
                {
                    k = 1;

                }
            }
        }
    }
}