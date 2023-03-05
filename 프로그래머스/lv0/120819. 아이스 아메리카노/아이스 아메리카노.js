function solution(money) {
    
    var a,b
    a=Math.floor(money/5500)
    b=money-5500*a
    var answer = [a,b];
    return answer;
}