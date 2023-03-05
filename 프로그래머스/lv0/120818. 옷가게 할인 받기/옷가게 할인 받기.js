function solution(price) {
    var answer = 0;
    if(price<100000) answer=price
        else if (price<300000) answer=Math.floor(0.95*price)
        else if (price<500000) answer=Math.floor(0.9*price)
        else (answer=Math.floor(0.8*price))
    return answer;
}