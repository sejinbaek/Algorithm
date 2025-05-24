function solution(my_string) {
    const arr = ['a', 'e', 'i', 'o', 'u'];
    for(let i = 0; i < arr.length; i++) {
        if(my_string.includes(arr[i])) {
            my_string = my_string.replaceAll(arr[i], "")
        }
    }
    return my_string;
}