package com.example.midterm07600452;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.midterm07600452.Model.Auth;

public class LoginActivity extends AppCompatActivity {
    private static final String EMAIL = "1234";
    private static final String PASSWORD = "5678";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText userEdittext = findViewById(R.id.editText);
        EditText passwordEdittext = findViewById(R.id.editText2);
        String inputuser = userEdittext.getText().toString();
        String inputpass = passwordEdittext.getText().toString();
        Auth auth = new Auth(inputuser, inputpass);
        final boolean result = auth.check();
        if (result) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("aaa", inputuser);
            startActivity(intent);
            finish();
            Toast.makeText(LoginActivity.this, "ยินดีต้อนรับ", Toast.LENGTH_SHORT).show();
        } else {
            AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this);
            dialog.setTitle("Error");
            dialog.setMessage("Invalid email or password");
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            }).show();

        }
    }
}
