package com.example.iqwhizz;

import com.jjoe64.graphview.series.DataPoint;

public class Gauss {

    public static double integrate(int start, int stop, float average, float standard_deviation){
        double sum = 0;
        for(int i=start; i<stop; i++){
            sum += function(i, average, standard_deviation);
        }
        return sum;
    }

    public static double function(float x, float average, float standard_deviation){
        return (1/(standard_deviation*Math.sqrt(2*Math.PI)))*Math.pow(Math.E,-Math.pow(x-average,2)/(2*Math.pow(standard_deviation,2)))*100;
    }

    public static DataPoint[] getDataPointCurve(int stop, float average, float standard_deviation){
        DataPoint data[] = new DataPoint[stop];
        for(int i=0; i<stop; i++){
            data[i] = new DataPoint(i, function(i, average, standard_deviation));
        }
        return data;
    }

}
