package com.example.camilomtz.Acercade;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.camilomtz.R;

import mehdi.sakout.aboutpage.AboutPage;

public class AboutFragment extends Fragment
{

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        View aboutPage = new AboutPage(getContext())
                .setDescription(getString(R.string.description))
                .isRTL(false)
                .setImage(R.drawable.cam)

                .addGroup(getString(R.string.connect_me))
                .addFacebook("camilo.martinez.3158")
                .addEmail("andresmtz199116@gmail.com")

                .create();
        return aboutPage;

    }

}