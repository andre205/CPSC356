package com.example.tyler.tylerandrews_tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView messageTextView;
    private TextView tipTextView;
    private EditText billEditText;
    private SeekBar satisfactionSeekBar;
    private TextView ratingTextView;

    private float tipPercentage = (float) .13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.messageTextView = (TextView) findViewById(R.id.tv_message);
        this.tipTextView = (TextView) findViewById(R.id.tv_tip);
        this.ratingTextView = (TextView) findViewById(R.id.tv_rating);
        this.billEditText = (EditText) findViewById(R.id.et_bill);
        this.satisfactionSeekBar = (SeekBar) findViewById(R.id.sb_rating);

        satisfactionSeekBar.setProgress(5);

        satisfactionSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String s = Integer.toString(i);

                ratingTextView.setText(s);

                if (i < 4)
                {
                    tipPercentage = (float) .1;
                }
                else if (i < 6)
                {
                    tipPercentage = (float) .13;
                }
                else if (i < 8)
                {
                    tipPercentage = (float) .15;
                }
                else if (i < 10)
                {
                    tipPercentage = (float) .2;
                }
                else if (i == 10)
                {
                    tipPercentage = (float) .25;
                }
                else
                {
                    //default to 15% in case of error
                    tipPercentage = (float) .15;
                }

                //get bill text, convert to float
                String bill = billEditText.getText().toString();



                try
                {

                    float bf = Float.parseFloat(bill);
                    if (bf > 0)
                    {
                        float tip = bf * tipPercentage;
                        new DecimalFormat("#.##").format(tip);
                        //tipTextView.setText(Float.toString(tip));
                        tipTextView.setText("$" + new DecimalFormat("#.##").format(tip));
                    }
                }

                catch (Exception e)
                {

                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        billEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                try
                {

                    float b = Float.parseFloat(charSequence.toString());
                    if (b > 0)
                    {
                        float tip = b * tipPercentage;
                        new DecimalFormat("#.##").format(tip);
                        //tipTextView.setText(Float.toString(tip));
                        tipTextView.setText("$" + new DecimalFormat("#.##").format(tip));
                    }
                }

                catch (Exception e)
                {

                }

                if (charSequence.length() == 0)
                {
                    tipTextView.setText("");
                    messageTextView.setText("");
                }
                else
                {
                    messageTextView.setText(R.string.tip);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });

    }

}
