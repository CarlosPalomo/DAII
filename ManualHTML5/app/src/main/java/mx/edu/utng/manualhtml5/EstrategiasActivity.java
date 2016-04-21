package mx.edu.utng.manualhtml5;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Carlos on 03/04/2016.
 */
public class EstrategiasActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estrategias_activity);
        /**
         * se declaran los botones para hacer referencia a las paginas
         * de internet
         */
        Button btnLink1=(Button)findViewById(R.id.link1);
        Button btnLink2=(Button)findViewById(R.id.link2);
        Button btnLink3=(Button)findViewById(R.id.link3);
/**
 * se hace referencia a una pagina de internet
 */
        btnLink1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="http://elcentrohtml5.sourceforge.net/Aprenda-HTML5-en-5-minutos";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        btnLink2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="http://www.soluciones4web.com/40-plantillas-gratis-html5-css3/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        btnLink3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.arkaitzgarro.com/html5/capitulo-18.html";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
    }

