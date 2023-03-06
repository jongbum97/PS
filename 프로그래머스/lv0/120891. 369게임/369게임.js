function solution(order) {
    var answer = 0;
    str=order.toString()
    for(var i=0;i<str.length;i++){
        if(str[i]!=0){
            if(str[i]%3==0){answer++}
        }
    }
    return answer;
}