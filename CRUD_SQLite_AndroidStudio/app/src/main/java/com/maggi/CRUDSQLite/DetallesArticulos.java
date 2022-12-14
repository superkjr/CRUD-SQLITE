package com.maggi.CRUDSQLite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DetallesArticulos extends AppCompatActivity {

    private TextView tv_codigo, tv_descripcion, tv_precio, tv_idcegoria;
    private TextView tv_codigo1, tv_descripcion1, tv_precio1, tv_fecha, tv_idcegoria1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_articulos);

        tv_codigo = (TextView) findViewById(R.id.tv_codigo);
        tv_descripcion = (TextView) findViewById(R.id.tv_descripcion);
        tv_precio = (TextView) findViewById(R.id.tv_precio);
        tv_idcegoria = (TextView) findViewById(R.id.tv_idCat);

        tv_codigo1 = (TextView) findViewById(R.id.tv_codigo1);
        tv_descripcion1 = (TextView) findViewById(R.id.tv_descripcion1);
        tv_precio1 = (TextView) findViewById(R.id.tv_precio1);
        tv_fecha = (TextView) findViewById(R.id.tv_fecha);
        tv_idcegoria1 = (TextView) findViewById(R.id.tv_idcat2);

        Bundle objeto = getIntent().getExtras();
        Dto dto = null;
        if (objeto != null) {
            dto = (Dto) objeto.getSerializable("tb_productos");
            tv_codigo.setText("" + dto.getCodigo());
            tv_descripcion.setText(dto.getDescripcion());
            tv_precio.setText(String.valueOf(dto.getPrecio()));
            tv_idcegoria.setText(String.valueOf(dto.getIdcategoria()));

            tv_codigo1.setText("" + dto.getCodigo());
            tv_descripcion1.setText(dto.getDescripcion());
            tv_precio1.setText(String.valueOf(dto.getPrecio()));
            tv_idcegoria1.setText(String.valueOf(dto.getIdcategoria()));
            tv_fecha.setText("Fecha de creacion" + getDateTime());
        }
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss a", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}