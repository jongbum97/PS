function solution(n) {
    var answer = 0;
    for(i=2; i<=n; i++){
        for(j=2; j<=i/2; j++){
            if(i%j==0){answer+=1;break}
            
        }
    if(n==2){answer=0}
    }
    return answer;
}