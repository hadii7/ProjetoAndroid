package br.com.fatecpg.qualtemp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    //as variaveis
    private Spinner spinner1, spinner2;
    //os arraylists dos spinners
    ArrayList<String> list1 = new ArrayList<String>();
    ArrayList<String> list2 = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //carregando os spinners
        addItemsOnSpinner1();
        addItemsOnSpinner2();

    }

    //metodo de validação dos campos, falta implementar
    public void removeSpinnerC() {
        list2.remove("C");
    }

    public void removeSpinnerF() {
        list1.remove("F");
    }

    public void removeSpinnerK() {
        list1.remove("K");
    }

    //carregando valores no spinner 1
    public void addItemsOnSpinner1() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);

        list1.add("Selecione o Tipo de Temperatura de Entrada");
        list1.add("C");
        list1.add("F");
        list1.add("K");
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter1);
    }

    //carregando valor no spinner 2
    public void addItemsOnSpinner2() {

        spinner2 = (Spinner) findViewById(R.id.spinner2);

        list2.add("Selecione o tipo de Temperatura de Saida");
        list2.add("C");
        list2.add("F");
        list2.add("K");
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);
    }

    //metodo de pegar o valor do spinner
    public String getSpinnerVal(int id) {
        Spinner e = (Spinner) findViewById(id);
        return e.getSelectedItem().toString();
    }

    //metodo de pegar o valor do txt
    public Double getEditVal(int id) {
        EditText T = (EditText) findViewById(id);
        return Double.parseDouble(T.getText().toString());
    }

    //Setando o valor na label
    public void setResult(String r) {
        TextView t = (TextView) findViewById(R.id.Resultado);
        t.setText(r);
    }

    //Metodo que vai no botão
    public void onClick(View view) {
//Pegando os valores dos spinners
        String r = getSpinnerVal(R.id.spinner1);
        String sp2 = getSpinnerVal(R.id.spinner2);
        //Pegando o valor da txt
        Double E = getEditVal(R.id.editText);
        //Comparação com Celsius e fahrenheit, só funciona se os dois estiverem selecionados
        if (r == "C" && sp2 == "F") {
            double res = (E * 1.8) + 32;
            Toast.makeText(getApplicationContext(), "A temperatura é: " + res + " em fahrenheit", Toast.LENGTH_LONG).show();
            String r2 = String.valueOf(res);
            setResult(r2);
        }
    }

}
