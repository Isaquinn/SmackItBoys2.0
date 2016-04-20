package br.com.isaque.smackitboys;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Instructions extends AppCompatActivity implements View.OnClickListener {
    //region Declaração de variáveis
    private Button Menu,Play;
    private TextView NomeInstrucoes,TextoInstrucoes;
    private Typeface custom_font;
    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        custom_font = Typeface.createFromAsset(getAssets(), "fonts/orange.ttf");
        Menu = (Button)findViewById(R.id.gotomenu);
        Menu.setTypeface(custom_font);
        Menu.setOnClickListener(this);
        Play = (Button)findViewById(R.id.gotogame);
        Play.setTypeface(custom_font);
        Play.setOnClickListener(this);
        NomeInstrucoes = (TextView)findViewById(R.id.telainstrucao);
        NomeInstrucoes.setTypeface(custom_font);
        TextoInstrucoes = (TextView)findViewById(R.id.textoinstrucoes);
        TextoInstrucoes.setText("       Click only on the boys to earn 100 points. \n\n       Do not click in the heart you will lose a life and lose  300 points. \n\n      You only have only three lives, if you lose all lose the game.");
        TextoInstrucoes.setTypeface(custom_font);
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.gotomenu)
        {
            Intent intent = new Intent(Instructions.this, Menu.class );
            startActivityForResult(intent, 0);
            overridePendingTransition(R.animator.slide_in_bot, R.animator.slide_out_bot);
        }
        else if(v.getId() == R.id.gotogame)
        {
            Intent intent = new Intent(Instructions.this, MainActivity.class );
            startActivityForResult(intent, 1);
            overridePendingTransition(R.animator.slide_in_topright, R.animator.slide_out_topright);
        }
    }
    public void onBackPressed()
    {
        // code here to show dialog
        // optional depending on your needs
    }
}
