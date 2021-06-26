package rios.miriam.asignacion4_calculadoraimc_anarios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var estatura: EditText ;
        var peso: EditText ;
        var resultado: TextView ;
        var veredicto: TextView ;

        val btnCalcular : Button= findViewById(R.id.btnCalcular) as Button;

        btnCalcular.setOnClickListener(){
            estatura = findViewById(R.id.etEstatura) as EditText;
            peso= findViewById(R.id.etPeso) as EditText;
            resultado= findViewById(R.id.tvResultado) as TextView;
            veredicto = findViewById(R.id.tvVeredicto) as TextView;

            //Verificar campos vacios
            if(estatura.getText().toString().equals("") || peso.getText().toString().equals("") ){
                var toast: Toast = Toast.makeText(applicationContext,resources.getString(R.string.camposVaciosAdvertencia),Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM,0,0);
                toast.show();
            }else{
                var imc = calcularIMC(peso.getText().toString().toFloat(),estatura.getText().toString().toFloat());

                if(imc.compareTo(18.5f)<0){
                    resultado.setText(imc.toString());
                    veredicto.setText(resources.getText(R.string.veredictoBP));
                    veredicto.setBackgroundResource(R.color.colorGreenish);
                }else if(imc.compareTo(24.9f)<0){
                    resultado.setText(imc.toString());
                    veredicto.setText(resources.getText(R.string.veredictoN));
                    veredicto.setBackgroundResource(R.color.colorGreen);
                }else if(imc.compareTo(29.9f)<0){
                    resultado.setText(imc.toString());
                    veredicto.setText(resources.getText(R.string.veredictoSP));
                    veredicto.setBackgroundResource(R.color.colorYellow);
                }else if(imc.compareTo(34.9f)<0){
                    resultado.setText(imc.toString());
                    veredicto.setText(resources.getText(R.string.veredictoOG1));
                    veredicto.setBackgroundResource(R.color.colorOrange);
                }else if(imc.compareTo(39.9f)<0){
                    resultado.setText(imc.toString());
                    veredicto.setText(resources.getText(R.string.veredictoOG2));
                    veredicto.setBackgroundResource(R.color.colorRed);
                }else if(imc.compareTo(39.9f)>0){
                    resultado.setText(imc.toString());
                    veredicto.setText(resources.getText(R.string.veredictoOG3));
                    veredicto.setBackgroundResource(R.color.colorBrown);
                }else{
                    println("Error en cálculo")
                }

            }

        }

    }

    //Funcion para calcular IMC
    fun calcularIMC(kilos: Float, estatura: Float): Float{ return (kilos/(estatura*estatura)) }
    fun resetearValores(){

    };
}
