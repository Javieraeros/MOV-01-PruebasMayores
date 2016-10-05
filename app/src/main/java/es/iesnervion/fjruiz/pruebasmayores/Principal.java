package es.iesnervion.fjruiz.pruebasmayores;

import android.graphics.Color;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Principal extends AppCompatActivity implements View.OnClickListener
                                                            ,RadioGroup.OnCheckedChangeListener{

    Button sum,aliz,alde,disminuir,aumentar;
    EditText et1,et2,et3;
    TextView tv;
    RadioGroup rg;

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
        rg.setOnCheckedChangeListener(this);
        et3=(EditText) findViewById(R.id.editText3);

        aliz=(Button) findViewById(R.id.alineaiz);
        aliz.setOnClickListener(this);
        alde=(Button) findViewById(R.id.alineade);
        alde.setOnClickListener(this);

        //disminuir
    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.button:
                Double res=Double.parseDouble(et1.getText().toString())
                        +
                        Double.parseDouble(et2.getText().toString());
                tv.setText(res.toString());
                return;
            case R.id.alineaiz:
                et3.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
                return;

            case R.id.alineade:
                et3.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
                return;
        }
    }

    public void onCheckedChanged(RadioGroup rg,int i){
        switch (i){
            case R.id.rbVerde:
                et3.setTextColor(Color.GREEN);
                return;
            case R.id.rbAzul:
                et3.setTextColor(Color.BLUE);
                return;
            case R.id.rbRojo:
                et3.setTextColor(Color.RED);
                return;
        }
    }
}
