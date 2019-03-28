package com.example.a2019_1_dcc196_exr05_lucasmargato;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private static final int X = 1, O = 2;
    Button [][] b = new Button[3][3];
    TextView quem, vitx, vito;
    int [][] mat;
    int jogador = X;
    AlertDialog alert;
    int vx, vo;

    protected void initialize(){
        for (int i=0 ; i<=2 ; i++){
            for (int j=0 ; j<=2 ; j++) {
                mat[i][j] = 0;
            }
        }
    }

    protected void draw() {
        if (jogador==X){
            quem.setText("Agora é a vez do X");
        } else {
            quem.setText("Agora é a vez do O");
        }
        for (int i=0 ; i<=2 ; i++){
            for (int j=0 ; j<=2 ; j++) {
                if (mat[i][j] == X){
                    b[i][j].setText("X");
                } else if (mat[i][j] == O){
                    b[i][j].setText("O");
                } else{
                    b[i][j].setText("");
                }
            }
        }

        vitx.setText("Vitórias do jogador X: " + vx);
        vito.setText("Vitorias do jogador O: " + vo);
    }

    protected void marca(int linha, int coluna) {
        mat[linha][coluna] = jogador;
        if (jogador == X) {
            jogador = O;
        } else {
            jogador = X;
        }
    }

    protected void verifica(){
        boolean velha = true;

        for (int i=0 ; i<=2 ; i++){
            for (int j=0 ; j<=2 ; j++) {
                if (mat[i][j] == 0) velha = false;
            }
        }

        if (
                ((mat[0][0] == X) && (mat[0][1] == X) && (mat[0][2] == X)) ||
                        ((mat[1][0] == X) && (mat[1][1] == X) && (mat[1][2] == X)) ||
                        ((mat[2][0] == X) && (mat[2][1] == X) && (mat[2][2] == X)) ||
                        ((mat[0][0] == X) && (mat[1][0] == X) && (mat[2][0] == X)) ||
                        ((mat[0][1] == X) && (mat[1][1] == X) && (mat[2][1] == X)) ||
                        ((mat[0][2] == X) && (mat[1][2] == X) && (mat[2][2] == X)) ||
                        ((mat[0][0] == X) && (mat[1][1] == X) && (mat[2][2] == X)) ||
                        ((mat[0][2] == X) && (mat[1][1] == X) && (mat[2][0] == X))
        ){
            alert.setTitle("Parabéns!");
            alert.setMessage("O jogador X venceu");
            vx++;
            jogador = X;
            alert.show();
        } else if (
                ((mat[0][0] == O) && (mat[0][1] == O) && (mat[0][2] == O)) ||
                        ((mat[2][0] == O) && (mat[2][1] == O) && (mat[2][2] == O)) ||
                        ((mat[1][0] == O) && (mat[1][1] == O) && (mat[1][2] == O)) ||
                        ((mat[0][0] == O) && (mat[1][0] == O) && (mat[2][0] == O)) ||
                        ((mat[0][1] == O) && (mat[1][1] == O) && (mat[2][1] == O)) ||
                        ((mat[0][2] == O) && (mat[1][2] == O) && (mat[2][2] == O)) ||
                        ((mat[0][0] == O) && (mat[1][1] == O) && (mat[2][2] == O)) ||
                        ((mat[0][2] == O) && (mat[1][1] == O) && (mat[2][0] == O))
        ){
            alert.setTitle("Parabéns!");
            alert.setMessage("O jogador O venceu");
            vo++;
            jogador = X;
            alert.show();
        } else if (velha) {
            alert.setTitle("Vixe!");
            alert.setMessage("Deu velha...");
            jogador = X;
            alert.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vx = 0;
        vo = 0;

        alert = new AlertDialog.Builder(MainActivity.this).create();
        alert.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                initialize();
                draw();
                dialog.dismiss();
            }
        });

        quem = (TextView) findViewById(R.id.quemjoga);
        vitx = (TextView) findViewById(R.id.vitoriasx);
        vito = (TextView) findViewById(R.id.vitoriaso);

        b[0][0] = (Button) findViewById(R.id.button_0_0);
        b[0][1] = (Button) findViewById(R.id.button_0_1);
        b[0][2] = (Button) findViewById(R.id.button_0_2);

        b[1][0] = (Button) findViewById(R.id.button_1_0);
        b[1][1] = (Button) findViewById(R.id.button_1_1);
        b[1][2] = (Button) findViewById(R.id.button_1_2);

        b[2][0] = (Button) findViewById(R.id.button_2_0);
        b[2][1] = (Button) findViewById(R.id.button_2_1);
        b[2][2] = (Button) findViewById(R.id.button_2_2);


        b[0][0].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (b[0][0].getText() == "") {
                    marca(0, 0);
                    draw();
                    verifica();
                }
            }
        });

        b[0][1].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (b[0][1].getText() == "") {
                    marca(0, 1);
                    draw();
                    verifica();
                }
            }
        });

        b[0][2].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (b[0][2].getText() == "") {
                    marca(0, 2);
                    draw();
                    verifica();
                }
            }
        });

        b[1][0].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (b[1][0].getText() == "") {
                    marca(1, 0);
                    draw();
                    verifica();
                }
            }
        });

        b[1][1].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (b[1][1].getText() == "") {
                    marca(1, 1);
                    draw();
                    verifica();
                }
            }
        });

        b[1][2].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (b[1][2].getText() == "") {
                    marca(1, 2);
                    draw();
                    verifica();
                }
            }
        });

        b[2][0].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (b[2][0].getText() == "") {
                    marca(2, 0);
                    draw();
                    verifica();
                }
            }
        });

        b[2][1].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (b[2][1].getText() == "") {
                    marca(2, 1);
                    draw();
                    verifica();
                }
            }
        });

        b[2][2].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (b[2][2].getText() == "") {
                    marca(2, 2);
                    draw();
                    verifica();
                }
            }
        });

        mat = new int[3][3];
        initialize();
        draw();
    }
}
