class array{
    //Rotate matrix by 90 degrees
    public void rotate(int[][] arr) {
        //Transpose the matrix
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr[0].length;j++){
                int t=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=t;
            }
        }
        //reverse each row elements
        for(int i=0;i<arr.length;i++){
            int f=0,l=arr[i].length-1;
            while(f<=l){
                int t=arr[i][f];
                arr[i][f]=arr[i][l];
                arr[i][l]=t;
                f++;l--;
            }
        }
    }


}