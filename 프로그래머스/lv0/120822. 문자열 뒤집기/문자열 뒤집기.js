function solution(my_string) {
    var answer = '';
    for(let i=my_string.length-1; 0<=i; i--){
        answer+=my_string[i]
    }
    return answer;
}