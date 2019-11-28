package club.qixqi.uiqq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class login extends AppCompatActivity implements View.OnClickListener {

    private DatabaseHelper dbHelper;

    private EditText idText;
    private EditText passText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new DatabaseHelper(this, "QixQi.db", null, 3);

        idText = (EditText) findViewById(R.id.username);
        passText = (EditText) findViewById(R.id.password);

        Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(this);

        Button finishButton = (Button) findViewById(R.id.finish);
        finishButton.setOnClickListener(this);

        TextView non = (TextView) findViewById(R.id.non);
        non.setOnClickListener(this);

        TextView news = (TextView) findViewById(R.id.news);
        news.setOnClickListener(this);

        TextView tiktok = (TextView) findViewById(R.id.tiktok);
        tiktok.setOnClickListener(this);

        // 隐藏密码
        EditText password = (EditText) findViewById(R.id.password);
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());

    }


    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.login:
                // Intent intent = new Intent(login.this, success.class);
                // startActivity(intent);
                // Toast.makeText(login.this, "用户点击了登录", Toast.LENGTH_SHORT).show();
                if(userLogin()){
                    Intent success_intent = new Intent(login.this, success.class);
                    startActivity(success_intent);
                }else{
                    idText.setText("");
                    passText.setText("");
                    Toast.makeText(login.this, "登录失败，账号或密码错误", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.finish:
                finish();
                break;
            case R.id.non:
                Toast.makeText(login.this, "你为什么无法登录呀", Toast.LENGTH_SHORT).show();
                break;
            case R.id.news:
                Intent register_intent = new Intent(login.this, register.class);
                startActivity(register_intent);
                break;
            case R.id.tiktok:
                Intent tiktok_intent = new Intent(login.this, TikTok.class);
                startActivity(tiktok_intent);
                break;
        }
    }


    private boolean userLogin(){
        String id = idText.getText().toString();
        String password = passText.getText().toString();

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("user", null, "id = ? and password = ?",
                new String[]{id, password}, null, null, null);
        if(cursor.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }

}
