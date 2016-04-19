package br.com.isaque.smackitboys;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity implements View.OnClickListener {
    //region Declaração de variáveis
    private Button playagain, menu;
    private TextView Gameoverr;
    private Typeface custom_font;
    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        custom_font = Typeface.createFromAsset(getAssets(), "fonts/orange.ttf");
        playagain = (Button)findViewById(R.id.playagain);
        playagain.setTypeface(custom_font);
        menu = (Button)findViewById(R.id.menu);
        menu.setTypeface(custom_font);
        Gameoverr = (TextView)findViewById(R.id.GameOver);
        Gameoverr.setTypeface(custom_font);
        playagain.setOnClickListener(this);
        menu.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.playagain)
        {
            Intent intent = new Intent(GameOver.this, MainActivity.class );
            startActivityForResult(intent, 1);
            overridePendingTransition(R.animator.slide_in_left, R.animator.slide_out_left);
        }
        else if(v.getId() == R.id.menu)
        {
            Intent intent = new Intent(GameOver.this, Menu.class );
            startActivityForResult(intent, 0);
            overridePendingTransition(R.animator.slide_in_right, R.animator.slide_out_right);
        }
    }
    public void onBackPressed()
    {
        // code here to show dialog
        // optional depending on your needs
    }
}
