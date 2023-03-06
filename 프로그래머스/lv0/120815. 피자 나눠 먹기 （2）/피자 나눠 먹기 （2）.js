function solution(n) {
    var answer = 0;
    for(var i=1;i<=100;i++)
        if((i*6)%n==0){answer=i;break}
    return answer;
}