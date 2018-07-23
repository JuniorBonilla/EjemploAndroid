package com.example.user.ejercicioxamp;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

public class MainActivity extends AppCompatActivity {
    EditText txtDocumento,txtNombre,txtEdad,txtProfesion;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         txtDocumento= (EditText) findViewById(R.id.txtDocumento);
         txtNombre= (EditText) findViewById(R.id.txtNombre);
        txtEdad= (EditText) findViewById(R.id.txtEdad);
         txtProfesion= (EditText) findViewById(R.id.txtProfesion);
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);



    }
    public void mtdRegistrar(View V){
        String Nombre= txtNombre.getText().toString();
        int Documento= Integer.parseInt(txtDocumento.getText().toString());
        int Edad= Integer.parseInt(txtEdad.getText().toString());
        String Profesion=txtProfesion.getText().toString();
        try {

            String url = "http://10.16.238.174:8080/servicioadsi/RegistrarPersonal.php?documento=" + Documento + "&nombres=" + Nombre + "&edad=" + Edad
                    +  "&profesion=" + Profesion;
            url = url.replace(" ", "%20");
            HttpClient objclient = new DefaultHttpClient();
            HttpGet object = new HttpGet(url);
            ResponseHandler<String> rh = new BasicResponseHandler();
            objclient.execute(object, rh);
            Toast.makeText(this,"persona registrada",Toast.LENGTH_SHORT).show();

        }catch (Exception e ){
            Toast.makeText(this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
