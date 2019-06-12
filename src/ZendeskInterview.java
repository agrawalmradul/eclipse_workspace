

class ZendeskInterview {
  public static void main(String[] args) {
      int[] arr = new int[]{4, 4, 0, 8, 0, 4, 1, 2, 3, 4, 5, 6, 7, 8, 9, 3};
    int[] arr2 = new int[]{4,2,2,2, 2,2,2,2, 2,2,2,2, 2};
    //{8, 2, 4, 2,  4, 2, 4, 2,  4, 2, 4, 2,  4}
      System.out.println(isValidCC(arr2));
  }
  
  //input is in array
  //4 4 0 8 0 4 1 2 3 4 5  6 7  8 9  3
  // creditNum[0] is the 4
  public static boolean isValidCC(int[] creditNum){
    int sum = 0;
    
    for(int i = creditNum.length-2; i>=0; i=i-2){
      creditNum[i] = creditNum[i]*2;
    }
    
        
    for(int j = 0; j < creditNum.length; j++){
      int temp = creditNum[j];
        if(temp>9){
          sum += temp%10;
          temp = temp/10;
        }
         sum += temp; 
    }
    return (sum%10==0)?true:false;
  }
}


/* 
# Credit card numbers can be validated with a process called the Luhn algorithm. Simply stated, the Luhn algorithm works like this:
 
# Starting with the next to last digit and continuing with every other digit going back to the beginning of the card, double the digit.
# Sum all doubled and untouched digits in the number.
# If that total is a multiple of 10, the number is valid.
# For example, given the card number 4408 0412 3456 7893:
 
# Orig :  4 4 0 8 0 4 1 2 3 4 5  6 7  8 9  3
# Step 1: 8 4 0 8 0 4 2 2 6 4 10 6 14 8 18 3
# Step 2: 8+4+0+8+0+4+2+2+6+4+1+0+6+1+4+8+1+8+3 = 70
# Step 3: 70 % 10 == 0
 
# Test Cases
# 1234567890123456 => false
# 4408041234567893 => true
# 38520000023237 => true
# 4222222222222 => true
 */

