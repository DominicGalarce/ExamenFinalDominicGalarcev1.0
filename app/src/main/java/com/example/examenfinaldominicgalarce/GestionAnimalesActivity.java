package com.example.examenfinaldominicgalarce;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.examenfinaldominicgalarce.database.AdminSQLiteOpenHelper;

public class GestionAnimalesActivity extends AppCompatActivity {

    private EditText ficha, nombre, tipo, edad, enfermedad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_animales);

        ficha = findViewById(R.id.ficha);
        nombre = findViewById(R.id.nombre);
        tipo = findViewById(R.id.tipo);
        edad = findViewById(R.id.edad);
        enfermedad = findViewById(R.id.enfermedad);
    }

    public void guardarFicha(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getBaseContext(), "VeticalCare", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String nFicha = ficha.getText().toString();
        String name = nombre.getText().toString();
        String tipe = tipo.getText().toString();
        String age = edad.getText().toString();
        String enf = enfermedad.getText().toString();

        if (!nFicha.isEmpty() && !name.isEmpty() && !tipe.isEmpty() && !age.isEmpty() && !enf.isEmpty()) {

            ContentValues cont = new ContentValues();
            cont.put("ficha", nFicha);
            cont.put("nombre", name);
            cont.put("tipo", tipe);
            cont.put("edad", age);
            cont.put("enfermedad", enf);

            db.insert("fichas", null, cont);
            Clean();
            db.close();
            Toast.makeText(getBaseContext(), "Se ha insertado la ficha", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getBaseContext(), "debe rellenar los campos", Toast.LENGTH_LONG).show();
        }

    }

    private void Clean() {
        ficha.setText("");
        nombre.setText("");
        tipo.setText("");
        edad.setText("");
        enfermedad.setText("");
    }

    public void mostrarFicha(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getBaseContext(), "VeticalCare", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String nFicha = ficha.getText().toString();


        if (!nFicha.isEmpty()) {

            Cursor file =
                    db.rawQuery("SELECT nombre, tipo, edad, enfermedad FROM fichas WHERE ficha=" + nFicha, null);

            if (file.moveToFirst()) {
                nombre.setText(file.getString(0));
                tipo.setText(file.getString(1));
                edad.setText(file.getString(2));
                enfermedad.setText(file.getString(3));
            } else {
                Toast.makeText(getBaseContext(), "no hay ficha asociada", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getBaseContext(), "el numero de ficha no debe ir vacio", Toast.LENGTH_LONG).show();
        }
    }

    public void eliminarFicha(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getBaseContext(), "VeticalCare", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String nFicha = ficha.getText().toString();


        if (!nFicha.isEmpty() ) {

            ContentValues cont = new ContentValues();

            cont.put("ficha", nFicha);
            

            db.delete("fichas", "ficha"+nFicha,null);
            Clean();
            db.close();
            Toast.makeText(getBaseContext(), "Se ha eliminado la ficha", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getBaseContext(), "debe rellenar los campos", Toast.LENGTH_LONG).show();
        }

    }
}