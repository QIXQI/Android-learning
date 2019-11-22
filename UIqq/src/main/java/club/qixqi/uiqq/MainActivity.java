package club.qixqi.uiqq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 下拉列表数据源
        spinner1 = (Spinner) this.findViewById(R.id.department);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, getDataSource());
        spinner1.setAdapter(adapter);

        Button button1 = (Button) this.findViewById(R.id.register);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);
            }
        });



        // 隐藏密码
        EditText password = (EditText) findViewById(R.id.password);
        // 显示密码
        // password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        // 隐藏密码
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());

    }

    public List<String> getDataSource(){
        List<String> list = new ArrayList<String>();
        list.add("销售部");
        list.add("技术部");
        list.add("人事部");
        list.add("财务部");
        return list;
    }

}
