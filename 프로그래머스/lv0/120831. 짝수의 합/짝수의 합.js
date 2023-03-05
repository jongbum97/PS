function solution(n) {
    var answer = 0;
    for(let a=0;a<=n;a++){
        if(a%2==0){answer+=a}
    }
    return answer;
}