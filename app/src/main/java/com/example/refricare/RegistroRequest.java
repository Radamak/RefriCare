package com.example.refricare;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegistroRequest extends StringRequest {
    private static final String ruta = "http://mctp.mx/libro/registro.php";
    private Map<String, String> parametros;
    public RegistroRequest (String nombre, String usuario, String clave, int edad, Response.Listener<String> listener){
        super (Request.Method.POST, ruta, listener, null);
        parametros = new HashMap<>();
        parametros.put("nombre",nombre+""); //verde es el nombre de los campos de la bd
        parametros.put("usuario",usuario+"");
        parametros.put("clave",clave+"");
        parametros.put("edad",edad+"");
    }
    @Override
    protected Map<String, String> getParams(){
        return parametros;
    }
}