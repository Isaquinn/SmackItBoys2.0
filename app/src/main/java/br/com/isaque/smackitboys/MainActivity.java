package br.com.isaque.smackitboys;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Runnable{
    //region Variáveis
    private ImageView imagem1, imagem2, imagem3, imagem4, imagem5, imagem6;
    private TextView nomedojogo,score,vidas,highscore;
    private int valorvidas, valorscore, valorhighscore;
    private Random random;
    private Random random2;
    private Timer timer;
    private Timer timer2;
    private  int time3 = 5;
    private int time2 = 4;
    private int time = 3;
    private int numero, imagemaleatoria;
    int timecontroladordenivel = 30;
    private Typeface custom_font;
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;
    private boolean GoToGame = false;
    private TextView TimeCount;
    private MediaPlayer  soco;
    private TextView novohighscore;
    private Vibrator vibrator;
    int timvibration;
    private Handler myhandler;
    private  ImageView luva;
    float dX, dY;
    private MotionEvent motionEvent;
    private int timecoracao = 8;

    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        soco = MediaPlayer.create(this, R.raw.socosoco);
        time2 = 4;
        numero = 10;
        imagemaleatoria = 10;
        //region Identificador de cada item da tela
        imagem1 = (ImageView)findViewById(R.id.imagem1);
        imagem2 = (ImageView)findViewById(R.id.imagem2);
        imagem3 = (ImageView)findViewById(R.id.imagem3);
        imagem4 = (ImageView)findViewById(R.id.imagem4);
        imagem5 = (ImageView)findViewById(R.id.imagem5);
        imagem6 = (ImageView)findViewById(R.id.imagem6);
        nomedojogo = (TextView)findViewById(R.id.NomeDoJogo);
        score = (TextView)findViewById(R.id.score);
        vidas = (TextView)findViewById(R.id.lifes);
        highscore = (TextView)findViewById(R.id.highscore);
        TimeCount = (TextView)findViewById(R.id.telatempo);
        novohighscore = (TextView)findViewById(R.id.novohighscore);
        novohighscore.setTypeface(custom_font);
        novohighscore.setVisibility(View.INVISIBLE);
        //endregion
        //region Não sei como separa, me desculpe
        custom_font = Typeface.createFromAsset(getAssets(), "fonts/orange.ttf");
        nomedojogo.setTypeface(custom_font);
        imagem1.setOnClickListener(this);imagem2.setOnClickListener(this);imagem3.setOnClickListener(this);imagem4.setOnClickListener(this);imagem5.setOnClickListener(this);imagem6.setOnClickListener(this);
        valorvidas = 3; valorscore = 0;
        random = new Random();
        random2 = new Random();
        //endregion
        //region Pega HighScore do bando de dados do celular
        sharedPref = getSharedPreferences("LevelScores", Context.MODE_PRIVATE);
        valorhighscore = sharedPref.getInt("score", 0);
        highscore.setText(String.valueOf("HighScore: " + valorhighscore));
        highscore.setTypeface(custom_font);
        //endregion
        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        luva = (ImageView)findViewById(R.id.luva);
        //run();
    }
    public void onPause()
    {
        super.onPause();
        GoToGame = true;
    }
    public  void onResume()
    {
        super.onResume();
        run();
    }
    public  boolean onTouchEvent(MotionEvent motionEvent)
    {
        switch (motionEvent.getAction())
        {
            case MotionEvent.ACTION_DOWN :
                dX = motionEvent.getX();
                dY = motionEvent.getY();
        }

         return  true;
    }
    @Override
    public void onClick(View v) {
        if (time2 <= 0) {
            if (v.getId() == R.id.imagem1) {
                if (numero == 0) {
                    luva.setVisibility(View.VISIBLE);
                    luva.setX(imagem1.getX());
                    luva.setY(imagem1.getY());
                    time = 3;
                    soco.start();
                    imagem1.setBackgroundResource(R.drawable.rosquinha);
                    imagem2.setBackgroundResource(R.drawable.rosquinha);
                    imagem3.setBackgroundResource(R.drawable.rosquinha);
                    imagem4.setBackgroundResource(R.drawable.rosquinha);
                    imagem5.setBackgroundResource(R.drawable.rosquinha);
                    imagem6.setBackgroundResource(R.drawable.rosquinha);
                    numero = random.nextInt(6);
                    if (imagemaleatoria != 0) {
                        valorscore += 100;
                    } else {
                        valorvidas -= 1;
                        valorscore -= 300;
                    }
                    imagemaleatoria = random2.nextInt(6);
                }
            } else if (v.getId() == R.id.imagem2) {
                if (numero == 1) {
                    luva.setVisibility(View.VISIBLE);
                    luva.setX(imagem2.getX());
                    luva.setY(imagem2.getY());
                    time = 3;
                    soco.start();
                    imagem1.setBackgroundResource(R.drawable.rosquinha);
                    imagem2.setBackgroundResource(R.drawable.rosquinha);
                    imagem3.setBackgroundResource(R.drawable.rosquinha);
                    imagem4.setBackgroundResource(R.drawable.rosquinha);
                    imagem5.setBackgroundResource(R.drawable.rosquinha);
                    imagem6.setBackgroundResource(R.drawable.rosquinha);
                    numero = random.nextInt(6);
                    if (imagemaleatoria != 0) {
                        valorscore += 100;
                    } else {
                        valorvidas -= 1;
                        valorscore -= 300;
                    }
                    imagemaleatoria = random2.nextInt(6);
                }
            } else if (v.getId() == R.id.imagem3) {
                if (numero == 2) {
                    luva.setVisibility(View.VISIBLE);
                    luva.setX(imagem3.getX());
                    luva.setY(imagem3.getY());
                    time = 3;
                    soco.start();
                    imagem1.setBackgroundResource(R.drawable.rosquinha);
                    imagem2.setBackgroundResource(R.drawable.rosquinha);
                    imagem3.setBackgroundResource(R.drawable.rosquinha);
                    imagem4.setBackgroundResource(R.drawable.rosquinha);
                    imagem5.setBackgroundResource(R.drawable.rosquinha);
                    imagem6.setBackgroundResource(R.drawable.rosquinha);
                    numero = random.nextInt(6);
                    if (imagemaleatoria != 0) {
                        valorscore += 100;
                    } else {
                        valorvidas -= 1;
                        valorscore -= 300;
                    }
                    imagemaleatoria = random2.nextInt(6);
                }
            } else if (v.getId() == R.id.imagem4) {
                if (numero == 3) {
                    luva.setVisibility(View.VISIBLE);
                    luva.setX(imagem4.getX());
                    luva.setY(imagem4.getY());
                    time = 3;
                    soco.start();
                    imagem1.setBackgroundResource(R.drawable.rosquinha);
                    imagem2.setBackgroundResource(R.drawable.rosquinha);
                    imagem3.setBackgroundResource(R.drawable.rosquinha);
                    imagem4.setBackgroundResource(R.drawable.rosquinha);
                    imagem5.setBackgroundResource(R.drawable.rosquinha);
                    imagem6.setBackgroundResource(R.drawable.rosquinha);
                    numero = random.nextInt(6);
                    if (imagemaleatoria != 0) {
                        valorscore += 100;
                    } else {
                        valorvidas -= 1;
                        valorscore -= 300;
                    }
                    imagemaleatoria = random2.nextInt(6);
                }
            } else if (v.getId() == R.id.imagem5) {
                if (numero == 4) {
                    luva.setVisibility(View.VISIBLE);
                    luva.setX(imagem5.getX());
                    luva.setY(imagem5.getY());
                    time = 3;
                    soco.start();
                    imagem1.setBackgroundResource(R.drawable.rosquinha);
                    imagem2.setBackgroundResource(R.drawable.rosquinha);
                    imagem3.setBackgroundResource(R.drawable.rosquinha);
                    imagem4.setBackgroundResource(R.drawable.rosquinha);
                    imagem5.setBackgroundResource(R.drawable.rosquinha);
                    imagem6.setBackgroundResource(R.drawable.rosquinha);
                    numero = random.nextInt(6);

                    if (imagemaleatoria != 0) {
                        valorscore += 100;
                    } else {
                        valorvidas -= 1;
                        valorscore -= 300;
                    }
                    imagemaleatoria = random2.nextInt(6);
                }
            } else if (v.getId() == R.id.imagem6) {
                if (numero == 5) {
                    luva.setVisibility(View.VISIBLE);
                    luva.setX(imagem6.getX());
                    luva.setY(imagem6.getY());
                    time = 3;
                    soco.start();
                    imagem1.setBackgroundResource(R.drawable.rosquinha);
                    imagem2.setBackgroundResource(R.drawable.rosquinha);
                    imagem3.setBackgroundResource(R.drawable.rosquinha);
                    imagem4.setBackgroundResource(R.drawable.rosquinha);
                    imagem5.setBackgroundResource(R.drawable.rosquinha);
                    imagem6.setBackgroundResource(R.drawable.rosquinha);
                    numero = random.nextInt(6);

                    if (imagemaleatoria != 0) {
                        valorscore += 100;
                    } else {
                        valorvidas -= 1;
                        valorscore -= 300;
                    }
                    imagemaleatoria = random2.nextInt(6);
                }
            }
        }
    }
    @Override
    public void run()
    {
        //region control of boxer
        runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                luva.setVisibility(View.INVISIBLE);
            }
        });
        //endregion
        //region control of vibration
        final Timer timertimer = new Timer();
        timertimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(valorscore > valorhighscore)
                {
                    timvibration += 1;
                    vibrator.vibrate(1000);
                    if(timvibration >= 2)
                    {
                        vibrator.cancel();
                    }
                }
            }

        },0,1000);
        //endregion
        timer2 = new Timer();
        timer2.schedule(new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        luva.setVisibility(View.INVISIBLE);
                        if (timecontroladordenivel == 25) {
                            time = 4;
                        } else if (timecontroladordenivel == 20) {
                            time = 3;
                        } else if (timecontroladordenivel == 10) {
                            time = 2;
                        }

                        time2 -= 1;
                        TimeCount.setText(String.valueOf(time2));
                        TimeCount.setTypeface(custom_font);
                        if(time2 == 0){TimeCount.setText("Go");}
                        if (time2 == -1) {

                            TimeCount.setVisibility(View.INVISIBLE);
                            timer = new Timer();
                            timer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            if (valorscore <= 0) {
                                                valorscore = 0;
                                            }
                                            if (valorvidas == 0) {
                                                Intent intent = new Intent(MainActivity.this, GameOver.class);
                                                startActivityForResult(intent, 1);
                                                overridePendingTransition(R.animator.slide_in_right, R.animator.slide_out_right);
                                                valorvidas = 3;
                                            }
                                            if (valorscore > valorhighscore) {
                                                sharedPref = getSharedPreferences("LevelScores", Context.MODE_PRIVATE);
                                                editor = sharedPref.edit();
                                                editor.putInt("score", valorscore);
                                                editor.commit();
                                                novohighscore.setVisibility(View.VISIBLE);
                                                novohighscore.setTypeface(custom_font);
                                            }
                                            score.setText(String.valueOf("Score: " + String.valueOf(valorscore)));
                                            score.setTypeface(custom_font);
                                            vidas.setText(String.valueOf("Lifes: " + String.valueOf(valorvidas)));
                                            vidas.setTypeface(custom_font);
                                            if (time == 3) {
                                                imagem1.setBackgroundResource(R.drawable.rosquinha);
                                                imagem2.setBackgroundResource(R.drawable.rosquinha);
                                                imagem3.setBackgroundResource(R.drawable.rosquinha);
                                                imagem4.setBackgroundResource(R.drawable.rosquinha);
                                                imagem5.setBackgroundResource(R.drawable.rosquinha);
                                                imagem6.setBackgroundResource(R.drawable.rosquinha);
                                            }
                                            timecoracao -= 1;
                                            time -= 1;
                                            if(timecoracao == 0)
                                            {
                                                int selecao = random.nextInt(4);
                                                if(selecao == 1)
                                                {
                                                    imagemaleatoria = 0;
                                                }
                                                timecoracao = 8;
                                            }
                                            if (time == 0) {
                                                numero = random.nextInt(6);
                                                imagemaleatoria = random2.nextInt(6);
                                                time = 3;

                                            }
                                            switch (numero) {
                                                case 0:
                                                    switch (imagemaleatoria) {
                                                        case 0:
                                                            imagem1.setBackgroundResource(R.drawable.coracao);
                                                            break;
                                                        case 1:
                                                            imagem1.setBackgroundResource(R.drawable.sprite01);
                                                            break;
                                                        case 2:
                                                            imagem1.setBackgroundResource(R.drawable.sprite02);
                                                            break;
                                                        case 3:
                                                            imagem1.setBackgroundResource(R.drawable.sprite03);
                                                            break;
                                                        case 4:
                                                            imagem1.setBackgroundResource(R.drawable.sprite04);
                                                            break;
                                                        case 5:
                                                            imagem1.setBackgroundResource(R.drawable.sprite05);
                                                            break;
                                                    }
                                                    break;
                                                case 1:
                                                    switch (imagemaleatoria) {
                                                        case 0:
                                                            imagem2.setBackgroundResource(R.drawable.coracao);
                                                            break;
                                                        case 1:
                                                            imagem2.setBackgroundResource(R.drawable.sprite01);
                                                            break;
                                                        case 2:
                                                            imagem2.setBackgroundResource(R.drawable.sprite02);
                                                            break;
                                                        case 3:
                                                            imagem2.setBackgroundResource(R.drawable.sprite03);
                                                            break;
                                                        case 4:
                                                            imagem2.setBackgroundResource(R.drawable.sprite04);
                                                            break;
                                                        case 5:
                                                            imagem2.setBackgroundResource(R.drawable.sprite05);
                                                            break;
                                                    }
                                                    break;
                                                case 2:
                                                    switch (imagemaleatoria) {
                                                        case 0:
                                                            imagem3.setBackgroundResource(R.drawable.coracao);
                                                            break;
                                                        case 1:
                                                            imagem3.setBackgroundResource(R.drawable.sprite01);
                                                            break;
                                                        case 2:
                                                            imagem3.setBackgroundResource(R.drawable.sprite02);
                                                            break;
                                                        case 3:
                                                            imagem3.setBackgroundResource(R.drawable.sprite03);
                                                            break;
                                                        case 4:
                                                            imagem3.setBackgroundResource(R.drawable.sprite04);
                                                            break;
                                                        case 5:
                                                            imagem3.setBackgroundResource(R.drawable.sprite05);
                                                            break;
                                                    }
                                                    break;
                                                case 3:
                                                    switch (imagemaleatoria) {
                                                        case 0:
                                                            imagem4.setBackgroundResource(R.drawable.coracao);
                                                            break;
                                                        case 1:
                                                            imagem4.setBackgroundResource(R.drawable.sprite01);
                                                            break;
                                                        case 2:
                                                            imagem4.setBackgroundResource(R.drawable.sprite02);
                                                            break;
                                                        case 3:
                                                            imagem4.setBackgroundResource(R.drawable.sprite03);
                                                            break;
                                                        case 4:
                                                            imagem4.setBackgroundResource(R.drawable.sprite04);
                                                            break;
                                                        case 5:
                                                            imagem4.setBackgroundResource(R.drawable.sprite05);
                                                            break;
                                                    }
                                                    break;
                                                case 4:
                                                    switch (imagemaleatoria) {
                                                        case 0:
                                                            imagem5.setBackgroundResource(R.drawable.coracao);
                                                            break;
                                                        case 1:
                                                            imagem5.setBackgroundResource(R.drawable.sprite01);
                                                            break;
                                                        case 2:
                                                            imagem5.setBackgroundResource(R.drawable.sprite02);
                                                            break;
                                                        case 3:
                                                            imagem5.setBackgroundResource(R.drawable.sprite03);
                                                            break;
                                                        case 4:
                                                            imagem5.setBackgroundResource(R.drawable.sprite04);
                                                            break;
                                                        case 5:
                                                            imagem5.setBackgroundResource(R.drawable.sprite05);
                                                            break;
                                                    }
                                                    break;
                                                case 5:
                                                    switch (imagemaleatoria) {
                                                        case 0:
                                                            imagem6.setBackgroundResource(R.drawable.coracao);
                                                            break;
                                                        case 1:
                                                            imagem6.setBackgroundResource(R.drawable.sprite01);
                                                            break;
                                                        case 2:
                                                            imagem6.setBackgroundResource(R.drawable.sprite02);
                                                            break;
                                                        case 3:
                                                            imagem6.setBackgroundResource(R.drawable.sprite03);
                                                            break;
                                                        case 4:
                                                            imagem6.setBackgroundResource(R.drawable.sprite04);
                                                            break;
                                                        case 5:
                                                            imagem6.setBackgroundResource(R.drawable.sprite05);
                                                            break;
                                                    }
                                                    break;
                                            }
                                        }
                                    });
                                }
                            }, 0, 1000);
                            ;
                        }
                    }
                });

            }
        }, 0, 1000);


    }
    public void onBackPressed()
    {
        // code here to show dialog
          // optional depending on your needs
    }
}
