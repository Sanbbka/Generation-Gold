public class Gold {

public static void main(String[] args) {

final int M=5;
final int N=(int)Math.pow(2,M)-1;

int[][] a1=new int[N][M], a2=new int[N][M];
a1[0]= new int[]{1,1,1,1,1};
a2[0]= new int[]{1,1,1,1,1};

for(int j=1; j<N; j++){
a1[j][0]=a1[j-1][2]^a1[j-1][4];
a2[j][0]=a2[j-1][2]^a2[j-1][4]^a2[j-1][3]^a2[j-1][1];
for(int i=1; i<M; i++){
a1[j][i]=a1[j-1][i-1];
a2[j][i]=a2[j-1][i-1];
}
}

int[][] gold =new int[N+2][N]; 

for(int j=N-1; j>=0; j--){
gold[0][j]=a1[j][M-1];
gold[1][j]=a2[j][M-1];
}

for(int j=2; j<N+2; j++){
for(int i=0; i<N-j+2; i++){
gold[j][i]=gold[0][i]^gold[1][i+j-2];
}
for(int i=N-j+2; i<N; i++){
gold[j][i]=gold[0][i]^gold[1][i+j-N-2];
}
}

for(int j=0; j<N+2; j++){
for(int i=0; i<N; i++){
System.out.print(gold[j][i]+" ");
}
System.out.println();
}
}

}