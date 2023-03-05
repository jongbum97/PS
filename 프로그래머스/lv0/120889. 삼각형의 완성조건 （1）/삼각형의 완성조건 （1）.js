function solution(sides) {
    var answer = 0;
    if(sides[0]<sides[1]+sides[2] && sides[1]<sides[0]+sides[2] && sides[2]<sides[1]+sides[0]){answer=1}
        else{answer=2}
    return answer;
}