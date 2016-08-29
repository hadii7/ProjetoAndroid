package br.com.fatecpg.qualtemp;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.text.NumberFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //as variaveis
    private Spinner spinner1, spinner2;
    private double res;
    //os arraylists dos spinners
    ArrayList<String> list1 = new ArrayList<String>();
    ArrayList<String> list2 = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Icone na barra de titulo
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        //carregando os spinners
        addItemsOnSpinner1();

        //Verifica a escala selecionada no spinner 1 para retirar a mesma escola do spinner2
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                addItemsOnSpinner2();
                if(spinner1.getSelectedItem() == "Selecione a escala de Entrada"){
                        //Faz nada ao selecionar o texto de hint
                }else{
                    String spn1Content =  spinner1.getSelectedItem().toString();
                    list2.remove(spn1Content);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    //carregando valores no spinner 1
    public void addItemsOnSpinner1() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        list1.add("Selecione a escala de Entrada");
        list1.add("Celsius");
        list1.add("Fahrenheit");
        list1.add("Kelvin");
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter1);
        spinner1.setSelection(0);
    }

    //carregando valor no spinner 2
    public void addItemsOnSpinner2() {
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        list2.clear();
        list2.add("Selecione a escala de Saida");
        list2.add("Celsius");
        list2.add("Fahrenheit");
        list2.add("Kelvin");
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list2);
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
        t.setVisibility(View.VISIBLE);
        t.setText(r);
    }

    //Metodo que vai no botão
    public void onClick(View view) {
        //Pegando os valores dos spinners
        String sp1 = getSpinnerVal(R.id.spinner1);
        String sp2 = getSpinnerVal(R.id.spinner2);

        try {
            //Pegando o valor da txt
            Double E = getEditVal(R.id.editText);
            String out;
                //Comparação das selecoes dos spinners e realiza o calculo
                if (sp1.equals("Celsius") && sp2.equals("Fahrenheit")) {
                    res = (E * 1.8) + 32;
                    out = "º " + sp2.substring(0,1);
                } else if (sp1.equals("Celsius") && sp2.equals("Kelvin")) {
                    res = E + 273.15;
                    out = " " + sp2.substring(0,1);
                } else if (sp1.equals("Fahrenheit") && sp2.equals("Celsius")) {
                    res = (E - 32) / 1.8;
                    out = "º " + sp2.substring(0,1);
                } else if (sp1.equals("Fahrenheit") && sp2.equals("Kelvin")) {
                    res = ((E - 32) / 1.8) + 273.15;
                    out = " " + sp2.substring(0,1);
                } else if (sp1.equals("Kelvin") && sp2.equals("Fahrenheit")) {
                    res = ((E - 273.15) * 1.8) + 32;
                    out = "º " + sp2.substring(0,1);
                } else if (sp1.equals("Kelvin") && sp2.equals("Celsius")) {
                    res = E - 273.15;
                    out = "º " + sp2.substring(0,1);
                } else {
                    Toast.makeText(getApplicationContext(), "Selecione Alguma Escala", Toast.LENGTH_LONG).show();
                    return;
                }

            String r2 = String.valueOf(NumberFormat.getInstance().format(res));
            setResult(r2 + out);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Digite alguma Temperatura", Toast.LENGTH_LONG).show();
        }
        }

        public void easter (View view){
            new AlertDialog.Builder(this).setMessage("Create By: \n\nEvellyn \n\nJulio \n\nMarcos \n\nMatheus \n\nRodrigo").setPositiveButton("Ok", null).show();
        }
    }


