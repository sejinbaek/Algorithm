function solution(num_list) {
    var answer = [];
    let odd_count = 0;
    let even_count = 0;
    for(let i = 0; i < num_list.length; i++) {
        if(num_list[i] % 2 == 0) {
            even_count++;
        }  else {
            odd_count++;
        }
    }
    answer[0] = even_count;
    answer[1] = odd_count;
    return answer;
}