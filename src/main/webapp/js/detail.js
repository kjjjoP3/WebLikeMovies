function Choose(index){
    var img = document.getElementById("img"+index);
    var trans = document.getElementById("pic-1");
    trans.src = img.src;   
}
function movePage(){
    document.getElementById("click1").scrollTop = document.getElementById("click2").scrollHeight;
}