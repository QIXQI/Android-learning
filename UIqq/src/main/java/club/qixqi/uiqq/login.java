package club.qixqi.uiqq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(login.this, "用户点击了登录", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(login.this, success.class);
                startActivity(intent);

            }
        });

        Button finishButton = (Button) findViewById(R.id.finish);
        finishButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });


        // 隐藏密码
        EditText password = (EditText) findViewById(R.id.password);
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());

    }
}
