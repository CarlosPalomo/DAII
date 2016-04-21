package mx.edu.utng.manualhtml5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Carlos on 22/03/2016.
 */
public class ContenidoActivity extends Activity implements AdapterView.OnItemSelectedListener{
    //se delara el spinner
    private Spinner cboTemas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenido);
        initComponents();
    }

    public void initComponents(){
        //llama a los temas para mostrarlos en el sppiner
        cboTemas=(Spinner)findViewById(R.id.cbo_temas);
        ArrayAdapter adapter= ArrayAdapter.createFromResource(this, R.array.temas, android.R.layout.simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cboTemas.setAdapter(adapter);
        cboTemas.setOnItemSelectedListener(this);
    }
//Mandar al contenido tematico
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 1:
                startActivity(new Intent(this, EstructuraGlobalActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, EstructuraCuerpoActivity.class));
                break;
            case 3:
                startActivity(new Intent(this, DentroCuerpoActivity.class));
                break;
            case 4:
                startActivity(new Intent(this, NuevosViejosElementosActivity.class));
                break;
            case 5:
                startActivity(new Intent(this, RefererenciaRapidaActivity.class));
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
