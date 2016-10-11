package es.iesnervion.fjruiz.pruebasmayores;

import android.graphics.Color;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity implements View.OnClickListener
        , RadioGroup.OnCheckedChangeListener {

    private Button sum, aliz, alde, disminuir, aumentar;
    private Button atras, siguiente;
    private EditText et1, et2, et3;
    private Toast toast;
    private TextView tv;
    private RadioGroup rg;
    private ImageView fotos;

    private int[] imagenes=new int[7];
    private int etiqueta;  //Aqui guardamos el indice del array de la foto actual

    private ImageButton cambiaImg;

    /**
     * Método que nos inicializa las variables al abrir la aplicación
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        sum = (Button) findViewById(R.id.button);
        sum.setOnClickListener(this);
        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        tv = (TextView) findViewById(R.id.Resultado);


        rg = (RadioGroup) findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(this);
        et3 = (EditText) findViewById(R.id.editText3);

        aliz = (Button) findViewById(R.id.alineaiz);
        aliz.setOnClickListener(this);
        alde = (Button) findViewById(R.id.alineade);
        alde.setOnClickListener(this);

        disminuir = (Button) findViewById(R.id.reduce);
        disminuir.setOnClickListener(this);
        aumentar = (Button) findViewById(R.id.aumenta);
        aumentar.setOnClickListener(this);

        atras = (Button) findViewById(R.id.atrás);
        atras.setOnClickListener(this);
        siguiente = (Button) findViewById(R.id.siguiente);
        siguiente.setOnClickListener(this);
        fotos=(ImageView) findViewById(R.id.imagen);

        imagenes[0]=R.drawable.bajo;
        imagenes[1]=R.drawable.baritono;
        imagenes[2]=R.drawable.tenor;
        imagenes[3]=R.drawable.alto;
        imagenes[4]=R.drawable.soprano;
        imagenes[5]=R.drawable.sopranino;
        imagenes[6]=R.drawable.soprillo;

        fotos.setImageResource(imagenes[3]);
        fotos.setTag(3);

        cambiaImg=(ImageButton) findViewById(R.id.cambiaImagen);
        cambiaImg.setImageResource(R.drawable.manoarriba);
        cambiaImg.setTag(0); //0 para mano arriba, 1 para mano abajo
        cambiaImg.setOnClickListener(this);

    }

    /**
     * Método que al ahcer click en un botón se activa realizando diferentes funciones
     * especificadas abajo
     * @param v= la vista que llama al método
     */
    public void onClick(View v) {
        switch (v.getId()) {
            //Suma dos números
            //Muestra toast en caso de no poner números
            case R.id.button:
                Double num1,num2,res;
                try {
                    num1=Double.parseDouble(et1.getText().toString());
                    num2=Double.parseDouble(et2.getText().toString());
                    res = num1+num2;
                    tv.setText(res.toString());
                }catch(NumberFormatException e){
                    toast=Toast.makeText(getApplicationContext(),e.toString(), Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                }
                break;
            //Alinea el texto a la izquierda
            case R.id.alineaiz:
                et3.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
                break;
            //Alinea el texto a al derecha
            case R.id.alineade:
                et3.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
                break;
            //Aumenta el texto 1 pixel
            case R.id.aumenta:
                et3.setTextSize(0, et3.getTextSize() + 1);
                break;
            //Disminuye el texto 1 pixel
            case R.id.reduce:
                et3.setTextSize(0, et3.getTextSize() - 1);
                break;
            //vuelve a la imagen anterior de saxofón
            case R.id.atrás:
                etiqueta=(int) fotos.getTag();
                if(etiqueta!=0) {
                    fotos.setImageResource(imagenes[etiqueta-1]);
                    //Cambiamos el valor de la etiqueta
                    fotos.setTag(etiqueta-1);
                }else{
                    //En caso de que sea la primera imagen, volvemos a la última
                    fotos.setImageResource(imagenes[6]);
                    fotos.setTag(6);
                }
                break;
            //Pasa a la siguiente imagen de saxofón
            case R.id.siguiente:
                etiqueta=(int) fotos.getTag();
                if(etiqueta!=6) {
                    fotos.setImageResource(imagenes[etiqueta+1]);
                    //Cambiamos el valor de la etiqueta
                    fotos.setTag(etiqueta+1);
                }else{
                    //En caso de que sea la última imagen, volvemos a la primera
                    fotos.setImageResource(imagenes[0]);
                    fotos.setTag(0);
                }
                break;

            //Cambia la imagen del pulgar
            case R.id.cambiaImagen:
                if((int)cambiaImg.getTag()==0){
                    cambiaImg.setImageResource(R.drawable.manoabajo);
                    cambiaImg.setTag(1);
                }else{
                    cambiaImg.setImageResource(R.drawable.manoarriba);
                    cambiaImg.setTag(0);
                }
                break;

        }
    }

    /**
     * Método que comprueba si un RadioButton ah sido cambiado
     * @param rg
     * @param i
     */
    public void onCheckedChanged(RadioGroup rg, int i) {
        switch (i) {
            case R.id.rbVerde:
                et3.setTextColor(Color.GREEN);
                break;
            case R.id.rbAzul:
                et3.setTextColor(Color.BLUE);
                break;
            case R.id.rbRojo:
                et3.setTextColor(Color.RED);
                break;
        }
    }
}
