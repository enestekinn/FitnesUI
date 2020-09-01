package com.example.fitnesui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnesui.FitnessMove;
import com.example.fitnesui.PopupActivity;
import com.example.fitnesui.R;
import com.example.fitnesui.recyclerview.FitnessPictureAdapter;

import java.util.ArrayList;

public class FitnessPicturesClass extends Fragment  implements FitnessPictureAdapter.MyListener{

    private FitnessPictureAdapter fitnessPictureAdapter;
    private  RecyclerView recyclerView;
    private ArrayList<FitnessMove> fitnessMoves;

    public static FitnessPicturesClass  newInstance() {
return new  FitnessPicturesClass();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_fitness_pictures, container, false);

        fitnessPictureAdapter =  new FitnessPictureAdapter((AppCompatActivity) getActivity(),this);

        fitnessMoves = fitnessPictureAdapter.getFitnessMoves();
        recyclerView = rootview.findViewById(R.id.fragment_fitness_pictures_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        if (isAdded()) {
            recyclerView.setAdapter(fitnessPictureAdapter);
getFitnessMoves(fitnessMoves);
        }
        return rootview;
    }

    private ArrayList<FitnessMove> getFitnessMoves(ArrayList<FitnessMove> fitnessMoves) {
        for (int i = 0 ; i<17;i++) {
            fitnessMoves.add(new FitnessMove("Fitness Move Name 1 "
                    ,"http://www.atilsamancioglu.com/wp-content/uploads/2018/06/fitness"+i+".jpg","Firnes Move Description",100));
        }

        return fitnessMoves;
    }

    @Override
    public void MyListener(FitnessMove fitnessMove) {
        System.out.println("Fitness move: "+ fitnessMove.getFitnessName());

        Intent intent = PopupActivity.newIntent(getActivity(),fitnessMove);
        startActivity(intent);
    }
}
