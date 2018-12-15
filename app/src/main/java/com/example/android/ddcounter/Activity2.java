package com.example.android.ddcounter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import java.security.PublicKey;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        EditText goldEditText = (EditText) findViewById(R.id.gold_EditText);
        SharedPreferences myGold = getSharedPreferences("Gold", 0);
        String amountGold = myGold.getString("gold", "0");
        goldEditText.setText(amountGold);

        EditText silverEditText = (EditText) findViewById(R.id.silver_EditText);
        SharedPreferences mySilver = getSharedPreferences("Silver", 0);
        String amountSilver = mySilver.getString("silver", "0");
        silverEditText.setText(amountSilver);

        EditText copperEditText = (EditText) findViewById(R.id.copper_EditText);
        SharedPreferences myCopper = getSharedPreferences("Copper", 0);
        String amountCopper = myCopper.getString("copper", "0");
        copperEditText.setText(amountCopper);

    }

    /**
     * This method increases the gold value by one
     *
     * @param view
     */

    public void goldIncrement(View view) {
        EditText goldEditText = (EditText) findViewById(R.id.gold_EditText);
        String testGoldValue = goldEditText.getText().toString();
        if ("".equals(testGoldValue)) {
            int goldValue = 0;
            goldValue = increment(goldValue);
            String value = "" + goldValue;
            goldEditText.setText(value);
        } else {
            int goldValue = Integer.parseInt(goldEditText.getText().toString());
            goldValue = increment(goldValue);
            String value = "" + goldValue;
            goldEditText.setText(value);
        }
        saveGOldData(findViewById(R.id.gold_EditText));
    }

    /**
     * This method decreases the gold value by one
     *
     * @param view
     */

    public void goldDecrement(View view) {
        EditText goldEditText = (EditText) findViewById(R.id.gold_EditText);
        String testGoldValue = goldEditText.getText().toString();
        if ("".equals(testGoldValue)) {
            int goldValue = 0;
            goldValue = decrement(goldValue);
            String value = "" + goldValue;
            goldEditText.setText(value);
        } else {
            int goldValue = Integer.parseInt(goldEditText.getText().toString());
            goldValue = decrement(goldValue);
            String value = "" + goldValue;
            goldEditText.setText(value);
        }
        saveGOldData(findViewById(R.id.gold_EditText));
    }

    /**
     * This method increases the silver value by one
     *
     * @param view
     */

    public void silverIncrement(View view) {
        EditText silverEditView = (EditText) findViewById(R.id.silver_EditText);
        String testSilverValue = silverEditView.getText().toString();
        if ("".equals(testSilverValue)) {
            int silverValue = 0;
            silverValue = increment(silverValue);
            String value = "" + silverValue;
            silverEditView.setText(value);
        } else {
            int silverValue = Integer.parseInt(silverEditView.getText().toString());
            silverValue = increment(silverValue);
            String value = "" + silverValue;
            silverEditView.setText(value);
        }
        saveSilverData(findViewById(R.id.silver_EditText));
    }

    /**
     * This method decreases the silver value by one
     *
     * @param view
     */

    public void silverDecrement(View view) {
        EditText silverEditView = (EditText) findViewById(R.id.silver_EditText);
        String testSilverValue = silverEditView.getText().toString();
        if ("".equals(testSilverValue)) {
            int silverValue = 0;
            silverValue = decrement(silverValue);
            String value = "" + silverValue;
            silverEditView.setText(value);
        } else {
            int silverValue = Integer.parseInt(silverEditView.getText().toString());
            silverValue = decrement(silverValue);
            String value = "" + silverValue;
            silverEditView.setText(value);
        }
        saveSilverData(findViewById(R.id.silver_EditText));
    }

    /**
     * This method increases the copper value by one
     *
     * @param view
     */

    public void copperIncrement(View view) {
        EditText copperEditView = (EditText) findViewById(R.id.copper_EditText);
        String testCopperValue = copperEditView.getText().toString();
        if ("".equals(testCopperValue)) {
            int copperValue = 0;
            copperValue = increment(copperValue);
            String value = "" + copperValue;
            copperEditView.setText(value);
        } else {
            int silverValue = Integer.parseInt(copperEditView.getText().toString());
            silverValue = increment(silverValue);
            String value = "" + silverValue;
            copperEditView.setText(value);
        }
        saveCopperData(findViewById(R.id.copper_EditText));
    }

    /**
     * This method decreases the copper value by one
     *
     * @param view
     */

    public void copperDecrement(View view) {
        EditText copperEditView = (EditText) findViewById(R.id.copper_EditText);
        String testCopperValue = copperEditView.getText().toString();
        if ("".equals(testCopperValue)) {
            int copperValue = 0;
            copperValue = decrement(copperValue);
            String value = "" + copperValue;
            copperEditView.setText(value);
        } else {
            int silverValue = Integer.parseInt(copperEditView.getText().toString());
            silverValue = decrement(silverValue);
            String value = "" + silverValue;
            copperEditView.setText(value);
        }
        saveCopperData(findViewById(R.id.copper_EditText));
    }


    /**
     * This method increases any value by one
     *
     * @param counterValue
     * @return counterValue
     */

    public int increment(int counterValue) {
        counterValue += 1;
        return counterValue;
    }

    /**
     * This method decreases any value by one
     *
     * @param counterValue
     * @return counterValue
     */

    public int decrement(int counterValue) {
        counterValue -= 1;
        return counterValue;
    }


    /**
     * hides softkeyboard
     *
     * @param ev
     * @return
     */

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) && view instanceof EditText && !view.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * Saves gold data
     *
     * @param view
     */

    public void saveGOldData(View view) {
        EditText goldEditText = (EditText) findViewById(R.id.gold_EditText);
        String amountGold = goldEditText.getText().toString();
        SharedPreferences myGold = getSharedPreferences("Gold", 0);
        SharedPreferences.Editor mEditor = myGold.edit();
        mEditor.putString("gold", amountGold).apply();
    }

    /**
     * Saves silver data
     *
     * @param view
     */

    public void saveSilverData(View view) {
        EditText silverEditText = (EditText) findViewById(R.id.silver_EditText);
        String amountSilver = silverEditText.getText().toString();
        SharedPreferences mySilver = getSharedPreferences("Silver", 0);
        SharedPreferences.Editor mEditor = mySilver.edit();
        mEditor.putString("silver", amountSilver).apply();
    }

    /**
     * Saves copper data
     *
     * @param view
     */

    public void saveCopperData(View view) {
        EditText copperEditText = (EditText) findViewById(R.id.copper_EditText);
        String amountCopper = copperEditText.getText().toString();
        SharedPreferences myCopper = getSharedPreferences("Copper", 0);
        SharedPreferences.Editor mEditor = myCopper.edit();
        mEditor.putString("copper", amountCopper).apply();
    }
}
