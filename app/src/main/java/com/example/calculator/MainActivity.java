package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    display=findViewById(R.id.input);

    display.setShowSoftInputOnFocus(false);

    display.setOnClickListener(view -> {
        if(getString(R.string.display).equals(display.getText().toString())){
        display.setText("");
        }
    });
    }
    private void updateText(String strToAdd){
        String oldStr=display.getText().toString();
        int cursorpos=display.getSelectionStart();
        String leftStr=oldStr.substring(0,cursorpos);
        String rightStr=oldStr.substring (cursorpos);
        display.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr));
    display.setSelection(cursorpos+1);
    }





    public void ZeroBTN(View view){
        updateText("0");

    }
    public void oneBTN(View view){
        updateText("1");

    }
    public void twoBTN(View view){
        updateText("2");

    }
    public void threeBTN(View view){
        updateText("3");
    }
    public void fourBTN(View view){
        updateText("4");
    }
    public void fiveBTN(View view){
        updateText("5");
    }
    public void sixBTN(View view){
        updateText("6");
    }
    public void sevenBTN(View view){
        updateText("7");
    }
    public void eightBTN(View view){
        updateText("8");
    }
    public void nineBTN(View view){
        updateText("9");
    }
    public void paranthesis1(View view){
        int cursorpos=display.getSelectionStart();
        int openpar=0;
        int closedpar = 0;
        int textlen=display.getText().length();
        for (int i = 0; i <cursorpos ; i++) {
            if(display.getText().toString().substring(i,i+1).equals("(")){
                openpar+=1;
            }
            if(display.getText().toString().charAt(i) == ')'){
                closedpar+=1; }

        }
        if(openpar==closedpar || display.getText().subSequence(textlen-1,textlen).equals("(") ){
updateText("(");
        display.setSelection(cursorpos+1);
    }
        else if(closedpar< openpar && !display.getText().subSequence(textlen-1,textlen).equals("(") )
    updateText(")");
        display.setSelection(cursorpos+1);}

    public void p2(View view){
        int cursorpos=display.getSelectionStart();
        int openpar=0;
        int closedpar = 0;
        int textlen=display.getText().length();
        for (int i = 0; i <cursorpos ; i++) {
            if(display.getText().toString().substring(i,i+1).equals("(")){
                openpar+=1;
            }
            if(display.getText().toString().charAt(i) == ')'){
                closedpar+=1; }

        }
        if(openpar==closedpar || display.getText().subSequence(textlen-1,textlen).equals("(") ){
            updateText("(");
            display.setSelection(cursorpos+1);
        }
        else if(closedpar< openpar && !display.getText().subSequence(textlen-1,textlen).equals("(") )
            updateText(")");
        display.setSelection(cursorpos+1);}


    public void devideBTN(View view){
        updateText("/");
    }
    public void sumBTN(View view){
        updateText("+");
    }
    public void minBTN(View view){
        updateText("-");
    }
    public void multiplyBTN(View view){
        updateText("x");
    }
    public void clearBTN(View view){
        display.setText("");

    }
    public void pointBTN(View view){
        updateText(".");

    }
    public void backspaceBTN(View view){
        int cursorpos=display.getSelectionStart();
        int textLen=display.getText().length();
        if(cursorpos!=0 && textLen !=0){
            SpannableStringBuilder selection= (SpannableStringBuilder) display.getText();
            selection.replace(cursorpos-1,cursorpos,"");
            display.setText(selection);
            display.setSelection(cursorpos-1);
        }

    }
    public void equaltoBTN(View view){
        String userExp=display.getText().toString();
        userExp=userExp.replaceAll("&#0215;" ,"*");
        userExp=userExp.replaceAll("\u00F7" ,"/");
    Expression exp=new Expression(userExp);
    String result=String.valueOf(exp.calculate());
    display.setText(result);
    display.setSelection(result.length());
    }
    public void powerBTN(View view){
        updateText("^");

    }

}