package com.interviews;

public class Zume {

}
import java.io.*;
import java.util.*;

/*
Imagine we have an image. We'll represent this image as a simple 2D array where every pixel is a 1 or a 0.

The image you get is known to have potentially many distinct rectangles of 0s on a background of 1s. Write a function that takes in the image and returns the coordinates of all the 0 rectangles -- top-left and bottom-right; or top-left, width and height.

image1 = [
  [0, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 0, 0, 0, 1],
  [1, 0, 1, 0, 0, 0, 1],
  [1, 0, 1, 1, 1, 1, 1],
  [1, 0, 1, 0, 0, 1, 1],
  [1, 1, 1, 0, 0, 1, 1],
  [1, 1, 1, 1, 1, 1, 0],
]

Sample output variations (only one is necessary):

findRectangles(image1) =>
  // (using top-left and bottom-right):
  [
    [[0,0],[0,0]],
    [[2,3],[3,5]],
    [[3,1],[5,1]],
    [[5,3],[6,4]],
    [[7,6],[7,6]],
  ]
  // (using top-left and width/height):
  [
    [[0,0],[1,1]],
    [[2,3],[3,2]],
    [[3,1],[1,3]],
    [[5,3],[2,2]],
    [[7,6],[1,1]],
  ]

Other test cases:

image2 = [
  [0],
]

findRectangles(image2) =>
  // (using top-left and bottom-right):
  [
    [[0,0],[0,0]],
  ]

  // (using top-left and width/height):
  [
    [[0,0],[1,1]],
  ]

image3 = [
  [1],
]

findRectangles(image3) => []


 */

class Solution {
  public static void main(String[] args) {
    
    int[][] image1 = {
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 0, 0, 0, 1},
      {1, 1, 1, 0, 0, 0, 1},
      {1, 1, 1, 1, 1, 1, 1}
    };

    int[][] image2 = {
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 0}
    };

    int[][] image3 = {
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 0, 0},
      {1, 1, 1, 1, 1, 0, 0}
    };

    int[][] image4 = {
      {0, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1}
    };

    int[][] image5 = {
      {0}
    }; 
    
    int[][] image2_1 = {
      {0, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 0, 0, 0, 1},
      {1, 0, 1, 0, 0, 0, 1},
      {1, 0, 1, 1, 1, 1, 1},
      {1, 0, 1, 0, 0, 1, 1},
      {1, 1, 1, 0, 0, 1, 1},
      {1, 1, 1, 1, 1, 1, 0},
    };

    int[][] image2_2 = {
      {0},
    };

    int[][] image2_3 = {
      {1},
    };


    // Solution sol = new Solution();
    // Rectangle result1 = sol.getRect(image5);
    // System.out.println(result1.toString());
  }
  
  
  class Rectangle{
    int row;
    int col;
    int width;
    int height;
    
    public Rectangle(int r, int c, int w, int h){
      this.row = r;
      this.col = c;
      this.width = w;
      this.height = h;
    }
    
    public Rectangle(int r, int c){
      this.row = r;
      this.col = c;
    }
    
    public String toString(){
      return "x: " + row + " y: " + col + " width: " + width + " height: " + height;
    }
  }
  
  
  
  public List<Rectangle> getListRect(int[][] image2){
    int widht = 0;
    int height = 0;
    int[] rows = new int[image.length];
    int[] cols = new int[image[0].length];
    int[][] image = Array.copy(image);
    
    List<Rectangle> result = new ArrayList<>();
    
    for(int r = 0; r < image.length; r++){
      for(int c = 0; c < image[0].length; c++){
        if(image[r][c] == 0){
          Rectange r1 = getRect(int[][] image, int r, int c, new Rectangle(r, c));
        }
      }
    }
    
    SizeStart rowData = getSize(rows);
    SizeStart colData = getSize(cols);
    
    return result;
  }
  
  private Rectangle getRect(int[][] image, int r, int c, Rectangle rect){
    
    if(r >= image.length || c >= image[0].length || image[r][c] != 0){
      return rect;
    }
    
    image[r][c] = -1;
    rect.
    
    getRect(image, row+1, col);
    getRect(image, row, col+1);
  }
  
  private SizeStart getSize(int[] arr){
    int size = 0;
    int start = -1;
    for(int i = 0; i<arr.length; i++){
      if(arr[i] == 1){
        if(start == -1) {
          start = i;
        }
        size++;
      }
    }
    
    return new SizeStart(size, start);
  }
  
  class SizeStart{
    int size;
    int start;
    public SizeStart(int size, int start){
      this.start = start;
      this.size = size;
    }
  }
  
}

