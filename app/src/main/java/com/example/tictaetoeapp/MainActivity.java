package com.example.tictaetoeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tictaetoeapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
private final ArrayList<int[]> combinationalList = new ArrayList<>();
private int playerTurn =1;
private int totalSelection =1;
private int boxPosition[] ={0,0,0,0,0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        combinationalList.add(new int[] {0,1,2});
        combinationalList.add(new int[] {3,4,5});
        combinationalList.add(new int[] {6,7,8});
        combinationalList.add(new int[] {0,3,6});
        combinationalList.add(new int[] {1,4,7});
        combinationalList.add(new int[] {2,5,8});
        combinationalList.add(new int[] {2,4,6});
        combinationalList.add(new int[] {0,4,8});

        String getPlayerOneName = getIntent().getStringExtra("playerOne");
        String getPlayerTwoName = getIntent().getStringExtra("playerTwo");


        binding.playerOneName.setText(getPlayerOneName);
        binding.playerTwoName.setText(getPlayerTwoName);

        binding.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(0)){
                    performAction((ImageView) v, 0);
                }
            }
        });



        binding.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(1)){
                    performAction((ImageView) v, 1);
                }
            }
        });


        binding.image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(2)){
                    performAction((ImageView) v, 2);
                }
            }
        });

        binding.image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(3)){
                    performAction((ImageView) v, 3);
                }
            }
        });

        binding.image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(4)){
                    performAction((ImageView) v, 4);
                }
            }
        });

        binding.image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(5)){
                    performAction((ImageView) v, 5);
                }
            }
        });


        binding.image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(6)){
                    performAction((ImageView) v, 6);
                }
            }
        });

        binding.image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(7)){
                    performAction((ImageView) v, 7);
                }
            }
        });

        binding.image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(8)){
                    performAction((ImageView) v, 8);
                }
            }
        });
    }

    private void performAction(ImageView imageview, int selctedBoxPosition){
        boxPosition[selctedBoxPosition]= playerTurn;

        if (playerTurn==1){
            imageview.setImageResource(R.drawable.x_image);
            if(checkResult()){
               DailogBox dailogBox = new DailogBox(MainActivity.this, binding.playerOneName.getText().toString()+" is the winner", MainActivity.this);
               dailogBox.setCancelable(false);
               dailogBox.show();
            }else if (totalSelection ==9){
                DailogBox dailogBox = new DailogBox(MainActivity.this, "Match Draww", MainActivity.this);
                dailogBox.setCancelable(false);
                dailogBox.show();
            }else{
                changePlayerTurn(2);
                totalSelection++;
            }
        }else{
            imageview.setImageResource(R.drawable.zero_image);
            if(checkResult()){
                DailogBox dailogBox = new DailogBox(MainActivity.this, binding.playerTwoName.getText().toString()+" is the winner",MainActivity.this);
                dailogBox.setCancelable(false);
                dailogBox.show();
            }else if(totalSelection ==9){
                DailogBox dailogBox = new DailogBox(MainActivity.this, " match draww!", MainActivity.this);
                dailogBox.setCancelable(false);
                dailogBox.show();
            }else{
                changePlayerTurn(1);
                totalSelection++;
            }
        }
    }

    private void changePlayerTurn(int currentPlayerTurn){
        playerTurn = currentPlayerTurn;
        if(playerTurn ==1){
            binding.playerOneLayout.setBackgroundResource(R.drawable.black_border);
            binding.playerTwoLayout.setBackgroundResource(R.drawable.white_box);

        }else{
            binding.playerTwoLayout.setBackgroundResource(R.drawable.black_border);
            binding.playerOneLayout.setBackgroundResource(R.drawable.white_box);
        }
    }

    private Boolean checkResult(){
        boolean response = false;
        for(int i =0;i<combinationalList.size();i++){
            final int combination[] = combinationalList.get(i);
            if(boxPosition[combination[0]]==playerTurn && boxPosition[combination[1]]==playerTurn && boxPosition[combination[2]] == playerTurn){
                response =true;
            }

        }
        return  response;
    }

    private boolean isBoxSelectable(int boxPositions){
        boolean response = false;
        if(boxPosition[boxPositions]==0){
            response =true;
        }
        return response;
    }

    public void restartMatch(){
        boxPosition = new int[] {0,0,0,0,0,0,0,0,0};
        playerTurn =1;
        totalSelection =1;

        binding.image1.setImageResource(R.drawable.white_box);
        binding.image2.setImageResource(R.drawable.white_box);
        binding.image3.setImageResource(R.drawable.white_box);
        binding.image4.setImageResource(R.drawable.white_box);
        binding.image5.setImageResource(R.drawable.white_box);
        binding.image6.setImageResource(R.drawable.white_box);
        binding.image7.setImageResource(R.drawable.white_box);
        binding.image8.setImageResource(R.drawable.white_box);
        binding.image9.setImageResource(R.drawable.white_box);
    }
}