function solution(s){
    s = s.toLowerCase();
    let p_count = 0;
    let y_count = 0;
    
    for(let i = 0; i < s.length; i++) {
        if(s[i] === "p") {
            p_count++;
        }
        if(s[i] === "y") {
            y_count++;
        }
    }
    return p_count === y_count ? true : false;
}