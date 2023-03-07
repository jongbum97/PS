function solution(my_string, letter) {
    var answer = [...my_string];
    let a=0
    for(let i=my_string.length-1; i>=0; i--){
        if(my_string[i]===letter){answer.splice(i,1)}
        
    }
    answer = answer.join('');
    return answer;
}