class Result {


    /*
     * Complete the 'pointsBelong' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER y1
     *  3. INTEGER x2
     *  4. INTEGER y2
     *  5. INTEGER x3
     *  6. INTEGER y3
     *  7. INTEGER xp
     *  8. INTEGER yp
     *  9. INTEGER xq
     *  10. INTEGER yq
     */


    public static int pointsBelong(int x1, int y1, int x2, int y2, int x3, int y3, int xp, int yp, int xq, int yq) {
        int result =0;
        if(!isNonDegenerate(x1, y1, x2, y2, x3, y3)){
            return 0;
        }
        
        if(isBelongsToTriangle(x1, y1, x2, y2, x3, y3, xp, yp) && !isBelongsToTriangle(x1, y1, x2, y2, x3, y3, xq, yq)){
            result = 1;
        }
        
        if(!isBelongsToTriangle(x1, y1, x2, y2, x3, y3, xp, yp) && isBelongsToTriangle(x1, y1, x2, y2, x3, y3, xq, yq)){
            result = 2;
        }
        
         if(isBelongsToTriangle(x1, y1, x2, y2, x3, y3, xp, yp) && isBelongsToTriangle(x1, y1, x2, y2, x3, y3, xq, yq)){
            result = 3;
        }
         if(!isBelongsToTriangle(x1, y1, x2, y2, x3, y3, xp, yp) && !isBelongsToTriangle(x1, y1, x2, y2, x3, y3, xq, yq)){
            result = 4;
        }
        
        return result;


    }
    
    public static boolean isNonDegenerate(int x1, int y1, int x2, int y2, int x3, int y3){
        Double ab = Math.sqrt(Math.pow(Math.abs(x2-x1), 2)+Math.pow(Math.abs(y2-y1), 2));
        Double bc = Math.sqrt(Math.pow(Math.abs(x3-x2), 2)+Math.pow(Math.abs(y3-y2), 2));
        Double ac = Math.sqrt(Math.pow(Math.abs(x3-x1), 2)+Math.pow(Math.abs(y3-y1), 2));
        if(ab+bc>ac && bc+ac>ab  && ab+ac>bc ){
            return true;
        }
    return false;
    }
      public static boolean isBelongsToTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y){
          Double A= area(x1, y1, x2, y2, x3, y3) ;
          
          Double A1 = area(x, y, x2, y2, x3, y3);
          
          Double A2 = area(x1, y1, x, y, x3, y3);
          
          Double A3 = area(x1, y1, x2, y2, x, y);          
        
    return (A == A1+A2+A3);
    }
    
     public static double area(int x1, int y1, int x2, int y2, int x3, int y3){
      
    return Math.abs((x1*(y2-y3)+ x2*(y3-y1)+x3*(y1-y2))/2.0);
    }
    
    


}
