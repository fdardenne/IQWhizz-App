package com.example.iqwhizz;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Stats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        createGraph();

        TextView averageIQ = (TextView) findViewById(R.id.betterIQ);

        NumberFormat formatter = new DecimalFormat("#0.00");
        averageIQ.setText("Votre QI est supérieur de " + formatter.format(Gauss.integrate(100,120,100,15))+"% à la moyenne");


    }

    protected void createGraph(){

        GraphView graph = (GraphView)  findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(Gauss.getDataPointCurve(200,100,15));
        series.setDrawBackground(false);
        series.setColor(Color.rgb(255, 0, 93));
        graph.addSeries(series);

        LineGraphSeries<DataPoint> score = new LineGraphSeries<>(Gauss.getDataPointCurve(120,100,15));
        score.setDrawBackground(true);
        score.setBackgroundColor(Color.argb(50, 255, 0, 93));
        score.setColor(Color.rgb(255, 0, 93));
        graph.addSeries(score);

        PointsGraphSeries<DataPoint> series2 = new PointsGraphSeries<>(new DataPoint[]{
                new DataPoint(120, Gauss.function(120, 100, 15))
        });

        series2.setColor(Color.rgb(255, 0, 93));
        graph.getViewport().setScalable(true);
        graph.setTitle("Votre QI en fonction du QI de la population (en %)");
        graph.addSeries(series2);
    }

}
