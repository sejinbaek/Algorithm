function solution(str_list, ex) {
    var answer = '';
    answer = str_list.join();
    for(let i = 0; i < str_list.length; i++) {
        if(str_list[i].includes(ex)) {
            delete str_list[i];
        }
    }
    answer = str_list.join("");
    return answer;
}