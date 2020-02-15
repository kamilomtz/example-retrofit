package com.example.camilomtz.mascotas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.camilomtz.R;
import com.example.camilomtz.bibliotecas.AdapterBibliotecas;
import com.example.camilomtz.bibliotecas.FragmentBibliotecas;
import com.example.camilomtz.bibliotecas.InterfaceDatCol;
import com.example.camilomtz.bibliotecas.ModelBibliotecas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class FragmentPet extends Fragment {

}