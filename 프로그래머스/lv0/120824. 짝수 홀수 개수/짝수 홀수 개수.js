function solution(num_list) {
    var answer = [];
    let a=0
    for(let i=0; i<num_list.length; i++){
        if(num_list[i]%2==0){a++}
    }
    answer.push(a,num_list.length-a)
    return answer;
}