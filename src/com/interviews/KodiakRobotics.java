package com.interviews;

public class KodiakRobotics {

}


/* 

Language: C++

Problem:

We have a vector of xy points (a trajectory) at discrete points in time. We would like to write some code that facilitates sampling of the trajectory at an arbitrary time.

T = [T0, T1, T2, …, Tn]         (scalar)
X = [X0, X1, X2, …, Xn]         (scalar)
Y = [Y0, Y1, Y2, …, Yn]         (scalar)

We don’t care about the smoothness of our output, and a linear interpolation between points is sufficient.

t = (tsample-Ti) / (Ti+1 - Ti) 

where tsample is the time at which we’d like to sample the trajectory, and Ti and Ti+1 correspond to the points in the trajectory vectors before and after tsample, respectively.

x(t) =  Xi + t * (Xi+1 - Xi)
y(t) =  Yi + t * (Yi+1 - Yi)

*/
// lets consider the T are sorted

//class Trajectory{
//  
//  var T = [];
//  var X = [];
//  var Y = [];
//  
//  constructor(T, X, Y){
//    this.T = T;
//    this.X = X;
//    this.Y = Y;
//  }
//
//  function interpolateXY(tSample){
//    var i = binerarySearch(this.T, tSample); //O(log n)
//    
//    var tDiff = (tSample - T[i])/(T[i+1] - T[i]);
//    
//    var x_inter = X[i] + tDiff*(X[i+1] - X[i]);
//    var y_inter = Y[i] + tDiff*(Y[i+1] - Y[i]);
//    
//    var interPolatedXY = {x_inter, y_inter};
//    return interPolatedXY;
//  }
//
//  function binarySearch(T, tSample){
//    
//    var start = 0;
//    var end = T.length;
//    
//    while( start < end){
//      var mid = start + end /2;
//      if(T[mid] > tSample)
//        end = mid;
//      else
//        start = mid;
//    }
//    
//    return start;
//  }
//}
//
//- if tsample is between t0 and tn
//- if tn and tn+1 // tDiff undefined
//- tsample is 0 and 1
//- n-1 and n
//- x1,y1 is +ve
// - x2, y2 is in 3rd quad 
