package com.example.iqwhizz;

import android.content.Intent;
import android.graphics.Color;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.iqwhizz.DAO.StatsDAO;
import com.example.iqwhizz.Objects.User;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Stats extends AppCompatActivity {


    TextView actualQI;
    TextView myBestQI;
    Button history_btn;
    int userQI;
    int bestQI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);


        userQI = StatsDAO.getAverageIQ(User.currentUser.getUsername());



        userQI = StatsDAO.getAverageIQ(User.currentUser.getUsername());
        if (userQI == -1){
            userQI = 0;
        }
        if(bestQI == -1){
            bestQI = 0;
        }
        bestQI = 130;

        actualQI = findViewById(R.id.myIQ);
        myBestQI = findViewById(R.id.myBestIQ);
        actualQI.setText(userQI + "");
        myBestQI.setText(bestQI + "");


        createGraph();
        TextView averageIQ = findViewById(R.id.averageIQ);
        NumberFormat formatter = new DecimalFormat("#0.00");


        if(userQI > 100){
            averageIQ.setText("Votre QI est supérieur de " + formatter.format(Gauss.integrate(100,userQI,100,15))+"% à la moyenne");
        }else if(userQI < 100){
            averageIQ.setText("Votre QI est inférieur de " + formatter.format(Gauss.integrate(userQI,100,100,15))+"% à la moyenne");
        }else{
            averageIQ.setText("Votre QI est égale à celle de la moyenne");
        }

        history_btn = findViewById(R.id.history);

        history_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                historyIntent();
            }
        });




    }

    private void historyIntent(){
        Intent intentHistory = new Intent(this, History.class);
        startActivity(intentHistory);
    }

    protected void createGraph(){

        //ne pas toucher
        GraphView graph = (GraphView)  findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(Gauss.getDataPointCurve(200,100,15));
        series.setDrawBackground(false);
        series.setColor(Color.rgb(255, 0, 93));
        graph.addSeries(series);

        LineGraphSeries<DataPoint> score = new LineGraphSeries<>(Gauss.getDataPointCurve(userQI,100,15));
        score.setDrawBackground(true);
        score.setBackgroundColor(Color.argb(50, 255, 0, 93));
        score.setColor(Color.rgb(255, 0, 93));
        graph.addSeries(score);

        PointsGraphSeries<DataPoint> series2 = new PointsGraphSeries<>(new DataPoint[]{
                new DataPoint(userQI, Gauss.function(userQI, 100, 15))
        });

        series2.setColor(Color.rgb(255, 0, 93));
        graph.getViewport().setScalable(true);
        graph.setTitle("Votre QI en fonction du QI de la population (en %)");
        graph.addSeries(series2);
    }

}