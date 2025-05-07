package mx.unam.fciencias.pocketlab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layoutExperimentos;
    private Button btnAgregar;
    private ArrayList<String> listaExperimentos; // Simulación de base de datos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutExperimentos = findViewById(R.id.layout_experimentos);
        btnAgregar = findViewById(R.id.btn_agregar_experimento);

        // Datos de prueba
        listaExperimentos = new ArrayList<>();
        listaExperimentos.add("Péndulo");
        listaExperimentos.add("Caída Libre");

        mostrarExperimentos();

        btnAgregar.setOnClickListener(v -> {
            String nuevoNombre = "Experimento " + (listaExperimentos.size() + 1);
            listaExperimentos.add(nuevoNombre);
            agregarBotonExperimento(nuevoNombre);
        });
    }

    private void mostrarExperimentos() {
        layoutExperimentos.removeAllViews();
        for (String nombre : listaExperimentos) {
            agregarBotonExperimento(nombre);
        }
    }

    private void agregarBotonExperimento(String nombre) {
        Button boton = new Button(this);
        boton.setText(nombre);
        boton.setBackgroundTintList(getResources().getColorStateList(android.R.color.holo_blue_light));
        boton.setTextColor(getResources().getColor(android.R.color.white));
        boton.setOnClickListener(v -> {
            // Aquí irías al detalle del experimento
            Toast.makeText(this, "Abriendo: " + nombre, Toast.LENGTH_SHORT).show();
        });

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 8, 0, 0);
        boton.setLayoutParams(params);

        layoutExperimentos.addView(boton);
    }
}
