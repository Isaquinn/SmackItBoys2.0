package br.com.isaque.smackitboys;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    //region Declaração de variáveis
    private Button play,instruction,exit;
    private Typeface custom_font;
    private TextView nomedejogomenu;
    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        custom_font = Typeface.createFromAsset(getAssets(), "fonts/orange.ttf");
        play = (Button)findViewById(R.id.play);
        play.setTypeface(custom_font);
        instruction = (Button)findViewById(R.id.instructions);
        instruction.setTypeface(custom_font);
        exit = (Button)findViewById(R.id.exit);
        exit.setTypeface(custom_font);
        nomedejogomenu = (TextView)findViewById(R.id.NomeDoJogoMenu);
        nomedejogomenu.setTypeface(custom_font);
        play.setOnClickListener(this);
        instruction.setOnClickListener(this);
        exit.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.play)
        {
            Intent intent = new Intent(Menu.this, MainActivity.class );
            startActivityForResult(intent, 1);
            overridePendingTransition(R.animator.slide_in_right, R.animator.slide_out_right);
        }
        else if(v.getId() == R.id.instructions)
        {
            Intent intent = new Intent(Menu.this, Instructions.class );
            startActivityForResult(intent, 0);
            overridePendingTransition(R.animator.slide_in_top, R.animator.slide_out_top);
        }
        else if(v.getId() == R.id.exit)
        {
            moveTaskToBack(true);
        }
    }
}
