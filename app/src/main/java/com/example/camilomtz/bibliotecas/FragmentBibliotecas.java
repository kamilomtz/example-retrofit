package com.example.camilomtz.bibliotecas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.camilomtz.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentBibliotecas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentBibliotecas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentBibliotecas extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private AdapterBibliotecas adapter;
    private RecyclerView recyclerView;

    public FragmentBibliotecas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentBibliotecas.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentBibliotecas newInstance(String param1, String param2) {
        FragmentBibliotecas fragment = new FragmentBibliotecas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root  = inflater.inflate(R.layout.fragment_bibliotecas, container, false);

        recyclerView = root.findViewById(R.id.recycler_bibliotecas);

        getData();

        return root;
    }

    private void getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(InterfaceDatCol.JSONURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        InterfaceDatCol api = retrofit.create(InterfaceDatCol.class);

        Call<String> call = api.getBibliotecas();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    String jsonresponse = response.body().toString();
                    writeRecycler(jsonresponse);

                }else{
                    Log.e(TAG,"onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }

        });
    }

    private void writeRecycler(String ans) {
        try {

            JSONObject obj = new JSONObject(ans);
            if(obj.optString("status").equals("true")){

                ArrayList<ModelBibliotecas> modelRecyclerArrayList = new ArrayList<>();
                JSONArray dataArray  = obj.getJSONArray("data");

                for (int i = 0; i < dataArray.length(); i++) {

                    ModelBibliotecas modelRecycler = new ModelBibliotecas();
                    JSONObject dataobj = dataArray.getJSONObject(i);

                    modelRecycler.setNombre(dataobj.getString("nombre"));
                    modelRecycler.setDepartamento(dataobj.getString("departamento"));
                    modelRecycler.setMunicipio(dataobj.getString("municipio"));
                    modelRecycler.setBarrio(dataobj.getString("barrio"));
                    modelRecycler.setDireccion(dataobj.getString("direccion"));
                    modelRecycler.setTelefono(dataobj.getString("telefono"));

                    modelRecyclerArrayList.add(modelRecycler);

                }

                adapter = new AdapterBibliotecas(getContext(), modelRecyclerArrayList);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

            }else {
                Toast.makeText(getContext(), obj.optString("message")+"", Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
