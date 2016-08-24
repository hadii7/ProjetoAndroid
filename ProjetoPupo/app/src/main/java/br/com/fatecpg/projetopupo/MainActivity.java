package br.com.fatecpg.projetopupo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Set;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public double getEditValue(int id) {
        EditText e = (EditText) findViewById(id);
        return Double.parseDouble(e.getText().toString());
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.Cel1:
                if (checked) {
                    View C = findViewById(R.id.Cel2);
                    C.setVisibility(View.INVISIBLE);
                    View F = findViewById(R.id.F2);
                    F.setVisibility(View.VISIBLE);
                    View K = findViewById(R.id.K2);
                    K.setVisibility(View.VISIBLE);
                    break;
                }
            case R.id.F:
                if (checked) {
                    View C = findViewById(R.id.Cel2);
                    C.setVisibility(View.VISIBLE);
                    View F = findViewById(R.id.F2);
                    F.setVisibility(View.INVISIBLE);
                    View K = findViewById(R.id.K2);
                    K.setVisibility(View.VISIBLE);
                    break;
                }
            case R.id.K:
                if (checked) {
                    View C = findViewById(R.id.Cel2);
                    C.setVisibility(View.VISIBLE);
                    View F = findViewById(R.id.F2);
                    F.setVisibility(View.VISIBLE);
                    View K = findViewById(R.id.K2);
                    K.setVisibility(View.INVISIBLE);
                    break;
                }
        }
    }
    public void setResult(String op,double r) {
        TextView t = (TextView) findViewById(R.id.Resultado);
        t.setText(op+ ":"+ r);
    }
    //Converter de Celsius para F
    public void converter(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        double n1 = getEditValue(R.id.editText);
        double r = (n1 * 1.8) + 32;
        setResult("O resultado é: ",r);
//erro aqui
// switch (view.getId()) {
   //       case R.id.F2:
     //           if (checked) {

       //         }

        //}
    }
}