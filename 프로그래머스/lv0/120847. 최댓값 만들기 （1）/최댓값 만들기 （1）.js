function solution(numbers) {
    var answer = 0;
    let max=[]
    for(let i=0; i<numbers.length; i++){
        for(let j=0; j<numbers.length; j++){
            if(i==j){continue}
            else {max.push(numbers[i]*numbers[j])}
        }
    }
    for(let i=0; i<numbers.length*(numbers.length-1); i++){
        (max[i]>answer)? answer=max[i]:answer=answer
    }
    return answer;
}