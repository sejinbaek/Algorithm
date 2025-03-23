function solution(str_list, ex) {
    const filtered = str_list.filter(str => !str.includes(ex));
    return filtered.join('');
}
