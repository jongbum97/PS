function solution(numbers) {
    var answer = 0;
    var len=numbers.length
    for(var i=0; i<len; i++){
        answer+=numbers[i]
    }
    return (answer/len);
}