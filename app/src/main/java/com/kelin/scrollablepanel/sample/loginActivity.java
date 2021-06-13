package com.kelin.scrollablepanel.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

class logincheck {
    private String user = "1";
    private String passwd = "2";

    private String userin = "";
    private  String passwdin = "";

    private boolean login_status = false;


    public logincheck(String userin, String passwdin) {
        this.userin = userin;
        this.passwdin = passwdin;
    }


    public boolean check()
    {
        if(user.equals(userin) && passwd.equals(passwdin) )
        {
            login_status = true;

        }
        return login_status;
    }
}
public class loginActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    public void onLogin(View view)
    {
//        Toast.makeText(loginActivity.this, "你单击了登陆按钮", Toast.LENGTH_SHORT).show();

        EditText username_edtx = (EditText)findViewById(R.id.username);
        String username = username_edtx.getText().toString();

        EditText passwd_edtx = (EditText)findViewById(R.id.password);
        String passwd = passwd_edtx.getText().toString();

        logincheck auth = new logincheck(username, passwd);

        boolean login_status = auth.check();
        if(login_status)
        {
            Toast.makeText(loginActivity.this, "successfully login ", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(loginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();

        }
        else
        {
            Toast.makeText(loginActivity.this, "login failed", Toast.LENGTH_SHORT).show();
        }
        //finish();
    }
}