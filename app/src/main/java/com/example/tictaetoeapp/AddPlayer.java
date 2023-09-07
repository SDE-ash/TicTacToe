package com.example.tictaetoeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlayer extends AppCompatActivity {
EditText playerOne, playerTwo;
Button startgame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        playerOne = findViewById(R.id.playerOne);
        playerTwo = findViewById(R.id.playerTwo);
        startgame = findViewById(R.id.startgame);

        startgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getPlayerOnename = playerOne.getText().toString();
                String getPlayerTwoName = playerTwo.getText().toString();

                if(getPlayerOnename.isEmpty() || getPlayerTwoName.isEmpty()){
                    Toast.makeText(AddPlayer.this, "enter the players names", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(AddPlayer.this, "Welcome to Akash's TiceTaeToe game", Toast.LENGTH_SHORT).show();
                    Intent inext = new Intent(getApplicationContext(),MainActivity.class);
                    inext.putExtra("playerOne", getPlayerOnename);
                    inext.putExtra("playerTwo", getPlayerTwoName);
                    startActivity(inext);
                }
            }
        });
    }
}