package es.iesnervion.fjruiz.pruebasmayores;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Principal extends AppCompatActivity implements View.OnClickListener {

    Button sum;
    EditText et1,et2,et3;
    TextView tv;
    RadioGroup rg;
    RadioButton rbVerde,rbAzul,rbRojo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        sum=(Button) findViewById(R.id.button);
        sum.setOnClickListener(this);
        et1=(EditText) findViewById(R.id.editText);
        et2=(EditText) findViewById(R.id.editText2);
        tv=(TextView) findViewById(R.id.Resultado);
        rg=(RadioGroup) findViewById(R.id.rg);
        //rbVerde=(RadioButton) findViewById(R.id.rbVerde);
        rbRojo=(RadioButton) findViewById(R.id.rbRojo);
        rbAzul=(RadioButton) findViewById(R.id.rbAzul);
        et3=(EditText) findViewById(R.id.editText3);
    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.button:
                Double res=Double.parseDouble(et1.getText().toString())
                        +
                        Double.parseDouble(et2.getText().toString());
                tv.setText(res.toString());
                return;
            case R.id.rg:
                switch (rg.getCheckedRadioButtonId()){
                    case R.id.rbVerde:
                        et3.setTextColor(2552550);
                        return;

                }
                return;

        }
    }
}
